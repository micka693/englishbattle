package fr.humanbooster.fx.englishbattle.servlets;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.PartieService;
import fr.humanbooster.fx.englishbattle.service.VerbeService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.PartieServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VerbeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private JoueurService joueurService = new JoueurServiceImpl();
    private PartieService partieService = new PartieServiceImpl();
    private VerbeService verbeService = new VerbeServiceImpl();


    /* Default constructor.
     */
    public IndexServlet() {

        verbeService.importerVerbes();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("nbVerbes", verbeService.recupererNbVerbes());
        // Recupere toutes les joueurs et les envoies à la JSP
        List<Joueur> joueurs = joueurService.recupererJoueursDuHallOfFame();
        req.setAttribute("joueurs", joueurs);
        req.getRequestDispatcher("WEB-INF/index.jsp").include(req, resp);

    }

}