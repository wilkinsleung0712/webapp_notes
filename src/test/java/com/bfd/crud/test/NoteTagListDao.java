package com.bfd.crud.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bfd.dao.NoteDao;
import com.bfd.pojo.Note;
import com.bfd.rest.service.NoteService;

@ContextConfiguration(locations = { "classpath:spring/applicationContext-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class NoteTagListDao {

    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteDao noteDao;

    private Note note1 = new Note("test1", "testcontent1");

    @Test
    @Rollback(true)
    public void testDelete() {
        noteService.deleteNote(1);
    }

    @Test
    public void testGetAllNotes() {
        assertNotNull(noteService.getAllList());
    }

    @Test
    @Rollback(true)
    public void testCreateRetrieveNoteTags() {
        noteService.createNote(note1);
    }

    @Test
    @Rollback(true)
    public void testUpdateTags() {
        List<String> list = new ArrayList<String>();
        list.add("tag1");
        list.add("tag2");

        note1.addLabel(list);
        Long noteId = noteDao.createNote(note1);
        assertFalse(noteId == null);
        assertFalse(noteId == 0);
        Note selectedNote = noteDao.getNoteById(noteId);

        selectedNote.addLabel(list);
        noteDao.updateNote(selectedNote);

        selectedNote = noteDao.getNoteById(noteId);
        assertEquals(list, selectedNote.getLabelList());

        List<String> list2 = new ArrayList<String>();
        list2.add("tag3");
        list2.add("tag4");
        selectedNote.addLabel(list2);
        noteDao.updateNote(selectedNote);
        assertEquals(list2, selectedNote.getLabelList());
    }
}
