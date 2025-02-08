package com.br.ClockHub.Controller;

import com.br.ClockHub.Model.BatidaPontoModel;
import com.br.ClockHub.Service.PontoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/ponto")
public class PontoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private PontoService pontoService;

    @Override
    public void init() throws ServletException {
        this.pontoService = new PontoService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtém o horário atual
        String horarioAtual = pontoService.obterHorarioAtual();

        // Define o horário como atributo para o JSP
        request.setAttribute("horarioAtual", horarioAtual);

        // Encaminha para o JSP
        request.getRequestDispatcher("/ponto.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtém os valores enviados pelo formulário
        String nomeUsuario = request.getParameter("inputUsuario");
        LocalTime horarioAtual = LocalTime.now();
        LocalDate diaAtual = LocalDate.now();

        // Cria uma instância do modelo com os dados
        BatidaPontoModel batidaPonto = new BatidaPontoModel();
        batidaPonto.setNomeUsuario(nomeUsuario);
        batidaPonto.setHoraDoPonto(horarioAtual);
        batidaPonto.setDiaDoPonto(diaAtual);

        // Salva a batida de ponto no banco
        pontoService.registrarBatidaPonto(batidaPonto);

        // Redireciona de volta para a página principal
        response.sendRedirect("ponto");
    }
}
