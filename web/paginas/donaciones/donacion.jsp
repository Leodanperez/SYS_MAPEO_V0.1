
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
                                    <i class="material-icons">plus_one </i> Registrar Donaciones
                                </a>
                            </li>
                            <li role="presentation">
                                <a href="#regSubModulo_nav" data-toggle="tab">
                                    <i class="material-icons">plus_one </i> Registrar Donantes
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
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="listadoDonaciones">
                                        <div class="card">
                                            <div class="header bg-indigo">
                                                <h2 class="col-md-10 col-sm-9 col-xs-8">
                                                    <strong>Lista de Donaciones</strong>
                                                </h2>

                                                <button type="button" class="btn btn-success waves-effect btn-sm col-md-2 col-sm-3 col-xs-4" onclick="javascript:mostrarformSuper(true, 'i')">
                                                    <i class="material-icons">add </i>
                                                    <span>Nuevo Donacion</span>
                                                </button>
                                                <br>
                                            </div>
                                            <div class="body table-responsive js-sweetalert">
                                                <table class="table table-striped">
                                                    <thead>
                                                        <tr>
                                                            <th>Codigo</th>
                                                            <th>Lugar</th>
                                                            <th>Fecha</th>
                                                            <th>Nombre</th>
                                                            <th>Unidad</th>
                                                            <th>Peso Total</th>
                                                            <th>Volumen Total</th>
                                                            <th>Cip</th>
                                                            <th>Acción</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${verdonaciones}" var="donacion" varStatus="ok">
                                                            <tr>
                                                                <td>${donacion.CDONA_COD}</td>
                                                                <td>${donacion.VLUG_ORIGEN}</td>
                                                                <td>${donacion.DDONA_FECHA}</td>
                                                                <td>${donacion.CDONATE_COD}</td>
                                                                <td>${donacion.COD_UNIDAD}</td>
                                                                <td>${donacion.DPESO_TOTAL}</td>
                                                                <td>${donacion.DVOLUMEN_TOTAL}</td>
                                                                <td>${donacion.CPERMILITARES_COD}</td>
                                                                <td>
                                                                    <button type="button" class="btn btn-primary btn-xs waves-effect" onclick="fn_showDonaciones(true, '${donacion.getCDONA_COD()}', '${donacion.getVLUG_ORIGEN()}', '${donacion.getDDONA_FECHA()}', '${donacion.getCDONATE_COD()}', '${donacion.getCOD_UNIDAD()}', '${donacion.getDPESO_TOTAL()}', '${donacion.getDVOLUMEN_TOTAL()}', '${donacion.getCPERMILITARES_COD()}', '${donacion.getVRECEPCION()}', '${donacion.getVMOVIMIENTO()}', '${donacion.getVENTRADA()}');">
                                                                        <i class="material-icons">mode_edit</i>
                                                                    </button>
                                                                        <a class="btn bg-pink btn-xs waves-effect" onclick="javasceipt: fn_deleteDonaciones(${donacion.getCDONA_COD()});">
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
                                <!-- #END# Striped Rows -->
                                <!-- Horizontal Layout -->
                                <div class="row clearfix">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="formInsertDonaciones">
                                        <div class="card">
                                            <div class="header">
                                                <div class="col-md-10 col-sm-9 col-xs-8">
                                                    <h2>
                                                        <strong>Registrar Donaciones</strong>
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
                                                                    <input type="text" id="codI" class="form-control" placeholder="Codigo de Donaciones">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="icono">Origen</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="Inorigen" class="form-control" placeholder="Lugar de Origen" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="icono">Fecha</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="date" id="Infecha" class="form-control" placeholder="" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descCorta">Donante</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line" id="comboDonante">
                                                                    
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="icono">Unidad</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="Inunidad" class="form-control" placeholder="Unidad" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="icono">Peso Total</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="Inpeso" class="form-control" placeholder="Peso Total" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="icono">Volumen Total</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="Involumen" class="form-control" placeholder="Volumen Total" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descripcionCorta">Militares</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="Incip" class="form-control" placeholder="Numero Cip" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descripcionCorta">Recepcion</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="Inrecep" class="form-control" placeholder="Recepcion" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descripcionCorta">Movimiento</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="Inmov" class="form-control" placeholder="Movimiento" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descripcionCorta">Entrada</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="Inentrada" class="form-control" placeholder="Entrada" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                                                            <button type="button" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript: fn_registrarDonaciones();">
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

                                <!-- FORM ACTUALIZAR Donaciones -->
                                <div class="row clearfix">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="formUpdateDonaciones">
                                        <div class="card" >
                                            <div class="header">
                                                <div class="col-md-10 col-sm-9 col-xs-8">
                                                    <h2>
                                                        <strong>Actualizar Donaciones</strong>
                                                    </h2>
                                                </div>
                                            </div>
                                            <div class="body">
                                                <form class="form-horizontal" id="form_validation" method="POST">
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="codDonacion">Codigo</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="codDonacion" class="form-control" placeholder="Codigo de Donaciones" disabled="">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="icono">Origen</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="origenDonacion" class="form-control" placeholder="Lugar de Origen" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="icono">Fecha</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="date" id="fechaDonacion" class="form-control" placeholder="" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descCorta">Donante</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <select class="form-control show-tick" id="codDonaDonacion">
                                                                        <option>- Seleccionar -</option>
                                                                        <option value=""></option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="icono">Unidad</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="unidadDonacion" class="form-control" placeholder="Unidad" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="icono">Peso Total</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="pesoDonacion" class="form-control" placeholder="Peso Total" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="icono">Volumen Total</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="volumenDonacion" class="form-control" placeholder="Volumen Total" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descripcionCorta">Militares</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="cipDonacion" class="form-control" placeholder="Numero Cip" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descripcionCorta">Recepcion</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="recepDonacion" class="form-control" placeholder="Recepcion" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descripcionCorta">Movimiento</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="movDonacion" class="form-control" placeholder="Movimiento" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descripcionCorta">Entrada</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="entradaDonacion" class="form-control" placeholder="Entrada" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                                                            <button type="button" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript: fn_updateDonaciones();">
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
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"  id="listarDonantes">
                                        <div class="card">
                                            <div class="header bg-indigo">
                                                <h2 class="col-md-10 col-sm-9 col-xs-8">
                                                    <strong>Lista de Donantes</strong>
                                                </h2>

                                                <button type="button" class="btn btn-success waves-effect btn-sm col-md-2 col-sm-3 col-xs-4" onclick="javascript:mostrarformSub(true, 'i');">
                                                    <i class="material-icons">add </i>
                                                    <span>Agregar</span>
                                                </button>
                                                <br>
                                            </div>
                                            <div class="body table-responsive js-sweetalert" id="listDonante">
                                                
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- #END# Striped Rows -->
                                <!-- Horizontal Layout -->
                                <div class="row clearfix">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"  id="formInsertDonantes">
                                        <div class="card">
                                            <div class="header">
                                                <div class="col-md-10 col-sm-9 col-xs-8">
                                                    <h2>
                                                        <strong>Registrar Donantes</strong>
                                                    </h2>
                                                </div>
                                            </div>
                                            <div class="body">
                                                <form class="form-horizontal" id="form_validation" method="POST">
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="codigoDonante">Codigo</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="codigoDonante" class="form-control" disabled="" placeholder="Codigo de Donante">
                                                                    <input type="hidden" id="codigoDonante">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descCorta">Nombre</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="nameDonante" class="form-control" placeholder="Nombres" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descLarga">Telefono</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="number" id="phoneDonante" class="form-control" placeholder="Telefono" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descLarga">Email</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="email" id="emailDonante" name="descLargaSubM" class="form-control" placeholder="Email" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="link">Tipo Doc</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line" id="comboTipoDocumento">
                                                                    
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="link">Nro Documento</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="number" id="nroDocDonante" class="form-control" placeholder="Numero Documento" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                                                            <button type="button" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:fn_registrarDonante();">
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
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"  id="formUpdateDonantes">
                                        <div class="card">
                                            <div class="header">
                                                <div class="col-md-10 col-sm-9 col-xs-8">
                                                    <h2>
                                                        <strong>Actualizar Donantes</strong>
                                                    </h2>
                                                </div>
                                            </div>
                                            <div class="body">
                                                <form class="form-horizontal" id="form_validation" method="POST">
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="UpcodigoDonante">Codigo</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="UpcodigoDonante" class="form-control" disabled="" placeholder="Codigo de Donante">
                                                                    <input type="hidden" id="UpcodigoDonante">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descCorta">Nombre</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="UpnameDonante" class="form-control" placeholder="Nombres" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descLarga">Telefono</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="number" id="UpphoneDonante" class="form-control" placeholder="Telefono" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descLarga">Email</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="email" id="UpemailDonante" name="descLargaSubM" class="form-control" placeholder="Email" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="link">Tipo Doc</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line" id="comboTipoDocumentoUpdate">
                                                                    
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="link">Nro Documento</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="number" id="UpdatenroDocDonante" class="form-control" placeholder="Numero Documento" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                                                            <button type="button" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:fn_updateDonante();">
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
<script src="js/donaciones.js" type="text/javascript"></script>
<script src="plugins/sweetalert/sweetalert.min.js"></script>
<link href="plugins/sweetalert/sweetalert.css" rel="stylesheet" type="text/css"/>

