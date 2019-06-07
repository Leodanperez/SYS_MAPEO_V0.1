
package Controllers;

import Dao.Impl.DbConnection;
import Dao.Impl.DonanteDao;
import Models.Donante;
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
@WebServlet(name = "DonanteServlet", urlPatterns = {"/donante"})
public class DonanteServlet extends HttpServlet {

 
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
                case "listarDonante":
                    this.verDonante(request, response);
                    break;
                case "eliminar":
                    this.eliminaDonante(request, response);
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

    private void verDonante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*DbConnection conn = new DbConnection();
        DonanteDao donaDao = new DonanteDao(conn);
        List<Donante> listaDonacion = donaDao.getAllDonante();
        request.setAttribute("verdonante", listaDonacion);

        RequestDispatcher rd;
        conn.disconnect();
        rd = request.getRequestDispatcher("paginas/donaciones/donacion.jsp");
        rd.forward(request, response);*/
    }

    private void eliminaDonante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
    }

}
