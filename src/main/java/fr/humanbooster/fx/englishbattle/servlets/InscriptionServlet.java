package fr.humanbooster.fx.englishbattle.servlets;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Niveau;
import fr.humanbooster.fx.englishbattle.business.Ville;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.NiveauService;
import fr.humanbooster.fx.englishbattle.service.VilleService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.NiveauServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VilleServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = { "/inscription"}, loadOnStartup = 1)
public class InscriptionServlet extends HttpServlet {

    private static final NiveauService ns = new NiveauServiceImpl();
    private static final VilleService vs = new VilleServiceImpl();
    private static final JoueurService js = new JoueurServiceImpl();



    private static final Long serialVersiionUIO =1L;
    //Envoie à la vue les villes et niveau
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("niveaux", ns.recupererNiveaux());
        req.setAttribute("villes", vs.recupererVilles());

        req.getRequestDispatcher("WEB-INF/inscription.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email= req.getParameter("email");
        String nom= req.getParameter("nom");
        String prenom= req.getParameter("prenom");
        String password= req.getParameter("password");
        Long idNiveau= Long.parseLong(req.getParameter("Niveau"));
        Long idVille= Long.parseLong(req.getParameter("Ville"));

        Joueur joueur = js.ajouterJoueur(email,nom,prenom,password, vs.recupererVille(idVille), ns.recupererNiveau(idNiveau));
        // hydratation de l'objet req avec le nouveau joueur
        req.setAttribute("joueur",joueur);

        System.out.println(joueur);


        req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
    }
}
