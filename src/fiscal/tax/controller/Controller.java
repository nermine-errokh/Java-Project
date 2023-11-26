package fiscal.tax.controller;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class Controller extends HttpServlet {

       public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
              response.setContentType("text/html");
              PrintWriter out = response.getWriter();

              int idFiscal = Integer.parseInt(request.getParameter("idFiscal"));
              String fiscalYear = request.getParameter("fiscalYear");

              int visitCount = 0;
              Cookie[] cookies = request.getCookies();
              if (cookies != null) {
                     for (Cookie cookie : cookies) {
                            if (cookie.getName().equals("visitCount")) {
                                   visitCount = Integer.parseInt(cookie.getValue());
                            }
                     }
              }

              visitCount++;

              Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));
              visitCookie.setMaxAge(365 * 24 * 60 * 60); // Cookie lasts for one year
              response.addCookie(visitCookie);

              TaxReport tr = new TaxReport();
              tr.setFiscalId(idFiscal);
              tr.setFiscalYear(fiscalYear);
              request.setAttribute("mytaxReport", tr);

              RequestDispatcher dispatcher;
              if (idFiscal < 10000) {
                     dispatcher = getServletContext().getRequestDispatcher("/jsp/regular.jsp");
              } else {
                     dispatcher = getServletContext().getRequestDispatcher("/jsp/high.jsp");
              }

              dispatcher.forward(request, response);
              out.close();
       }
}
