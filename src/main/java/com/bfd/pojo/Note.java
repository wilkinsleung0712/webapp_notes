package com.bfd.pojo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_note")
public class Note {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String content;
    private Timestamp created;
    private Timestamp updated;

    /**
     * 
     */
    public Note() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     *            the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the created
     */
    public Timestamp getCreated() {
        return created;
    }

    /**
     * @param created
     *            the created to set
     */
    public void setCreated(Timestamp created) {
        this.created = created;
    }

    /**
     * @return the updated
     */
    public Timestamp getUpdated() {
        return updated;
    }

    /**
     * @param updated
     *            the updated to set
     */
    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Note [id=" + id + ", title=" + title + ", content=" + content
                + ", created=" + created + ", updated=" + updated + "]";
    }

    /**
     * @param title
     * @param content
     */
    public Note(String title, String content) {
        super();
        this.title = title;
        this.content = content;
    }

}
