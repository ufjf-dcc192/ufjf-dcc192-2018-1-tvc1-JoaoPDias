/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.Anfitriao;
import Modelo.Estrangeiro;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EstrangeiroServlet", urlPatterns = {"/cadastrar-estrangeiro.html", "/consulta-disponibilidade.html"})
public class EstrangeiroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("/cadastrar-estrangeiro.html".equals(request.getServletPath())) {
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/cadastrar-estrangeiro.jsp");
            despachante.forward(request, response);
        } else if ("/consulta-disponibilidade.html".equals(request.getServletPath())) {
            Integer cod = Integer.parseInt(request.getParameter("est"));
            Estrangeiro estrangeiro = Estrangeiro.getEstrangeiros().get(cod);
            List<Anfitriao> disponiveis = estrangeiro.getAnfitrioesDisponiveis();
            request.setAttribute("disponiveis", disponiveis);
            request.setAttribute("estrangeiro", estrangeiro);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/consulta-disponibilidade.jsp");
            despachante.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Estrangeiro.getEstrangeiros().size();
        String nome = request.getParameter("nome");
        String pais = request.getParameter("pais");
        String cidade = request.getParameter("cidade");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate dataInicio = LocalDate.parse(request.getParameter("dataInicio"), formatter);
	LocalDate dataFim = LocalDate.parse(request.getParameter("dataFim"), formatter);
        Estrangeiro.getEstrangeiros().add(new Estrangeiro(id, nome, pais, cidade, dataInicio, dataFim));
        response.sendRedirect("estrangeiros.html");
        
    }

}
