package Controllers;

import Dao.DaoDonaciones;
import Dao.DaoDonante;
import Dao.Impl.DbConnection;
import Dao.Impl.DonacionesDao;
import Dao.Impl.DonanteDao;
import Models.Donaciones;
import Models.Donante;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * @author LEO
 */
@WebServlet(name = "DonacionesServlet", urlPatterns = {"/DonacionesServlet"})
public class DonacionesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        String action = request.getParameter("action");
        DbConnection conn = new DbConnection();
        DaoDonaciones donacionesDao = new DonacionesDao(conn);
        Donaciones objDonaciones = new Donaciones();
        Donante donante = new Donante();
        DaoDonante daoDonante = new DonanteDao(conn);
        RequestDispatcher rd;
        String result;
        StringBuilder sb;

        if ("listarDonacion".equals(action)) {
            List<Donaciones> listDonaciones = donacionesDao.listDonaciones();
            request.setAttribute("verdonaciones", listDonaciones);
            conn.disconnect();
            rd = request.getRequestDispatcher("paginas/donaciones/donacion.jsp");
            rd.forward(request, response);
        }
        
        if ("listDonate".equals(action)) {
            List<Donante> listDonante = daoDonante.listDonante();
            sb = tableDonante(listDonante);
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);
            }
        }
        
        if ("insertar".equals(action)) {
            String origen = request.getParameter("origen");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            format.setLenient(false);
            java.util.Date date;
            date = format.parse(request.getParameter("fechadona"));
            String donantec = request.getParameter("coddonante");
            String unidad = request.getParameter("codunidad");
            Integer ptotal = Integer.parseInt(request.getParameter("pesototal"));
            Integer vtotal = Integer.parseInt(request.getParameter("vtotal"));
            String militar = request.getParameter("cip");
            String recepcion = request.getParameter("recepcion");
            String movimiento = request.getParameter("movimiento");
            String entrada = request.getParameter("entrada");
            
            objDonaciones.setVLUG_ORIGEN(origen);
            objDonaciones.setDDONA_FECHA(new java.sql.Date(date.getTime()));
            objDonaciones.setCDONATE_COD(donantec);
            objDonaciones.setCOD_UNIDAD(unidad.charAt(0));
            objDonaciones.setDPESO_TOTAL(ptotal);
            objDonaciones.setDVOLUMEN_TOTAL(vtotal);
            objDonaciones.setCPERMILITARES_COD(militar.charAt(0));
            objDonaciones.setVRECEPCION(recepcion);
            objDonaciones.setVMOVIMIENTO(movimiento);
            objDonaciones.setVENTRADA(entrada);
            
            result = donacionesDao.insertDonaciones(objDonaciones);
            conn.disconnect();
            
            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }
            response.sendRedirect("paginas/donaciones/donacion.jsp");
        }
        if ("update".equals(action)) {
            String codigo = request.getParameter("codigo");
            String origen = request.getParameter("origen");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            format.setLenient(false);
            java.util.Date date;
            date = format.parse(request.getParameter("fecha"));
            String donantec = request.getParameter("coddonante");
            String unidad = request.getParameter("unidad");
            Integer ptotal = Integer.parseInt(request.getParameter("peso"));
            Integer vtotal = Integer.parseInt(request.getParameter("volumen"));
            String militar = request.getParameter("cip");
            String recepcion = request.getParameter("recepcion");
            String movimiento = request.getParameter("movimiento");
            String entrada = request.getParameter("entrada");
            
            
            objDonaciones.setCDONA_COD(codigo);
            objDonaciones.setCDONATE_COD(donantec);
            objDonaciones.setCPERMILITARES_COD(militar.charAt(0));
            objDonaciones.setVLUG_ORIGEN(origen);
            objDonaciones.setDDONA_FECHA(new java.sql.Date(date.getTime()));
            objDonaciones.setCOD_UNIDAD(unidad.charAt(0));
            objDonaciones.setDPESO_TOTAL(ptotal);
            objDonaciones.setDVOLUMEN_TOTAL(vtotal);
            objDonaciones.setVRECEPCION(recepcion);
            objDonaciones.setVMOVIMIENTO(movimiento);
            objDonaciones.setVENTRADA(entrada);

            result = donacionesDao.insertDonaciones(objDonaciones);
            //conn.disconnect();

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }
            response.sendRedirect("paginas/donaciones/donacion.jsp");
        }
        
        if ("delete".equals(action)) {
            String codParam = request.getParameter("codigoU");
            objDonaciones.setCDONA_COD(codParam);
            result = donacionesDao.deleteDonaciones(codParam);
            //conn.disconnect();

            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }

            response.sendRedirect("paginas/donaciones/donacion.jsp");
        }
        
        if ("insertDonante".equals(action)) {
            String nombre = request.getParameter("name");
            String telefono = request.getParameter("telefono");
            String email = request.getParameter("email");
            String tipodoc = request.getParameter("tipodoc");
            String nrodoc = request.getParameter("nrodoc");
            
            donante.setVNOMBRE(nombre);
            donante.setCTELEFONO(telefono);
            donante.setVEMAIL(email);
            donante.setCTIPODOC_COD(tipodoc);
            donante.setCNRODOC(nrodoc);
            
            result = daoDonante.insertDonante(donante);
            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }
            response.sendRedirect("paginas/donaciones/donacion.jsp");
            
        }
        
        if ("updateDonante".equals(action)) {
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            String telefono = request.getParameter("telefono");
            String email = request.getParameter("email");
            String tipodoc = request.getParameter("tipodoc");
            String nrodoc = request.getParameter("nrodoc");
            
            donante.setCDONANTE_COD(codigo);
            donante.setVNOMBRE(nombre);
            donante.setCTELEFONO(telefono);
            donante.setVEMAIL(email);
            donante.setCTIPODOC_COD(tipodoc);
            donante.setCNRODOC(nrodoc);
            
            result = daoDonante.updateDonante(donante);
            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(result);
            }
            response.sendRedirect("paginas/donaciones/donacion.jsp");
        }
        
        if ("deleteDonante".equals(action)) {
            String codigoParam = request.getParameter("codigoU");
            donante.setCDONANTE_COD(codigoParam);
            
            //result = daoDonante.deleteDonante(donante);
            
            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                //out.print(result);
            }
            response.sendRedirect("paginas/donaciones/donacion.jsp");
        }
        
        if ("comboDonantes".equals(action)) {
            List<Object[]> cboDonante = daoDonante.getDonanteSeect();
            sb = comboDonantes(cboDonante, "id=\"comboDonante\"");
            
            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);
            }
        }
        
        if("combotipoDoc".equals(action)){
            List<Object[]> cbotipoDoc = daoDonante.getTipodocSeect();
            sb = comboTipodoc(cbotipoDoc, "id=\"comboTipoDocumento\"");
            
            response.setContentType("text/html;charset=ISO-8859-1");
            try (PrintWriter out = response.getWriter()) {
                out.print(sb);
            }
        }
    }
    
    private StringBuilder comboDonantes(List<Object[]> list, String atr){
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            sb.append("<select class=\"form-control show-tick\"").append(atr).append(">");
            sb.append("<option value=\"\">-- Seleccione --</option>");
            
            for (Object[] reg : list) {
                sb.append("<option value=\"").append(reg[0]).append("\">");
                sb.append(reg[1]);
                sb.append("</option>");
            }
            sb.append("</select>");
        }
        return sb;
    }
    
    private StringBuilder comboTipodoc(List<Object[]> list, String atr){
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            sb.append("<select class=\"form-control show-tick\"").append(atr).append(">");
            sb.append("<option value=\"\">-- Seleccione tipo Documento --</option>");
            for (Object[] reg : list) {
                sb.append("<option value=\"").append(reg[0]).append("\">");
                sb.append(reg[1]);
                sb.append("</option>");
            }
            sb.append("</select>");
        }
        return sb;
    }
    
    private StringBuilder tableDonante (List list){
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            sb.append("<table class=\"table table-striped\">");
            sb.append("<thead>");
            sb.append("<tr>");
            sb.append("<th>Codigo</th>");
            sb.append("<th>Nombres</th>");
            sb.append("<th>Teléfono</th>");
            sb.append("<th>Email</th>");
            sb.append("<th>Tipo Doc</th>");
            sb.append("<th>Nro Documento</th>");
            sb.append("<th>Acciones</th>");
            sb.append("</tr>");
            sb.append("</thead>");
            sb.append("<tbody>");
            for (int j = 0; j < list.size(); j++) {
                Donante donante = (Donante) list.get(j);
                sb.append("<tr>");
                sb.append("<td>").append(donante.getCDONANTE_COD()).append("</td>");
                sb.append("<td>").append(donante.getVNOMBRE()).append("</td>");
                sb.append("<td>").append(donante.getCTELEFONO()).append("</td>");
                sb.append("<td>").append(donante.getVEMAIL()).append("</td>");
                sb.append("<td>").append(donante.getCTIPODOC_COD()).append("</td>");
                sb.append("<td>").append(donante.getCNRODOC()).append("</td>");
                sb.append("<td>"
                          + "<button type=\"button\" class=\"btn btn-primary btn-xs waves-effect\" onclick=\"javascript: fn_datosUpdateDonante(")
                          .append(true).append(",'").append(donante.getCDONANTE_COD()).append("','").append(donante.getVNOMBRE()).append("','")
                          .append(donante.getCTELEFONO()).append("','").append(donante.getVEMAIL()).append("','").append(donante.getCTIPODOC_COD()).append("','")
                          .append(donante.getCNRODOC()).append("');").append("\"<i class=\"material-icons\">edit</i>"
                          + "</button>"
                          + "<button type=\"button\" class=\"btn bg-red btn-xs\" onclick=\"javascript:fn_deleteDonante(").append(donante.getCDONANTE_COD())
                          .append(",").append(");\">"
                          + "<i class=\"material-icons\">delete</i>"
                          + "</button"
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(DonacionesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(DonacionesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
