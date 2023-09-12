import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {CommentaireRoutingModule} from './commentaire-routing.module';
import {ListeCommentaireComponent} from './components/liste-commentaire/liste-commentaire.component';
import {DetailCommentaireComponent} from './components/detail-commentaire/detail-commentaire.component';


@NgModule({
  declarations: [
    ListeCommentaireComponent,
    DetailCommentaireComponent
  ],
  exports: [
    ListeCommentaireComponent,
    DetailCommentaireComponent
  ],
  imports: [
    CommonModule,
    CommentaireRoutingModule
  ]
})
export class CommentaireModule {
}
