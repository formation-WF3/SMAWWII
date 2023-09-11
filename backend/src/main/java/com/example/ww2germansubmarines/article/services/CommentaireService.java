package com.example.ww2germansubmarines.article.services;

import com.example.ww2germansubmarines.article.adapters.CommentaireAdapter;
import com.example.ww2germansubmarines.article.domain.repositories.CommentaireRepository;
import com.example.ww2germansubmarines.article.rest.dtos.CommentaireDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CommentaireService {
    private CommentaireRepository commentaireRepository;

    private CommentaireAdapter commentaireAdapter;

    public List<CommentaireDto> getAll() {
        return commentaireRepository.findAll()
                .stream()
                .map(commentaireAdapter::toDto)
                .collect(Collectors.toList());
    }

    public List<CommentaireDto> getAllByArticleId(long id) {
        return commentaireRepository.findAllByArticleId(id)
                .stream()
                .map(commentaireAdapter::toDto)
                .collect(Collectors.toList());
    }

    public List<CommentaireDto> getAllByArticleTitre(String titre) {
        return commentaireRepository.findAllByArticleTitre(titre)
                .stream()
                .map(commentaireAdapter::toDto)
                .collect(Collectors.toList());
    }

}
