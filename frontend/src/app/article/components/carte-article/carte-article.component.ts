import {Component, Input} from '@angular/core';
import {Article} from "../../../shared/models/dtos/article";

@Component({
  selector: 'app-carte-article',
  templateUrl: './carte-article.component.html',
  styleUrls: ['./carte-article.component.scss']
})
export class CarteArticleComponent {
  @Input()
  article!: Article;
}
