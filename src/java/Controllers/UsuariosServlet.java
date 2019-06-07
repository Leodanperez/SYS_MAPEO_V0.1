/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.Impl.DbConnection;
import Dao.Impl.UsuariosDaoImpl;
import Dao.UsuariosDao;
import Models.Persona;
import Models.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GUSTAVO MANRIQUE
 */
@WebServlet(name = "UsuariosServlet", urlPatterns = {"/Usuarios"})
public class UsuariosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        String action = request.getParameter("action");
        DbConnection conn = new DbConnection();
        UsuariosDao objUsuarioDao = new UsuariosDaoImpl(conn);
        Usuarios objUsuario = new Usuarios();
        RequestDispatcher rd;
        String result;
        StringBuilder sb = new StringBuilder();
        Persona objPersona;

        if ("getListUsuarios".equals(action)) {

            List<Usuarios> listUsuario = objUsuarioDao.listUsuarios();
            request.setAttribute("usuario", listUsuario);

            conn.disconnect();
            rd = request.getRequestDispatcher("paginas/seguridad/ms_Usuarios.jsp");
            rd.forward(request, response);

        }

        if ("insert".equals(action)) {

            int cipParam = Integer.parseInt(request.getParameter("cip"));
            String usuarioParam = request.getParameter("login");
            String passwordParam = request.getParameter("pass");
            String emailParam = request.getParameter("correo");
            String fotoParam = request.getParameter("foto");

            objUsuario.setCmilitares_Cip(cipParam);
            objUsuario.setVusuarios_Login(usuarioParam);
            objUsuario.setVusuarios_Password(passwordParam);
            objUsuario.setVusuairos_Email(emailParam);
            objUsuario.setVusuarios_Foto(fotoParam);

            result = objUsuarioDao.insertUsuarios(objUsuario);
            List<Usuarios> listUsuario = objUsuarioDao.listUsuarios();
            conn.disconnect();

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }

            request.setAttribute("usuario", listUsuario);
            rd = request.getRequestDispatcher("paginas/seguridad/ms_Usuarios.jsp");
            rd.forward(request, response);

        }

        if ("update".equals(action)) {

            String codParam = request.getParameter("codigo");
            System.out.println("Codigo" + codParam);
            String usuarioParam = request.getParameter("login");
            System.out.println("usuario " + usuarioParam);
            String emailParam = request.getParameter("email");
            String fotoParam = request.getParameter("foto");
            String estadoParam = request.getParameter("estado");

            objUsuario.setCusuarios_Cod(codParam.charAt(0));
            objUsuario.setVusuarios_Login(usuarioParam);
            objUsuario.setVusuairos_Email(emailParam);
            objUsuario.setVusuarios_Foto(fotoParam);
            objUsuario.setCusuarios_Estado(estadoParam.charAt(0));

            result = objUsuarioDao.updateUsuarios(objUsuario);
            List<Usuarios> listUsuario = objUsuarioDao.listUsuarios();
            conn.disconnect();

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }

            request.setAttribute("usuario", listUsuario);
            rd = request.getRequestDispatcher("paginas/seguridad/ms_Usuarios.jsp");
            rd.forward(request, response);

        }

        if ("delete".equals(action)) {

            String codParam = request.getParameter("codigoU");
            result = objUsuarioDao.deleteUsuarios(codParam);

            conn.disconnect();

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }

            response.sendRedirect("paginas/seguridad/ms_Usuarios.jsp");
        }

        if ("BuscarPersonal".equals(action)) {

            String valorBusqueda = request.getParameter("valor");
            List listPersonal = objUsuarioDao.searchPersona(valorBusqueda);
            sb = tablaSearchPersona(listPersonal);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);
            }

        }
        
        if("mostrarPersona".equals(action)){
            
            String cipPersona = request.getParameter("cip");
            objPersona = objUsuarioDao.datosPersona(cipPersona);
            
            result = objPersona.getCmilitares_Cip() + "+++"
                    + objPersona.getVpersona_Nrodoc() + "+++"
                    + objPersona.getCgrados_Cod() + "+++"
                    + objPersona.getVpersonal_ApellNom() + "+++"
                    + objPersona.getCunidades_Cod();
            
            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }
            
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(UsuariosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(UsuariosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private StringBuilder tablaSearchPersona(List list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            sb.append("<table class=\"table table-bordered table-striped table-hover js-basic-example dataTable\">");
            sb.append("<thead>");
            sb.append("<tr>");
            sb.append("<th>Nro</th>");
            sb.append("<th>CIP</th>");
            sb.append("<th>DNI</th>");
            sb.append("<th>Grado</th>");
            sb.append("<th>Apellidos y Nombres</th>");
            sb.append("</tr>");
            sb.append("</thead>");
            sb.append("<tbody>");
            for (int k = 0; k < list.size(); k++) {
                Persona objPersona = (Persona) list.get(k);
                sb.append("<tr>");
                sb.append("<td><div class=\"\">");
                sb.append("<input type=\"radio\" id=\"").append(objPersona.getCmilitares_Cip()).append("\"name=\"radioCip\" value=\"").append(objPersona.getCmilitares_Cip()).append("\">\"");
                sb.append("<label for=\"").append(objPersona.getCmilitares_Cip()).append("\"></label>");
                sb.append("</td>");
                sb.append("<td>").append(objPersona.getCmilitares_Cip()).append("</td>");
                sb.append("<td>").append(objPersona.getVpersona_Nrodoc()).append("</td>");
                sb.append("<td>").append(objPersona.getCgrados_Cod()).append("</td>");
                sb.append("<td>").append(objPersona.getVpersonal_ApellNom()).append("</td>");
                sb.append("</tr>");
            }

            sb.append("</tbody>");
            sb.append("</table>");

        }

        return sb;

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
