import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Validation} from "../../../validators/validation.validator";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {SignupRequestPayload} from "../../models/signup-request-payload";


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
  signupRequestPayload: SignupRequestPayload = {
    username: '',
    password: '',
    email: ''
  };

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.formEnregistrement = this.formBuilder.group({
      nomUtilisateur: ['',
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(30)
      ],
      motDePasse: ['', Validators.required],
      confirmeMotDePasse: ['', Validators.required],
      email: ['',Validators.required]
    }, {
      validators: [Validation.patternMotDePasseValidator('motDePasse'), Validation.champsIdentiquesValidator(
        'motDePasse', 'confirmeMotDePasse'), Validation.patternEmailValidator('email')]
    });
  }

  get f(): { [key: string]: AbstractControl } {
    return this.formEnregistrement.controls;
  }

  enregistrementUtilisateurForm(): void {
    this.soumis = true;

    if (this.formEnregistrement.invalid) {
      return;
    }

    this.signupRequestPayload.username = this.formEnregistrement.value['nomUtilisateur'];
    this.signupRequestPayload.password = this.formEnregistrement.value['motDePasse'];
    this.signupRequestPayload.email = this.formEnregistrement.value['email'];

    this.authService.enregistrementUtilisateur(this.signupRequestPayload).subscribe(
      data => {

        this.reinitialisationForm();
        this.router.navigate(['/articles']);
      },
      error => {
        console.error("L'enregistrement a échoué !")
        this.chargement = false;
      }
    );

    console.log(this.formEnregistrement.value);
  }

  reinitialisationForm(): void {
    this.soumis = false;
    this.formEnregistrement.reset();
  }

}
