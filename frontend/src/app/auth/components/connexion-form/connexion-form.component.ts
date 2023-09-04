import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../services/auth.service";
import {ConnexionChargementRequete} from "../../models/connexion-chargement-requete";
import {NgForm} from "@angular/forms";
import {filter} from "rxjs";

@Component({
  selector: 'app-connexion-form',
  templateUrl: './connexion-form.component.html',
  styleUrls: ['./connexion-form.component.scss']
})
export class ConnexionFormComponent implements OnInit {
  utilisateur = {
    nomUtilisateur: '',
    motDePasse: ''
  };
  error = false;
  errorMessage?: String;

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
      this.error = true;
    });
  }

  connexionUtilisateurForm(form: NgForm) {
    const connexionChargementRequete: ConnexionChargementRequete = {
      nomUtilisateur: form.value.nomUtilisateur,
      motDePasse: form.value.motDePasse
    };

    this.authService.connexionUtilisateur(connexionChargementRequete).subscribe(
    (connecte) => {
        if (connecte) {
          this.router.navigate(['/articles']);
        } else {
          this.router.navigate(['/connexion'], {
            queryParams: {
              error: true
            }
          });
        }
      }
    );
  }

  reinitialisationForm(form: NgForm): void {
    form.reset();
  }

}
