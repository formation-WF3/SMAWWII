import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import { NgForm } from '@angular/forms';
import {CommentairePayload} from "../../../../shared/models/dtos/commentaire-payload";

@Component({
  selector: 'app-form-commentaire',
  templateUrl: './form-commentaire.component.html',
  styleUrls: ['./form-commentaire.component.scss']
})
export class FormCommentaireComponent implements OnInit {
  @Input()
  commentaire: CommentairePayload = {};
  @Input()
  succesMessage?: string;
  @Input()
  articleId!: number;

  @Output()
  succes= new EventEmitter<CommentairePayload>();

  erreurMessage?: string;
  commentairePayloadCopie: CommentairePayload = {};

  ngOnInit() {
    this.reinitialiserFormulaire();
  }

  soumettre(): void {
    this.succes.emit(this.commentairePayloadCopie);
    this.reinitialiserFormulaire();
  }

  reinitialiserFormulaire(): void {
    this.commentairePayloadCopie =  {...this.commentaire};
  }
}
