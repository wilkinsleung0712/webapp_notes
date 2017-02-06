package com.bfd.rest.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfd.dao.NoteDao;
import com.bfd.pojo.Note;
import com.bfd.rest.service.NoteService;

/**
 * @Date 4:39:07 pm 6 Feb 2017
 * @author wilkins.liang
 *
 */
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

    public void updateNote(Note newnote) {
        Note note = noteDao.getNoteById(newnote.getId());

        if (null != note) {
            // note exist
            // populate data from new note to existing note, should only
            // overwrite data that is not null in new note
            if (newnote.isLabelList()) {
                // append to our existing tag list
                note.addLabel(newnote.getLabelList());
            }

            if (!StringUtils.isBlank(newnote.getContent())) {
                note.setContent(newnote.getContent());
            }

            if (!StringUtils.isBlank(newnote.getTitle())) {
                note.setContent(newnote.getTitle());
            }

            note.setUpdated(new Date());
            // updating new information
            noteDao.updateNote(note);
        }

    }

    public void deleteNote(long noteId) {
        noteDao.deteleNote(noteId);

    }

    public void createNote(Note note) {
        note.setCreated(new Date());
        note.setUpdated(new Date());
        
        if (note.isLabelList()) {
            note.addLabel(note.getLabelList());
        }
        
        noteDao.createNote(note);
    }

}
