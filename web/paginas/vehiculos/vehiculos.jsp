
<%@page import="Dao.Impl.VehiculosDao"%>
<%@page import="Models.TipoVehiculo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Muestra el contenido -->

    <div class="container-fluid">
        <div class="block-header">
            <h3><strong>Administración de Donaciones</strong></h3>
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
                                    <i class="material-icons">plus_one </i> Registrar Vehiculos
                                </a>
                            </li>
                            <li role="presentation">
                                <a href="#regSubModulo_nav" data-toggle="tab">
                                    <i class="material-icons">plus_one </i> Registrar T. Vehiculo
                                </a>
                            </li>
                            <li role="presentation">
                                <a href="#rolModulo_nav" data-toggle="tab">
                                    <i class="material-icons">swap_horiz </i> Detalle Donacion
                                </a>
                            </li>
                        </ul>

                        <!-- MODULOS -->
                        <!-- Tab panes -->
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane fade in active" id="regModulo_nav">
                                <!-- Striped Rows -->
                                <div class="row clearfix">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="listadoVehiculos">
                                        <div class="card">
                                            <div class="header bg-indigo">
                                                <h2 class="col-md-10 col-sm-9 col-xs-8">
                                                    <strong>Lista de Vehiculos</strong>
                                                </h2>

                                                <button type="button" class="btn btn-success waves-effect btn-sm col-md-2 col-sm-3 col-xs-4" onclick="javascript:mostrarformSuper(true, 'i')">
                                                    <i class="material-icons">add </i>
                                                    <span>Nuevo Vehiculos</span>
                                                </button>
                                                <br>
                                            </div>
                                            <div class="body table-responsive js-sweetalert">
                                                <table class="table table-striped">
                                                    <thead>
                                                        <tr>
                                                            <th>Codigo</th>
                                                            <th>Peso Neto</th>
                                                            <th>Volumen</th>
                                                            <th>Tipo V.</th>
                                                            <th>Placa</th>
                                                            <th>Peso Bruto</th>
                                                            <th>Cp. Carga</th>
                                                            <th>Estado</th>
                                                            <th>Acción</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${vehiculos}" var="vehiculo" varStatus="ok">
                                                            <tr>
                                                                <td>${vehiculo.CVEHICULO_COD}</td>
                                                                <td>${vehiculo.DPESO_NETO}</td>
                                                                <td>${vehiculo.DVOLUMEN}</td>
                                                                <td>${vehiculo.CTVEHICULO_COD}</td>
                                                                <td>${vehiculo.VPLACA}</td>
                                                                <td>${vehiculo.DPESO_BRUTO}</td>
                                                                <td>${vehiculo.DCPCIDAD_CARGA}</td>
                                                                <td>
                                                                    <c:choose>
                                                                        <c:when test="${vehiculo.CESTADO=='A'}">
                                                                            <span class="badge bg-green">Activo</span>
                                                                        </c:when>
                                                                        <c:otherwise >
                                                                            <span class="badge bg-red">Inactivo</span>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </td>
                                                                <td>
                                                                    <button type="button" class="btn btn-primary btn-xs waves-effect" onclick="fn_datosUpdateVehiculos(true, '${vehiculo.getCVEHICULO_COD()}', '${vehiculo.getDPESO_NETO()}', '${vehiculo.getDVOLUMEN()}', '${vehiculo.getCTVEHICULO_COD()}', '${vehiculo.getVPLACA()}', '${vehiculo.getDPESO_BRUTO()}', '${vehiculo.getDCPCIDAD_CARGA()}');">
                                                                        <i class="material-icons">mode_edit</i>
                                                                    </button>
                                                                    <button type="button" class="btn bg-pink btn-xs waves-effect" onclick="javascript: fn_deleteVehiculo(${vehiculo.getCVEHICULO_COD()});">
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
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="formInsertVehiculos">
                                        <div class="card">
                                            <div class="header">
                                                <div class="col-md-10 col-sm-9 col-xs-8">
                                                    <h2>
                                                        <strong>Registrar Vehiculos</strong>
                                                    </h2>
                                                </div>
                                            </div>
                                            <div class="body">
                                                <form class="form-horizontal" id="form_validation" method="POST">
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="codModulo">Codigo</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="codModulo" class="form-control" placeholder="Codigo de Vehiculo" disabled="">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descCorta">Peso Neto</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="InpesoNeto" class="form-control" placeholder="Peso Neto" required name="donate">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descripcionCorta">Volumen</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="Involumen" class="form-control" placeholder="Volumen" required name="militar">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="icono">Codigo</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <select class="form-control show-tick" id="Intvehiculo" name="moduloSuper">
                                                                        <option>- Seleccionar -</option>
                                                                        <% for (TipoVehiculo t : VehiculosDao.listar()) {%>
                                                                        <option value="<%=t.getCTVEHICULO_COD()%>"><%=t.getVDESCRIPCION()%></option>
                                                                        <%}%>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="icono">Placa</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="Inplaca" class="form-control" placeholder="Placa" required name="fecha">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="icono">Peso Bruto</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="InpesBruto" class="form-control" placeholder="Peso Bruto" required name="unidad">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="icono">Cap. Carga</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="InCarga" class="form-control" placeholder="Capacidad de Carga" required name="ptotal">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                                                            <button type="button" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:fn_insertVehiculos();">
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

                                <!-- FORM ACTUALIZAR VEHICULOS -->
                                <div class="row clearfix">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="formUpdateVehiculos">
                                        <div class="card" >
                                            <div class="header">
                                                <div class="col-md-10 col-sm-9 col-xs-8">
                                                    <h2>
                                                        <strong>Actualizar Vehiculos</strong>
                                                    </h2>
                                                </div>
                                            </div>
                                            <div class="body">
                                                <form class="form-horizontal" id="form_validation" method="POST">
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="uCodvehiculo">Codigo Vehiculo</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="uCodvehiculo" class="form-control" disabled="" placeholder="Codigo de Vehiculo">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descCorta">Peso Neto</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="uPesoneto" class="form-control" placeholder="Peso Neto" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descripcionCorta">Volumen</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="uVolumen" class="form-control" placeholder="Volumen" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="icono">Tipo V.</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <select class="form-control show-tick" id="uTipvehiculo" name="moduloSuper">
                                                                        <option>- Seleccionar -</option>
                                                                        <% for (TipoVehiculo t : VehiculosDao.listar()) {%>
                                                                        <option value="<%=t.getCTVEHICULO_COD()%>"><%=t.getVDESCRIPCION()%></option>
                                                                        <%}%>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descripcionCorta">Placa</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="uPlaca" class="form-control" placeholder="Placa" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="upEstado">Estado</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <select class="form-control show-tick" id="upEstado">
                                                                         <option value="A">Activo</option>
                                                                         <option value="I">Inactivo</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descripcionCorta">Peso Bruto</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="uPesobruto" class="form-control" placeholder="Peso Bruto" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descripcionCorta">Cap. Carga</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="uCapcarga" class="form-control" placeholder="Capacidad de Carga" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                                                            <button type="button" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:fn_updateVehiculos();">
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
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"  id="listarTipoVehiculo">
                                        <div class="card">
                                            <div class="header bg-indigo">
                                                <h2 class="col-md-10 col-sm-9 col-xs-8">
                                                    <strong>Lista de Tipo Vehiculos</strong>
                                                </h2>

                                                <button type="button" class="btn btn-success waves-effect btn-sm col-md-2 col-sm-3 col-xs-4" onclick="javascript:mostrarformSub(true, 'i');">
                                                    <i class="material-icons">add </i>
                                                    <span>Agregar</span>
                                                </button>
                                                <br>
                                            </div>
                                            <div class="body table-responsive js-sweetalert" id="listTipoVehiculo">
                                                
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
                                                        <strong>Registrar Tipo Vehiculos</strong>
                                                    </h2>
                                                </div>
                                            </div>
                                            <div class="body">
                                                <form class="form-horizontal" id="form_validation" method="POST">
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="codSubModulo">Codigo</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="codSubModulo" name="codSubModulo" class="form-control" disabled="" placeholder="Codigo de Donante">
                                                                    <input type="hidden" id="modo" name="modo">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descCorta">Descripcion</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="idescripcion" name="descripcion" class="form-control" placeholder="Descripcion" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descLarga">Cantidad</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="icantidad" name="cantidad" class="form-control" placeholder="Cantidad" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                                                            <button type="button" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:fn_registrartVehiculos();">
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
                                                        <strong>Actualizar Tipo Vehiculo</strong>
                                                    </h2>
                                                </div>
                                            </div>
                                            <div class="body">
                                                <form class="form-horizontal" id="form_validation">
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="codSubModuloAct">Codigo</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="codtVehiculoUp" class="form-control" disabled="" placeholder="Codigo de Tipo Vehiculo">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descCortaAct">Descripción</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="descripcionUp" class="form-control" placeholder="Descripción" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descLargaAct">Cantidad</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="cantidadUp" class="form-control" placeholder="Cantidad" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                                            <label>Estado</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <select class="form-control show-tick" id="estadoUp">
                                                                         <option value="A">Activo</option>
                                                                         <option value="I">Inactivo</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                                                            <button type="button" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:fn_updatetVehiculo();">
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
                                            <div class="header bg-deep-orange">
                                                <h2>
                                                    <strong>Lista de Detalle Donacion</strong>
                                                </h2>
                                            </div>
                                            <div class="body table-responsive js-sweetalert" id="listamodrol">
                                                <table class="table table-striped">
                                                    <thead>
                                                        <tr>
                                                            <th>Codigo</th>
                                                            <th>Codigo</th>
                                                            <th>Producto</th>
                                                            <th>Peso</th>
                                                            <th>Volumen</th>
                                                            <th>Fech. Vencimiento</th>
                                                            <th>Acciones</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${verdonadetalle}" var="detalles" varStatus="ok">
                                                            <tr>
                                                                <td>${detalles.CDONA_COD}</td>
                                                                <td>${detalles.CDETADONA_COD}</td>
                                                                <td>${detalles.CPRODUCTO_COD}</td>
                                                                <td>${detalles.DPESO}</td>
                                                                <td>${detalles.DVOLUMEN}</td>
                                                                <td>${detalles.DFECHA_VENCIMIENTO}</td>
                                                                <td>
                                                                    <button type="button" class="btn btn-primary btn-xs waves-effect">
                                                                        <i class="material-icons">mode_edit</i>
                                                                    </button>
                                                                    <a type="button" class="btn bg-pink btn-xs waves-effect" href="subModulo?action=eliminar&codigo=${submodulo.modulos_codmodulo}" >
                                                                        <i class="material-icons">delete</i>
                                                                    </a>
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
                        </div>

                    </div>
                </div>
                <!-- #END# Tabs With Icon Title -->

            </div>
        </div>
    </div>

<!-- Modulo Js -->
<script src="js/tpvehiculos.js" type="text/javascript"></script>
<script src="plugins/sweetalert/sweetalert.min.js"></script>
<link href="plugins/sweetalert/sweetalert.css" rel="stylesheet" type="text/css"/>
