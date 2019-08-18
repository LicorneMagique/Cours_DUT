package controleur;

import java.io.IOException;

public class ActionServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        String page = request.getParameter("page");
        //Traitement t = new Traitement();
        //String nomCapital = t.capitalisation(request.getParameter("nom"));
        int resultat;
        RequestDispatcher rd;
        
        switch(page) {
            case "resultat":
                resultat = 5;
                request.setAttribute("resultat", resultat);
                rd = request.getRequestDispatcher("resultat.jsp");
                rd.forward(request, response);
                break;
            
            case "test":
                resultat = 8;
                request.setAttribute("test", resultat);
                rd = request.getRequestDispatcher("resultat.jsp");
                rd.forward(request, response);
                break;
            
            default:
                rd = request.getRequestDispatcher("index.html");
                rd.forward(request, response);
            
        }
        
    }
    
}
