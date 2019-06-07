///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Controllers;
//
//import Dao.Impl.DbConnection;
//import Dao.Impl.RolModuloDao;
//import Dao.Impl.UsuariosDaoImpl;
//import Models.RolModulo;
//import Models.Modulos;
//import Models.Usuarios;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author IVAN
// */
//@WebServlet(name = "ModRolServlet", urlPatterns = {"/RolModuloServlet"})
//public class RolModuloServlet extends HttpServlet {
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        DbConnection conn = new DbConnection();
//        String accion = request.getParameter("accion");
//        StringBuilder sb = new StringBuilder();
//        String result = null;
//        RolModulo modrol = new RolModulo();
//        RolModuloDao modrolDao = new RolModuloDao(conn);
//        System.out.println(accion);
//
//        if (accion.equals("BuscarModulo")) {
//            String busqueda = request.getParameter("valor");
//            System.out.println(busqueda);
//            List list = modrolDao.BuscarModulo(busqueda);
//            sb = tabla(list);
//
//            response.setContentType("text/html;charset=UTF-8");
//            try (PrintWriter out = response.getWriter()) {
//                out.print(sb);
//            }
//        }
//        
//        if (accion.equals("mostrar")) {
//            String Cod = request.getParameter("cod");
//            Modulos modulo = modrolDao.DatosModulo(Cod);
//            result = modulo.getCmodulos_codmodulo() + "+++"
//                    + modulo.getVmodulos_deslar();
//            System.out.println(result);
//            response.setContentType("text/html;charset=ISO-8859-1");
//            try (PrintWriter out = response.getWriter()) {
//                out.print(result);
//            }
//        }
//
//        if (accion.equals("mostrarLista")) {
//            Integer Cod = Integer.parseInt(request.getParameter("cod"));
//            System.out.println(Cod);
//            RolModuloDao modroldao = new RolModuloDao(conn);
//            List<RolModulo> listamodrol = modroldao.getAllModRol(Cod);
//            sb = tabla2(listamodrol);
//
//            response.setContentType("text/html;charset=ISO-8859-1");
//            try (PrintWriter out = response.getWriter()) {
//                out.print(sb);
//            }
//        }
//
//        if (accion.equals("insertar")) {
//            Integer moduloParam = Integer.parseInt(request.getParameter("codModulo"));
//            String tipoRolParam = request.getParameter("tipoRol");
//            RolModulo mdrol = new RolModulo();
//            mdrol.setCmodulos_codmodulo(moduloParam);
//            mdrol.setCroles_codrol(tipoRolParam);
//            RolModuloDao modroldao = new RolModuloDao(conn);
//            boolean status = modroldao.insert(mdrol);
//            List<RolModulo> listamodrol = modroldao.getAllModRol(moduloParam);
//            sb = tabla2(listamodrol);
//            System.out.println(moduloParam);
//
//            response.setContentType("text/html;charset=UTF-8");
//            try (PrintWriter out = response.getWriter()) {
//                out.print(sb);
//            }
//        }
//
//        if (accion.equals("eliminaRolModulo")) {
//
//            String eCodModulo = request.getParameter("codModulo");
//            String eCodRol = request.getParameter("codRol");
//
//            modrol.setCodModulo(eCodModulo);
//            modrol.setCroles_codrol(eCodRol);
//            
//            boolean status=modrolDao.eliminar(modrol);
//            sb.append(status);
//
//            response.setContentType("text/html;charset=UTF-8");
//            try (PrintWriter out = response.getWriter()) {
//                out.print(sb);
//            }
//        }
//        
//        if (accion.equals("updateUsuario")) {
//            String CUSUARIO_CODUSER = request.getParameter("codigoact");
//            Integer uCMILITARES_CIP = Integer.parseInt(request.getParameter("cipUact").trim());
//            String uVUSUARIOS_LOGIN = request.getParameter("loginUact");
//            String uVUSUARIOS_PASSWORD = request.getParameter("passwordUact");
//            String uVUSUARIOS_ESTADO = request.getParameter("estadoUact");
//            String uVUSUARIOS_CORREO = request.getParameter("correoUact");
//
//            Usuarios usuario = new Usuarios();
//            usuario.setCUSUARIOS_IDUSERS(CUSUARIO_CODUSER);
//            usuario.setCMILITARES_CIP(uCMILITARES_CIP);
//            usuario.setVUSUARIOS_LOGIN(uVUSUARIOS_LOGIN);
//            usuario.setVUSUARIOS_PASSWORD(uVUSUARIOS_PASSWORD);
//            usuario.setVUSUARIOS_ESTADO(uVUSUARIOS_ESTADO);
//            usuario.setVUSUARIOS_CORREO(uVUSUARIOS_CORREO);
//            DbConnection connv = new DbConnection();
//
//            UsuariosDaoImpl usuDao = new UsuariosDaoImpl(connv);
//            //System.out.println(uCMILITARES_CIP + "+++" + uVUSUARIOS_CORREO + "+++" + uVUSUARIOS_LOGIN + "+++" + uVUSUARIOS_PASSWORD);
//            boolean UpdateUsu = usuDao.update(usuario);
//            System.out.println(UpdateUsu);
//            List<Usuarios> listaUsuario = usuDao.getAllUsuarios();
//            RequestDispatcher rd;
//            request.setAttribute("usuario", listaUsuario);
//            rd = request.getRequestDispatcher("/ms_Usuarios.jsp");
//            conn.disconnect();
//            rd.forward(request, response);
//        }
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
//            sb.append("<th>CODIGO</th>");
//            sb.append("<th>DESCRIPCIÓN CORTA</th>");
//            sb.append("<th>DESCRIPCIÓN LARGA</th>");
//            sb.append("</tr>");
//            sb.append("</thead>");
//            sb.append("<tbody>");
//            for (int k = 0; k < list.size(); k++) {
//                Modulos md = (Modulos) list.get(k);
//                sb.append("<tr>");
//                sb.append("<td>");
//                sb.append("<input type=\"radio\" id=\"").append(md.getCmodulos_codmodulo()).append("\" name=\"radio1\" value=\"").append(md.getCmodulos_codmodulo()).append("\" class=\"form-check-input\">");
//                sb.append("<label for=\"").append(md.getCmodulos_codmodulo()).append("\"></label>");
//                sb.append("</td>");
//                sb.append("<td>").append(md.getCmodulos_codmodulo()).append("</td>");
//                sb.append("<td>").append(md.getVmodulos_descor()).append("</td>");
//                sb.append("<td>").append(md.getVmodulos_deslar()).append("</td>");
//                sb.append("</tr>");
//            }
//            sb.append("</tbody>");
//            sb.append("</table>");
//        }
//        return sb;
//    }
//
//    private StringBuilder tabla2(List list) {
//        StringBuilder sb = new StringBuilder();
//        if (list != null) {
//            sb.append("<table class=\"table table-bordered table-striped table-hover js-basic-example dataTable\">");
//            sb.append("<thead>");
//            sb.append("<tr>");
//            sb.append("<th>Nro</th>");
//            sb.append("<th>Modulo</th>");
//            sb.append("<th>Rol</th>");
//            sb.append("<th></th> ");
//            sb.append("</tr>");
//            sb.append("</thead>");
//            sb.append("<tbody>");
//            for (int k = 0; k < list.size(); k++) {
//                RolModulo modrol = (RolModulo) list.get(k);
//                sb.append("<tr>");
//                sb.append("<td>").append(k + 1).append("</td>");
//                sb.append("<td>").append(modrol.getModulos()).append("</td>");
//                sb.append("<td>").append(modrol.getRoles()).append("</td>");
//                sb.append("<td><button class='btn bg-red btn-xs' onclick='javascript:eliminarRolModulo(").append(modrol.getCodModulo()).append(",").append(modrol.getCroles_codrol()).append(");").append("'><i class='material-icons'>delete</i></button></td>");
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
