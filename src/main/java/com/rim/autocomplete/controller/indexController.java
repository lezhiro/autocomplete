package com.rim.autocomplete.controller;


import com.google.gson.Gson;
import com.rim.autocomplete.model.Buscador;
import com.rim.autocomplete.service.BuscadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class indexController {

    @Autowired
    @Qualifier("buscadorService")
    private BuscadorService buscadorService;

    @RequestMapping("/index")
    private String index() {


        return "index";
    }

    @RequestMapping("/buscador")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {

            String q = request.getParameter("query");

                    List<Buscador> o = buscadorService.getBuscador(q);

                    Gson gson = new Gson();
                    //System.out.println(request.getParameter("query"));
                    // convert java object to JSON format,
                    // and returned as JSON formatted string
                    String json = gson.toJson(o);
                    System.out.println(q);
                    System.out.println(json);

                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write("{\"suggestions\":" + gson.toJson(o) + "}");

        } catch (Exception e) {
        }
    }
}



