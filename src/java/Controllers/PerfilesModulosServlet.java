/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.Impl.DbConnection;
import Dao.Impl.PerfilesDaoImpl;
import Dao.PerfilesDao;
import Models.Perfiles;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LEO
 */
@WebServlet(name = "PerfilesModulosServlet", urlPatterns = {"/PerfilesModulos"})
public class PerfilesModulosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        StringBuilder sb = new StringBuilder();
        DbConnection conn = new DbConnection();
        PerfilesDao objPerfilesdao = new PerfilesDaoImpl(conn);
        Perfiles objPerfiles;
        String result;

        if (action.equals("buscarPerfil")) {

            String busqueda = request.getParameter("valor");
            List listPerfiles = objPerfilesdao.searchPerfiles(busqueda);
            sb = tableSearchPerfiles(listPerfiles);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);
            }

        }

        if (action.equals("mostrarPerfiles")) {

            String Cod = request.getParameter("codigo");
            objPerfiles = objPerfilesdao.datosPerfiles(Cod);
            result = objPerfiles.getCperfiles_Cod() + "+++"
                    + objPerfiles.getVperfiles_Descripcion();

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }

        }

        if (action.equals("listPerfilesModulos")) {

            String codPerfil = request.getParameter("codPerfil");
            List<Perfiles> listPerfilesModulos = objPerfilesdao.listPerfilesModulos(codPerfil);
            sb = tableListPerfilesModulos(listPerfilesModulos);

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);
            }

        }

        if (action.equals("getModulosSelect")) {

            List<Object[]> comboModulos = objPerfilesdao.getModulosSelect();
            sb = comboModulos(comboModulos, "id=\"comboModulos\"");

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);
            }
            
        }

        if (action.equals("insertPM")) {

            String perParam = request.getParameter("codigoPerfil");
            String modParam = request.getParameter("codigoModulo");

            boolean res = objPerfilesdao.insertPerfilesModulos(perParam, modParam);
            sb.append(res);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);
            }
            
        }

        if (action.equals("deletePM")) {

            String codPerfil = request.getParameter("codPerf");
            String codModulo = request.getParameter("codMod");
            
            boolean res = objPerfilesdao.deletePerfilesModulos(codPerfil, codModulo);
            sb.append(res);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);

            }
        }
        
    }

    private StringBuilder tableSearchPerfiles(List list) {

        StringBuilder sb = new StringBuilder();
        if (list != null) {
            sb.append("<table class=\"table table-bordered table-striped table-hover js-basic-example dataTable\">");
            sb.append("<thead>");
            sb.append("<tr>");
            sb.append("<th>Nro</th>");
            sb.append("<th>Codigo</th>");
            sb.append("<th>DESCRIPCIÓN</th>");
            sb.append("</tr>");
            sb.append("</thead>");
            sb.append("<tbody>");
            for (int k = 0; k < list.size(); k++) {
                Perfiles objPerfiles = (Perfiles) list.get(k);
                sb.append("<tr>");
                sb.append("<td><div>");
                sb.append("<input type=\"radio\" id=\"").append(objPerfiles.getCperfiles_Cod()).append("\" name=\"codPerfil\" value=\"").append(objPerfiles.getCperfiles_Cod()).append("\" class=\"form-check-input\">");
                sb.append("<label for=\"").append(objPerfiles.getCperfiles_Cod()).append("\"></label>");
                sb.append("</td>");
                sb.append("<td>").append(objPerfiles.getCperfiles_Cod()).append("</td>");
                sb.append("<td>").append(objPerfiles.getVperfiles_Descripcion()).append("</td>");
                sb.append("</tr>");
            }
            sb.append("</tbody>");
            sb.append("</table>");
        }
        return sb;
    }

    private StringBuilder tableListPerfilesModulos(List list) {

        StringBuilder sb = new StringBuilder();
        if (list != null) {
            sb.append("<table class=\"table table-bordered table-striped table-hover js-basic-example dataTable\">");
            sb.append("<thead>");
            sb.append("<tr>");
            sb.append("<th>Nro</th>");
            sb.append("<th>PERFIL</th>");
            sb.append("<th>MODULO</th>");
            sb.append("<th>ACCIÓN</th>");
            sb.append("</tr>");
            sb.append("</thead>");
            sb.append("<tbody>");
            for (int k = 0; k < list.size(); k++) {
                Perfiles objPerfiles = (Perfiles) list.get(k);
                sb.append("<tr>");
                sb.append("<td>").append(k + 1).append("</td>");
                sb.append("<td>").append(objPerfiles.getVperfiles_Descripcion()).append("</td>");
                sb.append("<td>").append(objPerfiles.getVmodulos_desc()).append("</td>");
                sb.append("<td> <button class='btn bg-red btn-xs' onclick='javascript:deletePM(").append(objPerfiles.getCperfiles_Cod()).append(",").append(objPerfiles.getCmodulos_Cod()).append(");").append("'><i class=\"material-icons\">delete</i></button></td>");
                sb.append("</tr>");
            }

            sb.append("</tbody>");
            sb.append("</table>");
        }
        return sb;

    }
    
    private StringBuilder comboModulos(List<Object[]> list, String atr){
        
        StringBuilder sb = new StringBuilder();
        if(list != null){
            sb.append("<select class=\"form-control show-tick\"").append(atr).append(">");
            
            for(Object[] reg: list){
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
