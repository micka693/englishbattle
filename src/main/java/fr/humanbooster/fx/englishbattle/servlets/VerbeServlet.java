package fr.humanbooster.fx.englishbattle.servlets;

import fr.humanbooster.fx.englishbattle.business.Verbe;
import fr.humanbooster.fx.englishbattle.service.VerbeService;
import fr.humanbooster.fx.englishbattle.service.impl.VerbeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * cette classe est une servlet qui traite des requetes http sur url /verbe
 * elle affichera les info sur 1 et un seul verbe
 *
 */
@WebServlet("/verbe")
public class VerbeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private VerbeService verbeService = null;
    private static final VerbeService vs = new VerbeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerbeServlet() {
        verbeService = new VerbeServiceImpl();
    }

    /** Cette méthode est invoquée lorsque quelqu'un se rend sur l'url :
     * http://localhost:8080/englishbattle/verbe
     *
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // on declare l'objet idVerbe qui prend la valeur du parametre nommé idpresent dans l'objet request
        Long idVerbe = Long.parseLong(request.getParameter("ID"));
        request.setAttribute("verbe", verbeService.recupererVerbe(idVerbe));
        request.getRequestDispatcher("WEB-INF/verbe.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> map = req.getParameterMap();

        // On parcourt l'ensemble des clés de la map
        for (String cle : map.keySet()) {
            String[] tableauDeValeursPourCeParametre = (String[]) map.get(cle);
            for (String valeur : tableauDeValeursPourCeParametre) {
                System.out.println("Clé=" + cle + ", valeur=" + valeur);
            }
        }
        Long idVerbe = Long.parseLong(req.getParameter("ID"));
        String baseVerbale = map.get("baseVerbale")[0];
        String preterit = map.get("preterit")[0];
        String participePasse= map.get("participePasse")[0];
        String traduction= map.get("traduction")[0];

        verbeService.modifierVerbe(idVerbe,baseVerbale,preterit,participePasse,traduction);
        resp.sendRedirect("verbe");
    }
}
