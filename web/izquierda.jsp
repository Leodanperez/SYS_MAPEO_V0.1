<%//@page import="Dao.UsuarioDao"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section>
    <!-- Left Sidebar -->
    <aside id="leftsidebar" class="sidebar">
        <!-- User Info -->
        <div class="user-info">
            <div class="image">
                <img src="images/user_military.png" width="48" height="48" alt="User" />
            </div>
            <div class="info-container">
                <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="font-size: 12px;">${user.getVpersonal_ApellNom()}</div>
                <div class="email">${user.getVusuairos_Email()}</div>
                <div class="btn-group user-helper-dropdown">
                    <i class="material-icons" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
                    <ul class="dropdown-menu pull-right">
                        <li><a href="javascript:void(0);"><i class="material-icons">person</i>Perfil</a></li>                            
                        <li role="separator" class="divider"></li>
                        <li><a href="Admin?action=close"><i class="material-icons">input</i>Cerrar Sesion</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- #User Info -->

        <!-- Menu -->
        <div class="menu">
            <ul class="list">
                <li class="header">MENU DE NAVEGACION</li>
                <li class="active">
                    <a href="#">
                        <i class="material-icons">home</i>
                        <span>Inicio</span>
                    </a>     
                </li>
                <li class="">
                    <a href="javascript:void(0);" class="menu-toggle " title="MODULO GEOLOCALIZACION">
                        <i class="material-icons">location_on</i>
                        <span>MODULO GEOLOCALIZACIÓN</span>
                    </a>
                    <ul class="ml-menu ul-menu">
                        <li>
                            <a href="https://qgiscloud.com/gmanriquef/MAPA/?bl=mapnik&st=&l=todo%20lines&t=MAPA&e=-8594422%2C-1359054%2C-8565822%2C-1345234" style="color: orangered" target="_blank">
                                <i class="material-icons">location_on</i>
                                <span style="color: orangered">VER MAPA</span>
                            </a>     
                        </li>
                    </ul>
                </li>


                <c:forEach items="${modu}" var="modulo" varStatus="status">
                    <li>
                        <a href="javascript:void(0);" class="menu-toggle " title="${modulo.getVmodulos_Desc()}">
                            <i class="material-icons">${modulo.getVmodulos_icon()}</i>
                            <span>${modulo.getVmodulos_Desc()}</span>
                        </a>

                        <ul class="ml-menu ul-menu">
                            <input type="hidden" value="${modulo.getCmodulos_Cod()}" name="codigo" id="codigo" />
                            <c:forEach items="${subModu}" var="modulo2" varStatus="status">  
                                <c:choose>
                                    <c:when test="${modulo.getCmodulos_Cod()==modulo2.getCmodulos_ModSuper()}">
                                        <li>
                                            <button class=" waves-effect waves-block sty-menu" onclick="javascript:fn_CargarMenu('${modulo2.getVmodulos_Servlet()}', '${modulo2.getVmodulos_link()}');" title="${modulo2.getVmodulos_Desc()}">
                                                <i class="material-icons">${modulo2.getVmodulos_icon()}</i>
                                                <span>${modulo2.getVmodulos_Desc()}</span>
                                            </button>
                                        </li>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </ul>

                    </li>
                </c:forEach>
            </ul>
        </div>
    </aside>
    <!-- #Menu -->
</section>

