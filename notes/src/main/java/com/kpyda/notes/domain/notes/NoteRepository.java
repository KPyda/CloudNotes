package com.kpyda.notes.domain.notes;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

interface NoteRepository extends ReactiveMongoRepository<Note, String> {

    Flux<Note> findAllByAuthorId(String authorId);
}
