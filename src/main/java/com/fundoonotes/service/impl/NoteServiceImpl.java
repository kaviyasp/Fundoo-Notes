package com.fundoonotes.service.impl;

import com.fundoonotes.dto.request.CreateNoteRequestDto;
import com.fundoonotes.entity.Note;
import com.fundoonotes.repository.NoteRepository;
import com.fundoonotes.service.NoteService;
import org.springframework.stereotype.Service;

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
}