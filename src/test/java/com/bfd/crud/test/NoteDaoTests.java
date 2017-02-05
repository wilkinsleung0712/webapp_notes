package com.bfd.crud.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bfd.dao.NoteDao;
import com.bfd.pojo.Note;

@ContextConfiguration(locations = {
        "classpath:spring/applicationContext-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class NoteDaoTests {

    @Autowired
    private NoteDao noteDao;

    private Note note1 = new Note("test1", "testcontent1");

    @Test
    @Rollback(true)
    public void testDelete() {
        noteDao.deteleNote(1);
    }

    @Test
    public void testGetById() {
        assertNotNull(noteDao.getAllNote());
        assertNotNull(noteDao.getNoteById(1));
    }

    @Test
    @Rollback(true)
    public void testCreateRetrieve() {
        Long noteId = noteDao.createNote(note1);
        assertFalse(noteId == null);
        assertFalse(noteId == 0);
    }

    @Test
    public void testUpdate() {
        Long noteId = noteDao.createNote(note1);
        assertFalse(noteId == null);
        assertFalse(noteId == 0);
        Note selectedNote = noteDao.getNoteById(note1.getId());
        selectedNote.setContent(selectedNote.getContent() + " test appended");
        noteDao.updateNote(selectedNote);
    }
}
