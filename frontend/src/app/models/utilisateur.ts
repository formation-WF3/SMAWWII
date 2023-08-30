import {Role} from "./role";

export interface Utilisateur {
  id?: number;
  nomUtilisateur?: string;
  motDePasse?: string;
  email?: string;
  emailVerifiee?: boolean;
  cleActivation?: string;
  dateActivation?: Date;
  dateEnregistrement?: Date;
  actif?: boolean;
  role?: Role;
}
