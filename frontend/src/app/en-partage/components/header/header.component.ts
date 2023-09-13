import {Component, Input, OnInit} from '@angular/core';
import {AuthService} from "../../../auth/services/auth.service";
import {Router} from "@angular/router";
import {Observable} from "rxjs";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  @Input()
  titre?: string;

  loggedIn = false;
  nomUtilisateur = '';
  token = '';

  constructor(
    private authService: AuthService,
    private router: Router
  ) {
  }

  ngOnInit() {
    // Permet de vérifier, lors d'un raffraichissement, si un utilisateur est connecté
    this.utilisateurConnecte$ = this.authService.loggedIn$;
  }

  deconnexion() {
    this.authService.deconnexion();
    this.router.navigate(['/accueil'])
  }

}
