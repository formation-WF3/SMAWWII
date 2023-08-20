import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, tap} from "rxjs";
import {Article} from "../../shared/models/dtos/Article";

@Injectable()
export class ArticleService {
  API_URL: string = 'http://localhost:8080';

  constructor(
    private httpClient: HttpClient
  ) {
  }

  getAll(): Observable<Article[]> {
    return this.httpClient.get<Article[]>(`${this.API_URL}/articles`);
  }
}
