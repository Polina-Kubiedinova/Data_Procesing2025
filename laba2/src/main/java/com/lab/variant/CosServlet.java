package com.lab.variant;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.google.gson.Gson;

@WebServlet(urlPatterns = "/cos")

public class CosServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Cosmetic cos = new Cosmetic("345 Relief Cream", "/images/cream.jpg","Dr. Althea",855,"Aqua, Propanediol, Glycerin, Cyclohexasiloxane, 1,2-Hexanediol, Niacinamide, Caprylic/capric, Triglyceride, Polyglycerin-3, Panthenol, Polyglyceryl-10 Stearate, Hydrogenated Polydecene, Hydrogenated Poly(C6-14 Olefin), Dicaprylyl Carbonate, Ammonium Acryloyldimethyltaurate/vp Copolymer, C14-22 Alcohols, Polymethylsilsesquioxane, C12-20 Alkyl Glucoside, Butylene Glycol, Acrylates/c10-30 Alkyl Acrylate Crosspolymer, Ethylhexylglycerin, Polyquaternium-51, Tromethamine, Sodium Hyaluronate, Coptis Japonica Root Extract, Houttuynia Cordata Extract, Oenothera Biennis (Evening Primrose) Flower Extract, Beta-glucan, Resveratrol, Gardenia Florida Fruit Extract, Lavandula Angustifolia (Lavender) Flower Extract, Opuntia Ficus-indica Stem Extract, Hydrolyzed Hyaluronic Acid, Centella Asiatica Leaf Extract, Phenoxyethanol, Hibiscus Sabdariffa Flower Extract, Tocopherol, Corallina Officinalis Extract, Ceramide NP");
        Gson gson = new Gson();
        String json = gson.toJson(cos);
        response.setContentType("application/json");
        response.getWriter().write(json);

    }
}
