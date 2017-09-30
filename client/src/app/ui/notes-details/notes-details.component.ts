import {Component, OnInit} from '@angular/core';
import {Note} from "../domain/note";
import {ActivatedRoute} from "@angular/router";
import {NotesService} from "../../service/notes.service";

@Component({
  selector: 'app-notes-details',
  templateUrl: './notes-details.component.html',
  styleUrls: ['./notes-details.component.css']
})
export class NotesDetailsComponent implements OnInit {

  note: Note;

  constructor(private router: ActivatedRoute, private noteService: NotesService) {
  }

  ngOnInit() {
    this.note = this.noteService.getNote(this.router.snapshot.params['id']);
  }

}
