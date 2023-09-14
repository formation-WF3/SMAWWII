import {Component, Input, OnInit} from '@angular/core';
import {Commentaire} from "../../../shared/models/dtos/commentaire";

@Component({
  selector: 'app-liste-commentaire',
  templateUrl: './liste-commentaire.component.html',
  styleUrls: ['./liste-commentaire.component.scss']
})
export class ListeCommentaireComponent implements OnInit {
  titre: string = "Commentaires";

  @Input()
  commentaires: Commentaire[] = [];

  constructor() {
  }

  ngOnInit() {
  }
}
