package com.bfd.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.bfd.common.JsonUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Date 10:44:22 am 6 Feb 2017
 * @author wilkins.liang
 *
 */
@Entity
@Table(name = "tb_note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String content;
    private Date created;
    private Date updated;
    /**
     * json data string that we present in the database layer, we dont use to
     * display or receive from json data
     */
    @JsonIgnore
    private String labels;

    /**
     * a list of data that represent our json data string in database, we dont
     * see this list into database
     */
    @Transient
    private List<String> labelList;

    /**
     * 
     */
    public Note() {
        super();
    }

    /**
     * 
     */
    public void syncLabels() {
        if (!StringUtils.isBlank(labels)) {
            if (null != labelList) {
                labelList.addAll(convertLabelsJsonToList());
            } else {
                labelList = new ArrayList<String>();
                labelList.addAll(convertLabelsJsonToList());
            }
        }
        // else if (tagList != null && tagList.isEmpty()) {
        // tags = convertTagListToJson();
        // }
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

    public String convertLabelListToJson() {
        if (null != labelList && !labelList.isEmpty()) {
            return JsonUtils.objectToJson(labelList);
        }
        return "";
    }

    public List<String> convertLabelsJsonToList() {
        return JsonUtils.jsonToList(labels, String.class);
    }

    /**
     * @return the tags
     */
    public String getLabels() {

        return labels;
    }

    /**
     * @param labelsJsonData
     */
    private void setLabels(String labelsJsonData) {
        this.labels = labelsJsonData;
    }


    /**
     * @return
     */
    public List<String> getLabelList() {
        // format existing tag data to list of tag
        syncLabels();
        return labelList;
    }

    /**
     * Validate if tagList is been set.
     * 
     * @return
     */
    public boolean isLabelList() {
        return labelList != null && !labelList.isEmpty();
    }

    /**
     * replace tag list to existing tag list
     * 
     * @param labelList
     */
    public void addLabel(List<String> labelList) {
        // comment out appending new tag list to existing taglist
        // List<String> tagsDataList = JsonUtils.jsonToList(tags, String.class);
        // if (null == tagsDataList) {
        // tagsDataList = new ArrayList<String>();
        // }
        // tagsDataList.addAll(tagList);
        this.setLabels(JsonUtils.objectToJson(labelList));
        this.labelList = labelList;
    }

    /**
     * Seting data for tagList
     * 
     * @param labelList
     *            the tagList to set
     */
    public void setLabelList(List<String> labelList) {
        this.labelList = labelList;
    }

    /**
     * @return the created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created
     *            the created to set
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * @return the updated
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * @param updated
     *            the updated to set
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Note [id=" + id + ", title=" + title + ", content=" + content + ", created=" + created + ", updated="
                + updated + ", labels=" + labels + ", labelList=" + labelList + "]";
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
