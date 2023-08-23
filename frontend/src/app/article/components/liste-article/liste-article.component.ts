import {Component, OnInit} from '@angular/core';
import {Article} from "../../../shared/models/dtos/Article";
import {ArticleService} from "../../services/article.service";


@Component({
  selector: 'app-liste-article',
  templateUrl: './liste-article.component.html',
  styleUrls: ['./liste-article.component.scss']
})
export class ListeArticleComponent implements OnInit {
  titre: string = 'Les articles';
  articles: Article[] = [];

  constructor(
    private articleService: ArticleService
  ) {
  }

  ngOnInit() {
    this.articleService.getAll().subscribe(
      articles => this.articles = articles
    );
  }
}
