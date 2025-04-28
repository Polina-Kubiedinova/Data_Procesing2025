package com.lab.variant;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.lab.variant.Cosmetic;
import com.lab.variant.CosService;

@WebServlet(urlPatterns = "/cos")

public class CosServlet extends HttpServlet{
    private CosService cosService =new CosService();
    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        List<Cosmetic> cos = cosService.getAllCos();
        response.setContentType("application/json");
        response.getWriter().write(gson.toJson(cos));
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        BufferedReader reader = request.getReader();
        Cosmetic newCos = gson.fromJson(reader,Cosmetic.class);
        cosService.addCos(newCos);
        response.setStatus(HttpServletResponse.SC_CREATED);
        }
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        BufferedReader reader = request.getReader();
        Cosmetic updateCos = gson.fromJson(reader,Cosmetic.class);
        if(cosService.updateCos(updateCos)){
        response.setStatus(HttpServletResponse.SC_OK);}
        else{
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);}
    }
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if(cosService.deleteCos(id)){
            response.setStatus(HttpServletResponse.SC_OK);}
        else{
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);}
    }
}
