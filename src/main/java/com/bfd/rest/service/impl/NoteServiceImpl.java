package com.bfd.rest.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfd.dao.NoteDao;
import com.bfd.pojo.Note;
import com.bfd.rest.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao noteDao;

    public List<Note> getAllList() {
        return noteDao.getAllNote();
    }

    public Note getNodeById(long noteId) {
        return noteDao.getNoteById(noteId);
    }

    public List<Note> getNoteByUserId(long userId) {
        // TODO Auto-generated method stub
        return null;
    }

    public void updateNote(Note note) {
        note.setUpdated(new Date());
        noteDao.updateNote(note);

    }

    public void deleteNote(long noteId) {
        noteDao.deteleNote(noteId);

    }

    public void createNote(Note note) {
        note.setCreated(new Date());
        note.setUpdated(new Date());
        noteDao.createNote(note);
    }

}
