package com.fundoonotes.util;

import com.fundoonotes.entity.Note;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelHelper {

    public static List<Note> excelToNotes(InputStream is, Long userId) {
        List<Note> notes = new ArrayList<>();

        try {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue;

                Note note = new Note();
                note.setUserId(userId);
                note.setTitle(row.getCell(0).getStringCellValue());
                note.setContent(row.getCell(1).getStringCellValue());

                notes.add(note);
            }

            workbook.close();
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse Excel");
        }

        return notes;
    }
}