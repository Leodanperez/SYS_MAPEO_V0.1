<%//@page import="Models.UsuPerf" %>
<%//@page import="Dao.PerfilesDao"%>
<%//@page import="Models.PerPerfiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Muestra el contenido -->
<div class="container-fluid">
    <div class="block-header">
        <h3><strong>ADMINISTRACIÓN DE USUARIOS</strong></h3>
    </div>
    <!-- Tabs With Icon Title -->
    <div class="row clearfix">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div class="card">
                <div class="body">
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active">
                            <a href="#regusuario_nav" data-toggle="tab">
                                <i class="material-icons">plus_one </i> Registrar Usuarios
                            </a>
                        </li>
                        <li role="presentation">
                            <a href="#perfilusuario_nav" data-toggle="tab">
                                <i class="material-icons">swap_horiz </i> Asignar Perfil a Usuario
                            </a>
                        </li>
                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane fade in active" id="regusuario_nav">

                            <!-- Tabla  Usuarios -->
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="listadoUsuarios">
                                    <div class="card">
                                        <div class="header bg-blue-grey">
                                            <h2 class="col-md-10 col-sm-9 col-xs-8">
                                                <strong>Lista de Usuarios Actuales</strong>
                                            </h2>

                                            <button type="button" class="btn btn-success waves-effect btn-sm col-md-2 col-sm-3 col-xs-4" onclick="javascript:mostrarform(true, 'i');">
                                                <i class="material-icons">add </i>
                                                <span>Agregar Usuario</span>
                                            </button>
                                            <br>
                                        </div>
                                        <div class="body">
                                            <div class="table-responsive">
                                                <table class="table table-bordered table-striped table-hover js-basic-example dataTable">
                                                    <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>Nombres y Apellidos</th>
                                                            <th>CIP</th>
                                                            <th>Usuario</th>
                                                            <th>Email</th>
                                                            <th>Foto</th>
                                                            <th>Estado</th>
                                                            <th>Acción</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${usuario}" var="usu" varStatus="status">
                                                            <tr>
                                                                <td>${usu.getCusuarios_Cod()}</td>
                                                                <td>${usu.getVpersonal_ApellNom()}</td>
                                                                <td>${usu.getCmilitares_Cip()}</td>
                                                                <td>${usu.getVusuarios_Login()}</td>
                                                                <td>${usu.getVusuairos_Email()}</td>
                                                                <td><img src="${usu.getVusuarios_Foto()}"></td>
                                                                <td> 
                                                                    <c:choose>
                                                                        <c:when test="${usu.getCusuarios_Estado()=='A'}">
                                                                            <span class="badge bg-green">Activo</span>
                                                                        </c:when>
                                                                        <c:otherwise >
                                                                            <span class="badge bg-red">Inactivo</span>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </td>
                                                                <td>
                                                                    <button class="btn btn-primary btn-xs" onclick="fn_datosUpdateUsuario(true, '${usu.getCusuarios_Cod()}', '${usu.getVpersonal_ApellNom()}', '${usu.getCmilitares_Cip()}', '${usu.getVusuarios_Login()}', '${usu.getVusuairos_Email()}');">
                                                                        <i class="material-icons">mode_edit</i>
                                                                    </button>
                                                                    <button type="button" class="btn bg-pink btn-xs" onclick="javascript: fn_deleteUsuario(${usu.getCusuarios_Cod()});">
                                                                        <i class="material-icons">delete</i>
                                                                    </button>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- #END# Striped Rows -->
                            <!-- Horizontal Layout -->
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="formInsertUsuarios">
                                    <div class="card">
                                        <div class="header">
                                            <div class="col-md-10 col-sm-9 col-xs-8">
                                                <h2>
                                                    <strong>Registrar Usuarios</strong>
                                                </h2>
                                            </div>
                                            <button type="button" class="btn bg-cyan btn-sm col-md-2 col-sm-3 col-xs-4" data-toggle="modal" data-target="#buscarPersona">
                                                <i class="material-icons">search</i>
                                                <span>Buscar Persona</span>
                                            </button>
                                        </div>
                                        <div class="body">
                                            <form class="form-horizontal" id="formInsertUser">
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="nomApell">Nombre y Apellidos</label>
                                                    </div>
                                                    <div class="col-lg-5 col-md-5 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="nombre" class="form-control" name="nombre" placeholder="Número Administrativo">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="nroCip">Nro de CIP</label>
                                                    </div>
                                                    <div class="col-lg-3 col-md-3 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="nroCipInsert" class="form-control" placeholder="Nombre del Usuario">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="nombUsuario">Usuario</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="nombUsuarioInsert" class="form-control" name="loginU" placeholder="Nombre de Usuario" required>
                                                            </div>
                                                            <div class="help-info">Ejemplo: SYMAP+DOC</div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="contraseña">Contraseña</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="password" id="passwordInsert" class="form-control" name="passworUsu" minlength="8" placeholder="Contraseña" required>
                                                            </div>
                                                            <div class="help-info">Min. 8 caracteres [ABC/abc/0-9]</div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="correoinst">Correo Institucional</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group form-float">
                                                            <div class="form-line">
                                                                <input type="email" class="form-control" name="correoU" placeholder="Correo Institucional" required id="emailInsert">
                                                            </div>
                                                            <div class="help-info">Ejemplo: demo@ep.indeci.pe</div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="correoinst">Foto de Perfil</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group form-float">
                                                            <div class="form-line">
                                                                <input type="file" class="form-control" name="correoU" placeholder="Correo Institucional" required id="fotoInsert">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                                                        <button type="button" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:fn_registrarUsuario();">
                                                            <i class="material-icons">save </i>
                                                            <span>Registrar</span>
                                                        </button>
                                                        <button type="button" class="btn bg-pink waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:cancelarform(true);">
                                                            <i class="material-icons">cancel</i>
                                                            <span>Cancelar</span>
                                                        </button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>

                                        <!-- Modal Buscar Persona -->
                                        <div class="modal fade" id="buscarPersona" tabindex="-1" role="dialog">
                                            <div class="modal-dialog modal-lg" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h4 class="modal-title" id="largeModalLabel">Buscar Persona</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="form-group form-float form-group-lg">
                                                            <div class="col-md-9 col-sm-9 col-xs-9">
                                                                <div class="form-line ">
                                                                    <input type="text" class="form-control"  id="buscarPersonal" name="buscarPersonal" placeholder="DNI / Apellidos y Nombres"/>
                                                                    <!--<label class="form-label">DNI / Apellidos y Nombres</label>-->
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3 col-sm-3 col-xs-3">
                                                                <button type="button" class="btn btn-info waves-effect col-md-12 col-sm-12 col-xs-12" onclick="javascript:buscarpersonal();">
                                                                    <i class="material-icons">search</i>
                                                                    <span>Buscar</span>
                                                                </button>
                                                            </div>
                                                        </div>                                                           
                                                        <div class="row clearfix">
                                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                                <div class="body">
                                                                    <div class="table-responsive" id="resultBuscarPersona">
                                                                        <table class="table table-bordered table-striped table-hover js-basic-example dataTablet">
                                                                            <thead>
                                                                                <tr>
                                                                                    <th>Nro</th>
                                                                                    <th>CIP</th>
                                                                                    <th>DNI</th>
                                                                                    <th>Grado</th>
                                                                                    <th>Apellidos y Nombres</th>
                                                                                </tr>
                                                                            </thead>
                                                                        </table>
                                                                    </div>
                                                                </div>                                                                    
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-success" data-dismiss="modal" onclick="javascript:mostrarbusquedaPersonal();" >Aceptar</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- #END# Horizontal Layout -->
                            </div>
                            <!-- START ACTUALIZAR USUARIO -->
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="formUpdateUsuarios">
                                    <div class="card">
                                        <div class="header">
                                            <div class="col-md-10 col-sm-9 col-xs-8">
                                                <h2>
                                                    <strong>Actualizar Usuarios</strong>
                                                </h2>
                                            </div>
                                        </div>
                                        <div class="body">
                                            <form class="form-horizontal" id="formUpdateUser">
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="nomApell">NOMBRES</label>
                                                    </div>
                                                    <div class="col-lg-5 col-md-5 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="ApellNomUpdate" class="form-control" name="codigoUact" disabled="">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="nroCip">Nro de CIP</label>
                                                    </div>
                                                    <div class="col-lg-3 col-md-3 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="CipUpdate" class="form-control" name="cipUact" readonly="">
                                                                <input type="hidden" id="codUsuariosUpdate">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="nombUsuario">Usuario</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="usuarioUpdate" class="form-control" name="loginUact" placeholder="Nombre de Usuario" required>
                                                            </div>
                                                            <div class="help-info">Ejemplo: F+BOLOGNESI+C</div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="correoinst">Correo Institucional</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group form-float">
                                                            <div class="form-line">
                                                                <input type="email" class="form-control" id="emailUpdate" name="correoUact" placeholder="Correo CHASQUI" required>
                                                            </div>
                                                            <div class="help-info">Ejemplo: fbolognesic@ep.mil.pe</div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="correoinst">Foto de perfil</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group form-float">
                                                            <div class="form-line">
                                                                <input type="file" class="form-control" id="fotoUpdate" name="correoUact" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="estadoUact">Estado</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <select class="form-control show-tick" id="estadoUpdate" name="estadoUact">
                                                            <option value="A">Activo</option>
                                                            <option value="I">Inactivo</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                                                        <button type="button" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:fn_updateUsuario();">
                                                            <i class="material-icons">save </i>
                                                            <span>Registrar</span>
                                                        </button>
                                                        <button type="button" class="btn bg-pink waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:cancelarform(true);">
                                                            <i class="material-icons">cancel</i>
                                                            <span>Cancelar</span>
                                                        </button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <!-- END ACTUALIZAR USUARIO -->
                            </div>
                        </div>

                        <!-- ASIGNAR PERFILES A USUARIO-->
                        <div role="tabpanel" class="tab-pane fade" id="perfilusuario_nav">                                        
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="fomrAsigUsuariosPerfil">
                                    <div class="card">
                                        <div class="header">
                                            <div class="col-md-10 col-sm-9 col-xs-8">
                                                <h2>
                                                    <strong>Asignar Perfiles</strong>
                                                </h2>
                                            </div>
                                            <button type="button" class="btn bg-cyan waves-effect btn-sm col-md-2 col-sm-3 col-xs-4" data-toggle="modal" data-target="#buscarUsuario">
                                                <i class="material-icons">search</i>
                                                <span>Buscar Usuario</span>
                                            </button>
                                        </div>
                                        <div class="body">
                                            <form class="form-horizontal" id="formInsertAsignacion">
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="nroCip">Nro de CIP</label>
                                                    </div>
                                                    <div class="col-lg-4 col-md-4 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="nroCip" class="form-control" placeholder="Numero de CIP" readonly="">
                                                                <input type="hidden" id="codigoU" class="form-control" placeholder="CodigoUsuario" readonly="">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="nroDNI">Login</label>
                                                    </div>
                                                    <div class="col-lg-4 col-md-4 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="login" class="form-control" placeholder="Número de DNI" readonly="">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="nomApell">Nombre y Apellidos</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="nomApell" class="form-control" placeholder="Nombre y Apellidos del usuario" readonly="">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <hr>
                                                <h6 class="text-muted text-center">DATOS DE PERFIL</h6>
                                                <hr>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                                        <label>Tipo de Perfil</label>
                                                    </div>
                                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-5">
                                                        <div class="form-group" >
                                                            <div class="form-line" id="comboPerfilesAsig">
                                                                <!-- Combo de Seleccion de perfiles-->
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-4 col-md-4 col-sm-5 col-xs-4">
                                                        <button type="button" class="btn btn-success waves-effect btn-sm col-md-6 col-sm-8 col-xs-12" onclick="javascript:insertUP();">
                                                            <i class="material-icons">save </i>
                                                            <span>Agregar Perfil</span>
                                                        </button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>

                                        <!-- Modal Buscar Usuario -->
                                        <div class="modal fade" id="buscarUsuario" tabindex="-1" role="dialog">
                                            <div class="modal-dialog modal-lg" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h4 class="modal-title" id="largeModalLabel">Buscar Usuario</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="form-group form-float form-group-lg">
                                                            <div class="col-md-9 col-sm-9 col-xs-9">
                                                                <div class="form-line ">
                                                                    <input type="text" class="form-control" id="busquedaUser" name="busquedaCip" placeholder="DNI / Apellidos y Nombres"/>
                                                                    <!--<label class="form-label">DNI / Apellidos y Nombres</label>-->
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3 col-sm-3 col-xs-3">
                                                                <button type="button" class="btn btn-info waves-effect col-md-12 col-sm-12 col-xs-12" onclick="javascript:BuscarUsuario();">
                                                                    <i class="material-icons">search</i>
                                                                    <span>Buscar</span>
                                                                </button>
                                                            </div>
                                                        </div>                                                           
                                                        <div class="row clearfix">
                                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                                <div class="body">
                                                                    <div class="table-responsive" id="resultBuscarUsuario">
                                                                        <table class="table table-bordered table-striped table-hover js-basic-example dataTable">
                                                                            <thead>
                                                                                <tr>
                                                                                    <th>Nro</th>
                                                                                    <th>CIP</th>
                                                                                    <th>DNI</th>
                                                                                    <th>Apellidos y Nombres</th>
                                                                                    <th>Login</th>
                                                                                </tr>
                                                                            </thead>
                                                                        </table>
                                                                    </div>
                                                                </div>                                                                    
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-success" data-dismiss="modal"  onclick="javascript:mostrarBusquedaUsuario();">Aceptar</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                            </div>
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div class="card">
                                        <div class="header bg-blue-grey">
                                            <h2>
                                                <strong>Lista de Usuarios - Perfiles</strong>
                                            </h2>
                                        </div>
                                        <div class="body table-responsive js-sweetalert">
                                            <div id="PerfUsuario" name="PerfUsuario">
                                                <table class="table table-bordered table-striped table-hover js-basic-example dataTable">
                                                    <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>Usuario</th>
                                                            <th>Perfil</th>
                                                            <th>Nro CIP</th>
                                                            <th>Acción</th>
                                                        </tr>
                                                    </thead>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <!-- #END# Tabs With Icon Title -->


        </div>
    </div>
</div>
<script src="js/usuario.js" type="text/javascript"></script>
<!-- Sweet Alert Plugin Js -->
<script src="plugins/sweetalert/sweetalert.min.js" type="text/javascript"></script>
<link href="plugins/sweetalert/sweetalert.css" rel="stylesheet" type="text/css"/>

