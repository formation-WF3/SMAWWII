import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Validation} from "../../../core/validators/validation.validator";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-page-inscription',
  templateUrl: './page-inscription.component.html',
  styleUrls: ['./page-inscription.component.scss']
})
export class PageInscriptionComponent implements OnInit {
  formInscription: FormGroup = new FormGroup({
    nomUtilisateur: new FormControl(''),
    motDePasse: new FormControl(''),
    confirmeMotDePasse: new FormControl(''),
    email: new FormControl('')
  });
  soumis = false;
  chargement = false;
  erreurMessage?: String;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
  }

  get f(): { [key: string]: AbstractControl } {
    return this.formInscription.controls;
  }

  ngOnInit() {
    this.formInscription = this.formBuilder.group({
      nomUtilisateur: ['',
        [Validators.required,
        Validators.minLength(4),
        Validators.maxLength(30)]
      ],
      motDePasse: ['', Validators.required],
      confirmeMotDePasse: ['', Validators.required],
      email: ['', Validators.required]
    }, {
      validators: [Validation.patternMotDePasseValidateur('motDePasse'), Validation.champsIdentiquesValidateur(
        'motDePasse', 'confirmeMotDePasse'), Validation.patternEmailValidateur('email')]
    });
  }

  inscriptionUtilisateurForm(): void {
    this.soumis = true;

    if (this.formInscription.invalid) {
      return;
    }

    this.authService.inscription({...this.formInscription.value}).subscribe({
      next: data => {
        this.reinitialisationForm();
        this.router.navigate(['/articles']);
      },
      error: (error) => {
        this.erreurMessage = error;
        this.chargement = false;
      }
    });
  }

  reinitialisationForm(): void {
    this.soumis = false;
    this.formInscription.reset();
  }

}
