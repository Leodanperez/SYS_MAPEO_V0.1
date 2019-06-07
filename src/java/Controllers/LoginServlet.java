/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.Impl.Autenticacion;
import Dao.Impl.DbConnection;
import Dao.Impl.LoginDaoImpl;
import Dao.LoginDao;
import Models.Modulos;
import Models.Usuarios;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author IVAN
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    private HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        // Recibimos parametros del formulario de login
        String userParam = request.getParameter("username");
        String passParam = request.getParameter("password");
        String msg = "";
        // Recuperamos una instancia del objeto HttpSession
        session = request.getSession();

        DbConnection conn = new DbConnection();
        Autenticacion objAutenticacion = new Autenticacion(conn);
        // Verificamos en la BD, si es un usuario correcto.

        Usuarios objUsuario = objAutenticacion.login(userParam, passParam);
        String login = userParam;

        RequestDispatcher rd;
        if (objUsuario.getCusuariosCod() > 0) {
            LoginDao objLoginDao = new LoginDaoImpl(conn);
            List<Modulos> listModulosSuper = objLoginDao.getListModulosSuper(login);
            List<Modulos> listSubModulos = objLoginDao.getListSubModulos();
            // Creamos una variable de session, con el registro de usuario (Bean)
            // Verificar en el administrador de aplicaciones de tomcat.
            session.setAttribute("user", objUsuario);
            session.setAttribute("modu", listModulosSuper);
            session.setAttribute("subModu", listSubModulos);
            rd = request.getRequestDispatcher("m_Principal.jsp");
        } else {
            msg = "Usuario y/o password incorrectos";
            request.setAttribute("message", msg);
            rd = request.getRequestDispatcher("login.jsp");

        }
        conn.disconnect();
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
