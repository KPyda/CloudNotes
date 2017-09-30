import {Injectable} from '@angular/core';
import {Note} from "../ui/domain/note";

@Injectable()
export class NotesService {
  private notes: Note[] = [
    new Note("1", "Hello", "My new note1"),
    new Note("2", "Hello2", "My new note2"),
    new Note("3", "Hello4", "My new note3"),
    new Note("4", "Hello54", "My new note4"),
    new Note("5", "Hello34", "My new note5"),
    new Note("6", "Hellosda", "My new note6"),
    new Note("7", "Helloda", "My new note7"),
  ];

  constructor() {
  }

  public getNotes() {
    return this.notes;
  }

  public getNote(id: String): Note {
    return this.notes.find(note => note.id === id);
  }

}
