package com.example.sousmarinsallemandswwii.core.services;

import com.example.sousmarinsallemandswwii.core.adapters.UtilisateurAdapter;
import com.example.sousmarinsallemandswwii.core.domain.models.UtilisateurModel;
import com.example.sousmarinsallemandswwii.core.domain.repositories.UtilisateurRepository;
import com.example.sousmarinsallemandswwii.core.exceptions.EntiteNonTrouveException;
import com.example.sousmarinsallemandswwii.core.exceptions.RaisonEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class UtilisateurServiceTest {

    @Mock
    UtilisateurRepository utilisateurRepository;

    @Mock
    UtilisateurAdapter utilisateurAdapter;

    @InjectMocks
    UtilisateurService utilisateurService;

    @Test
    void doitRetournerUnUtilisateurQuandUnNomExistantEstFourni() {
        // given
        UtilisateurModel utilisateurAttendu = UtilisateurModel.builder()
                .nomUtilisateur("Caroline").build();

        given(utilisateurRepository.findByNomUtilisateur(utilisateurAttendu.getNomUtilisateur())).willReturn(of(utilisateurAttendu));

        // when
        UtilisateurModel utilisateurRecu = utilisateurService.getByNomIfExists(utilisateurAttendu.getNomUtilisateur());

        // then
        assertEquals(utilisateurAttendu.getNomUtilisateur(), utilisateurRecu.getNomUtilisateur());
    }

    @Test
    void doitRetournerUneExceptionSiLUtilisateurNExistePas() {
        // given
        String nomUtilisateur = "Carolin";
        given(utilisateurRepository.findByNomUtilisateur (nomUtilisateur)).willThrow(new EntiteNonTrouveException(RaisonEnum.UTILISATEUR_INTROUVABLE));

        //when, then
        assertThrows(EntiteNonTrouveException.class, () -> utilisateurService.getByNomIfExists("Carolin"));
    }
}
