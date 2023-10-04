import {Component, Input} from '@angular/core';
import {Commentaire} from "../../../../shared/models/dtos/commentaire";

@Component({
  selector: 'app-liste-commentaire',
  templateUrl: './liste-commentaire.component.html',
  styleUrls: ['./liste-commentaire.component.scss']
})
export class ListeCommentaireComponent {
  titre: string = "Commentaires";

  @Input()
  commentaires: Commentaire[] = [];
}
