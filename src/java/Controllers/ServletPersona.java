//package Controllers;
//
//import Dao.DaoPersona;
//import Dao.Impl.DaoPersonaimpl;
//import Models.PersonaBeans;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(name = "ServletPersona", urlPatterns = {"/ServletPersona"})
//public class ServletPersona extends HttpServlet {
//
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String accion = request.getParameter("accion");
//        StringBuilder sb = new StringBuilder();
//        String result = null;
//        DaoPersona daoPersona = new DaoPersonaimpl();
//
//        if (accion.equals("BuscarPersona")) {
//            String busqueda = request.getParameter("valor");
//            System.out.println(busqueda);
//            List list = daoPersona.BuscarPersona(busqueda);
//            sb = tabla(list);
//
//            response.setContentType("text/html;charset=UTF-8");
//            try (PrintWriter out = response.getWriter()) {
//                out.print(sb);
//            }
//
//        }
//
//        //BUSCA MILITARES PARA CREAR USUARIO
//        if (accion.equals("BuscarPersonaCip")) {
//            String busqueda = request.getParameter("valor");
//            System.out.println("BuscarPersonaCip");
//            System.out.println(busqueda);
//            List list = daoPersona.BuscarPersonaCip(busqueda);
//            sb = tabla2(list);
//
//            response.setContentType("text/html;charset=UTF-8");
//            try (PrintWriter out = response.getWriter()) {
//                out.print(sb);
//            }
//
//        }
//
//        if (accion.equals("BuscarUsuario")) {
//            String busqueda = request.getParameter("valor");
//            //  System.out.println(busqueda);
//            List list = daoPersona.BuscarUsuario(busqueda);
//            System.out.println(list);
//            sb = tabla(list);
//
//            response.setContentType("text/html;charset=UTF-8");
//            try (PrintWriter out = response.getWriter()) {
//                out.print(sb);
//            }
//
//        }
//
//        if (accion.equals("mostrar")) {
//            String Cip = request.getParameter("Cip");
//            //  PersonaBeans persona = daoPersona.DatosPersona(Cip);
//            PersonaBeans persona = daoPersona.DatosUsuario(Cip);
//            result = persona.getCip() + "+++"
//                    + persona.getDni() + "+++"
//                    + persona.getGrado() + "+++"
//                    + persona.getApellNom() + "+++"
//                    + persona.getCodigo();
//            response.setContentType("text/html;charset=ISO-8859-1");
//            try (PrintWriter out = response.getWriter()) {
//                out.print(result);
//            }
//
//        }
//
//        //MUESTRA A LA PERSONA SELECCIONADA PARA CREAR USUARUARIO
//        if (accion.equals("mostrarUsuario")) {
//            String Cip = request.getParameter("Cip");
//            PersonaBeans persona = daoPersona.DatosPersona(Cip);
//
//            result = persona.getCip() + "+++"
//                    + persona.getDni() + "+++"
//                    + persona.getGrado() + "+++"
//                    + persona.getApellNom() + "+++"
//                    + persona.getCodigo();
//            response.setContentType("text/html;charset=ISO-8859-1");
//            try (PrintWriter out = response.getWriter()) {
//                out.print(result);
//            }
//
//        }
//    }
//
//    private StringBuilder tabla2(List list) {
//        StringBuilder sb = new StringBuilder();
//        if (list != null) {
//
//            sb.append("<table class=\"table table-bordered table-striped table-hover js-basic-example dataTable\">");
//            sb.append("<thead>");
//            sb.append("<tr>");
//            sb.append("<th>Nro</th>");
//            sb.append("<th>CIP</th>");
//            sb.append("<th>DNI</th>");
//            //  sb.append("<th>Grado</th>");
//            sb.append("<th>Apellidos y Nombres</th>");
//            sb.append("</tr>");
//            sb.append("</thead>");
//            sb.append("<tbody>");
//            for (int k = 0; k < list.size(); k++) {
//                PersonaBeans per = (PersonaBeans) list.get(k);
//                sb.append("<tr>");
//                sb.append("<td><div class=\"\">");
//                sb.append("<input type=\"radio\" id=\"").append(per.getCip()).append("\" name=\"radioCip\" value=\"").append(per.getCip()).append("\" class=\"\">");
//                sb.append("<label for=\"").append(per.getCip()).append("\"></label>");
//                sb.append("</td>");
//                sb.append("<td>").append(per.getCip()).append("</td>");
//                sb.append("<td>").append(per.getDni()).append("</td>");
//                sb.append("<td>").append(per.getApellNom()).append("</td>");
//                sb.append("</tr>");
//            }
//
//            sb.append("</tbody>");
//            sb.append("</table>");
//        }
//        return sb;
//
//    }
//
//    private StringBuilder tabla(List list) {
//        StringBuilder sb = new StringBuilder();
//        if (list != null) {
//
//            sb.append("<table class=\"table table-bordered table-striped table-hover js-basic-example dataTable\">");
//            sb.append("<thead>");
//            sb.append("<tr>");
//            sb.append("<th>Nro</th>");
//            sb.append("<th>CIP</th>");
//            sb.append("<th>DNI</th>");
//            sb.append("<th>Grado</th>");
//            sb.append("<th>Apellidos y Nombres</th>");
//            sb.append("</tr>");
//            sb.append("</thead>");
//            sb.append("<tbody>");
//            for (int k = 0; k < list.size(); k++) {
//                PersonaBeans per = (PersonaBeans) list.get(k);
//                sb.append("<tr>");
//                //sb.append("<td>").append(k+1).append("</td>"); 
//                sb.append("<td><div class=\"\">");
//                //sb.append("<td>");
//                //sb.append("<label for=\"radio1\" class=\"form-check-label \">");
//                sb.append("<input type=\"radio\" id=\"").append(per.getCip()).append("\" name=\"radio1\" value=\"").append(per.getCip()).append("\" class=\"\">");
//                sb.append("<label for=\"").append(per.getCip()).append("\"></label>");
//                //sb.append("</div></div></td>");
//                sb.append("</td>");
//                sb.append("<td>").append(per.getCip()).append("</td>");
//                sb.append("<td>").append(per.getDni()).append("</td>");
//                sb.append("<td>").append(per.getGrado()).append("</td>");
//                sb.append("<td>").append(per.getApellNom()).append("</td>");
//                sb.append("</tr>");
//            }
//
//            sb.append("</tbody>");
//            sb.append("</table>");
//        }
//        return sb;
//
//    }
//
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
