//package Controllers;
//
//import Dao.Impl.DbConnection;
//import Dao.Impl.ModulosDaoImpl;
//import Models.Modulos;
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
//@WebServlet(name = "SubModuloServlet", urlPatterns = {"/subModulo"})
//public class SubModuloServlet extends HttpServlet {
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet PerModuloSuperServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet PerModuloSuperServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String action = request.getParameter("action");
//        if (null != action) {
//            switch (action) {
//                case "lista":
//                    this.verSubModulos(request, response);
//                    break;
//                case "eliminar":
//                    this.eliminaModulo(request, response);
//                    break;
//                case "asignar":
//                    break;
//                default:
//                    break;
//            }
//        }
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String modo = request.getParameter("modo");
//        String codSubModuloAct = request.getParameter("codSubModuloAct");
//        Modulos perModulos = new Modulos();
//        DbConnection conn = new DbConnection();
//        ModulosDaoImpl perModuloDao = new ModulosDaoImpl(conn);
//
//        try {
//            switch (modo) {
//                case "i":
//                    String descripcionCortaParam = request.getParameter("descripcionCorta");
//                    String descripcionLargaParam = request.getParameter("descripcionLarga");
//                    String moduloSuper = request.getParameter("modSuper");
//                    String link = request.getParameter("link");
//                    String icon = request.getParameter("icono");
//                    String orden = request.getParameter("nOrden");
//
//                    //perModulos.setModulos_codmodulo(codigoParam);
//                    perModulos.setVmodulos_descor(descripcionCortaParam);
//                    perModulos.setVmodulos_deslar(descripcionLargaParam);
//                    perModulos.setModulos_modsuper(moduloSuper);
//                    perModulos.setVmodulos_link(link);
//                    perModulos.setVmodulos_icon(icon);
//                    perModulos.setCmodulos_orden(orden);
//
//                    String status = perModuloDao.RegistrarSubModulo(perModulos);
//                    List<Modulos> lista = perModuloDao.verSubModulos();
//                    conn.disconnect();
//
//                    response.setContentType("text/html;charset=ISO-8859-1");
//                    try (PrintWriter out = response.getWriter()) {
//                        out.print(status);
//
//                    }
//
//                    RequestDispatcher rd;
//                    request.setAttribute("versubmodulo", lista);
//                    rd = request.getRequestDispatcher("paginas/seguridad/ms_Modulos.jsp");
//                    rd.forward(request, response);
//                    break;
//
//                default:
//                    String descripcionCortaActParam = request.getParameter("descCortaAct");
//                    String descripcionLargaActParam = request.getParameter("descLargaAct");
//                    String moduloActSuper = request.getParameter("moduloSuper");
//                    String linkActParam = request.getParameter("linkAct");
//                    String iconActParam = request.getParameter("iconoSubAct");
//                    String ordenActParam = request.getParameter("nOrdenAct");
//
//                    perModulos.setModulos_codmodulo(codSubModuloAct);
//                    perModulos.setVmodulos_descor(descripcionCortaActParam);
//                    perModulos.setVmodulos_deslar(descripcionLargaActParam);
//                    perModulos.setModulos_modsuper(moduloActSuper);
//                    perModulos.setVmodulos_link(linkActParam);
//                    perModulos.setVmodulos_icon(iconActParam);
//                    perModulos.setCmodulos_orden(ordenActParam);
//
//                    String statusA = perModuloDao.updateSubModulo(perModulos);
//                    List<Modulos> lista2 = perModuloDao.verSubModulos();
//                    conn.disconnect();
//
//                    conn.disconnect();
//
//                    response.setContentType("text/html;charset=ISO-8859-1");
//                    try (PrintWriter out = response.getWriter()) {
//                        out.print(statusA);
//
//                    }
//
//                    request.setAttribute("versubmodulo", lista2);
//                    rd = request.getRequestDispatcher("paginas/seguridad/ms_Modulos.jsp");
//                    rd.forward(request, response);
//                    break;
//
//            }
//        } catch (Exception e) {
//
//            String descripcionCortaActParam = request.getParameter("descCortaAct");
//            String descripcionLargaActParam = request.getParameter("descLargaAct");
//            String moduloActSuper = request.getParameter("moduloSuper");
//            String linkActParam = request.getParameter("linkAct");
//            String iconActParam = request.getParameter("iconoSubAct");
//            String ordenActParam = request.getParameter("nOrdenAct");
//
//            perModulos.setModulos_codmodulo(codSubModuloAct);
//            perModulos.setVmodulos_descor(descripcionCortaActParam);
//            perModulos.setVmodulos_deslar(descripcionLargaActParam);
//            perModulos.setModulos_modsuper(moduloActSuper);
//            perModulos.setVmodulos_link(linkActParam);
//            perModulos.setVmodulos_icon(iconActParam);
//            perModulos.setCmodulos_orden(ordenActParam);
//
//            String statusA = perModuloDao.updateSubModulo(perModulos);
//            List<Modulos> lista = perModuloDao.verSubModulos();
//            conn.disconnect();
//
//            conn.disconnect();
//
//            response.setContentType("text/html;charset=ISO-8859-1");
//            try (PrintWriter out = response.getWriter()) {
//                out.print(statusA);
//
//            }
//
//            RequestDispatcher rd;
//            request.setAttribute("versubmodulo", lista);
//            rd = request.getRequestDispatcher("paginas/seguridad/ms_Modulos.jsp");
//            rd.forward(request, response);
//
//        }
//
//    }
//
//    //LISTA SUBMODULOS
//    private void verSubModulos(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        DbConnection conn = new DbConnection();
//        ModulosDaoImpl permoddao = new ModulosDaoImpl(conn);
//        List<Modulos> lista = permoddao.verSubModulos();
//        conn.disconnect();
//
//        RequestDispatcher rd;
//        //Compartir los atributos de objeto modulo
//        request.setAttribute("versubmodulo", lista);
//
//        //Enviamos respuesta. Renderizamos la vista ms_Modulos.jsp
//        rd = request.getRequestDispatcher("ms_Modulos.jsp");
//        rd.forward(request, response);
//
//    }
//
//    private void eliminaModulo(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int codigoParam = Integer.parseInt(request.getParameter("codigo"));
//
//        DbConnection conn = new DbConnection();
//        ModulosDaoImpl perModuloDao = new ModulosDaoImpl(conn);
//        boolean status = perModuloDao.eliminaModulo(codigoParam);
//        List<Modulos> lista = perModuloDao.verSubModulos();
//        conn.disconnect();
//        RequestDispatcher rd;
//        request.setAttribute("vermodulo", lista);
//        rd = request.getRequestDispatcher("/paginas/seguridad/ms_Modulos.jsp");
//        rd.forward(request, response);
//
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Short description";package Controllers;
//
//import Dao.Impl.DbConnection;
//import Dao.Impl.ModulosDaoImpl;
//import Models.Modulos;
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
//@WebServlet(name = "SubModuloServlet", urlPatterns = {"/subModulo"})
//public class SubModuloServlet extends HttpServlet {
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet PerModuloSuperServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet PerModuloSuperServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String action = request.getParameter("action");
//        if (null != action) {
//            switch (action) {
//                case "lista":
//                    this.verSubModulos(request, response);
//                    break;
//                case "eliminar":
//                    this.eliminaModulo(request, response);
//                    break;
//                case "asignar":
//                    break;
//                default:
//                    break;
//            }
//        }
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String modo = request.getParameter("modo");
//        String codSubModuloAct = request.getParameter("codSubModuloAct");
//        Modulos perModulos = new Modulos();
//        DbConnection conn = new DbConnection();
//        ModulosDaoImpl perModuloDao = new ModulosDaoImpl(conn);
//
//        try {
//            switch (modo) {
//                case "i":
//                    String descripcionCortaParam = request.getParameter("descripcionCorta");
//                    String descripcionLargaParam = request.getParameter("descripcionLarga");
//                    String moduloSuper = request.getParameter("modSuper");
//                    String link = request.getParameter("link");
//                    String icon = request.getParameter("icono");
//                    String orden = request.getParameter("nOrden");
//
//                    //perModulos.setModulos_codmodulo(codigoParam);
//                    perModulos.setVmodulos_descor(descripcionCortaParam);
//                    perModulos.setVmodulos_deslar(descripcionLargaParam);
//                    perModulos.setModulos_modsuper(moduloSuper);
//                    perModulos.setVmodulos_link(link);
//                    perModulos.setVmodulos_icon(icon);
//                    perModulos.setCmodulos_orden(orden);
//
//                    String status = perModuloDao.RegistrarSubModulo(perModulos);
//                    List<Modulos> lista = perModuloDao.verSubModulos();
//                    conn.disconnect();
//
//                    response.setContentType("text/html;charset=ISO-8859-1");
//                    try (PrintWriter out = response.getWriter()) {
//                        out.print(status);
//
//                    }
//
//                    RequestDispatcher rd;
//                    request.setAttribute("versubmodulo", lista);
//                    rd = request.getRequestDispatcher("paginas/seguridad/ms_Modulos.jsp");
//                    rd.forward(request, response);
//                    break;
//
//                default:
//                    String descripcionCortaActParam = request.getParameter("descCortaAct");
//                    String descripcionLargaActParam = request.getParameter("descLargaAct");
//                    String moduloActSuper = request.getParameter("moduloSuper");
//                    String linkActParam = request.getParameter("linkAct");
//                    String iconActParam = request.getParameter("iconoSubAct");
//                    String ordenActParam = request.getParameter("nOrdenAct");
//
//                    perModulos.setModulos_codmodulo(codSubModuloAct);
//                    perModulos.setVmodulos_descor(descripcionCortaActParam);
//                    perModulos.setVmodulos_deslar(descripcionLargaActParam);
//                    perModulos.setModulos_modsuper(moduloActSuper);
//                    perModulos.setVmodulos_link(linkActParam);
//                    perModulos.setVmodulos_icon(iconActParam);
//                    perModulos.setCmodulos_orden(ordenActParam);
//
//                    String statusA = perModuloDao.updateSubModulo(perModulos);
//                    List<Modulos> lista2 = perModuloDao.verSubModulos();
//                    conn.disconnect();
//
//                    conn.disconnect();
//
//                    response.setContentType("text/html;charset=ISO-8859-1");
//                    try (PrintWriter out = response.getWriter()) {
//                        out.print(statusA);
//
//                    }
//
//                    request.setAttribute("versubmodulo", lista2);
//                    rd = request.getRequestDispatcher("paginas/seguridad/ms_Modulos.jsp");
//                    rd.forward(request, response);
//                    break;
//
//            }
//        } catch (Exception e) {
//
//            String descripcionCortaActParam = request.getParameter("descCortaAct");
//            String descripcionLargaActParam = request.getParameter("descLargaAct");
//            String moduloActSuper = request.getParameter("moduloSuper");
//            String linkActParam = request.getParameter("linkAct");
//            String iconActParam = request.getParameter("iconoSubAct");
//            String ordenActParam = request.getParameter("nOrdenAct");
//
//            perModulos.setModulos_codmodulo(codSubModuloAct);
//            perModulos.setVmodulos_descor(descripcionCortaActParam);
//            perModulos.setVmodulos_deslar(descripcionLargaActParam);
//            perModulos.setModulos_modsuper(moduloActSuper);
//            perModulos.setVmodulos_link(linkActParam);
//            perModulos.setVmodulos_icon(iconActParam);
//            perModulos.setCmodulos_orden(ordenActParam);
//
//            String statusA = perModuloDao.updateSubModulo(perModulos);
//            List<Modulos> lista = perModuloDao.verSubModulos();
//            conn.disconnect();
//
//            conn.disconnect();
//
//            response.setContentType("text/html;charset=ISO-8859-1");
//            try (PrintWriter out = response.getWriter()) {
//                out.print(statusA);
//
//            }
//
//            RequestDispatcher rd;
//            request.setAttribute("versubmodulo", lista);
//            rd = request.getRequestDispatcher("paginas/seguridad/ms_Modulos.jsp");
//            rd.forward(request, response);
//
//        }
//
//    }
//
//    //LISTA SUBMODULOS
//    private void verSubModulos(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        DbConnection conn = new DbConnection();
//        ModulosDaoImpl permoddao = new ModulosDaoImpl(conn);
//        List<Modulos> lista = permoddao.verSubModulos();
//        conn.disconnect();
//
//        RequestDispatcher rd;
//        //Compartir los atributos de objeto modulo
//        request.setAttribute("versubmodulo", lista);
//
//        //Enviamos respuesta. Renderizamos la vista ms_Modulos.jsp
//        rd = request.getRequestDispatcher("ms_Modulos.jsp");
//        rd.forward(request, response);
//
//    }
//
//    private void eliminaModulo(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int codigoParam = Integer.parseInt(request.getParameter("codigo"));
//
//        DbConnection conn = new DbConnection();
//        ModulosDaoImpl perModuloDao = new ModulosDaoImpl(conn);
//        boolean status = perModuloDao.eliminaModulo(codigoParam);
//        List<Modulos> lista = perModuloDao.verSubModulos();
//        conn.disconnect();
//        RequestDispatcher rd;
//        request.setAttribute("vermodulo", lista);
//        rd = request.getRequestDispatcher("/paginas/seguridad/ms_Modulos.jsp");
//        rd.forward(request, response);
//
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}

//    }// </editor-fold>
//
//}
