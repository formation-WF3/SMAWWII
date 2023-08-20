import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ArticleRoutingModule} from './article-routing.module';
import {ArticleComponent} from './pages/article/article.component';
import {ListeArticleComponent} from './components/liste-article/liste-article.component';
import {CarteArticleComponent} from './components/carte-article/carte-article.component';
import {ArticleService} from "./services/article.service";


@NgModule({
  declarations: [
    ArticleComponent,
    ListeArticleComponent,
    CarteArticleComponent
  ],
  imports: [
    CommonModule,
    ArticleRoutingModule
  ],
  providers: [
    ArticleService
  ]
})
export class ArticleModule {
}
