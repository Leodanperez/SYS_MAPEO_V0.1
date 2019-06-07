package Controllers;

import Dao.Impl.DbConnection;
import Models.Roles;
import Dao.Impl.RolesDao;
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
 * @author CARTOLIN
 */
@WebServlet(name = "RolesServlet", urlPatterns = {"/Roles"})
public class RolesServlet extends HttpServlet {

    StringBuilder sb = new StringBuilder();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        /*String modoParam = request.getParameter("modo");
        String codigoParam = request.getParameter("codigo");
        String codigoactParam = request.getParameter("codigoRol");*/
        Roles roles = new Roles();
        DbConnection conn = new DbConnection();
        RolesDao rolesDao = new RolesDao(conn);
        String action = request.getParameter("action");

        if ("getListRoles".equals(action)) {
            //this.verRoles(request, response);
            List<Roles> lista = rolesDao.verRoles();

            conn.disconnect();
            RequestDispatcher rd;
            request.setAttribute("roles", lista);
            rd = request.getRequestDispatcher("paginas/seguridad/ms_Roles.jsp");
            rd.forward(request, response);

        }/* else if ("listaRolesModulo".equals(action)) {
            this.verRolesModulo(request, response);

        } else if ("grabarRolesModulo".equals(action)) {
            this.grabarRolesModulo(request, response);

        } else if ("eliminarRoles".equals(action)) {
            this.eliminarRoles(request, response);

        } else if ("indRoles".equals(action)) {
            this.individualRoles(request, response);
        }

        if (action.equals("verRoles")) {

            List<Roles> lista = rolesDao.verRoles();
            sb = tabla(lista);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);

            }
        }*/

 /* if (action.equals("insertarRoles")) {

            String descripcionCortaParam = request.getParameter("descripcionCorta");
            String descripcionLargaParam = request.getParameter("descripcionLarga");

            roles.setCROLES_CODROL(codigoParam);
            roles.setVROLES_DESCOR(descripcionCortaParam);
            roles.setVROLES_DESLAR(descripcionLargaParam);

            String status = rolesDao.insert(roles);
            List<Roles> lista = rolesDao.verRoles();
            sb = tabla(lista);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);

            }*/
 /*conn.disconnect();
            RequestDispatcher rd;
            request.setAttribute("roles", lista);
            rd = request.getRequestDispatcher("paginas/seguridad/ms_Roles.jsp");
            rd.forward(request, response);
        }*/

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RolesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recibimos parametros

        /*String modoParam = request.getParameter("modo");
        String codigoParam = request.getParameter("codigo");
        String codigoactParam = request.getParameter("codigoRol");
        Roles roles = new Roles();
        DbConnection conn = new DbConnection();
        RolesDao rolesDao = new RolesDao(conn);
        try {
            switch (modoParam) {
                case "i":
                    String descripcionCortaParam = request.getParameter("descripcionCorta");
                    String descripcionLargaParam = request.getParameter("descripcionLarga");

                    roles.setCROLES_CODROL(codigoParam);
                    roles.setVROLES_DESCOR(descripcionCortaParam);
                    roles.setVROLES_DESLAR(descripcionLargaParam);
                    String status = rolesDao.insert(roles);
                    List<PerRoles> lista = rolesDao.verRoles();
                    /*sb = tabla(lista);

                    response.setContentType("text/html;charset=ISO-8859-1");
                    try (PrintWriter out = response.getWriter()) {
                        out.print(sb);

                    }
                    conn.disconnect();
                    RequestDispatcher rd;
                    request.setAttribute("roles", lista);
                    rd = request.getRequestDispatcher("paginas/seguridad/ms_Roles.jsp");
                    rd.forward(request, response);
                    break;
                default:
                    String descripcionCortaActParam = request.getParameter("descripcionCorta");
                    String descripcionLargaActParam = request.getParameter("descripcionLarga");
                    roles.setCROLES_CODROL(codigoactParam);
                    roles.setVROLES_DESCOR(descripcionCortaActParam);
                    roles.setVROLES_DESLAR(descripcionLargaActParam);
                    String statusA = rolesDao.update(roles);
                    conn.disconnect();

                    /*rd = request.getRequestDispatcher("paginas/seguridad/ms_Roles.jsp");
                    rd.forward(request, response);
                    break;
            }
        } catch (Exception e) {
            String descripcionCortaActParam = request.getParameter("descripcionCorta");
            String descripcionLargaActParam = request.getParameter("descripcionLarga");
            roles.setCROLES_CODROL(codigoactParam);
            roles.setVROLES_DESCOR(descripcionCortaActParam);
            roles.setVROLES_DESLAR(descripcionLargaActParam);
            String statusA = rolesDao.update(roles);
            List<PerRoles> lista = rolesDao.verRoles();
            conn.disconnect();

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(statusA);

            }

            RequestDispatcher rd;
            request.setAttribute("roles", lista);
            rd = request.getRequestDispatcher("paginas/seguridad/ms_Roles.jsp");
            rd.forward(request, response);

        }*/
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RolesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //LISTADO DE ROLES

