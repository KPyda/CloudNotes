import {NotesListComponent} from './ui/notes-list/notes-list.component';
import {Routes} from '@angular/router';
import {NotesNewComponent} from "./ui/notes-new/notes-new.component";
import {NotesDetailsComponent} from "./ui/notes-details/notes-details.component";
import {NotesRouteActivator} from "./service/notes-route-activator";
import {Error404Component} from "./error/404.component";


export const appRoutes: Routes = [
  {path: 'notes', component: NotesListComponent},
  {path: 'notes/:id', component: NotesDetailsComponent, canActivate: [NotesRouteActivator]},
  {path: 'new-note', component: NotesNewComponent},
  {path: '404', component: Error404Component},
  {path: '', redirectTo: '/', pathMatch: 'full'}
];

