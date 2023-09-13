import {Injectable} from '@angular/core';
import {Observable, Subject, tap} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {InscriptionChargementRequete} from "../models/inscription-chargement-requete";
import {ConnexionChargementRequete} from "../models/connexion-chargement-requete";
import {JwtAuthReponse} from "../models/jwtAuthReponse";
import jwt_decode from 'jwt-decode';

@Injectable()
export class AuthService {
  API_URL: string = 'http://localhost:8080/api/auth';
  private _logger = new Subject<boolean>();

  constructor(
    private httpClient: HttpClient
  ) {
  }

  get loggedIn$(): Observable<boolean> {
    return this._logger.asObservable();
  }

  inscription(valeursForm: InscriptionChargementRequete): Observable<JwtAuthReponse> {
    return this.httpClient.post(`${this.API_URL}/inscription`, valeursForm);
  }

  connexion(valeursForm: ConnexionChargementRequete): Observable<JwtAuthReponse> {
    this._logger.next(true);
    return this.httpClient.post<JwtAuthReponse>(`${this.API_URL}/connexion`, valeursForm)
      .pipe(
        tap(jwtAuthReponse => {
          if (jwtAuthReponse?.token) {
            this.sauvegarderToken(jwtAuthReponse.token);
            this._logger.next(true);
          }
        }));
  }

  deconnexion(): void {
    localStorage.clear();
    this._logger.next(false);
  }

  sauvegarderToken(token: string): void {
    localStorage.setItem('token', token);
    this._logger.next(true);
  }

  isConnecte(): boolean {
    return localStorage.getItem('token') !== null;
  }

  getToken(): string {
    return localStorage.getItem('token') as string;
  }

  decodeToken(token: string): string|null {
    try {
      return jwt_decode(token);
    } catch(Error) {
      return null;
    }
  }

}
