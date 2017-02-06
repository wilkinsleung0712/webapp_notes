package com.bfd.common;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Custom return object from backend to front end indicate if the request has
 * been successful.
 * 
 * @Date 4:30:12 pm 6 Feb 2017
 * @author wilkins.liang
 *
 */
public class NoteResult {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    // http status
    private Integer status;

    // error message
    private String msg;

    // data if data return is required
    private Object data;

    public static NoteResult build(Integer status, String msg, Object data) {
        return new NoteResult(status, msg, data);
    }

    public static NoteResult ok(Object data) {
        return new NoteResult(data);
    }

    public static NoteResult ok() {
        return new NoteResult(null);
    }

    public NoteResult() {

    }

    public static NoteResult build(Integer status, String msg) {
        return new NoteResult(status, msg, null);
    }

    public NoteResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public NoteResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    // public Boolean isOK() {
    // return this.status == 200;
    // }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * å°†jsonç»“æžœé›†è½¬åŒ–ä¸ºNoteResultå¯¹è±¡
     * 
     * @param jsonData
     *            jsonæ•°æ�®
     * @param clazz
     *            NoteResultä¸­çš„objectç±»åž‹
     * @return
     */
    public static NoteResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, NoteResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Convert data string into NoteResult
     * 
     * @param json
     * @return
     */
    public static NoteResult format(String json) {
        try {
            return MAPPER.readValue(json, NoteResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Convert data string into NoteResult which contain a list of clazz
     * 
     * @param jsonData
     * @param clazz
     * @return
     */
    public static NoteResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }
}
