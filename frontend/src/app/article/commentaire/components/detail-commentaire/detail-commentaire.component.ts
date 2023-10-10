import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Commentaire} from "../../../../shared/models/dtos/commentaire";
import {AuthService} from "../../../../auth/services/auth.service";

@Component({
  selector: 'app-detail-commentaire',
  templateUrl: './detail-commentaire.component.html',
  styleUrls: ['./detail-commentaire.component.scss']
})
export class DetailCommentaireComponent implements OnInit {
  succesMessage?: string;

  @Input()
  commentaire!: Commentaire;
  @Input()
  utilisateurEstConnecte!: boolean;
  @Input()
  idCommentaireEnEdition?: number;

  // Variable émise plus bas
  @Output()
  edition= new EventEmitter<number>();

  constructor(
    private authService: AuthService
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
    this.idCommentaireEnEdition = this.commentaire.id;
  }

}
