import {Injectable} from '@angular/core';
import {Observable, Subject} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Utilisateur} from "../../models/utilisateur";
import {EnregistrementChargementRequete} from "../models/enregistrement-chargement-requete";
import {ConnexionChargementRequete} from "../models/connexion-chargement-requete";
import {Token} from "@angular/compiler";

@Injectable()
export class AuthService {
  API_URL: string = 'http://localhost:8080/api/auth';
  private logger = new Subject<boolean>();

  constructor(
    private httpClient: HttpClient
  ) {
  }

  get loggedIn$(): Observable<boolean> {
    return this.logger.asObservable();
  }

  enregistrementUtilisateur(valeursForm: EnregistrementChargementRequete): Observable<Utilisateur> {
    return this.httpClient.post(`${this.API_URL}/enregistrement`, valeursForm);
  }

  connexionUtilisateur(valeursForm: ConnexionChargementRequete): Observable<any> {
    return this.httpClient.post(`${this.API_URL}/connexion`, valeursForm);
  }

  sauvegarderToken(token: Token) {
    localStorage.setItem('token', JSON.stringify(token));
    this.logger.next(true);
  }

  isLogged(): boolean {
    return localStorage.getItem('token') !== null;
  }

  getToken(): string {
    return localStorage.getItem('token') as string;
  }

}
