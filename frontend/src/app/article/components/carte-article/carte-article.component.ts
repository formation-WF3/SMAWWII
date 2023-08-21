import {Component, Input, OnInit} from '@angular/core';
import {Article} from "../../../shared/models/dtos/Article";
import {ArticleService} from "../../services/article.service";

@Component({
  selector: 'app-carte-article',
  templateUrl: './carte-article.component.html',
  styleUrls: ['./carte-article.component.scss']
})
export class CarteArticleComponent {
  titre: string = 'Carte d\'un article';

  @Input()
  article!: Article;

}
