import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Utilisateur} from "../../models/utilisateur";

@Injectable()
export class AuthService {
  API_URL: string = 'http://localhost:8080/api/auth';

  constructor(
    private httpClient: HttpClient
  ) {
  }

  enregistrementUtilisateur(valeursForm: Utilisateur): Observable<Utilisateur> {
    return this.httpClient.post(`${this.API_URL}/signup`, valeursForm);
  }

}