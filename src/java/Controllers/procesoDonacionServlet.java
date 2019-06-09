package Controllers;

import Dao.DaoProceVehiculos;
import Dao.Impl.DaoProcDonaciones;
import Dao.Impl.DaoProceVehiculosImpl;
import Dao.Impl.DbConnection;
import Dao.ProceDonacionesDao;
import Models.DetalleDonacion;
import Models.ListAllVehiculosProc;
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
        
        if("listarVehiculos".equals(action)){
            List<ListAllVehiculosProc> listProcVehiculos = daoProceVehiculos.listVehiculos();
            sb = listProcVehiculo(listProcVehiculos);
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);
            }
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
            
            List<ListAllVehiculosProc> listVehiculos = daoProceVehiculos.listVehiculos();
            sb = listProcVehiculo(listVehiculos);
            conn.disconnect();
            
            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }
            /*request.setAttribute("listProceDonaciones", listVehiculos);
            rd = request.getRequestDispatcher("paginas/proceso/p_donaciones.jsp");
            rd.forward(request, response);*/
        }
    }

    private StringBuilder listProcVehiculo(List list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            sb.append("<table class=\"table table-striped\" id=\"getAllVehiculos\">");
            sb.append("<thead>");
            sb.append("<tr>");
            sb.append("<th>Volumen</th>");
            sb.append("<th>Placa</th>");
            sb.append("<th>Combustible</th>");
            sb.append("<th>Vehiculos</th>");
            sb.append("<th>Sub Combustible</th>");
            sb.append("<th>Unidad</th>");
            sb.append("<th>Emergencia</th>");
            sb.append("</tr>");
            sb.append("</thead>");
            sb.append("<tbody>");
            for (int i = 0; i < list.size(); i++) {
                ListAllVehiculosProc proceVehiculos = (ListAllVehiculosProc) list.get(i);
                sb.append("<tr>");
                sb.append("<td>").append(proceVehiculos.getVOLUMEN()).append("</td>");
                sb.append("<td>").append(proceVehiculos.getPLACA()).append("</td>");
                sb.append("<td>").append(proceVehiculos.getCOMBUSTIBLE()).append("</td>");
                sb.append("<td>").append(proceVehiculos.getVEHICULO()).append("</td>");
                sb.append("<td>").append(proceVehiculos.getSUB_TOTALCOMBUSTIBLE()).append("</td>");
                sb.append("<td>").append(proceVehiculos.getUNIDAD()).append("</td>");
                sb.append("<td>").append(proceVehiculos.getEMERGENCIA()).append("</td>");
                sb.append("</tr>");
            }
            sb.append("</tbody>");
            sb.append("</table>");
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
