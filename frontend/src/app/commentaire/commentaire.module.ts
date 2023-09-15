import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {CommentaireRoutingModule} from './commentaire-routing.module';
import {ListeCommentaireComponent} from './components/liste-commentaire/liste-commentaire.component';
import {DetailCommentaireComponent} from './components/detail-commentaire/detail-commentaire.component';
import {FormCommentaireComponent} from './components/form-commentaire/form-commentaire.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommentaireService} from "./services/commentaire.service";


@NgModule({
  declarations: [
    ListeCommentaireComponent,
    DetailCommentaireComponent,
    FormCommentaireComponent
  ],
  exports: [
    ListeCommentaireComponent,
    DetailCommentaireComponent,
    FormCommentaireComponent
  ],
    imports: [
        CommonModule,
        CommentaireRoutingModule,
        ReactiveFormsModule,
        FormsModule
    ],
  providers: [
    CommentaireService
  ]
})
export class CommentaireModule {
}
