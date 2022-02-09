package com.sber.task.ThreeNumbersRest.controller;

import com.sber.task.ThreeNumbersRest.model.Information;
import com.sber.task.ThreeNumbersRest.model.Note;
import com.sber.task.ThreeNumbersRest.service.InfoService;
import com.sber.task.ThreeNumbersRest.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {
    private final NoteService noteService;
    private final InfoService infoService;

    @Autowired
    public NoteController(NoteService noteService, InfoService infoService) {
        this.noteService = noteService;
        this.infoService = infoService;
    }

    @PostMapping(value = "/putNote")
    public ResponseEntity<?> create(@RequestBody Note note) {
        noteService.create(note);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/info")
    public ResponseEntity<Information> readInfo() {
        final Information information = infoService.readInfo();

        return information != null
                ? new ResponseEntity<>(information, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
