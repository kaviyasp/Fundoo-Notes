package com.fundoonotes.service.impl;

import com.fundoonotes.dto.request.CreateNoteRequestDto;
import com.fundoonotes.entity.Note;
import com.fundoonotes.repository.NoteRepository;
import com.fundoonotes.service.NoteService;
import com.fundoonotes.messaging.MessageProducer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final MessageProducer producer;

    public NoteServiceImpl(NoteRepository noteRepository, MessageProducer producer) {
        this.noteRepository = noteRepository;
        this.producer = producer;
    }

    @Override
    public Note createNote(Long userId, CreateNoteRequestDto dto) {

        Note note = new Note();
        note.setUserId(userId);
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());

        Note saved = noteRepository.save(note);

        producer.sendMessage("New note created with id: " + saved.getId());

        return saved;
    }

    @Override
    public List<Note> getNotes(Long userId) {
        return noteRepository.findByUserId(userId);
    }

    @Override
    public Note togglePin(Long userId, Long noteId) {
        Note note = noteRepository.findById(noteId).orElseThrow();
        if (!note.getUserId().equals(userId)) throw new RuntimeException("Unauthorized");
        note.setPinned(!note.isPinned());
        return noteRepository.save(note);
    }

    @Override
    public Note toggleArchive(Long userId, Long noteId) {
        Note note = noteRepository.findById(noteId).orElseThrow();
        if (!note.getUserId().equals(userId)) throw new RuntimeException("Unauthorized");
        note.setArchived(!note.isArchived());
        return noteRepository.save(note);
    }

    @Override
    public Note toggleTrash(Long userId, Long noteId) {
        Note note = noteRepository.findById(noteId).orElseThrow();
        if (!note.getUserId().equals(userId)) throw new RuntimeException("Unauthorized");
        note.setTrashed(!note.isTrashed());
        return noteRepository.save(note);
    }
}