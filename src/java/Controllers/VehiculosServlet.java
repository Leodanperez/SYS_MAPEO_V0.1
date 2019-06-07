package Controllers;

import Dao.DaoVehiculos;
import Dao.Impl.DbConnection;
import Dao.Impl.VehiculosDao;
import Models.TipoVehiculo;
import Models.Vehiculo;
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
@WebServlet(name = "VehiculosServlet", urlPatterns = {"/VehiculosServlet"})
public class VehiculosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        DbConnection conn = new DbConnection();
        DaoVehiculos vehiculadao = new VehiculosDao(conn);
        TipoVehiculo objTpvehiculo = new TipoVehiculo();
        Vehiculo objVehiculo = new Vehiculo();
        RequestDispatcher rd;
        String result;
        StringBuilder sb;

        if ("listtVehiculos".equals(action)) {

            List<Vehiculo> listVehiculo = vehiculadao.listVehiculos();
            request.setAttribute("vehiculos", listVehiculo);

            conn.disconnect();
            rd = request.getRequestDispatcher("paginas/vehiculos/vehiculos.jsp");
            rd.forward(request, response);
        }
        
        if ("listTipovehiculo".equals(action)){
            List<TipoVehiculo> listtVehiculo = vehiculadao.listtVehiculos();
            //conn.disconnect();
            //request.setAttribute("tvehiculos", listtVehiculo);
            sb = listtVehiculos(listtVehiculo);
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);
            }
        }

        if ("insertar".equals(action)) {
            String VDESCRIPCION = request.getParameter("description");
            int CANTIDAD = Integer.parseInt(request.getParameter("cantidad"));

            objTpvehiculo.setVDESCRIPCION(VDESCRIPCION);
            objTpvehiculo.setCANTIDAD(CANTIDAD);

            result = vehiculadao.inserttVehiculo(objTpvehiculo);
            //listtVehiculos(listtVehiculo);
            List<TipoVehiculo> listtVehiculo = vehiculadao.listtVehiculos();
            listtVehiculos(listtVehiculo);
            conn.disconnect();
            

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }

            response.sendRedirect("paginas/vehiculos/vehiculos.jsp");
            //request.setAttribute("tvehiculos", listtVehiculo);
            //rd = request.getRequestDispatcher("paginas/vehiculos/vehiculos.jsp");
            //rd.forward(request, response);
        }

        if ("update".equals(action)) {
            String codigo = request.getParameter("codigo");
            String uVDESCRIPCION = request.getParameter("descripcion");
            int uCANTIDAD = Integer.parseInt(request.getParameter("cantidad").trim());
            String uESTADO = request.getParameter("estado");

            objTpvehiculo.setCTVEHICULO_COD(codigo);
            objTpvehiculo.setVDESCRIPCION(uVDESCRIPCION);
            objTpvehiculo.setCANTIDAD(uCANTIDAD);
            objTpvehiculo.setCESTADO(uESTADO.charAt(0));

            result = vehiculadao.updatetVehiculo(objTpvehiculo);
            List<TipoVehiculo> listtVehiculo = vehiculadao.listtVehiculos();
            conn.disconnect();

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }

            request.setAttribute("tvehiculos", listtVehiculo);
            rd = request.getRequestDispatcher("paginas/vehiculos/vehiculos.jsp");
            rd.forward(request, response);
        }

        if ("delete".equals(action)) {
            String codParam = request.getParameter("codigoU");
            result = vehiculadao.deletetVehiculo(codParam);

            conn.disconnect();

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }

            response.sendRedirect("paginas/vehiculos/vehiculos.jsp");
        }

        if ("inservehiculo".equals(action)) {
            int pesoneto = Integer.parseInt(request.getParameter("InpesoNeto"));
            int volumen = Integer.parseInt(request.getParameter("Involumen"));
            String tvehiculo = request.getParameter("Intvehiculo");
            String placa = request.getParameter("Inplaca");
            int pbruto = Integer.parseInt(request.getParameter("InpesBruto"));
            int carga = Integer.parseInt(request.getParameter("InCarga"));

            objVehiculo.setDPESO_NETO(pesoneto);
            objVehiculo.setDVOLUMEN(volumen);
            objVehiculo.setCTVEHICULO_COD(tvehiculo);
            objVehiculo.setVPLACA(placa);
            objVehiculo.setDPESO_BRUTO(pbruto);
            objVehiculo.setDCPCIDAD_CARGA(carga);

            result = vehiculadao.insertVehiculo(objVehiculo);
            List<Vehiculo> listVehiculo = vehiculadao.listVehiculos();
            conn.disconnect();

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }

            request.setAttribute("tvehiculos", listVehiculo);
            rd = request.getRequestDispatcher("paginas/vehiculos/vehiculos.jsp");
            rd.forward(request, response);
        }
        if ("updatevehiculo".equals(action)) {
            String Ucodigo = request.getParameter("Ucodigo");
            int Upesoneto = Integer.parseInt(request.getParameter("Upesoneto").trim());
            int Uvolumen = Integer.parseInt(request.getParameter("Uvolumen").trim());
            String Utvehiculo = request.getParameter("Utipovehiculo");
            String Uplaca = request.getParameter("Uplaca");
            String Ustado = request.getParameter("Uestado");
            int Upbruto = Integer.parseInt(request.getParameter("Upesobruto").trim());
            int Ucarga = Integer.parseInt(request.getParameter("Ucarga").trim());

            objVehiculo.setCVEHICULO_COD(Ucodigo);
            objVehiculo.setDPESO_NETO(Upesoneto);
            objVehiculo.setDVOLUMEN(Uvolumen);
            objVehiculo.setCTVEHICULO_COD(Utvehiculo);
            objVehiculo.setVPLACA(Uplaca);
            objVehiculo.setCESTADO(Ustado.charAt(0));
            objVehiculo.setDPESO_BRUTO(Upbruto);
            objVehiculo.setDCPCIDAD_CARGA(Ucarga);

            result = vehiculadao.updateVehiculo(objVehiculo);
            List<Vehiculo> listVehiculo = vehiculadao.listVehiculos();
            conn.disconnect();

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }

            request.setAttribute("tvehiculos", listVehiculo);
            rd = request.getRequestDispatcher("paginas/vehiculos/vehiculos.jsp");
            rd.forward(request, response);
        }

        if ("deletevehiculo".equals(action)) {
            String codParam = request.getParameter("codigoU");
            result = vehiculadao.deleteVehiculo(codParam);
            conn.disconnect();

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }

            response.sendRedirect("paginas/vehiculos/vehiculos.jsp");
        }
    }

    private StringBuilder listtVehiculos(List list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            sb.append("<table class=\"table table-striped\">");
            sb.append("<thead>");
            sb.append("<tr>");
            sb.append("<th>Codigo</th>");
            sb.append("<th>Descripcion</th>");
            sb.append("<th>Cantidad</th>");
            sb.append("<th>Estado</th>");
            sb.append("<th>Acciones</th>");
            sb.append("</tr>");
            sb.append("</thead>");
            sb.append("<tbody>");
            for (int i = 0; i < list.size(); i++) {
                TipoVehiculo tipoVehiculo = (TipoVehiculo) list.get(i);
                sb.append("<tr>");
                sb.append("<td>").append(tipoVehiculo.getCTVEHICULO_COD()).append("</td>");
                sb.append("<td>").append(tipoVehiculo.getVDESCRIPCION()).append("</td>");
                sb.append("<td>").append(tipoVehiculo.getCANTIDAD()).append("</td>");
                sb.append("<td>").append(tipoVehiculo.getCESTADO()).append("</td>");
                String estado = String.valueOf(tipoVehiculo.getCESTADO());
                if (estado.equals("A")) {
                    sb.append("<td><span class=\"badge bg-green\">Activo</span></td>");
                } else {
                    sb.append("<td><span class=\"badge bg-red\">Inactivo</span></td>");
                }
                sb.append("<td>"
                        + "<button type=\"button\" class=\"btn btn-primary btn-xs waves-effect\" onclick=\"javascript: fn_datosUpdatetVehiculo(")
                        .append(true).append(",'").append(tipoVehiculo.getCTVEHICULO_COD()).append("','").append(tipoVehiculo.getVDESCRIPCION()).append("','")
                        .append(tipoVehiculo.getCANTIDAD()).append("');").append("\"<i class=\"material-icons\">edit</i>"
                        + "</button>"
                        + "<button type=\"button\" class=\"btn bg-pink btn-xs waves-effect\" onclick=\"javascript: fn_eliminartVehiculo(")
                        .append(tipoVehiculo.getCTVEHICULO_COD()).append(");\">"
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
