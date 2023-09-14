import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../services/auth.service";
import {ConnexionPayload} from "../../models/connexion-payload";
import {NgForm} from "@angular/forms";
import {filter} from "rxjs";

@Component({
  selector: 'app-page-connexion',
  templateUrl: './page-connexion.component.html',
  styleUrls: ['./page-connexion.component.scss']
})
export class PageConnexionComponent implements OnInit {
  utilisateur = {
    nomUtilisateur: '',
    motDePasse: ''
  };
  erreur = false;
  erreurMessage?: String;

  constructor(
    private activatedRoute: ActivatedRoute,
    private authService: AuthService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.activatedRoute.queryParamMap.pipe(filter(
      params => params.has('error'))
    ).subscribe(params => {
      this.erreur = true;
    });
  }

  connexionUtilisateurForm(form: NgForm): void {
    const connexionChargementRequete: ConnexionPayload = {
      nomUtilisateur: form.value.nomUtilisateur,
      motDePasse: form.value.motDePasse
    };

    this.authService.connexion(connexionChargementRequete).subscribe({
        next: (jwtAuthReponse) => this.router.navigate(['/articles']),
        error: error => this.erreurMessage = error
      }
    );
  }

  reinitialisationForm(form: NgForm): void {
    form.reset();
  }
}
