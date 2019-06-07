package Controllers;

import Dao.Impl.DbConnection;
import Dao.Impl.PerfilesDaoImpl;
import Dao.PerfilesDao;
import Models.Perfiles;
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
 * @author IVAN
 */
@WebServlet(name = "PerfilesServlet", urlPatterns = {"/Perfiles"})
public class PerfilesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        String action = request.getParameter("action");
        DbConnection conn = new DbConnection();
        PerfilesDao objPerfilesDao = new PerfilesDaoImpl(conn);
        Perfiles objPerfiles = new Perfiles();
        RequestDispatcher rd;
        String result;

        if ("getListPerfiles".equals(action)) {
            
            List<Perfiles> listPerfiles = objPerfilesDao.listPerfiles();
            conn.disconnect();

            request.setAttribute("perfiles", listPerfiles);
            rd = request.getRequestDispatcher("paginas/seguridad/ms_Perfiles.jsp");
            rd.forward(request, response);
            
        }

        if ("insert".equals(action)) {
            
            String descripcionParam = request.getParameter("descripcion");

            objPerfiles.setVperfiles_Descripcion(descripcionParam);

            result = objPerfilesDao.insertPerfiles(objPerfiles);
            conn.disconnect();

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }

            response.sendRedirect("paginas/seguridad/ms_Perfiles.jsp");
        }

        if ("update".equals(action)) {

            String codParam = request.getParameter("codigo");
            String descripcionParam = request.getParameter("descripcion");

            objPerfiles.setCperfiles_Cod(codParam.charAt(0));
            objPerfiles.setVperfiles_Descripcion(descripcionParam);

            result = objPerfilesDao.updatePerfiles(objPerfiles);
            conn.disconnect();

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }
            
            response.sendRedirect("paginas/seguridad/ms_Perfiles.jsp");

        }

        if ("delete".equals(action)) {

            String codigoParm = request.getParameter("codigo");
            result = objPerfilesDao.deletePerfiles(codigoParm);

            conn.disconnect();
            
            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }
            
            response.sendRedirect("paginas/seguridad/ms_Perfiles.jsp");

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(PerfilesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(PerfilesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
