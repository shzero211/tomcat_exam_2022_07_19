package com.ll.exam;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      /**
        int idx=1;
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        int dan=Integer.parseInt(req.getParameter("dan"));
        int limit=Integer.parseInt(req.getParameter("limit"));
            resp.getWriter().append("<h1>%d</h1> <br>".formatted(dan));
        for(int j=1;j<=limit;j++){
            resp.getWriter().append("<p>%d x %d = %d</p> <br>".formatted(dan,j,dan*j));
        }
       **/
        Rq rq = new Rq(req, resp);

        int dan = rq.getIntParam("dan", 9);
        int limit = rq.getIntParam("limit", 9);

        rq.appendBody("<h1>%d단</h1>\n".formatted(dan));

        for (int i = 1; i <= limit; i++) {
            rq.appendBody("<div>%d * %d = %d</div>\n".formatted(dan, i, dan * i));
        }
    }

    }
