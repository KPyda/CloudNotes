import {Component, Input, OnInit} from '@angular/core';
import {Note} from "../../domain/note";

@Component({
  selector: 'app-note-list-details',
  templateUrl: './note-list-details.component.html',
  styleUrls: ['./note-list-details.component.css']
})
export class NoteListDetailsComponent implements OnInit {

  @Input() public note: Note;

  constructor() {
  }

  ngOnInit() {
  }

}
