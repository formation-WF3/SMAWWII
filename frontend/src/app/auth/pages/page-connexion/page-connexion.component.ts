import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../services/auth.service";
import {ConnexionChargementRequete} from "../../models/connexion-chargement-requete";
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
    private router: Router,
  ) {
  }

  ngOnInit(): void {
    this.activatedRoute.queryParamMap.pipe(filter(
      params => params.has('error'))
    ).subscribe(params => {
      this.erreur = true;
    });
  }

  connexionUtilisateurForm(form: NgForm) {
    const connexionChargementRequete: ConnexionChargementRequete = {
      nomUtilisateur: form.value.nomUtilisateur,
      motDePasse: form.value.motDePasse
    };

    this.authService.connexionUtilisateur(connexionChargementRequete).subscribe({
        next: (token) => {
          if (token) {
            this.authService.sauvegarderToken(token);
            this.router.navigate(['/articles']);
          } else {
            this.router.navigate(['/connexion'], {
              queryParams: {
                erreur: true
              }
            });
          }
        },
        error: (error) => (this.erreurMessage = error)
      }
    );
  }

  reinitialisationForm(form: NgForm): void {
    form.reset();
  }

}
