import {Commentaire} from "./commentaire";

export interface Article {
  id?: number;
  titre?: string;
  descriptionCourte?: string;
  texte?: string;
  dateCreation?: Date;
  dateModification?: Date;
  actif?: boolean;
  imageSrc?: string;
  commentaires?: Commentaire[];
  categorieNom?: string;
  utilisateurNom?: string;
}
