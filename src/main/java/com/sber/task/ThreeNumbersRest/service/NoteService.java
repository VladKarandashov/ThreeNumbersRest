package com.sber.task.ThreeNumbersRest.service;

import com.sber.task.ThreeNumbersRest.model.Note;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NoteService {
    /**
     * Создает новую запись из трёх чисел
     * @param note - note для создания
     * @return
     */
    ResponseEntity<Note> create(Note note);

    /**
     * Возвращает список всех имеющихся записей
     * @return список записей
     */
    List<Note> readAll();

}
