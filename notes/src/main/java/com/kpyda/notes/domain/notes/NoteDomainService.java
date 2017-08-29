package com.kpyda.notes.domain.notes;

import com.kpyda.commons.annotations.DomainService;
import com.kpyda.notes.domain.notes.dto.NoteDTO;
import com.kpyda.notes.domain.notes.dto.command.CreateNoteCommand;
import com.kpyda.notes.domain.notes.dto.response.CreateNoteResponse;
import com.kpyda.notes.domain.support.dto.UserTokenDetails;
import com.kpyda.notes.infrastructure.exceptions.ApiException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.kpyda.notes.infrastructure.exceptions.ApiStatus.NOTE_NOT_FOUND;
import static java.util.UUID.randomUUID;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@DomainService
@AllArgsConstructor
@Slf4j
public class NoteDomainService {

    private final NoteRepository noteRepository;
    private final NoteFactory noteFactory;

    public Mono<CreateNoteResponse> createNote(CreateNoteCommand command) {
        Note newNote = noteFactory.buildNote(command);
        return noteRepository.save(newNote)
                .map(note -> new CreateNoteResponse(note.getId()));

    }

    public Flux<NoteDTO> getNotesForUser(UserTokenDetails userTokenDetails) {
        return noteRepository.findAllByAuthorId(userTokenDetails.getUserId())
                .map(NoteAssembler::toDTO);
    }

    public Mono<NoteDTO> getNoteById(String id) {
        return noteRepository.findById(id)
                .map(NoteAssembler::toDTO);
    }

    public Mono<Void> deleteNote(String id) {
        return noteRepository.existsById(id)
                .flatMap(doesExist -> deleteIfExist(doesExist, id))
                .doOnError(throwable -> log.info("", throwable));
    }

    private Mono<Void> deleteIfExist(Boolean exist, String id) {
        if (exist) {
            return noteRepository.deleteById(id);
        } else {
            throw new ApiException(randomUUID().toString(), NOTE_NOT_FOUND, "Note not found", null, NOT_FOUND);
        }
    }
}
