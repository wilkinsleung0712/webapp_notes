package com.bfd.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bfd.common.ExceptionUtil;
import com.bfd.common.NoteResult;
import com.bfd.pojo.Note;
import com.bfd.rest.service.NoteService;

@RestController
public class NoteRESTContrller {

    @Autowired
    private NoteService noteService;

    @RequestMapping("/note/{noteId}")
    @ResponseBody
    public NoteResult getNoteByNoteId(@PathVariable Long noteId) {
        try {
            Note note = noteService.getNodeById(noteId);
            return NoteResult.ok(note);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return NoteResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

    @RequestMapping("/note/all")
    @ResponseBody
    public NoteResult getAllNotes() {

        try {
            List<Note> allList = noteService.getAllList();
            return NoteResult.ok(allList);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return NoteResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

}
