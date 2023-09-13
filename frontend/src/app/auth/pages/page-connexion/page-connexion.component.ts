import {Component} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../services/auth.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-page-connexion',
  templateUrl: './page-connexion.component.html',
  styleUrls: ['./page-connexion.component.scss']
})
export class PageConnexionComponent {
  utilisateur = {
    nomUtilisateur: '',
    motDePasse: ''
  };
  erreurMessage?: String;

  constructor(
    private activatedRoute: ActivatedRoute,
    private authService: AuthService,
    private router: Router
  ) {
  }

  connexionUtilisateurForm(form: NgForm) {
    this.authService.connexion(form.value).subscribe({
        next: () => this.router.navigate(['/articles']),
        error: (error) => (this.erreurMessage = error)
      }
    );
  }

  reinitialisationForm(form: NgForm): void {
    form.reset();
  }

}
