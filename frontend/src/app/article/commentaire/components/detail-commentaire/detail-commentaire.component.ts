import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Commentaire} from "../../../../shared/models/dtos/commentaire";
import {AuthService} from "../../../../auth/services/auth.service";
import {CommentaireService} from '../../services/commentaire.service';

@Component({
  selector: 'app-detail-commentaire',
  templateUrl: './detail-commentaire.component.html',
  styleUrls: ['./detail-commentaire.component.scss']
})
export class DetailCommentaireComponent implements OnInit {
  @Input()
  commentaire!: Commentaire;
  @Input()
  utilisateurEstConnecte!: boolean;

  // Variables émisent plus bas
  @Output()
  edition = new EventEmitter<number>();
  @Output()
  suppression = new EventEmitter<number>();

  succesMessage?: string;

  constructor(
    private authService: AuthService,
    private commentaireService: CommentaireService
  ) {
  }

  ngOnInit(): void {
    if (this.utilisateurEstConnecte) {
      console.log("Quel utilisateur ?");
    }
  }

  // Emission vers l'extérieur (@Output) de $event créé par emit
  emettreEdition(): void {
    this.edition.emit(this.commentaire.id);
  }

  supprimerCommentaire(): void {
    this.suppression.emit(this.commentaire.id);
  }

}
