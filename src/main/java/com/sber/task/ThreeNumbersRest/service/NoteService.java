package com.sber.task.ThreeNumbersRest.service;

import com.sber.task.ThreeNumbersRest.model.Note;

import java.util.List;

public interface NoteService {
    /**
     * Создает новую запись из трёх чисел
     * @param note - note для создания
     */
    void create(Note note);

    /**
     * Возвращает список всех имеющихся записей
     * @return список записей
     */
    List<Note> readAll();

    /**
     * Возвращает запись по её ID
     * @param id - ID записи
     * @return - объект note с заданным ID
     */
    Note read(int id);

    /**
     * Возвращает список записей с заданным group
     * @param group - group записей которые нужно вернуть
     * @return - список записей
     */
    List<Note> read(long group);

    /**
     * Возвращает список записей с заданным group и member
     * @param group - group записей которые нужно вернуть
     * @param member - member записей которые нужно вернуть
     * @return - список записей
     */
    List<Note> read(long group, long member);

    /**
     * Возвращает список group
     * @return - список group
     */
    List<Long> readGroups();

    /**
     * Возвращает список member с заданным group
     * @param group - group записей
     * @return - список member
     */
    List<Long> readMembers(long group);
}
