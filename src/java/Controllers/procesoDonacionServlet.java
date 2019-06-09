package Controllers;

import Dao.DaoProceVehiculos;
import Dao.Impl.DaoProcDonaciones;
import Dao.Impl.DaoProceVehiculosImpl;
import Dao.Impl.DbConnection;
import Dao.ProceDonacionesDao;
import Models.DetalleDonacion;
import Models.ProceVehiculos;
import Models.ProcesoDonaciones;
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
@WebServlet(name = "procesoDonacionServlet", urlPatterns = {"/procesoDonacionServlet"})
public class procesoDonacionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DbConnection conn = new DbConnection();
        ProceDonacionesDao proceDonacionesDao = new DaoProcDonaciones(conn);
        ProcesoDonaciones procesoDonaciones = new ProcesoDonaciones();
        DetalleDonacion detalleDonacion = new DetalleDonacion();
        ProceVehiculos proceVehiculos = new ProceVehiculos();
        DaoProceVehiculos daoProceVehiculos = new DaoProceVehiculosImpl(conn);
        RequestDispatcher rd;
        String result;
        StringBuilder sb;

        String action = request.getParameter("action");
        
        if ("listProcDonaciones".equals(action)) {
            List<DetalleDonacion> listProcDonaciones = proceDonacionesDao.getSelectEmergencia();
            request.setAttribute("listProceDonaciones", listProcDonaciones);
            
            conn.disconnect();
            rd = request.getRequestDispatcher("paginas/proceso/p_donaciones.jsp");
            rd.forward(request, response);
            //response.sendRedirect("paginas/proceso/p_donaciones.jsp");
        }

        if ("insert".equals(action)) {
            String VDESCRIPCION = request.getParameter("codEmergencia");

            procesoDonaciones.setCEMERGENCIA_COD(VDESCRIPCION);

            result = proceDonacionesDao.calcularProceso(procesoDonaciones);
            List<DetalleDonacion> listProcDonaciones = proceDonacionesDao.getSelectEmergencia();
            conn.disconnect();

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }

            request.setAttribute("listProceDonaciones", listProcDonaciones);
            rd = request.getRequestDispatcher("paginas/proceso/p_donaciones.jsp");
            rd.forward(request, response);
        }

        if ("procVehiculos".equals(action)) {
            String codvehiculo = request.getParameter("codVehiculo");
            String codemergencia = request.getParameter("codEmergencia");
            String codunidad = request.getParameter("codUnidad");
            
            proceVehiculos.setCOD_TIPO_VEHICULO(codvehiculo);
            proceVehiculos.setCOD_EMERGENCIA(codemergencia);
            proceVehiculos.setCOD_UNIDAD(codunidad);
            
            result = daoProceVehiculos.procDonaciones(proceVehiculos);
            List<ProceVehiculos> listVehiculos = daoProceVehiculos.listDonaciones();
            conn.disconnect();
            
            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }
            request.setAttribute("listProceDonaciones", listVehiculos);
            rd = request.getRequestDispatcher("paginas/proceso/p_donaciones.jsp");
            rd.forward(request, response);
        }
    }

    private StringBuilder listProcVehiculo(List list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            sb.append("");
            sb.append("");
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
    }

}
