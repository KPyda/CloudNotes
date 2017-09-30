import {Component, OnInit} from '@angular/core';
import {Note} from "../domain/note";
import {NotesService} from "../../service/notes.service";

@Component({
  selector: 'app-notes-list',
  templateUrl: './notes-list.component.html',
  providers: [NotesService],
  styleUrls: ['./notes-list.component.css']
})
export class NotesListComponent implements OnInit {
  constructor(private notesService: NotesService) {
  }

  private _notes: Note[];

  get notes(): Note[] {
    return this._notes;
  }

  ngOnInit() {
    this._notes = this.notesService.getNotes();
  }

  protected handleThumbnailClick(noteId) {
    this.notesService.getNote(noteId);
  }


}
