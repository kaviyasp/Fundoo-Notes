package com.fundoonotes.controller;

import com.fundoonotes.dto.request.CreateNoteRequestDto;
import com.fundoonotes.entity.Note;
import com.fundoonotes.service.NoteService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public Note createNote(@RequestBody CreateNoteRequestDto dto,
                           Authentication authentication) {

        Long userId = (Long) authentication.getPrincipal();

        return noteService.createNote(userId, dto);
    }

    @GetMapping
    public List<Note> getNotes(Authentication authentication) {

        Long userId = (Long) authentication.getPrincipal();

        return noteService.getNotes(userId);
    }
}