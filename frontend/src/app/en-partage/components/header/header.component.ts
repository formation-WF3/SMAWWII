import {Component, Input, OnInit} from '@angular/core';
import {AuthService} from "../../../auth/services/auth.service";

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
    private authService: AuthService
  ) {
  }

  ngOnInit() {
    // Permet de vérifier, lors d'un raffraichissement, si un utilisateur est connecté
    this.loggedIn = this.authService.isLogged();
    this.authService.loggedIn$.subscribe(loggedIn => {
      this.loggedIn = loggedIn;
      if (this.loggedIn) {
        this.token = this.authService.getToken();
      }
    });
  }
}
