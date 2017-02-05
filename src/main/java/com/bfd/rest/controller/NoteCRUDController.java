package com.bfd.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bfd.common.ExceptionUtil;
import com.bfd.common.NoteResult;
import com.bfd.pojo.Note;
import com.bfd.rest.service.NoteService;

@Controller
@RequestMapping("/note")
public class NoteCRUDController {

    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public NoteResult editNote(@RequestBody Note note) {
        try {
            if (null != note) {
                noteService.updateNote(note);
            }
            return NoteResult.ok();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return NoteResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

    @RequestMapping(value = "/{noteId}", method = RequestMethod.DELETE)
    @ResponseBody
    public NoteResult deleteNote(@PathVariable Long noteId) {
        try {
            if (null != noteId) {
                noteService.deleteNote(noteId);
            }
            return NoteResult.ok();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return NoteResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public NoteResult createNote(@RequestBody Note note) {
        try {
            if (null != note) {
                noteService.createNote(note);
            }
            return NoteResult.ok();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return NoteResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

}
