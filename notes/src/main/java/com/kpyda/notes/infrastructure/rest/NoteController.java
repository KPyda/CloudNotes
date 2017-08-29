package com.kpyda.notes.infrastructure.rest;

import com.kpyda.notes.domain.notes.NoteDomainService;
import com.kpyda.notes.domain.notes.dto.NoteDTO;
import com.kpyda.notes.domain.notes.dto.command.CreateNoteCommand;
import com.kpyda.notes.domain.notes.dto.response.CreateNoteResponse;
import com.kpyda.notes.domain.support.TokenService;
import com.kpyda.notes.domain.support.dto.UserTokenDetails;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Slf4j
@RestController
@AllArgsConstructor
public class NoteController {
    private final NoteDomainService noteDomainService;
    private final TokenService tokenService;

    @PostMapping(value = "/notes")
    @ResponseStatus(HttpStatus.CREATED)
    Mono<CreateNoteResponse> createNoteCommand(@Valid @RequestBody CreateNoteCommand command) {
        log.info("{}", command);
        return noteDomainService.createNote(command)
                .doOnNext(createNoteResponse -> log.info("Note created: {}", createNoteResponse));
    }

    @GetMapping(value = "/notes")
    Flux<NoteDTO> getAllNotesForUser() {
        UserTokenDetails userTokenDetails = tokenService.getDetailsFromToken();
        return noteDomainService.getNotesForUser(userTokenDetails)
                .doOnNext(noteDTO -> log.info("{}", noteDTO));
    }

    @GetMapping(value = "/notes/{id}")
    Mono<NoteDTO> getAllNotes(@PathVariable String id) {
        return noteDomainService.getNoteById(id)
                .doOnNext(noteDTO -> log.info("{}", noteDTO));
    }

    @DeleteMapping(value = "/notes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    Mono<Void> deleteNoteCommand(@PathVariable String id) {
        return noteDomainService.deleteNote(id)
                .doOnNext(aVoid -> log.info("Deleted by id: {}", id));
    }
}
