import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Article} from "../../shared/models/dtos/article";

@Injectable()
export class ArticleService {
  API_URL: string = 'http://localhost:8080/api';

  constructor(
    private httpClient: HttpClient
  ) {
  }

  getAll(): Observable<Article[]> {
    return this.httpClient.get<Article[]>(`${this.API_URL}/articles`);
  }

  getById(id: number): Observable<Article> {
    return this.httpClient.get<Article>(`${this.API_URL}/articles/${id}`);
  }
}
