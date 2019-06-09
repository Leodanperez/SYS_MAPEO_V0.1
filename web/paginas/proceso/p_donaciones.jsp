
<%@page import="Dao.Impl.DaoProcDonaciones"%>
<%@page import="Models.Emergencias"%>
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
                                <i class="material-icons">plus_one </i> Proc. Donaciones
                            </a>
                        </li>
                        <li role="presentation">
                            <a href="#regSubModulo_nav" data-toggle="tab">
                                <i class="material-icons">plus_one </i> Proc. Vehiculos
                            </a>
                        </li>
                    </ul>

                    <!-- MODULOS -->
                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane fade in active" id="regModulo_nav">
                            <!-- Striped Rows -->
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="listadoDonaciones">
                                    <div class="card">
                                        <div class="header bg-indigo">
                                            <h2 class="col-md-10 col-sm-9 col-xs-8">
                                                <strong>Procesos de Donaciones</strong>
                                            </h2><br>
                                        </div>
                                        <div class="row clearfix">
                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                <div class="card">
                                                    <div class="body">
                                                        <form class="form-horizontal" id="form_validation" method="POST">

                                                            <div class="row clearfix">
                                                                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-5 form-control-label">
                                                                    <label for="descripcionCorta">Seleccione Emergencia</label>
                                                                </div>
                                                                <div class="col-lg-6 col-md-6 col-sm-8 col-xs-7">
                                                                    <div class="form-group">
                                                                        <div class="form-line">
                                                                            <select class="form-control show-tick" id="CodigoEmergencia">
                                                                                <option>- Seleccionar -</option>
                                                                                <% for (Emergencias t : DaoProcDonaciones.getEmergencia()) {%>
                                                                                <option value="<%=t.getCEMERGENCIA_COD()%>"><%=t.getVDESCRIPCION()%></option>
                                                                                <%}%>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row clearfix">
                                                                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-5 form-control-label">
                                                                    <label for="icono">Numero Damnificados</label>
                                                                </div>
                                                                <div class="col-lg-6 col-md-6 col-sm-8 col-xs-7">
                                                                    <div class="form-group">
                                                                        <div class="form-line">
                                                                            <input type="text" id="IDamnificado" class="form-control" placeholder="500" readonly>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row clearfix">
                                                                <div class="col-lg-4 col-md-4 col-sm-8 col-xs-7">
                                                                    <button type="button" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:fn_procDonaciones();">
                                                                        <i class="material-icons">save </i>
                                                                        <span>CALCULAR</span>
                                                                    </button>
                                                                </div>
                                                                <div class="col-lg-4 col-md-4 col-sm-8 col-xs-7">
                                                                    <button type="button" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:fn_procDonaciones();">
                                                                        <i class="material-icons">save </i>
                                                                        <span>CALCULAR</span>
                                                                    </button>
                                                                </div>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                                <table class="table table-striped">
                                                    <thead>
                                                        <tr>
                                                            <th>Codigo</th>
                                                            <th>Producto</th>
                                                            <th>Cant. Producto</th>
                                                            <th>Donacion Bah</th>
                                                            <th>Edad Antropologica</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${listProceDonaciones}" var="listar" varStatus="ok">
                                                            <tr>
                                                                <td>${listar.CDETADONA_COD}</td>
                                                                <td>${listar.TIPOPRODUCTO}</td>
                                                                <td>${listar.ICANTIDAD_PROD}</td>
                                                                <td>${listar.CDONA_COD}</td>
                                                                <td>${listar.EDADANTROPOLOGICA}</td>
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

                        </div>
                        <!-- END MODULOS-SUPER -->

                        <!-- START SUB-MODULOS -->
                        <div role="tabpanel" class="tab-pane fade" id="regSubModulo_nav">
                            <!-- Striped Rows -->
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="listadoDonaciones">
                                    <div class="card">
                                        <div class="header bg-indigo">
                                            <h2 class="col-md-10 col-sm-9 col-xs-8">
                                                <strong>Procesos de Vehiculos</strong>
                                            </h2><br>
                                        </div>
                                        <div class="row clearfix">
                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                <div class="card">
                                                    <div class="body">
                                                        <form class="form-horizontal" id="form_validation" method="POST">
                                                            <div class="row clearfix">
                                                                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-5 form-control-label">
                                                                    <label for="descripcionCorta">Seleccione Vehiculo</label>
                                                                </div>
                                                                <div class="col-lg-6 col-md-6 col-sm-8 col-xs-7">
                                                                    <div class="form-group">
                                                                        <div class="form-line">
                                                                            <select class="form-control show-tick" id="Ivehiculo">
                                                                                <option>- Seleccionar -</option>
                                                                                <option value="1">CAMION</option>
                                                                                <option value="1">VOLQUETE</option>
                                                                                <option value="1">MOTO</option>
                                                                                <option value="1">AUTO</option>
                                                                                <option value="1">TRACTOR</option>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row clearfix">
                                                                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-5 form-control-label">
                                                                    <label for="descripcionCorta">Seleccione Emergencia</label>
                                                                </div>
                                                                <div class="col-lg-6 col-md-6 col-sm-8 col-xs-7">
                                                                    <div class="form-group">
                                                                        <div class="form-line">
                                                                            <select class="form-control show-tick" id="Iemergencia">
                                                                                <option>- Seleccionar -</option>
                                                                                <option value="1">Derrumbe</option>
                                                                                <option value="1">Huracan</option>
                                                                                <option value="1">Huaico</option>
                                                                                <option value="1">Volcan</option>
                                                                                <option value="1">Fin del Mundo</option>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row clearfix">
                                                                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-5 form-control-label">
                                                                    <label for="descripcionCorta">Seleccione Unidad</label>
                                                                </div>
                                                                <div class="col-lg-6 col-md-6 col-sm-8 col-xs-7">
                                                                    <div class="form-group">
                                                                        <div class="form-line">
                                                                            <select class="form-control show-tick" id="Iunidad">
                                                                                <option>- Seleccionar -</option>
                                                                                <option value="1">Pentagonito</option>
                                                                                <option value="1">Chorrillos</option>
                                                                                <option value="1">Rimac</option>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row clearfix">
                                                                <div class="col-lg-4 col-md-4 col-sm-8 col-xs-7">
                                                                    <button type="button" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:fn_registrarDonaciones(true);">
                                                                        <i class="material-icons">save </i>
                                                                        <span>CALCULAR</span>
                                                                    </button>
                                                                </div>
                                                            </div>
                                                        </form>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                        <table class="table table-striped">
                                            <thead>
                                                <tr>
                                                    <th>Item</th>
                                                    <th>Edad Antro</th>
                                                    <th>Producto</th>
                                                    <th>Cant. Producto</th>
                                                    <th>Acción</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Bebe</td>
                                                    <td>Pañales</td>
                                                    <td>20</td>
                                                    <td>
                                                        <button type="button" class="btn btn-primary btn-xs waves-effect">
                                                            <i class="material-icons">mode_edit</i>
                                                        </button>
                                                        <a class="btn bg-pink btn-xs waves-effect" href="modulos?action=eliminar&codigo=" >
                                                            <i class="material-icons">delete</i>
                                                        </a>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!-- #END# Striped Rows -->
                        </div>
                    </div>

                </div>
            </div>
            <!-- #END# Tabs With Icon Title -->

        </div>
    </div>
</div>

<!-- Modulo Js -->
<script src="js/procDonaciones.js" type="text/javascript"></script>
<script src="plugins/sweetalert/sweetalert.min.js"></script>
<link href="plugins/sweetalert/sweetalert.css" rel="stylesheet" type="text/css"/>

