package com.fundoonotes.controller;

import com.fundoonotes.dto.request.CreateNoteRequestDto;
import com.fundoonotes.entity.Note;
import com.fundoonotes.security.JwtService;
import com.fundoonotes.service.NoteService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;
    private final JwtService jwtService;

    public NoteController(NoteService noteService, JwtService jwtService) {
        this.noteService = noteService;
        this.jwtService = jwtService;
    }

    @PostMapping
    public Note createNote(
            @RequestHeader("Authorization") String token,
            @RequestBody CreateNoteRequestDto dto) {

        Long userId = jwtService.extractUserId(token.substring(7));
        return noteService.createNote(userId, dto);
    }

    @GetMapping
    public List<Note> getNotes(
            @RequestHeader("Authorization") String token) {

        Long userId = jwtService.extractUserId(token.substring(7));
        return noteService.getNotes(userId);
    }

    @PutMapping("/{id}/pin")
    public Note togglePin(
            @PathVariable Long id,
            @RequestHeader("Authorization") String token) {

        Long userId = jwtService.extractUserId(token.substring(7));
        return noteService.togglePin(userId, id);
    }

    @PutMapping("/{id}/archive")
    public Note toggleArchive(
            @PathVariable Long id,
            @RequestHeader("Authorization") String token) {

        Long userId = jwtService.extractUserId(token.substring(7));
        return noteService.toggleArchive(userId, id);
    }

    @PutMapping("/{id}/trash")
    public Note toggleTrash(
            @PathVariable Long id,
            @RequestHeader("Authorization") String token) {

        Long userId = jwtService.extractUserId(token.substring(7));
        return noteService.toggleTrash(userId, id);
    }

    //  EXCEL UPLOAD
    @PostMapping("/upload")
    public String uploadExcel(
            @RequestHeader("Authorization") String token,
            @RequestParam("file") MultipartFile file) {

        Long userId = jwtService.extractUserId(token.substring(7));
        noteService.uploadExcel(userId, file);

        return "Excel uploaded successfully";
    }
}