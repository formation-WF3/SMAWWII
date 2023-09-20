import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CommentaireService} from "../../services/commentaire.service";
import {ActivatedRoute} from "@angular/router";
import {CommentairePayload} from "../../../shared/models/dtos/commentaire-payload";
import {Commentaire} from "../../../shared/models/dtos/commentaire";

@Component({
  selector: 'app-form-commentaire',
  templateUrl: './form-commentaire.component.html',
  styleUrls: ['./form-commentaire.component.scss']
})
export class FormCommentaireComponent implements OnInit {
  commentairePayload: CommentairePayload = {};
  erreurMessage?: string;

  @Input()
  succesMessage?: string;
  @Input()
  articleId!: number;
  @Input()
  commentaireRecu!: Commentaire;

  @Output()
  succes = new EventEmitter<Commentaire>();

  constructor(
    private activatedRoute: ActivatedRoute,
    private commentaireService: CommentaireService
  ) {
  }

  ngOnInit(): void {
    if (this.commentaireRecu) {
      this.commentairePayload.id = this.commentaireRecu.id;
      this.commentairePayload.texte = this.commentaireRecu.texte;
      console.log(this.commentaireRecu);
    }
  }

  soumettre(): void {
    this.commentaireService.enregistrer(this.articleId, this.commentairePayload).subscribe({
      next: commentaire => {
        this.succes.emit(commentaire);
        this.reinitialiserFormulaire();
      },
      error: error => this.erreurMessage = error
    });
  }

  reinitialiserFormulaire(): void {
    this.commentairePayload.id = undefined;
    this.commentairePayload.texte = '';
  }
}
