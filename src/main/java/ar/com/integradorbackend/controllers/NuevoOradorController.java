package ar.com.integradorbackend.controllers;

import java.io.IOException;
import java.time.LocalDate;
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

        protected void doPost(
                        HttpServletRequest req,
                        HttpServletResponse res)
                        throws ServletException,
                        IOException {
                String JsonFromFront = req.getReader()
                                .lines()
                                .collect(Collectors.joining(System.lineSeparator()));
                ObjectMapper mapper = this.getObjectMapper();

                OradorRequest oradorRequest = mapper.readValue(JsonFromFront, OradorRequest.class);

                // Guardar en la DB

                Orador orador = new Orador(oradorRequest.getFirstName(),
                                oradorRequest.getLastName(),
                                oradorRequest.getMail(),
                                oradorRequest.getTheme(),
                                LocalDate.now());

                this.repository.save(orador);
                res.setStatus(HttpServletResponse.SC_CREATED);

                // Convierto a String para enviar
                res.getWriter().print(mapper.writeValueAsString(orador));
        }

        protected void doGet(
                        HttpServletRequest req,
                        HttpServletResponse resp)
                        throws ServletException,
                        IOException {
                String id = req.getParameter("id");
                if (id != null && !id.isEmpty()) {
                        Orador foundedOrador = this.repository.getById(Long.parseLong(id));
                        ObjectMapper mapper = this.getObjectMapper();
                        String jsonString = mapper.writeValueAsString(foundedOrador);
                        resp.setStatus(HttpServletResponse.SC_OK);
                        resp.getWriter().print(jsonString);
                        return;
                }

                List<Orador> oradoresList = this.repository.findAll();

                ObjectMapper mapper = this.getObjectMapper();

                String jsonString = mapper.writeValueAsString(oradoresList);

                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().print(jsonString);
        }

        protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                super.doDelete(req, resp);

                String id = req.getParameter("id");
                this.repository.delete(Long.parseLong(id));
                resp.setStatus(HttpServletResponse.SC_OK);

        }

        protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                super.doPut(req, resp);
                String id = req.getParameter("id");

                String json = req.getReader()
                                .lines()
                                .collect(Collectors.joining(System.lineSeparator()));

                ObjectMapper mapper = this.getObjectMapper();
                OradorRequest oradorRequest = mapper.readValue(json, OradorRequest.class);

                // Busco el orador en la db
                Orador oradorFound = this.repository.getById(Long.parseLong(id));

                // Actualizo los datos del orador
                oradorFound.setName(oradorRequest.getFirstName());
                oradorFound.setLastName(oradorRequest.getLastName());
                oradorFound.setEmail(oradorRequest.getMail());
                oradorFound.setTheme(oradorRequest.getTheme());

                // Actualizo el valor en la DB
                this.repository.update(oradorFound);
                resp.setStatus(HttpServletResponse.SC_OK);
        }

}
