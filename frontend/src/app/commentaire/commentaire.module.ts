import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {CommentaireRoutingModule} from './commentaire-routing.module';
import {ListeCommentaireComponent} from './components/liste-commentaire/liste-commentaire.component';
import {CommentaireComponent} from './services/commentaire/commentaire.component';


@NgModule({
    declarations: [
        ListeCommentaireComponent,
        CommentaireComponent
    ],
    exports: [
        ListeCommentaireComponent
    ],
    imports: [
        CommonModule,
        CommentaireRoutingModule
    ]
})
export class CommentaireModule { }
