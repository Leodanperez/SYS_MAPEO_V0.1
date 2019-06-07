<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Muestra el contenido -->
<div class="container-fluid">
    <div class="block-header">
        <h3><strong>ADMINISTRACIÓN DE PERFILES</strong></h3>
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
                                <i class="material-icons">plus_one </i> Registrar Perfiles
                            </a>
                        </li>
                        <li role="presentation">
                            <a href="#perfilusuario_nav" data-toggle="tab">
                                <i class="material-icons">swap_horiz </i> Asignar Modulo a Perfil
                            </a>
                        </li>
                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane fade in active" id="regusuario_nav">

                            <!-- Striped Rows -->
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="listadoPerfiles">
                                    <div class="card">
                                        <div class="header bg-deep-orange">
                                            <h2 class="col-md-10 col-sm-9 col-xs-8">
                                                <strong>Lista de Perfiles</strong>
                                            </h2>

                                            <button type="button" class="btn btn-success waves-effect btn-sm col-md-2 col-sm-3 col-xs-4" onclick="javascript:mostrarform(true, 'i');">
                                                <i class="material-icons">add </i>
                                                <span>Nuevo Perfil</span>
                                            </button><br>

                                        </div>
                                        <div class="body table-responsive js-sweetalert">
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>
                                                        <th>Codigo</th>
                                                        <th>Descripcion</th>
                                                        <th>Estado</th>
                                                        <th>Acción</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${perfiles}" var="perfil" varStatus="status">
                                                        <tr>
                                                            <td>${perfil.getCperfiles_Cod()}</td>
                                                            <td>${perfil.getVperfiles_Descripcion()}</td>
                                                            <td >    
                                                                <c:choose>
                                                                    <c:when test="${perfil.getCperfiles_Estado()=='A'}">
                                                                        <span class="badge bg-green">Activo</span>
                                                                    </c:when>
                                                                    <c:otherwise >
                                                                        <span class="badge bg-red">Inactivo</span>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </td>
                                                            <td>
                                                                <button type="button" class="btn btn-primary btn-xs waves-effect" onclick="fn_dataUpdatePerfiles(true, '${perfil.getCperfiles_Cod()}', '${perfil.getVperfiles_Descripcion()}', '${perfil.getCperfiles_Estado()}');">
                                                                    <i class="material-icons">mode_edit</i>
                                                                </button>
                                                                    <button  class="btn bg-pink btn-xs waves-effect" onclick="javascript:deletePerfiles('${perfil.getCperfiles_Cod()}')">
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
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="formInsertPerfiles">
                                    <div class="card">
                                        <div class="header">
                                            <div class="col-md-10 col-sm-9 col-xs-8">
                                                <h2>
                                                    <strong>Registrar Perfiles</strong>
                                                </h2>
                                            </div>
                                        </div>
                                        <div class="body">
                                            <form class="form-horizontal" id="form_validation">
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="codPerfil">Codigo Perfil</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="codPerfil" class="form-control" disabled="" placeholder="Codigo de Perfil">
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
                                                                <input type="text" id="descripcionInsert" class="form-control" placeholder="Descripción" required name="descripcionCorta">
                                                            </div>
                                                            <div class="help-info">(Descripción)</div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                                                        <button type="button" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:fn_insertPerfiles();">
                                                            <i class="material-icons">save </i>
                                                            <span>Registrar</span>
                                                        </button>
                                                        <button type="button" class="btn bg-pink waves-effect btn-sm col-md-6 col-sm-6 col-xs-6"onclick="javascript:cancelarform(true);">
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
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="formUpdatePerfiles">
                                    <div class="card">
                                        <div class="header">
                                            <div class="col-md-10 col-sm-9 col-xs-8">
                                                <h2>
                                                    <strong>Actualizar Perfiles</strong>
                                                </h2>
                                            </div>
                                        </div>
                                        <div class="body">
                                            <form class="form-horizontal" id="form_validation" method="POST">
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="codPerfilAct">Codigo Perfil</label>
                                                    </div>
                                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="codigoUpdate" class="form-control" disabled="" placeholder="Codigo de Perfil" value="2">
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
                                                                <input type="text" id="descripcionUpdate" class="form-control" placeholder="Descripción" required value="DEMO">
                                                            </div>
                                                            <div class="help-info">Descripción del perfil</div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                                                        <button type="button" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:fn_updatePerfiles();">
                                                            <i class="material-icons">save </i>
                                                            <span>Registrar</span>
                                                        </button>
                                                        <button type="button" class="btn bg-pink waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="cancelarform(true)">
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

                        <div role="tabpanel" class="tab-pane fade" id="perfilusuario_nav">                                        
                            <div class="row clearfix">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div class="card">
                                        <div class="header">
                                            <div class="col-md-10 col-sm-9 col-xs-8">
                                                <h2>
                                                    <strong>Asignar Perfiles</strong>
                                                </h2>
                                            </div>
                                            <button type="button" class="btn bg-cyan waves-effect btn-sm col-md-2 col-sm-3 col-xs-4" data-toggle="modal" data-target="#buscarPerfil">
                                                <i class="material-icons">search</i>
                                                <span>Buscar Perfil</span>
                                            </button>
                                        </div>
                                        <div class="body">
                                            <form class="form-horizontal" id="form_validation" method="post" action="">
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="descripCorta">Codigo</label>
                                                    </div>
                                                    <div class="col-lg-4 col-md-4 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="codigoPerfil" name="codigoPerfil" class="form-control" disabled="" placeholder="Codigo">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                        <label for="descripLarga">Descripción</label>
                                                    </div>
                                                    <div class="col-lg-4 col-md-4 col-sm-8 col-xs-7">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" id="descripcionPerfil" name="descripcionPerfil" class="form-control" disabled="" placeholder="Descripción">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>                                                            
                                                <hr>
                                                <h6 class="text-muted text-center">DATOS DEL MODULO</h6>
                                                <hr>
                                                <div class="row clearfix">
                                                    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                                        <label for="tipoModulo">Tipo de Modulo</label>
                                                    </div>
                                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-5">
                                                        <div class="form-group">
                                                            <div class="form-line" id="selectModulos">
                                                               <!-- Combo de seleccion de Modulos-->
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-4 col-md-4 col-sm-5 col-xs-4">
                                                        <button type="button" class="btn btn-success waves-effect btn-sm col-md-6 col-sm-8 col-xs-12" onclick="javascript:insertPM();">
                                                            <i class="material-icons">save </i>
                                                            <span>Agregar Modulo</span>
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
                                                        <h4 class="modal-title" id="largeModalLabel">Buscar Perfil</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="form-group form-float form-group-lg">
                                                            <div class="col-md-9 col-sm-9 col-xs-9">
                                                                <div class="form-line ">
                                                                    <input type="text" class="form-control" id="valorBusquedaPerfil" name="busqueda" placeholder="Nombre de Perfi"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3 col-sm-3 col-xs-3">
                                                                <button type="button" class="btn btn-info waves-effect col-md-12 col-sm-12 col-xs-12" onclick="fn_buscarPerfiles();">
                                                                    <i class="material-icons">search</i>
                                                                    <span>Buscar</span>
                                                                </button>
                                                            </div>
                                                        </div>                                                           
                                                        <div class="row clearfix">
                                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                                <div class="body">
                                                                    <div class="table-responsive" id="resulbuscarPerfil">
                                                                        <table class="table table-hover">
                                                                            <thead>
                                                                                <tr>
                                                                                    <th>Nro</th>
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
                                                <strong>Lista de Usuarios - Perfiles</strong>
                                            </h2>
                                        </div>
                                        <div class="body table-responsive js-sweetalert" id="moduloPerfil">
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>
                                                        <th>#</th>
                                                        <th>Perfil</th>
                                                        <th>Módulo</th>
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
<script src="js/perfil.js" type="text/javascript"></script>
<!-- Sweet Alert Plugin Js -->
<script src="plugins/sweetalert/sweetalert.min.js" type="text/javascript"></script>
<link href="plugins/sweetalert/sweetalert.css" rel="stylesheet" type="text/css"/>

