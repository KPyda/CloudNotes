import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {TopNavComponent} from './ui/top-nav/top-nav.component';
import {NotesListComponent} from './ui/notes-list/notes-list.component';
import {RouterModule} from '@angular/router';
import {NoteListDetailsComponent} from './ui/notes-list/note-list-details/note-details.component';
import {appRoutes} from './routes';
import {ChangesListComponent} from './ui/changes/changes-list/changes-list.component';
import {NotesNewComponent} from './ui/notes-new/notes-new.component';
import {NotesDetailsComponent} from './ui/notes-details/notes-details.component';
import {Error404Component} from "./error/404.component";
import {NotesRouteActivator} from "./service/notes-route-activator";
import {NotesService} from "./service/notes.service";

@NgModule({
  declarations: [
    AppComponent,
    TopNavComponent,
    NotesListComponent,
    NoteListDetailsComponent,
    ChangesListComponent,
    NotesNewComponent,
    NotesDetailsComponent,
    Error404Component
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
  ],
  exports: [RouterModule],
  providers: [NotesRouteActivator, NotesService],
  bootstrap: [AppComponent]
})
export class AppModule {

}
