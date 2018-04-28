package Servlets;

import Modelo.Anfitriao;
import Modelo.Estrangeiro;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AnfitriaoServlet", urlPatterns = {"/cadastrar-anfitriao.html"})
public class AnfitriaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("/cadastrar-anfitriao.html".equals(request.getServletPath())) {
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/cadastrar-anfitriao.jsp");
            despachante.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Anfitriao.getAnfitrioes().size();
        String nome = request.getParameter("nome");
        String categoria = request.getParameter("categoria");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataInicio = LocalDate.parse(request.getParameter("dataInicio"), formatter);
        LocalDate dataFim = LocalDate.parse(request.getParameter("dataFim"), formatter);
        Anfitriao.getAnfitrioes().add(new Anfitriao(id, nome, categoria, dataInicio, dataFim));
        response.sendRedirect("anfitrioes.html");

    }

}
