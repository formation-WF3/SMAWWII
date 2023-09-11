import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ArticleRoutingModule} from './article-routing.module';
import {PageArticleComponent} from './pages/page-article/page-article.component';
import {ListeArticleComponent} from './components/liste-article/liste-article.component';
import {CarteArticleComponent} from './components/carte-article/carte-article.component';
import {ArticleService} from "./services/article.service";
import {DetailArticleComponent} from './components/detail-article/detail-article.component';
import {CommentaireModule} from "../commentaire/commentaire.module";


@NgModule({
  declarations: [
    PageArticleComponent,
    ListeArticleComponent,
    CarteArticleComponent,
    DetailArticleComponent
  ],
  imports: [
    CommonModule,
    ArticleRoutingModule,
    CommentaireModule
  ],
  providers: [
    ArticleService
  ]
})
export class ArticleModule {
}
