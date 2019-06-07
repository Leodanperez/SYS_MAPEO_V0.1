package Controllers;

import Dao.Impl.DbConnection;
import Dao.Impl.ModulosDaoImpl;
import Dao.ModulosDao;
import Models.Modulos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ModulosServlet", urlPatterns = {"/Modulos"})
public class ModulosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        DbConnection conn = new DbConnection();
        ModulosDao objModulosDao = new ModulosDaoImpl(conn);
        Modulos objModulos = new Modulos();
        RequestDispatcher rd;
        String result;
        StringBuilder sb;

        if ("getListModulos".equals(action)) {
            List<Modulos> listModulosSuper = objModulosDao.listModulosSuper();
            //List<Modulos> listSubModulos = objModulosDao.listSubModulos();
            conn.disconnect();

            request.setAttribute("moduloSuper", listModulosSuper);
            //request.setAttribute("subModulo", listSubModulos);

            rd = request.getRequestDispatcher("paginas/seguridad/ms_Modulos.jsp");
            rd.forward(request, response);
        }

        if ("insertModSuper".equals(action)) {

            String descripcionParam = request.getParameter("descripcion");
            String iconoParam = request.getParameter("icono");
            String ordenParam = request.getParameter("orden");

            objModulos.setVmodulos_Desc(descripcionParam);
            objModulos.setVmodulos_icon(iconoParam);
            objModulos.setCmodulos_Orden(ordenParam);

            result = objModulosDao.insertModulosSuper(objModulos);
            conn.disconnect();

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }

            response.sendRedirect("paginas/seguridad/ms_Modulos.jsp");

        }

        if ("updateModSuper".equals(action)) {

            String codigoParam = request.getParameter("codigo");
            String descripcionParam = request.getParameter("descripcion");
            String iconoParam = request.getParameter("icono");
            String ordenParam = request.getParameter("orden");

            objModulos.setCmodulos_Cod(codigoParam);
            objModulos.setVmodulos_Desc(descripcionParam);
            objModulos.setVmodulos_icon(iconoParam);
            objModulos.setCmodulos_Orden(ordenParam);

            result = objModulosDao.updateModulosSuper(objModulos);

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }

            response.sendRedirect("paginas/seguridad/ms_Modulos.jsp");

        }

        if ("getListSubModulos".equals(action)) {

            List<Modulos> listSubModulos = objModulosDao.listSubModulos();
            List<Modulos> listModulosSuper = objModulosDao.listModulosSuper();
            sb = tablelistSubModulos(listSubModulos, listModulosSuper);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);
            }

        }

        if ("comboModulos".equals(action)) {

            List<Object[]> comboModulosSuper = objModulosDao.getModulosSuperSelect();
            sb = comboModulosSuper(comboModulosSuper, "id=\"moduloSuperInsert\"");

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);
            }

        }

        if ("insertSubMod".equals(action)) {

            String descripcionParam = request.getParameter("descripcion");
            String modSuperParam = request.getParameter("modSuper");
            String servletParam = request.getParameter("servlet");
            String linkParam = request.getParameter("link");
            String iconoParam = request.getParameter("icono");
            String ordenParam = request.getParameter("nOrden");

            objModulos.setVmodulos_Desc(descripcionParam);
            objModulos.setCmodulos_ModSuper(modSuperParam);
            objModulos.setVmodulos_Servlet(servletParam);
            objModulos.setVmodulos_link(linkParam);
            objModulos.setVmodulos_icon(iconoParam);
            objModulos.setCmodulos_Orden(ordenParam);

            result = objModulosDao.insertSubModulos(objModulos);

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }

            rd = request.getRequestDispatcher("paginas/seguridad/ms_Modulos.jsp");
            rd.forward(request, response);

        }

        if ("updateSubMod".equals(action)) {

            String modSuperParam;
            String modSuper = request.getParameter("modSuper2").trim();
            System.out.println("modSuper2" + modSuper);

            if (modSuper.length() == 0) {
                modSuperParam = request.getParameter("modSuper");
            } else {
                modSuperParam = request.getParameter("modSuper2");
            }
            String codigoParam = request.getParameter("codigo");
            String descripcionParam = request.getParameter("descripcion");
            String servletParam = request.getParameter("servlet");
            String linkParam = request.getParameter("link");
            String iconoParam = request.getParameter("icono");
            String ordenParam = request.getParameter("nOrden");

            objModulos.setCmodulos_Cod(codigoParam);
            objModulos.setVmodulos_Desc(descripcionParam);
            objModulos.setCmodulos_ModSuper(modSuperParam);
            objModulos.setVmodulos_Servlet(servletParam);
            objModulos.setVmodulos_link(linkParam);
            objModulos.setVmodulos_icon(iconoParam);
            objModulos.setCmodulos_Orden(ordenParam);

            result = objModulosDao.updateSubModulos(objModulos);

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }

            response.sendRedirect("paginas/seguridad/ms_Modulos.jsp");

        }

        if ("delete".equals(action)) {

            String codigoParam = request.getParameter("codModulo");

            objModulos.setCmodulos_Cod(codigoParam);

            result = objModulosDao.deleteModulos(codigoParam);

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }

            response.sendRedirect("paginas/seguridad/ms_Modulos.jsp");

        }

    }

    private StringBuilder tablelistSubModulos(List list, List list2) {

        StringBuilder sb = new StringBuilder();
        if (list != null) {
            sb.append("<table  class=\"table table-striped table-hover js-basic-example dataTable\">");
            sb.append("<thead>");
            sb.append("<tr>");
            sb.append("<th>Codigo</th>");
            sb.append("<th>Descripcion</th>");
            sb.append("<th>Servlet</th>");
            sb.append("<th>Link</th>");
            sb.append("<th>Icon</th>");
            sb.append("<th>Orden</th>");
            sb.append("<th>Mod. Super</th>");
            sb.append("<th>Estado</th>");
            sb.append("<th>Accion</th>");
            sb.append("</tr>");
            sb.append("</thead>");
            sb.append("<tbody>");
            for (int i = 0; i < list.size(); i++) {
                Modulos objModulos = (Modulos) list.get(i);
                sb.append("<tr>");
                sb.append("<td>").append(objModulos.getCmodulos_Cod()).append("</td>");
                sb.append("<td>").append(objModulos.getVmodulos_Desc()).append("</td>");
                sb.append("<td>").append(objModulos.getVmodulos_Servlet()).append("</td>");
                sb.append("<td>").append(objModulos.getVmodulos_link()).append("</td>");
                sb.append("<td><i class=\"material-icons\">").append(objModulos.getVmodulos_icon()).append("</i></td>");
                sb.append("<td>").append(objModulos.getCmodulos_Orden()).append("</td>");
                for (int j = 0; j < list2.size(); j++) {
                    Modulos objModulosSuper = (Modulos) list2.get(j);
                    if (objModulos.getCmodulos_ModSuper().equals(objModulosSuper.getCmodulos_Cod())) {
                        sb.append("<td>").append(objModulosSuper.getVmodulos_Desc()).append("</td>");
                    }
                }
                String estado = String.valueOf(objModulos.getCmodulos_Estado());
                if (estado.equals("A")) {
                    sb.append("<td><span class=\"badge bg-green\">Activo</span></td>");
                } else {
                    sb.append("<td><span class=\"badge bg-red\">Inactivo</span></td>");
                }
                sb.append("<td>"
                        + "<button type=\"button\" class=\"btn bg-blue btn-xs\" onclick=\"javascript:fn_dataEditarSubModulo(")
                        .append(true).append(",'").append(objModulos.getCmodulos_Cod()).append("','").append(objModulos.getVmodulos_Desc()).append("','")
                        .append(objModulos.getVmodulos_Servlet()).append("','").append(objModulos.getVmodulos_link()).append("','").append(objModulos.getVmodulos_icon())
                        .append("','").append(objModulos.getCmodulos_Orden()).append("','").append(objModulos.getCmodulos_ModSuper()).append("');").append("\"<i class=\"material-icons\">edit</i>"
                        + "</button>"
                        + "<button type=\"button\" class=\"btn bg-red btn-xs\" onclick=\"javascript:fn_deleteModulos(").append(objModulos.getCmodulos_Cod())
                        .append(",").append("'sM'").append(");\">"
                        + "<i class=\"material-icons\">delete</i>"
                        + "</button>"
                        + "</td>");
                sb.append("</tr>");
            }

            sb.append("</tbody>");
            sb.append("</table>");
        }

        return sb;
    }

    private StringBuilder comboModulosSuper(List<Object[]> list, String atr) {

        StringBuilder sb = new StringBuilder();
        if (list != null) {
            sb.append("<select class=\"form-control show-tick\"").append(atr).append(">");
            sb.append("<option value=\"\">...Seleccione un Modulo ...</option>");

            for (Object[] reg : list) {
                sb.append("<option value=\"").append(reg[0]).append("\">");
                sb.append(reg[1]);
                sb.append("</option>");
            }

            sb.append("</select>");
        }

        return sb;

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
