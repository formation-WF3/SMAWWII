import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Commentaire} from "../../../shared/models/dtos/commentaire";

@Component({
  selector: 'app-detail-commentaire',
  templateUrl: './detail-commentaire.component.html',
  styleUrls: ['./detail-commentaire.component.scss']
})
export class DetailCommentaireComponent {
  @Input()
  commentaire!: Commentaire;

  @Output()
  commentaireEnvoye: EventEmitter<Commentaire> = new EventEmitter<Commentaire>();

  envoyerCommentaire(commentaire: Commentaire): void {
    this.commentaireEnvoye.emit(commentaire);
  }
}
