import {Injectable} from '@angular/core';
import {BehaviorSubject, map, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {InscriptionPayload} from "../models/inscription-payload";
import {ConnexionPayload} from "../models/connexion-payload";
import {JwtAuthReponse} from "../../shared/models/dtos/jwt-auth-reponse";
import jwt_decode from 'jwt-decode';

@Injectable()
export class AuthService {
  API_URL: string = 'http://localhost:8080/api/auth';
  private _logger: BehaviorSubject<boolean>;

  constructor(
    private httpClient: HttpClient
  ) {
    /* Permet de déterminer le statut de connexion au rechargement
     de la page et de le diffuser à tous les subscribes */
    this._logger = new BehaviorSubject<boolean>(this.isConnecte());
  }

  get loggedIn$(): Observable<boolean> {
    return this._logger.asObservable();
  }

  inscription(valeursForm: InscriptionPayload): Observable<JwtAuthReponse> {
    return this.httpClient.post(`${this.API_URL}/inscription`, valeursForm);
  }

  connexion(valeursForm: ConnexionPayload): Observable<void> {
    return this.httpClient.post<JwtAuthReponse>(`${this.API_URL}/connexion`, valeursForm)
      .pipe(
        map(jwtAuthReponse => {
          /* jwtAuthReponse.token sera toujours valué.
              Dans le cas d'une erreur Http (404, 401, 403, 500...),
               c'est l'intercepteur qui prendra le relais. */
          this.sauvegarderToken(jwtAuthReponse.token as string);
          this._logger.next(true);
        }));
  }

  deconnexion(): void {
    localStorage.clear();
    this._logger.next(false);
  }

  isConnecte(): boolean {
    return localStorage.getItem('token') !== null;
  }

  getToken(): string {
    return localStorage.getItem('token') as string;
  }

  private sauvegarderToken(token: string): void {
    localStorage.setItem('token', token);
    this._logger.next(true);
  }

  private decodeToken(token: string): string|null {
    try {
      return jwt_decode(token);
    } catch(Error) {
      return null;
    }
  }
}
