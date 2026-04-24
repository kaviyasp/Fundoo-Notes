package com.fundoonotes.service;

import com.fundoonotes.dto.request.CreateNoteRequestDto;
import com.fundoonotes.entity.Note;

import java.util.List;

public interface NoteService {

    Note createNote(Long userId, CreateNoteRequestDto dto);

    List<Note> getNotes(Long userId);
}