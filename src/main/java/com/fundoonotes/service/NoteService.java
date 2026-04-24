package com.fundoonotes.service;

import com.fundoonotes.dto.request.CreateNoteRequestDto;
import com.fundoonotes.entity.Note;

public interface NoteService {

    Note createNote(Long userId, CreateNoteRequestDto dto);
}