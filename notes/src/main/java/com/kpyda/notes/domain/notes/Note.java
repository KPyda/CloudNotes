package com.kpyda.notes.domain.notes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Note {

    @Id
    private String id;
    private String title;
    private String content;
    private List<String> tags;
    private Author author;

    public Note(String title, String content, List<String> tags, Author author) {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.author = author;
    }

}
