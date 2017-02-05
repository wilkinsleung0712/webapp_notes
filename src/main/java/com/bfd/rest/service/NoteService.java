package com.bfd.rest.service;

import java.util.List;

import com.bfd.pojo.Note;

public interface NoteService {

    public List<Note> getAllList();

    public Note getNodeById(long noteId);

    public List<Note> getNoteByUserId(long userId);

    public void updateNote(Note note);

    public void deleteNote(long noteId);

}
