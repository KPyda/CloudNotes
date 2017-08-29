package com.kpyda.notes.domain.notes.dto.command;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

@Data
@ToString
public class CreateNoteCommand {
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private String username;
    @NotEmpty
    private String authorId;
    private List<String> tags;
}
