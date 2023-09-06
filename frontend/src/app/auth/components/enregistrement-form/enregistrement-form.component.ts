import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Validation} from "../../../core/validators/validation.validator";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-enregistrement-form',
  templateUrl: './enregistrement-form.component.html',
  styleUrls: ['./enregistrement-form.component.scss']
})
export class EnregistrementFormComponent implements OnInit {
  formEnregistrement: FormGroup = new FormGroup({
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
    return this.formEnregistrement.controls;
  }

  ngOnInit() {
    this.formEnregistrement = this.formBuilder.group({
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

  enregistrementUtilisateurForm(): void {
    this.soumis = true;

    if (this.formEnregistrement.invalid) {
      return;
    }

    this.authService.enregistrementUtilisateur({...this.formEnregistrement.value}).subscribe({
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
    this.formEnregistrement.reset();
  }

}
