import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ArticleService} from "../../services/article.service";
import {Article} from "../../../en-partage/models/dtos/Article";
import {Commentaire} from "../../../en-partage/models/dtos/Commentaire";

@Component({
  selector: 'app-detail-article',
  templateUrl: './detail-article.component.html',
  styleUrls: ['./detail-article.component.scss']
})
export class DetailArticleComponent implements OnInit {
  article!: Article;
  commentaires: Commentaire[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private articleService: ArticleService
  ) {
  }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params => {
      const id = params.get('id') as string;
      if (id) {
        this.articleService.getById(+id).subscribe(
          article => this.article = article
        );
      }
    });


  }
}
