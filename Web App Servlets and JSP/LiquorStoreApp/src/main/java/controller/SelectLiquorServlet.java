package controller;

import model.LiquorType;
import service.LiquorService;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(
        name = "selectliquorservlet",
        urlPatterns = "/SelectLiquor"
)
public class SelectLiquorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String liquorType = req.getParameter("name");

        LiquorService liquorService = new LiquorService();
        LiquorType l = LiquorType.valueOf(liquorType);

        List liquorBrands = liquorService.getAvailableBrands(l);

        req.setAttribute("brands", liquorBrands);
        RequestDispatcher view = req.getRequestDispatcher("result.jsp");
        view.forward(req, resp);

    }
}
