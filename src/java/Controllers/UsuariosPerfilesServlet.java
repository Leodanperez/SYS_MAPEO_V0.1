package Controllers;

import Dao.Impl.DbConnection;
import Dao.Impl.UsuariosDaoImpl;
import Dao.UsuariosDao;
import Models.Persona;
import Models.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "PerfilUsuarioServlet", urlPatterns = {"/UsuariosPerfiles"})
public class UsuariosPerfilesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        StringBuilder sb = new StringBuilder();
        DbConnection conn = new DbConnection();
        UsuariosDao objUsuariosDao = new UsuariosDaoImpl(conn);
        Usuarios objUsuarios = new Usuarios();
        Persona objPersona;
        String result;
        RequestDispatcher rd;

        if ("buscarUsuario".equals(action)) {

            String valor = request.getParameter("valor");
            List listUsuarios = objUsuariosDao.searchUsuarios(valor);
            sb = tableSearchUsuarios(listUsuarios);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);
            }

        }

        if ("mostrarUsuario".equals(action)) {

            String valor = request.getParameter("cip");
            objPersona = objUsuariosDao.datosUsuario(valor);
            result = objPersona.getCmilitares_Cip() + "+++"
                    + objPersona.getVpersona_Nrodoc() + "+++"
                    + objPersona.getCgrados_Cod() + "+++"
                    + objPersona.getVpersonal_ApellNom() + "+++"
                    + objPersona.getCusuarios_Cod() + "+++"
                    + objPersona.getVusuarios_Login();

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }

        }

        if ("listUsuariosPerfiles".equals(action)) {
            
            String valor = request.getParameter("nroCip");
            List<Usuarios> listUsuariosPerfiles = objUsuariosDao.listUsuariosPerfiles(valor);
            sb = tableUsuariosPerfiles(listUsuariosPerfiles);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);
            }
            
        }

        if ("getPerfilesSelect".equals(action)) {
            
            List<Object[]> comboPerfiles = objUsuariosDao.getPerfilesSelect();
            sb = combo(comboPerfiles, "id=\"comboPerfiles\"");

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);
            }
            
        }

        if ("insertUP".equals(action)) {
            String valor = request.getParameter("nroCip");
            String codUsuario = request.getParameter("codUsuario");
            String codPerfil = request.getParameter("codPerfil");

            boolean res = objUsuariosDao.insertUsuariosPerfiles(codUsuario, codPerfil);
            sb.append(res);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);
            }

        }

        if ("deleteUP".equals(action)) {

            String codUsuario = request.getParameter("codigoUsuario");
            String codPerfil = request.getParameter("codPerfil");

            boolean res = objUsuariosDao.deleteUsuariosPerfiles(codUsuario, codPerfil);
            sb.append(res);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);
            }

        }

    }

    private StringBuilder tableSearchUsuarios(List list) {

        StringBuilder sb = new StringBuilder();
        if (list != null) {
            sb.append("<table  class=\"table table-bordered table-striped table-hover js-basic-example dataTable\">");
            sb.append("<thead>");
            sb.append("<tr>");
            sb.append("<th>Nro</th>");
            sb.append("<th>CIP</th>");
            sb.append("<th>DNI</th>");
            sb.append("<th>Nombres y Apellidos</th>");
            sb.append("<th>Login</th>");
            sb.append("</tr>");
            sb.append("</thead>");
            sb.append("<tbody>");
            for (int i = 0; i < list.size(); i++) {
                Persona objPersona = (Persona) list.get(i);
                sb.append("<tr>");
                sb.append("<td>");
                sb.append("<div>");
                sb.append("<input type=\"radio\" id=\"").append(objPersona.getCmilitares_Cip()).append("\" name=\"radioUsuario\" value=\"").append(objPersona.getCmilitares_Cip()).append("\" class=\"\">");
                sb.append("<label for=\"").append(objPersona.getCmilitares_Cip()).append("\"></label>");
                sb.append("</div>");
                sb.append("</td>");
                sb.append("<td>").append(objPersona.getCmilitares_Cip()).append("</td>");
                sb.append("<td>").append(objPersona.getVpersona_Nrodoc()).append("</td>");
                sb.append("<td>").append(objPersona.getVpersonal_ApellNom()).append("</td>");
                sb.append("<td>").append(objPersona.getVusuarios_Login()).append("</td>");
                sb.append("</tr>");
            }

            sb.append("</tbody>");
            sb.append("</table>");

        }

        return sb;

    }

    private StringBuilder tableUsuariosPerfiles(List list) {

        StringBuilder sb = new StringBuilder();
        if (list != null) {
            sb.append("<table  class=\"table table-bordered table-striped table-hover js-basic-example dataTable\">");
            sb.append("<thead>");
            sb.append("<tr>");
            sb.append("<th>Nro</th>");
            sb.append("<th>Nro CIP</th>");
            sb.append("<th>Usuario</th>");
            sb.append("<th>Perfil</th>");
            sb.append("<th>Acción</th>");
            sb.append("</tr>");
            sb.append("</thead>");
            sb.append("<tbody>");
            for (int i = 0; i < list.size(); i++) {
                Usuarios objUsuarios = (Usuarios) list.get(i);
                sb.append("<tr>");
                sb.append("<td>").append(i + 1).append("</td>");
                sb.append("<td>").append(objUsuarios.getCmilitares_Cip()).append("</td>");
                sb.append("<td>").append(objUsuarios.getVusuarios_Login()).append("</td>");
                sb.append("<td>").append(objUsuarios.getVperfiles_Descripcion()).append("</td>");
                sb.append("<td> <button type='button' class='btn bg-red btn-xs' onclick='javascript:deleteUP(").append(objUsuarios.getCusuarios_Cod()).append(",").append(objUsuarios.getCperfiles_Cod()).append(",").append(objUsuarios.getCmilitares_Cip()).append(");").append("'><i class=\"material-icons\">delete</i></button></td>");;
            }
            sb.append("</tbody");
            sb.append("</table>");
        }

        return sb;

    }

    private StringBuilder combo(List<Object[]> list, String atr) {

        StringBuilder sb = new StringBuilder();
        if (list != null) {
            sb.append("<select class=\"form-control show-tick\"").append(atr).append(">");

            for (Object[] reg : list) {
                sb.append("<option value=\"").append(reg[0]).append("\">");
                sb.append(reg[1]);
                sb.append("<option/>");
            }

            sb.append("</select>");

        }

        return sb;

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
