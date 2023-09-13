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

  getAllByArticleId(id: number): Observable<Commentaire[]> {
    return this.httpClient.get<Commentaire[]>(`${this.API_URL}/articles/${id}/commentaires`);
  }

  add(articleId: number, valeursForm: Commentaire): Observable<any> {
    return this.httpClient.post(`${this.API_URL}/articles/${articleId}/commentaires`, valeursForm);
  }

  getAllByArticleTitre(ArticleTitre: string): Observable<Commentaire[]> {
    return this.httpClient.get<Commentaire[]>(`${this.API_URL}/articles/${ArticleTitre}/commentaires`);
  }

}
