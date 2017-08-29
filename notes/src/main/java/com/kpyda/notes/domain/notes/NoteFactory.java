package com.kpyda.notes.domain.notes;

import com.kpyda.commons.annotations.Factory;
import com.kpyda.notes.domain.notes.dto.command.CreateNoteCommand;


@Factory
class NoteFactory {
    Note buildNote(CreateNoteCommand command) {
        return Note.builder()
                .author(new Author(command.getAuthorId(), command.getUsername()))
                .title(command.getTitle())
                .content(command.getContent())
                .tags(command.getTags())
                .build();
    }
}
