package com.bfd.dao;

import java.util.List;

import com.bfd.pojo.Note;

/**
 * Interface class for Note CRUD at DAO layer
 * 
 * @Date 4:32:29 pm 6 Feb 2017
 * @author wilkins.liang
 *
 */
public interface NoteDao {

    /**
     * Get all Notes from system
     * 
     * @return - a list of all notes
     */
    List<Note> getAllNote();

    /**
     * Get Note By noteid
     * 
     * @param id
     *            - note id that indicate to a note
     * @return - note with noteid
     */
    Note getNoteById(long id);

    /**
     * Craete a new Note
     * 
     * @param note
     * @return
     */
    Long createNote(Note note);

    /**
     * Update existing note to a new note
     * 
     * @param note
     * @return
     */
    Long updateNote(Note note);

    /**
     * delete note by a specify id
     * 
     * @param noteId
     */
    void deteleNote(long noteId);

}