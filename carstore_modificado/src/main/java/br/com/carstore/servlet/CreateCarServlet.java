package br.com.carstore.servlet;

import com.google.gson.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/create-car")

public class CreateCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String carName = request.getParameter("car-name");

        System.out.println(carName);

        // Configuração para criar a resposta em JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Criando o Objeto em Json
        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("mensagem", "Carro adicionado com sucesso!");
        jsonResponse.addProperty("nomeCarro", carName);
        jsonResponse.addProperty("status", "sucesso");

        // Enviando resposta em Json
        PrintWriter out = response.getWriter();
        out.print(jsonResponse.toString());
        out.flush();

    }
}
