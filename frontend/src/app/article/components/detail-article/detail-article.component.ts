import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ArticleService} from "../../services/article.service";
import {Article} from "../../../shared/models/dtos/article";
import {Commentaire} from "../../../shared/models/dtos/commentaire";
import {CommentaireService} from "../../../commentaire/services/commentaire.service";

@Component({
  selector: 'app-detail-article',
  templateUrl: './detail-article.component.html',
  styleUrls: ['./detail-article.component.scss']
})
export class DetailArticleComponent implements OnInit {
  article?: Article;
  commentaires: Commentaire[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private articleService: ArticleService,
    private commentaireService: CommentaireService
  ) {
  }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params => {
      const id = params.get('id') as string;
      if (id) {
        this.articleService.getById(+id).subscribe(
          article => {
            this.article = article;

            this.commentaireService.getAllByArticleId(+id).subscribe(
              commentaires => this.commentaires = commentaires
            );
          }
        );
      }
    });

    /*
    if (this.article) {
      this.commentaireService.getAllByArticleTitre(this.article.titre).subscribe(
        commentaires => this.commentaires = commentaires
      );
    }
     */
  }
}
