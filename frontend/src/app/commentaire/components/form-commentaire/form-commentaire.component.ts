import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {CommentaireService} from "../../services/commentaire.service";

@Component({
  selector: 'app-form-commentaire',
  templateUrl: './form-commentaire.component.html',
  styleUrls: ['./form-commentaire.component.scss']
})
export class FormCommentaireComponent implements OnInit {
  formCommentaire: FormGroup = new FormGroup({
    texte: new FormControl('')
  });
  soumis = false;
  chargement = false;
  erreurMessage?: String;

  constructor(
    private formBuilder: FormBuilder,
    private commentaireService: CommentaireService,
    private router: Router
  ) {
  }

  get f(): { [key: string]: AbstractControl } {
    return this.formCommentaire.controls;
  }

  ngOnInit() {
    this.formCommentaire = this.formBuilder.group({
      texte: ['',
        [Validators.required,
          Validators.minLength(10),
          Validators.maxLength(250)]
      ]
    });
  }

  commentaireForm(): void {
    this.soumis = true;

    if (this.formCommentaire.invalid) {
      return;
    }

    if (!this.formCommentaire.invalid) {
      console.table(this.formCommentaire);
    }

    // this.commentaireService.commenter({...this.formCommentaire.value}).subscribe({
    //   next: data => {
    //     this.reinitialisationForm();
    //     this.router.navigate(['/articles']);
    //   },
    //   error: (error) => {
    //     this.erreurMessage = error;
    //     this.chargement = false;
    //   }
    // });
  }

  reinitialisationForm(): void {
    this.soumis = false;
    this.formCommentaire.reset();
  }

}
