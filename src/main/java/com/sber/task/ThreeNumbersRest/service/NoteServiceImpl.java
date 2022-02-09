package com.sber.task.ThreeNumbersRest.service;

import com.sber.task.ThreeNumbersRest.model.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class NoteServiceImpl implements NoteService{

    private static final AtomicInteger NOTE_ID_HOLDER = new AtomicInteger();
    private static final Map<Integer, Note> NOTE_REPOSITORY_MAP = new HashMap<>();

    @Override
    public void create(Note note) {
        final int noteId = NOTE_ID_HOLDER.incrementAndGet();
        note.setId(noteId);
        NOTE_REPOSITORY_MAP.put(noteId, note);
    }

    @Override
    public List<Note> readAll() {
        return new ArrayList<>(NOTE_REPOSITORY_MAP.values());
    }

    @Override
    public Note read(int id) {
        return NOTE_REPOSITORY_MAP.get(id);
    }

    @Override
    public List<Note> read(long group) {
        ArrayList<Note> notesWithGroup = new ArrayList<>();
        for (Note note : readAll()){
            if (note.getGroup() == group) notesWithGroup.add(note);
        }
        return notesWithGroup;
    }

    @Override
    public List<Note> read(long group, long member) {
        ArrayList<Note> notesWithGroupAndMember = new ArrayList<>();
        for (Note note : readAll()){
            if (note.getGroup() == group && note.getMember() == member) notesWithGroupAndMember.add(note);
        }
        return notesWithGroupAndMember;
    }

    @Override
    public List<Long> readGroups() {
        ArrayList<Long> groups = new ArrayList<>();
        for (Note note : readAll()){
            if (!groups.contains(note.getGroup())) groups.add(note.getGroup());
        }
        return groups;
    }

    @Override
    public List<Long> readMembers(long group) {
        ArrayList<Long> members = new ArrayList<>();
        for (Note note : read(group)){
            if (!members.contains(note.getMember())) members.add(note.getMember());
        }
        return members;
    }


}
