import {Component, Input, OnInit} from '@angular/core';
import {Article} from "../../../shared/models/dtos/Article";

@Component({
  selector: 'app-carte-article',
  templateUrl: './carte-article.component.html',
  styleUrls: ['./carte-article.component.scss']
})
export class CarteArticleComponent {
  @Input()
  article!: Article;

}
