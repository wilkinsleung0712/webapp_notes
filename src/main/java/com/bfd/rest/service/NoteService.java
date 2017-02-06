package com.bfd.rest.service;

import java.util.List;

import com.bfd.pojo.Note;

/**
 * Service Layer for Note operation
 * @Date 4:38:50 pm 6 Feb 2017
 * @author wilkins.liang
 *
 */
public interface NoteService {

    public List<Note> getAllList();

    public Note getNodeById(long noteId);

    public List<Note> getNoteByUserId(long userId);

    public void updateNote(Note note);

    public void deleteNote(long noteId);
    
    public void createNote(Note note);

}
