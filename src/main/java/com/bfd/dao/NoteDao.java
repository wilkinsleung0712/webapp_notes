package com.bfd.dao;

import java.util.List;

import com.bfd.pojo.Note;

public interface NoteDao {

    List<Note> getAllNote();

    List<Note> getNoteByUserId(long userid);

    Note getNoteById(long id);

    Long createNote(Note note);

    Long updateNote(Note note);

    void deteleNote(long noteId);

}