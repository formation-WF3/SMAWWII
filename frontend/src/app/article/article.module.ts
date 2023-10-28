import {NgModule} from '@angular/core';
import {CommonModule, NgOptimizedImage} from '@angular/common';

import {ArticleRoutingModule} from './article-routing.module';
import {PageArticleComponent} from './pages/page-article/page-article.component';
import {ListeArticleComponent} from './components/liste-article/liste-article.component';
import {CarteArticleComponent} from './components/carte-article/carte-article.component';
import {ArticleService} from "./services/article.service";
import {DetailArticleComponent} from './components/detail-article/detail-article.component';
import {CommentaireModule} from "./commentaire/commentaire.module";
import {CommentaireService} from "./commentaire/services/commentaire.service";
import {FormCommentaireComponent} from "./commentaire/components/form-commentaire/form-commentaire.component";
import { CoreModule } from '../core/core.module';


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
        CommentaireModule,
        NgOptimizedImage,
        CoreModule
    ],
  providers: [
    ArticleService,
    CommentaireService,
    FormCommentaireComponent
  ]
})
export class ArticleModule {
}
