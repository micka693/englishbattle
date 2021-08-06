package fr.humanbooster.fx.englishbattle.servlets;

import fr.humanbooster.fx.englishbattle.service.NiveauService;
import fr.humanbooster.fx.englishbattle.service.VerbeService;
import fr.humanbooster.fx.englishbattle.service.VilleService;
import fr.humanbooster.fx.englishbattle.service.impl.NiveauServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VerbeServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VilleServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/init"}, loadOnStartup = 1)
public class InitServlet extends HttpServlet {
    static VerbeService verbeService = new VerbeServiceImpl();
    private NiveauService niveauService = new NiveauServiceImpl();

    private VilleService villeService = new VilleServiceImpl();


    @Override
    public void init(){
        verbeService.importerVerbes();
        System.out.println("nombre de verbes trouvé : " + verbeService.recupererNbVerbes());

        //Si pas de villes -> ajouter ville
        if (villeService.recupererVilles().isEmpty()){
            villeService.ajouterVille("Lyon");
            villeService.ajouterVille("PAs sté");
            villeService.ajouterVille("Paris");

        }

        //Si pas de niveaux en bdd -> ajouter ces niveaux
        if (niveauService.recupererNiveaux().isEmpty()){
            niveauService.ajouterNiveau("Débutant");
            niveauService.ajouterNiveau("Intermédiaire");
            niveauService.ajouterNiveau("Expert");
        }

    }
}