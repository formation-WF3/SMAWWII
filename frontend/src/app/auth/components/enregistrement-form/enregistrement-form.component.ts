import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Validation} from "../../../validators/validation.validator";
import {AuthService} from "../../services/auth.service";
import {tap} from "rxjs";


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

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService
  ) {
  }

  ngOnInit() {
    this.formEnregistrement = this.formBuilder.group({
      nomUtilisateur: ['',
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(30)
      ],
      motDePasse: ['',
        Validators.required,
        Validators.minLength(8),
        Validators.maxLength(20)
      ],
      confirmeMotDePasse: ['', Validators.required],
      email: ['',
        Validators.required,
        Validators.email
      ]
    }, {
      validators: [Validation.patternMotDePasseValidator('motDePasse'), Validation.champsIdentiquesValidator(
        'motDePasse', 'confirmeMotDePasse'
      )]
    });
  }

  get f(): { [key: string]: AbstractControl } {
    return this.formEnregistrement.controls;
  }

  enregistrementDonneesForm(): void {
    this.soumis = true;

    if (this.formEnregistrement.invalid) {
      return;
    }

    this.authService.enregistrementUtilisateur(this.formEnregistrement.value).pipe(
      tap((enregistre) => {
        if (enregistre) {
          this.reinitialisationForm();
        } else {
          console.error('Echec de l\'enregistrement');
        }
      })
    ).subscribe();

    console.log(this.formEnregistrement);
  }

  reinitialisationForm(): void {
    this.soumis = false;
    this.formEnregistrement.reset();
  }

}
