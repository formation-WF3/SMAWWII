import {Component} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {NgForm} from "@angular/forms";
import {ConnexionPayload} from "../../models/connexion-payload";

@Component({
  selector: 'app-page-connexion',
  templateUrl: './page-connexion.component.html',
  styleUrls: ['./page-connexion.component.scss']
})
export class PageConnexionComponent {
  connexionPayload: ConnexionPayload = {};
  erreurMessage?: String;

  constructor(
    private authService: AuthService,
    private router: Router
  ) {
  }

  soumettreFormulaire(): void {
    this.authService.connexion(this.connexionPayload).subscribe({
      next: () => this.router.navigate(['/articles']),
      error: error => this.erreurMessage = error
    });
  }

  reinitialiserFormulaire(form: NgForm): void {
    form.reset();
  }
}
