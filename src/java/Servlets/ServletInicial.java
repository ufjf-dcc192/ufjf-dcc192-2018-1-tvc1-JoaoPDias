package Servlets;

import Modelo.Anfitriao;
import Modelo.Estrangeiro;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletInicial", urlPatterns = {"/index.html","/anfitrioes.html","/estrangeiros.html"})
public class ServletInicial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("/index.html".equals(request.getServletPath())) {
            response.setContentType("text/html;charset=UTF-8");
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/index.jsp");
            despachante.forward(request, response);
        }
        else if ("/anfitrioes.html".equals(request.getServletPath())) {
            response.setContentType("text/html;charset=UTF-8");
            request.setAttribute("anfitrioes",Anfitriao.getAnfitrioes());
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/anfitrioes.jsp");
            despachante.forward(request, response);
        }else if ("/estrangeiros.html".equals(request.getServletPath())) {
            response.setContentType("text/html;charset=UTF-8");
            request.setAttribute("estrangeiros",Estrangeiro.getEstrangeiros());
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/estrangeiros.jsp");
            despachante.forward(request, response);
        }
    }

}
