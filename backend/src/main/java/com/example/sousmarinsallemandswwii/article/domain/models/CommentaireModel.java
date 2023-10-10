package com.example.sousmarinsallemandswwii.article.domain.models;

import com.example.sousmarinsallemandswwii.core.domain.models.UtilisateurModel;
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
@Table(name = "commentaire")
public class CommentaireModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String texte;

    @CreatedDate
    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @LastModifiedDate
    @Column(name ="date_modification")
    private LocalDateTime dateModification;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private UtilisateurModel utilisateur;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private ArticleModel article;

}
