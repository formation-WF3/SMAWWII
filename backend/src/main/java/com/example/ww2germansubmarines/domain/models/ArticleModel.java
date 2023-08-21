package com.example.ww2germansubmarines.domain.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "article")
public class ArticleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String titre;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String texte;

    @CreatedDate
    @Column(name = "date_creation", nullable = false)
    private LocalDateTime dateCreation;

    @LastModifiedDate
    @Column(name = "date_modification")
    private LocalDateTime dateModification;

    @Column(nullable = false)
    private boolean actif;

    @Column(name = "image_src", length = 50)
    private String imageSrc;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private CategorieModel categorie;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private UtilisateurModel utilisateur;

}
