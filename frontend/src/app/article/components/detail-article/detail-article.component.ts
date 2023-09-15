import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ArticleService} from "../../services/article.service";
import {Article} from "../../../shared/models/dtos/article";
import {Commentaire} from "../../../shared/models/dtos/commentaire";

@Component({
  selector: 'app-detail-article',
  templateUrl: './detail-article.component.html',
  styleUrls: ['./detail-article.component.scss']
})
export class DetailArticleComponent implements OnInit {
  titre: string = "Commentaires";
  article: Article = {};
  succesMessage?: string;

  constructor(
    private activatedRoute: ActivatedRoute,
    private articleService: ArticleService
  ) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap
      .subscribe(params => {
        const id = params.get('id') as string;
        if (id) {
          this.articleService.getById(+id).subscribe(article => this.article = article);
        }
      }
    );
  }

  recevoirCommentaire(commentaire: Commentaire): void {
    if (this.article.commentaires?.length) {
      this.article.commentaires.push(commentaire);
    } else {
      this.article.commentaires = [commentaire];
    }
    this.succesMessage = 'Commentaire ajouté avec succès';
  }

}
