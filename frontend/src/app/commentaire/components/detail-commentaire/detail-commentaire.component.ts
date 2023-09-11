import {Component, Input} from '@angular/core';
import {Commentaire} from "../../../en-partage/models/dtos/Commentaire";

@Component({
  selector: 'app-detail-commentaire',
  templateUrl: './detail-commentaire.component.html',
  styleUrls: ['./detail-commentaire.component.scss']
})
export class DetailCommentaireComponent {
  @Input()
  commentaire!: Commentaire;

}
