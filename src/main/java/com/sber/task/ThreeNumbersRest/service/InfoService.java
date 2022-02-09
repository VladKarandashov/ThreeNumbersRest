package com.sber.task.ThreeNumbersRest.service;

import com.sber.task.ThreeNumbersRest.model.Group;
import com.sber.task.ThreeNumbersRest.model.Information;
import com.sber.task.ThreeNumbersRest.model.Member;
import com.sber.task.ThreeNumbersRest.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class InfoService {

    private final NoteServiceImpl noteService;
    List<Note> data;

    @Autowired
    public InfoService(NoteServiceImpl noteService) {
        this.noteService = noteService;
    }

    public Information readInfo(){

        data = noteService.readAll();
        List<Long> myGroups = new ArrayList<>();
        for (Note note : data) {
            if (! myGroups.contains(note.getGroup())) myGroups.add(note.getGroup());
        }

        ArrayList<Group> info = new ArrayList<>();
        double sumInfo = 0;
        for (Long numberGroup : myGroups) {
            ArrayList<Member> members = new ArrayList<>();
            double sumGroup = 0;
            for (Long numberMember : readMembers(numberGroup)){
                double sum = 0;
                for (Note note : read(numberGroup, numberMember)){
                    sum += note.getItem();
                }
                Member member = new Member(Long.toString(numberMember), Double.toString(sum));
                members.add(member);
                sumGroup += sum;
            }
            Group group = new Group(Long.toString(numberGroup), Double.toString(sumGroup), members);
            info.add(group);
            sumInfo += sumGroup;
        }
        return new Information(info, Double.toString(sumInfo));
    }

    private List<Long> readMembers(Long numberGroup){
        List<Long> myMember = new ArrayList<>();
        for (Note note : data) {
            if ((! myMember.contains(note.getMember())) && Objects.equals(note.getGroup(), numberGroup)) myMember.add(note.getMember());
        }
        return myMember;
    }

    private List<Note> read(Long numberGroup, Long numberMember){
        List<Note> myNote = new ArrayList<>();
        for (Note note : data) {
            if (Objects.equals(note.getGroup(), numberGroup) && Objects.equals(note.getMember(), numberMember))
                myNote.add(note);
        }
        return myNote;
    }

}
