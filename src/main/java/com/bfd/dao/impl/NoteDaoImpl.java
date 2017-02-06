package com.bfd.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bfd.dao.NoteDao;
import com.bfd.pojo.Note;

@Repository
@Transactional
public class NoteDaoImpl implements NoteDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 
     */
    public NoteDaoImpl() {
        super();
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bfd.dao.impl.NoteDao#getAllNote()
     */
    @SuppressWarnings("unchecked")
    public List<Note> getAllNote() {
        List<Note> list = session().createCriteria(Note.class).list();
        session().flush();
        return list;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bfd.dao.impl.NoteDao#getNoteById(long)
     */
    public Note getNoteById(long id) {
        Note note = (Note) session().get(Note.class, id);
        session().flush();
        return note;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bfd.dao.impl.NoteDao#createNote(com.bfd.pojo.Note)
     */
    public Long createNote(Note note) {
        session().save(note);
        session().flush();
        return note.getId();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bfd.dao.impl.NoteDao#updateNote(com.bfd.pojo.Note)
     */
    public Long updateNote(Note note) {
        session().update(note);
        session().flush();
        return note.getId();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bfd.dao.impl.NoteDao#deteleNote(long)
     */
    public void deteleNote(long noteId) {
        Object note = session().load(Note.class, noteId);
        session().delete(note);
        session().flush();
    }

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

}
