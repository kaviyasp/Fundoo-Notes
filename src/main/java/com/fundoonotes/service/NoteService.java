package com.fundoonotes.service;

import com.fundoonotes.dto.request.CreateNoteRequestDto;
import com.fundoonotes.entity.Note;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NoteService {

    Note createNote(Long userId, CreateNoteRequestDto dto);

    List<Note> getNotes(Long userId);

    Note togglePin(Long userId, Long noteId);

    Note toggleArchive(Long userId, Long noteId);

    Note toggleTrash(Long userId, Long noteId);


    void uploadExcel(Long userId, MultipartFile file);
}