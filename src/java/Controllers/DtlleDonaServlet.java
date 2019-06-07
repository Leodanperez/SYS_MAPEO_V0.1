
package Controllers;

import Dao.Impl.DbConnection;
import Dao.Impl.DetallDonaDao;
import Dao.Impl.DonacionesDao;
import Models.DetalleDonacion;
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
 * @author LEO
 */
@WebServlet(name = "DtlleDonaServlet", urlPatterns = {"/detalledona"})
public class DtlleDonaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (null != action) {
            switch (action) {
                case "listardetalledona":
                    this.verDtlDonacion(request, response);
                    break;
                case "eliminar":
                    this.eliminaDotlDnacion(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void verDtlDonacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DbConnection conn = new DbConnection();
        DetallDonaDao donaDao = new DetallDonaDao(conn);
        List<DetalleDonacion> listaDonacion = donaDao.getAllDetallDonacion();
        request.setAttribute("verdetalledona", listaDonacion);

        RequestDispatcher rd;
        conn.disconnect();
        rd = request.getRequestDispatcher("paginas/donaciones/donacion.jsp");
        rd.forward(request, response);
    }

    private void eliminaDotlDnacion(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