    protected void verRoles(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*DbConnection conn = new DbConnection();
        RolesDao rolesDao = new RolesDao(conn);
        List<Roles> lista = rolesDao.verRoles();

        /*sb = tabla(lista);

        response.setContentType("text/html;charset=ISO-8859-1");
        try (PrintWriter out = response.getWriter()) {
            out.print(sb);

        }
        conn.disconnect();
        RequestDispatcher rd;
        request.setAttribute("roles", lista);
        rd = request.getRequestDispatcher("paginas/seguridad/ms_Roles.jsp");
        rd.forward(request, response);*/
    }

    protected void verRolesModulo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*DbConnection conn = new DbConnection();
        RolesDao rolesDao = new RolesDao(conn);
        List<Roles> lista = rolesDao.verRolesActivos();
        conn.disconnect();
        RequestDispatcher rd;
        request.setAttribute("roles", lista);
        rd = request.getRequestDispatcher("/ms_Modulos.jsp");
        rd.forward(request, response);*/
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void grabarRolesModulo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recibimos parametros
        /*String codigoParam = request.getParameter("codigo");
        String descripcioCortaParam = request.getParameter("descripcionCorta");
        String descripcionLargaParam = request.getParameter("descripcionLarga");
        Roles roles = new Roles();
        roles.setCROLES_CODROL(codigoParam);
        roles.setVROLES_DESCOR(descripcioCortaParam);
        roles.setVROLES_DESLAR(descripcionLargaParam);
        DbConnection conn = new DbConnection();
        RolesDao rolesDao = new RolesDao(conn);
        String status = rolesDao.insert(roles);
        List<Roles> lista = rolesDao.verRoles();
        conn.disconnect();
        RequestDispatcher rd;
        request.setAttribute("roles", lista);
        rd = request.getRequestDispatcher("/ms_Roles.jsp");
        rd.forward(request, response);*/

    }

    private void eliminarRoles(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* int codigoParam = Integer.parseInt(request.getParameter("codigo"));

        DbConnection conn = new DbConnection();
        RolesDao rolesDao = new RolesDao(conn);
        boolean status = rolesDao.Eliminar(codigoParam);
        List<Roles> lista = rolesDao.verRoles();
        conn.disconnect();
        RequestDispatcher rd;
        request.setAttribute("roles", lista);
        rd = request.getRequestDispatcher("paginas/seguridad/ms_Roles.jsp");
        rd.forward(request, response);*/
    }

    private void individualRoles(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*String codigoParam = request.getParameter("codigo");
        String result = null;
        System.out.println("ingreso servlet");
        DbConnection conn = new DbConnection();
        RolesDao rolesDao = new RolesDao(conn);
        Roles rol = rolesDao.getidRol(codigoParam);
        System.out.println(codigoParam);
        result = rol.getCROLES_CODROL() + "+++"
                + rol.getVROLES_DESCOR() + "+++"
                + rol.getVROLES_DESLAR() + "+++"
                + rol.getCROLES_ESTADO();

        System.out.println(result);
        response.setContentType("text/html;charset=ISO-8859-1");
        try (PrintWriter out = response.getWriter()) {
            out.print(result);

            conn.disconnect();
        }*/

    }

    /*private StringBuilder tabla(List list) {
        /*StringBuilder sb = new StringBuilder();
        if (list != null) {
            sb.append("<table class=\"table table-bordered table-striped table-hover js-basic-example dataTable\">");
            sb.append("<thead>");
            sb.append("<tr>");
            sb.append("<th>Codigo</th>");
            sb.append("<th>Desc. Corta</th>");
            sb.append("<th>Desc. Larga</th>");
            sb.append("<th>Estado</th>");
            sb.append("<th>Accion</th>");
            sb.append("</tr>");
            sb.append("</thead>");
            sb.append("<tbody>");
            for (int k = 0; k < list.size(); k++) {
                Roles rol = (Roles) list.get(k);
                sb.append("<tr>");
                sb.append("<td><div class=\"\">");
                sb.append("<input type=\"radio\" id=\"").append(rol.getCROLES_CODROL()).append("\" name=\"radio1\" value=\"").append(rol.getCROLES_CODROL()).append("\" class=\"\">");
                sb.append("<label for=\"").append(rol.getVROLES_DESCOR()).append("\"></label>");
                //sb.append("</div></div></td>");
                sb.append("</td>");
                sb.append("<td>").append(rol.getVROLES_DESLAR()).append("</td>");
                sb.append("<td>").append(rol.getCROLES_ESTADO()).append("</td>");
                sb.append("<td>"
                        + "<button type='button' class='btn bg-primary btn-xs' ").append("'><i class=\"material-icons\">mode_edit</i></button>"
                                + "<button type='button' class='btn bg-red btn-xs' ").append("'><i class=\"material-icons\">delete</i></button>"
                                + "</td>");
                sb.append("</tr>");
            }

            sb.append("</tbody>");
            sb.append("</table>");
        }
        return sb;

    }*/
}
