package com.sber.task.ThreeNumbersRest.service;

import com.sber.task.ThreeNumbersRest.model.Group;
import com.sber.task.ThreeNumbersRest.model.Information;
import com.sber.task.ThreeNumbersRest.model.Member;
import com.sber.task.ThreeNumbersRest.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InfoService {

    private final NoteServiceImpl noteService;

    @Autowired
    public InfoService(NoteServiceImpl noteService) {
        this.noteService = noteService;
    }

    public Information readInfo(){
        ArrayList<Group> info = new ArrayList<>();
        for (Long numberGroup : noteService.readGroups()) {
            ArrayList<Member> members = new ArrayList<>();
            double sumGroup = 0;
            for (Long numberMember : noteService.readMembers(numberGroup)){
                double sum = 0;
                for (Note note : noteService.read(numberGroup, numberMember)){
                    sum += note.getItem();
                }
                Member member = new Member(Long.toString(numberMember), Double.toString(sum));
                members.add(member);
                sumGroup += sum;
            }
            Group group = new Group(Long.toString(numberGroup), Double.toString(sumGroup), members);
            info.add(group);
        }
        return new Information(info);
    }



}
