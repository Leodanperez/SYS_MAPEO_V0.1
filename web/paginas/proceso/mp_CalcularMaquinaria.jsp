<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Muestra el contenido -->
<div class="container-fluid">
    <div class="block-header">
        <h3><strong>CALCULO DE MAQUINARIA PARA ATENDER EMERGENCIA</strong></h3>
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
                                <i class="material-icons">add</i> Cálculo Maquinaria
                            </a>
                        </li>
                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane fade in active" id="regusuario_nav">
                            <!-- INSERTAR PERSONAL -->
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="formInsertUsuarios">
                                    <div class="card">
                                        <div class="header">
                                            <div class="col-md-10 col-sm-9 col-xs-8">
                                                <h2>
                                                    <strong>PROCESO DE CÁLCULO</strong>
                                                </h2>
                                            </div>
                                            <!--<button type="button" class="btn bg-cyan btn-sm col-md-2 col-sm-3 col-xs-4" data-toggle="modal" data-target="#buscarPersona">
                                                <i class="material-icons">search</i>
                                                <span>Buscar Persona</span>
                                            </button>-->
                                        </div>
                                        <div class="body">
                                            <form class="form-horizontal" method="POST">
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="tpP">Selecccione Emergencia</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group form-float">
                                                            <div class="form-line">
                                                                <select class="form-control" id="tpP" name="tpP">
                                                                    <option value="0">Seleccione...</option>                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="uniP">Seleccione Unidad</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group form-float">
                                                            <div class="form-line">
                                                                <select class="form-control" id="uniP" name="uniP">
                                                                    <option value="0">Seleccione...</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--<div class="row clearfix">
                                                    <div class="col-lg-4 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="uniP">Seleccione Vehiculo</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group form-float">
                                                            <div class="form-line">
                                                                <select class="form-control" id="uniP" name="uniP">
                                                                    <option value="0">Seleccione...</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>-->

                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-5">
                                                        <button type="button" onclick="javascript:fn_registrarProducto();" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6">
                                                            <i class="material-icons">save </i>
                                                            <span>Iniciar calculo</span>
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
                            </div>
                            <!-- #END INSERTAR PERSONAL -->
                            <!-- Tabla  personal -->
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="listadoUsuarios">
                                    <div class="card">
                                        <div class="header bg-blue-grey">
                                            <h2 class="col-md-10 col-sm-9 col-xs-8">
                                                <strong>CALCULO MAQUINARIA PARA EMERGENCIA - DETALLE</strong>
                                            </h2>
                                            <br>
                                        </div>
                                        <div class="body">
                                            <div class="table-responsive">
                                                <table class="table table-bordered table-striped table-hover js-basic-example dataTable">
                                                    <thead>
                                                        <tr>
                                                            <th>Item</th>
                                                            <th>Vehiculo</th>
                                                            <th>Cantidad</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>

                                                        <tr>
                                                            <td>01</td>
                                                            <td>Cargador Frontal</td>
                                                            <td class="text-center">20</td>
                                                        </tr>
                                                         <tr>
                                                            <td>01</td>
                                                            <td>Bolquete</td>
                                                            <td class="text-center">10</td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div><br>
                                            <div class="row clearfix">
                                                    <div class="col-lg-10 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="tpP">Total de maquinaria a emplear: </label>
                                                    </div>
                                                    <div class="col-lg-2 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group form-float">
                                                            <div class="form-line">
                                                                <input type="text" value="  30 vehiculos" class="form-control"/>
                                                            </div>
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