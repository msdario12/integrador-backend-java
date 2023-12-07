package ar.com.integradorbackend.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import ar.com.integradorbackend.orador.Orador;
import ar.com.integradorbackend.repository.MySQLOradorRepository;
import ar.com.integradorbackend.repository.OradorRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * NuevoOradorController
 */
@WebServlet("/api/orador")
public class NuevoOradorController extends HttpServlet {

    private OradorRepository repository = new MySQLOradorRepository();

    private ObjectMapper getObjectMapper() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return mapper;
    };

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Obtener JSON desde frontEnd
        String JsonFromFront = req.getReader()
                .lines()
                .collect(Collectors.joining(System.lineSeparator()));
        // Converter JSON to JavaObject
        ObjectMapper mapper = this.getObjectMapper();

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Orador> oradoresList = this.repository.findAll();

        // Convertir de JSON a JavaObject usando jackson2
        // ObjectMapper mapper = new ObjectMapper();
        // mapper.registerModule(new JavaTimeModule());
        // mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ObjectMapper mapper = this.getObjectMapper();

        String jsonString = mapper.writeValueAsString(oradoresList);

        resp.setStatus(HttpServletResponse.SC_OK);

        // Escribe la respuesta en resp
        resp.getWriter().print(jsonString);

    }

}
