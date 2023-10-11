import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ArticleService} from "../../services/article.service";
import {Article} from "../../../shared/models/dtos/article";
import {AuthService} from "../../../auth/services/auth.service";
import {CommentairePayload} from "../../../shared/models/dtos/commentaire-payload";
import {CommentaireService} from "../../commentaire/services/commentaire.service";

@Component({
  selector: 'app-detail-article',
  templateUrl: './detail-article.component.html',
  styleUrls: ['./detail-article.component.scss']
})
export class DetailArticleComponent implements OnInit {
  titre: string = "Commentaires";
  article: Article = {};
  succesMessage?: string;
  utilisateurEstConnecte = false;
  idCommentaireEnEdition?: number;

  constructor(
    private activatedRoute: ActivatedRoute,
    private articleService: ArticleService,
    private commentaireService: CommentaireService,
    private authService: AuthService
  ) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap
      .subscribe(params => {
        const id = params.get('id') as string;
        if (id) {
          this.articleService.getById(+id).subscribe(article => this.article = article);
        }
      }
    );
    this.utilisateurEstConnecte = this.authService.isConnecte();
  }

  enregistrerCommentaire(commentairePayload: CommentairePayload): void {
    const isEdition = !!commentairePayload.id;

    this.commentaireService.enregistrer(this.article.id!, commentairePayload).subscribe({
      next: commentaireRecu => {
        if (isEdition) {

          if (this.article.commentaires?.length) {
            const index = this.article.commentaires.findIndex(commentaire => commentaireRecu.id === commentaire.id);

            if (index >= 0) {
              this.article.commentaires[index] = commentaireRecu;
              this.idCommentaireEnEdition = undefined;
            }
          }

        } else {
          if (this.article.commentaires?.length) {
            this.article.commentaires.push(commentaireRecu);
          } else {
            this.article.commentaires = [commentaireRecu];
          }
        }

        this.succesMessage = 'Commentaire enregistré avec succès';
      }
    });
  }

  supprimerCommentaire(idCommentaire: number): void {
    console.log(idCommentaire);
    this.commentaireService.supprimer(this.article.id!, idCommentaire).subscribe({
      next: commentaireASupprimer => {
        if (this.article.commentaires!.length > 1) {
          const index = this.article.commentaires!.findIndex(commentaire => commentaireASupprimer.id === commentaire.id);

          if (index != -1) {
            this.article.commentaires = this.article.commentaires!.splice(index, 1);
          }
        } else {
          this.article.commentaires = [];
        }
      }
    });

    console.log("Commentaire supprimé !");
  }

}
