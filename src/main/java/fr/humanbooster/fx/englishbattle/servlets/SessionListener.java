package fr.humanbooster.fx.englishbattle.servlets;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{

    private JoueurService joueurService = new JoueurServiceImpl();


    /**
     * Patron Observateur/Observé
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent evenement) {
        Partie partie = (Partie) evenement.getSession().getAttribute("partie");
        if (partie != null) {
            Joueur joueur = partie.getJoueur();
            joueur.setEstEnLigne(false);
            joueurService.mettreAJourJoueur(joueur.getId(), joueur.getEmail(), joueur.getNom(), joueur.getPrenom(), joueur.getMotDePasse(), joueur.getVille(), joueur.getNiveau(), false);
            System.out.println("Déconnexion de " + partie.getJoueur().getPrenom());
        }
    }
}