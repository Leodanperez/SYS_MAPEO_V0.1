<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Muestra el contenido -->

<div class="container-fluid">
    <div class="block-header">
        <h3><strong>ADMINISTRACIÓN DE MÓDULOS</strong></h3>
    </div>
    <!-- Tabs With Icon Title -->
    <div class="row clearfix">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div class="card">
                <div class="body">
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active">
                            <a href="#regModulo_nav" data-toggle="tab">
                                <i class="material-icons">plus_one </i> Registrar Modulos
                            </a>
                        </li>
                        <li role="presentation">
                            <a href="#regSubModulo_nav" data-toggle="tab">
                                <i class="material-icons">plus_one </i> Registrar Sub-Modulos
                            </a>
                        </li>
                        <li role="presentation">
                            <a href="#rolModulo_nav" data-toggle="tab">
                                <i class="material-icons">swap_horiz </i> Asignar Rol a Modulo
                            </a>
                        </li>
                    </ul>

                    <!-- MODULOS -->
                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane fade in active" id="regModulo_nav">
                            <!-- Striped Rows -->
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="listadoModulosSuper">
                                    <div class="card">
                                        <div class="header bg-indigo">
                                            <h2 class="col-md-10 col-sm-9 col-xs-8">
                                                <strong>Lista de Modulos</strong>
                                            </h2>

                                            <button type="button" class="btn btn-success waves-effect btn-sm col-md-2 col-sm-3 col-xs-4" onclick="javascript:mostrarformSuper(true, 'i')">
                                                <i class="material-icons">add </i>
                                                <span>Nuevo Modulo</span>
                                            </button>
                                            <br>
                                        </div>
                                        <div class="body table-responsive js-sweetalert">
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>
                                                        <th>Codigo</th>
                                                        <th>Descripcion</th>
                                                        <th>Icono</th>
                                                        <th>N°Orden</th>
                                                        <th>Estado</th>
                                                        <th>Acción</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${moduloSuper}" var="moduloSuper" varStatus="ok">
                                                        <tr>
                                                            <td>${moduloSuper.getCmodulos_Cod()}</td>
                                                            <td>${moduloSuper.getVmodulos_Desc()}</td>
                                                            <td><i class="material-icons">${moduloSuper.getVmodulos_icon()}</i></td>
                                                            <td>${moduloSuper.getCmodulos_Orden()}</td>
                                                            <td>
                                                                <c:choose>
                                                                    <c:when test="${moduloSuper.getCmodulos_Estado()=='A'}">
                                                                        <span class="badge bg-green">Activo</span>
                                                                    </c:when>
                                                                    <c:otherwise >
                                                                        <span class="badge bg-red">Inactivo</span>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </td>
                                                            <td>
                                                                <button type="button" class="btn btn-primary btn-xs waves-effect"onclick="fn_dataEditarModuloSuper(true, '${moduloSuper.getCmodulos_Cod()}', '${moduloSuper.getVmodulos_Desc()}', '${moduloSuper.getVmodulos_icon()}', '${moduloSuper.getCmodulos_Orden()}');">
                                                                    <i class="material-icons">mode_edit</i>
                                                                </button>
                                                                    <button class="btn bg-pink btn-xs waves-effect" onclick="javascript:fn_deleteModulos('${moduloSuper.getCmodulos_Cod()}','mS')">
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
                            <!-- #END# Striped Rows -->
                            <!-- Horizontal Layout -->
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="formInsertModulosSuper">
                                    <div class="card">
                                        <div class="header">
                                            <div class="col-md-10 col-sm-9 col-xs-8">
                                                <h2>
                                                    <strong>Registrar Modulos</strong>
                                                </h2>
                                            </div>
                                        </div>
                                        <div class="body">
                                            <form class="form-horizontal" id="form_validation">
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="codModulo">Codigo Modulo</label>s
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="codModulo" class="form-control" disabled="" placeholder="Codigo de Modulo">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="descCorta">Descripción</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="descripcionInsert" class="form-control" placeholder="Descripción" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="icono">Icono</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="iconoInsert" class="form-control" placeholder="Icono" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                 <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="descripcionCorta">N°Orden</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="ordenInsert" class="form-control" placeholder="numero de Orden" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                                                        <button type="button" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:fn_registrarModulosSuper();">
                                                            <i class="material-icons">save </i>
                                                            <span>Registrar</span>
                                                        </button>
                                                        <button type="button" class="btn bg-pink waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:cancelarformSuper(true);">
                                                            <i class="material-icons">cancel</i>
                                                            <span>Cancelar</span>
                                                        </button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <!-- #END# Horizontal Layout -->

                            <!-- FORM ACTUALIZAR MODULOS-SUPER -->
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="formUpdateModulosSuper">
                                    <div class="card" >
                                        <div class="header">
                                            <div class="col-md-10 col-sm-9 col-xs-8">
                                                <h2>
                                                    <strong>Actualizar Modulo</strong>
                                                </h2>
                                            </div>
                                        </div>
                                        <div class="body">
                                            <form class="form-horizontal" id="form_validation">
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="codigoUpdate">Codigo Modulo</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="codigoUpdate" class="form-control" disabled="" placeholder="Codigo de Modulo">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="descripcionUpdate">Descripción</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="descripcionUpdate" class="form-control" placeholder="Descripción Corta" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="iconoUpdate">Icono</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="iconoUpdate" class="form-control" placeholder="Descripción Larga" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="ordenUpdate">Orden</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="ordenUpdate" class="form-control" placeholder="Icono" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                                                        <button type="button" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:fn_updateModulosSuper();">
                                                            <i class="material-icons">save </i>
                                                            <span>Registrar</span>
                                                        </button>
                                                        <button type="button" class="btn bg-pink waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:cancelarformSuper(true);">
                                                            <i class="material-icons">cancel</i>
                                                            <span>Cancelar</span>
                                                        </button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- #END# FORM ACTUALIZAR MODULOS-SUPER -->

                        </div>
                        <!-- END MODULOS-SUPER -->

                        <!-- START SUB-MODULOS -->
                        <div role="tabpanel" class="tab-pane fade" id="regSubModulo_nav">
                            <!-- Striped Rows -->
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"  id="listarSubModulos">
                                    <div class="card">
                                        <div class="header bg-indigo">
                                            <h2 class="col-md-10 col-sm-9 col-xs-8">
                                                <strong>Lista de Sub-Modulos</strong>
                                            </h2>

                                            <button type="button" class="btn btn-success waves-effect btn-sm col-md-2 col-sm-3 col-xs-4" onclick="javascript:mostrarformSub(true, 'i');">
                                                <i class="material-icons">add </i>
                                                <span>Agregar</span>
                                            </button>
                                            <br>
                                        </div>
                                        <div class="body table-responsive js-sweetalert" id="tablegetListSubModulos">
                                            <!-- data de SUb Modulos-->
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- #END# Striped Rows -->
                            <!-- Horizontal Layout -->
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"  id="formInsertSubModulos">
                                    <div class="card">
                                        <div class="header">
                                            <div class="col-md-10 col-sm-9 col-xs-8">
                                                <h2>
                                                    <strong>Registrar Sub-Modulo</strong>
                                                </h2>
                                            </div>
                                        </div>
                                        <div class="body">
                                            <form class="form-horizontal" id="form_validation">
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="codigoSubInsert">Codigo Sub-Modulo</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="codigoSubInsert" name="codigoSubInsert" class="form-control" disabled="" placeholder="Codigo de Sub-Modulo">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="descripcionSubInsert">Descripción</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="descripcionSubInsert" name="descripcionSubInsert" class="form-control" placeholder="Descripción" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                                        <label>Modulo Superior</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line" id="comboModulosSuper">
                                                                <!--Combo modulos super-->
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="servletSubInsert">Servlet</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="servletSubInsert" name="servletSubInsert" class="form-control" placeholder="Servlet" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="linkSubInsert">Link</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="linkSubInsert" name="linkSubInsert" class="form-control" placeholder="Link" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="iconoSubInsert">Icono</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="iconoSubInsert" name="iconoSubInsert" class="form-control" placeholder="Icono" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="nOrdenSubInsert">N°de Orden</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="nOrdenSubInsert" name="nOrdenSubInsert" class="form-control" placeholder="Número de Orden" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                                                        <button type="button" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:fn_insertSubModulos();">
                                                            <i class="material-icons">save </i>
                                                            <span>Registrar</span>
                                                        </button>
                                                        <button type="button" class="btn bg-pink waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="cancelarformSub();">
                                                            <i class="material-icons">cancel</i>
                                                            <span>Cancelar</span>
                                                        </button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <!-- #END# Horizontal Layout -->
                            </div>
                            <!-- Horizontal Layout -->
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"  id="formUpdateSubModulos">
                                    <div class="card">
                                        <div class="header">
                                            <div class="col-md-10 col-sm-9 col-xs-8">
                                                <h2>
                                                    <strong>Actualizar Sub-Modulo</strong>
                                                </h2>
                                            </div>
                                        </div>
                                        <div class="body">
                                            <form class="form-horizontal" id="form_validation">
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="codigoSubUpdate">Codigo Sub-Modulo</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="codigoSubUpdate" class="form-control" disabled="" placeholder="Codigo de Sub-Modulo">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="descSubUpdate">Descripción</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="descSubUpdate" class="form-control" placeholder="Descripción" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="servletSubUpdate">Servlet</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="servletSubUpdate" class="form-control" placeholder="Descripción Larga" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="linkSubUpdate">Link</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="linkSubUpdate" class="form-control" placeholder="Link" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                  <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="iconoSubUpdate">Icono</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="iconoSubUpdate" class="form-control" placeholder="Icono" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="nOrdenSubUpdate">N°de Orden</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="nOrdenSubUpdate" class="form-control" placeholder="Número de Orden" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                                        <label>Modulo Superior</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line" id="moduloSuperUpdate">
                                                                       <!-- Combo de seleccion de modulos-->
                                                            </div>
                                                                <input type="hidden" id="codModuloSuperUpdate">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                                                        <button type="button" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:fn_actualizarSubModulo();">
                                                            <i class="material-icons">save </i>
                                                            <span>Registrar</span>
                                                        </button>
                                                        <button type="button" class="btn bg-pink waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="cancelarformSub(true);">
                                                            <i class="material-icons">cancel</i>
                                                            <span>Cancelar</span>
                                                        </button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <!-- #END# Horizontal Layout -->
                            </div>
                        </div>
                        <!-- END SUB-MODULOS -->

                        <!-- START ASIGNACION ROLE-MODULO -->
                        <div role="tabpanel" class="tab-pane fade" id="rolModulo_nav">                                        
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div class="card">
                                        <div class="header">
                                            <div class="col-md-10 col-sm-9 col-xs-8">
                                                <h2>
                                                    <strong>Asignar Rol</strong>
                                                </h2>
                                            </div>
                                            <button type="button" class="btn bg-cyan waves-effect btn-sm col-md-2 col-sm-3 col-xs-4" data-toggle="modal" data-target="#buscarPerfil">
                                                <i class="material-icons">search</i>
                                                <span>Buscar Modulo</span>
                                            </button>
                                        </div>
                                        <div class="body">
                                            <form class="form-horizontal" id="form_validation" method="POST">                                                            
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="codModuloA">Codigo</label>
                                                    </div>
                                                    <div class="col-lg-4 col-md-4 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="codModuloAsig" class="form-control" disabled="" placeholder="Codigo de modulo">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="descLarga">Modulo</label>
                                                    </div>
                                                    <div class="col-lg-4 col-md-4 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="descripLargaAsig" class="form-control" disabled="" placeholder="Descripción Larga">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>                                                            
                                                <hr>
                                                <h6 class="text-muted text-center">DATOS DEL ROL</h6>
                                                <hr>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                                        <label>Tipo de Rol</label>
                                                    </div>
                                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-5">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <select name="tipoRol" id="tipoRol" class="form-control">
                                                                    <option value="0">- Seleccione -</option>

                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-4 col-md-4 col-sm-5 col-xs-4">
                                                        <button type="button" class="btn btn-success waves-effect btn-sm col-md-6 col-sm-8 col-xs-12" onclick="javascript:Insertar();">
                                                            <i class="material-icons">save </i>
                                                            <span>Agregar Rol</span>
                                                        </button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>

                                        <!-- Modal Buscar Perfil -->
                                        <div class="modal fade" id="buscarPerfil" tabindex="-1" role="dialog">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h4 class="modal-title" id="largeModalLabel">Buscar Modulos</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="form-group form-float form-group-lg">
                                                            <div class="col-md-9 col-sm-9 col-xs-9">
                                                                <div class="form-line ">
                                                                    <input type="text" class="form-control" id="busqueda" name="busqueda"/>
                                                                    <label class="form-label">Nombre de Modulo</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3 col-sm-3 col-xs-3">
                                                                <button type="button" class="btn btn-info waves-effect col-md-12 col-sm-12 col-xs-12" onclick="javascript:buscarmodulo();">
                                                                    <i class="material-icons">search</i>
                                                                    <span>Buscar</span>
                                                                </button>
                                                            </div>
                                                        </div>                                                           
                                                        <div class="row clearfix">
                                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                                <div class="body">
                                                                    <div class="table-responsive" id="resulbuscar">
                                                                        <table class="table table-hover">
                                                                            <thead>
                                                                                <tr>
                                                                                    <th>#</th>
                                                                                    <th>Codigo</th>
                                                                                    <th>Desc. Corta</th>
                                                                                    <th>Desc. Larga</th>
                                                                                </tr>
                                                                            </thead>
                                                                        </table>
                                                                    </div>
                                                                </div>                                                                    
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-success" data-dismiss="modal" onclick="javasript:mostrarbusqueda();" >Aceptar</button>
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
                                        <div class="header bg-deep-orange">
                                            <h2>
                                                <strong>Lista de Modulos - Roles</strong>
                                            </h2>
                                        </div>
                                        <div class="body table-responsive js-sweetalert" id="listamodrol">
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>
                                                        <th>#</th>
                                                        <th>Modulo</th>
                                                        <th>Rol</th>
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
            <!-- #END# Tabs With Icon Title -->

        </div>
    </div>
</div>

<!-- Modulo Js -->
<script src="js/modulo.js" type="text/javascript"></script>
<!-- Sweet Alert Plugin Js -->
<script src="plugins/sweetalert/sweetalert.min.js" type="text/javascript"></script>
<link href="plugins/sweetalert/sweetalert.css" rel="stylesheet" type="text/css"/>


