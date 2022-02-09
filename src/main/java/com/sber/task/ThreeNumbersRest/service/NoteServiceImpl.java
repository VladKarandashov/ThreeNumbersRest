package com.sber.task.ThreeNumbersRest.service;

import com.sber.task.ThreeNumbersRest.model.Note;
import com.sber.task.ThreeNumbersRest.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public ResponseEntity<Note> create(Note note) {

        Note _note = noteRepository
                .save(new Note(note.getMember(), note.getGroup(), note.getItem()));
        return new ResponseEntity<>(_note, HttpStatus.CREATED);
    }

    @Override
    public List<Note> readAll() {
        List<Note> notes = new ArrayList<>();
        noteRepository.findAll().forEach(notes::add);
        return notes;
    }

}
