package com.bowling;

import io.cucumber.java.After;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Lorsque;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static java.util.stream.Stream.iterate;
import static org.assertj.core.api.Assertions.assertThat;

public class PartieBowlingStepDefs {

    private PartieBowling partieBowling;
    private Exception erreurDeclenchee;
    private boolean verifierAbsenceErreur = true;

    @Etantdonné("une nouvelle partie de bowling")
    public void une_nouvelle_partie_de_bowling() {
        partieBowling = new PartieBowling();
    }

    @Alors("le score est égal à {int}")
    public void le_score_est_égal_à(int score) {
        assertThat(partieBowling.score()).isEqualTo(score);
    }

    @Lorsque("le joueur( a) fait tomber {int} quille(s)")
    public void le_joueur_fait_tomber_quilles(int quillesTombees) {
        try {
            partieBowling.lancer(quillesTombees);
        } catch (Exception e) {
            this.erreurDeclenchee = e;
        }
    }

    @Lorsque("le joueur( a) fait tomber {int} quille(s) {int} fois")
    public void le_joueur_fait_tomber_quilles_n_fois(int quillesTombees, int nombreDeFois) {
        iterate(0, i -> i).limit(nombreDeFois).forEach(i -> le_joueur_fait_tomber_quilles(quillesTombees));
    }

    @Alors("le nombre de manches est {int}")
    public void le_nombre_de_manches_est(int nombreManches) {
        assertThat(partieBowling.nombreManches()).isEqualTo(nombreManches);
    }

    @Alors("il y a une erreur")
    public void il_y_a_une_erreur() {
        verifierAbsenceErreur = false;
        assertThat(erreurDeclenchee).as("Une erreur devrait survenir").isNotNull();
    }

    @Alors("il y a un Spare")
    public void il_y_a_un_Spare() {
        assertThat(partieBowling.isSpare()).isTrue();
    }

    @Alors("il y a un Strike")
    public void il_y_a_un_Strike() {
        assertThat(partieBowling.isStrike()).isTrue();
    }

    @Alors("la manche est terminée")
    public void la_manche_est_terminée() {
        assertThat(partieBowling.isStrike()).isTrue();
    }

    @Alors("la partie est terminée")
    public void la_partie_est_terminée() {
        assertThat(partieBowling.estTerminee()).isTrue();
    }

    @Etantdonnéque("le joueur a fait tomber les quilles suivantes : {}")
    public void le_joueur_a_fait_tomber_les_quilles_suivantes(String quillesTombees) {
        asList(quillesTombees.split(",")).stream()
                .mapToInt(s -> parseInt(s))
                .forEach(lancer -> le_joueur_fait_tomber_quilles(lancer));
    }

    @After
    public void il_n_y_a_pas_eu_d_erreur() {
        if (verifierAbsenceErreur) {
            assertThat(erreurDeclenchee).isNull();
        }
    }
}
