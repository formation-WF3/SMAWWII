import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Utilisateur} from "../../models/utilisateur";
import {EnregistrementChargementRequete} from "../models/enregistrement-chargement-requete";
import {ConnexionChargementRequete} from "../models/connexion-chargement-requete";

@Injectable()
export class AuthService {
  API_URL: string = 'http://localhost:8080/api/auth';

  constructor(
    private httpClient: HttpClient
  ) {
  }

  enregistrementUtilisateur(valeursForm: EnregistrementChargementRequete): Observable<Utilisateur> {
    return this.httpClient.post(`${this.API_URL}/enregistrement`, valeursForm);
  }

  connexionUtilisateur(valeursForm: ConnexionChargementRequete): Observable<Utilisateur> {
    return this.httpClient.post(`${this.API_URL}/connexion`, valeursForm);
  }

}
