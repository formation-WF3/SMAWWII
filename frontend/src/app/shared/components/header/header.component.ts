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

  utilisateurConnecte$ = new Observable<boolean>();
  nomUtilisateur = '';
  token = '';

  constructor(
    private authService: AuthService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    // Permet de vérifier, lors d'un raffraichissement, si un utilisateur est connecté
    this.utilisateurConnecte$ = this.authService.loggedIn$;
  }

  deconnexion(): void {
    this.authService.deconnexion();
    this.router.navigate(['/accueil'])
  }
}
