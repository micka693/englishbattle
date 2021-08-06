package fr.humanbooster.fx.englishbattle.servlets;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.PartieService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.PartieServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static fr.humanbooster.fx.englishbattle.servlets.InitServlet.verbeService;
@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {

    private JoueurService joueurService = new JoueurServiceImpl();
    private PartieService partieService = new PartieServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ok");
        if (verbeService.recupererNbVerbes()==0)
        {       //req. cest les request et resp. les response
            req.setAttribute("erreur", "il n'est pas possible de jouer, la base de verbes irr&eacute;guliers est vide");
            req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
        }

        // On récupère les données saisies sur le formulaire de connexion
        String email = req.getParameter("email");
        String motDePasse = req.getParameter("password");

        // On essaie de récupérer un joueur avec ces données
        Joueur joueur = joueurService.recupererJoueurParEmailEtMotDePasse(email, motDePasse);
        if (joueur != null) {
            // Le joueur a saisi le bon email + mdp
            joueur.setEstEnLigne(true);
            System.out.println("Connexion de " + joueur.getPrenom());
            joueurService.mettreAJourJoueur(joueur.getId(), joueur.getEmail(), joueur.getMotDePasse(), joueur.getEmail(), joueur.getMotDePasse(), joueur.getVille(), joueur.getNiveau(), true);
            // Ajout d'une partie et mise en session de cette partie
            // get session veut dire on creer une session de garder la session ouverte
            //et tu lance une parti pour le joueur co a cette session
            req.getSession().setAttribute("partie", partieService.ajouterPartie(joueur));
            // On passe le relai à la servlet QuestionServlet
            resp.sendRedirect("jeu");
        } else {//sinon si tu trouve rien t'enrichi la req avec une erreur
                // et tu redirige vers l'index
            req.setAttribute("erreur", "email et/ou mot de passe incorrect");
            // on met les jsp dans les WEB INF pour ne pas qu'elle soit accecible publiquement
            req.getRequestDispatcher("WEB-INF/index.jsp").forward(req,resp);
        }
    }
}
