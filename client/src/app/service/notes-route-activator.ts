import {ActivatedRouteSnapshot, CanActivate, Router} from "@angular/router";
import {NotesService} from "./notes.service";
import {Injectable} from "@angular/core";

@Injectable()
export class NotesRouteActivator implements CanActivate {
  constructor(private notesService: NotesService, private router: Router) {

  }

  canActivate(route: ActivatedRouteSnapshot) {
    const noteExists = !!this.notesService.getNote(route.params['id']);

    if (!noteExists) {
      this.router.navigate(['/404']);
    }
    return noteExists;
  }
}
