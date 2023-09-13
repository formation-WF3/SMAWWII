import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Commentaire} from "../../en-partage/models/dtos/Commentaire";

@Injectable()
export class CommentaireService {
  API_URL: string = 'http://localhost:8080/api';

  constructor(
    private httpClient: HttpClient
  ) {
  }

  getAll(): Observable<Commentaire[]> {
    return this.httpClient.get<Commentaire[]>(`${this.API_URL}/commentaires`);
  }

  getAllByArticleId(id: number): Observable<Commentaire[]> {
    return this.httpClient.get<Commentaire[]>(`${this.API_URL}/commentaires/id/${id}`);
  }

  commenter(valeursForm: Commentaire): Observable<any> {
    return this.httpClient.post(`${this.API_URL}/commentaires`, valeursForm);
  }

  getAllByArticleTitre(titre: string): Observable<Commentaire[]> {
    return this.httpClient.get<Commentaire[]>(`${this.API_URL}/commentaires/${titre}`);
  }

}
