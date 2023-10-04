import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {CommentaireRoutingModule} from './commentaire-routing.module';
import {DetailCommentaireComponent} from './components/detail-commentaire/detail-commentaire.component';
import {FormCommentaireComponent} from './components/form-commentaire/form-commentaire.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommentaireService} from "./services/commentaire.service";
import {NgbDropdown, NgbDropdownItem, NgbDropdownMenu, NgbDropdownToggle} from "@ng-bootstrap/ng-bootstrap";


@NgModule({
  declarations: [
    DetailCommentaireComponent,
    FormCommentaireComponent
  ],
  exports: [
    DetailCommentaireComponent,
    FormCommentaireComponent
  ],
  imports: [
    CommonModule,
    CommentaireRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgbDropdownItem,
    NgbDropdownMenu,
    NgbDropdownToggle,
    NgbDropdown
  ],
  providers: [
    CommentaireService
  ]
})
export class CommentaireModule {
}
