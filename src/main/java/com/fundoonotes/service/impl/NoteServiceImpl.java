package com.fundoonotes.service.impl;

import com.fundoonotes.dto.request.CreateNoteRequestDto;
import com.fundoonotes.entity.Note;
import com.fundoonotes.repository.NoteRepository;
import com.fundoonotes.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note createNote(Long userId, CreateNoteRequestDto dto) {

        Note note = new Note();
        note.setUserId(userId);
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());

        return noteRepository.save(note);
    }

    @Override
    public List<Note> getNotes(Long userId) {
        return noteRepository.findByUserId(userId);
    }

    @Override
    public Note togglePin(Long userId, Long noteId) {

        Note note = noteRepository.findById(noteId).orElseThrow();

        if (!note.getUserId().equals(userId)) {
            throw new RuntimeException("Unauthorized");
        }

        note.setPinned(!note.isPinned());

        return noteRepository.save(note);
    }

    @Override
    public Note toggleArchive(Long userId, Long noteId) {

        Note note = noteRepository.findById(noteId).orElseThrow();

        if (!note.getUserId().equals(userId)) {
            throw new RuntimeException("Unauthorized");
        }

        note.setArchived(!note.isArchived());

        return noteRepository.save(note);
    }

    @Override
    public Note toggleTrash(Long userId, Long noteId) {

        Note note = noteRepository.findById(noteId).orElseThrow();

        if (!note.getUserId().equals(userId)) {
            throw new RuntimeException("Unauthorized");
        }

        note.setTrashed(!note.isTrashed());

        return noteRepository.save(note);
    }
}