import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Commentaire} from "../../../shared/models/dtos/commentaire";
import {CommentairePayload} from "../../../shared/models/dtos/commentaire-payload";

@Injectable()
export class CommentaireService {
  API_URL: string = 'http://localhost:8080/api';

  constructor(
    private httpClient: HttpClient
  ) {
  }

  getAllByArticleId(id: number): Observable<Commentaire[]> {
    return this.httpClient.get<Commentaire[]>(`${this.API_URL}/articles/${id}/commentaires`);
  }

  enregistrer(articleId: number, valeursForm: CommentairePayload): Observable<Commentaire> {
    return this.httpClient.post(`${this.API_URL}/articles/${articleId}/commentaires`, valeursForm);
  }
}
