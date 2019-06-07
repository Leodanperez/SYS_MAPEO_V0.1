<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Muestra el contenido -->
<div class="container-fluid">
    <div class="block-header">
        <h3><strong>CALCULO DE MAQUINARIA Y COMBUSTIBLE PARA LA ATENCIÓN DE UNA EMERGENCIA</strong></h3>
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
                                <i class="material-icons">add</i> Cálculo Combustible
                            </a>
                        </li>
                    </ul>
                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane fade in active" id="regusuario_nav">
                            <!-- INSERTAR PERSONAL -->
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="formInsertUsuarios">
                                    <div class="body">
                                        <form class="form-horizontal" method="POST">
                                            <div class="row clearfix">
                                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                    <label for="tpP">Emergencia: </label>
                                                </div>
                                                <div class="col-lg-4 col-md-10 col-sm-8 col-xs-7">
                                                    <div class="form-group form-float">
                                                        <div class="form-line">
                                                            <select class="form-control" id="selectEmergencia" name="selectEmergencia">
                                                                <option value="0">Seleccione...</option>                                                            
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-lg-1 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                    <label for="uniP">Unidad:</label>
                                                </div>
                                                <div class="col-lg-3 col-md-10 col-sm-8 col-xs-7">
                                                    <div class="form-group form-float">
                                                        <div class="form-line">
                                                            <select class="form-control" id="selectUnidad" name="selectUnidad">
                                                                <option value="0">Seleccione...</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-lg-2 col-md-4 col-sm-4 col-xs-5">
                                                    <button type="button" onclick="javascript:fn_registrarProducto();" class="btn bg-blue waves-effect btn-sm">
                                                        <i class="material-icons">save </i>
                                                        <span>Iniciar Proceso</span>
                                                    </button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <!-- #END INSERTAR PERSONAL -->
                            <!-- Tabla  personal -->
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="listadoUsuarios" style="display:none">
                                    <div class="header bg-blue-grey">
                                        <h2 class="col-md-10 col-sm-9 col-xs-8">
                                            <strong>CALCULO COMBUSTIBLE PARA MAQUINARIA - DETALLE</strong>
                                        </h2>
                                        <br>
                                    </div>
                                    <div class="body">
                                        <div class="table-responsive">
                                            <table class="table table-bordered table-striped table-hover js-basic-example dataTable">
                                                <thead>
                                                    <tr>
                                                        <th>Item</th>
                                                        <th>Emergencia</th>
                                                        <th>Unidad</th>
                                                        <th>Vehiculo</th>
                                                        <th>Galones / Combustible</th>
                                                    </tr>
                                                </thead>
                                                <tbody>

                                                    <tr>
                                                        <td>01</td>
                                                        <td>incendio</td>
                                                        <td>18 und. brigada</td>
                                                        <td>Cargador Frontal</td>
                                                        <td class="text-center">20</td>
                                                    </tr>
                                                    <tr>
                                                        <td>01</td>
                                                        <td>incendio</td>
                                                        <td>18 und. brigada</td>
                                                        <td>Bolquete</td>
                                                        <td class="text-center">10</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div><br>
                                        <div class="row clearfix">
                                            <div class="col-lg-10 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                <label for="tpP">Total de combustible a emplear: </label>
                                            </div>
                                            <div class="col-lg-2 col-md-10 col-sm-8 col-xs-7">
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <input type="text" value="  30 galones" class="form-control"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- #END# Tabla personal -->

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>