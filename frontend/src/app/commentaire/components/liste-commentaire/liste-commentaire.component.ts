import {Component, Input, OnInit} from '@angular/core';
import {Commentaire} from "../../../en-partage/models/dtos/Commentaire";

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
