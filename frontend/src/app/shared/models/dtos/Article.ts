export interface Article {
  id?: number;
  titre?: string;
  descriptionCourte?: string;
  texte?: string;
  dateCreation?: Date;
  dateModification?: Date;
  actif?: boolean;
  imageSrc?: string;
  categorieNom?: string;
  utilisateurNom?: string;
}
