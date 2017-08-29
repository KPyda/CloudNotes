package com.kpyda.notes.domain.notes;


import com.kpyda.notes.domain.notes.dto.NoteDTO;

class NoteAssembler {

    static NoteDTO toDTO(Note note) {
        return NoteDTO.builder()
                .id(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .tags(note.getTags())
                .build();
    }

}
