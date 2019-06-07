<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        

<!-- Muestra el contenido -->
    <div class="container-fluid">
        <div class="block-header">
            <h3><strong>Administración de Roles</strong></h3>
        </div>
        <!-- Tabs With Icon Title -->
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="body">                                            
                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active">
                                <a href="#regroles_nav" data-toggle="tab">
                                    <i class="material-icons">plus_one </i> Registrar Roles
                                </a>
                            </li>
                        </ul>

                        <!-- Tab panes -->
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane fade in active" id="regroles_nav">
                                <!-- Striped Rows -->
                                <div class="row clearfix" id="listaRoles">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="card">
                                            <div class="header bg-teal">
                                                <h2 class="col-md-10 col-sm-9 col-xs-8">
                                                    <strong>Lista de Roles</strong>
                                                </h2>

                                                <button type="button" class="btn btn-success waves-effect btn-sm col-md-2 col-sm-3 col-xs-4" onclick="mostrarform(true, 'í')">
                                                    <i class="material-icons">add</i>
                                                    <span>Nuevo Rol</span>
                                                </button>
                                                <br>
                                            </div>
                                            <%-- LISTADO DE ROLES --%>
                                            <div class="body table-responsive js-sweetalert" id="listadoRoles">
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
                                                        <c:forEach items="${roles}" var="rol" varStatus="status">
                                                            <tr>
                                                                <td>${rol.getCroles_Cod()}</td>
                                                                <td>${rol.getVroles_Descripcion()}</td>
                                                                <td>
                                                                    <c:choose>
                                                                        <c:when test="${rol.getCroles_Estado()=='A'}">
                                                                            <span class="badge bg-green">Activo</span>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <span class="badge bg-red">Inactivo</span>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </td>
                                                                <td>
                                                                    <button type="button" class="btn btn-primary btn-xs waves-effect" onclick="fn_EditarRegistro()">
                                                                        <i class="material-icons">mode_edit</i>
                                                                    </button>
                                                                    <a class="btn bg-pink btn-xs waves-effect" href="roles?action=eliminarRoles&codigo=">
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
                                <!-- registrar Roles -->
                                <div class="row clearfix"  >
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="formInsertarRoles" >
                                        <div class="card">
                                            <div class="header">
                                                <div class="col-md-10 col-sm-9 col-xs-8">
                                                    <h2>
                                                        <strong>Registrar Roles</strong>
                                                    </h2>
                                                </div>
                                            </div>
                                            <div class="body">
                                                <form class="form-horizontal" id="form_validation"  action="javascript:fn_registrarRoles();" method="POST">
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="codRol">Codigo</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="codRol" class="form-control" disabled="" placeholder="Codigo de Rol" name="codigo">
                                                                    <input type="hidden" id="modo" name="modo" >
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="descCorta">Descripción </label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="descripcionCorta" class="form-control" placeholder="Descripción Corta" required name="descripcionCorta">
                                                                </div>
                                                                <div class="help-info">Descripion del Rol</div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                                                            <button type="submit" class="btn bg-blue waves-effect btn-sm col-md-6 col-sm-6 col-xs-6">
                                                                <i class="material-icons">save </i>
                                                                <span>Registrar</span>
                                                            </button>
                                                            <button type="button" class="btn bg-pink waves-effect btn-sm col-md-6 col-sm-6 col-xs-6" onclick="cancelarform();">
                                                                <i class="material-icons">cancel</i>
                                                                <span>Cancelar</span>
                                                            </button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div><br><br><br><br><br><br>
                                <!-- #END# Registar Roles -->

                                <!-- Actualizar Roles -->
                                <div class="row clearfix">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="formActualizaRoles">
                                        <div class="card">
                                            <div class="header">
                                                <div class="col-md-10 col-sm-9 col-xs-8">
                                                    <h2>
                                                        <strong>Actualizar Roles</strong>
                                                    </h2>
                                                </div>
                                            </div>
                                            <div class="body">
                                                <form class="form-horizontal" id="form_validation" method="POST" action="javascript:fn_actualizarRoles();">
                                                    <div class="row clearfix">
                                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                                            <label for="codRolaAct">Codigo</label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                                            <div class="form-group">
                                                                <div class="form-line">
                                                                    <input type="text" id="codRolAct" class="form-control" disabled="" placeholder="Codigo de Rol" name="codigoact" value="4">
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
                                                                    <input type="text" id="descCortaAct" class="form-control" placeholder="Descripción Corta" required name="descripcionCortaact" value="REPORTAR">
                                                                </div>
                                                                <div class="help-info">Descripcion o Nombre del rol</div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row clearfix">
                                                        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                                                            <button type="submit" class="btn bg-blue btn-sm col-md-6 col-sm-6 col-xs-6">
                                                                <i class="material-icons">save </i>
                                                                <span>Actualizar</span>
                                                            </button>
                                                            <button type="button" class="btn bg-pink btn-sm col-md-6 col-sm-6 col-xs-6" onclick="javascript:cancelarform();">
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
                        </div>

                    </div>
                </div>
                <!-- #END# Tabs With Icon Title -->
            </div>
        </div>
    </div>

<!-- Js Listar Roles -->
<!--<script type="text/javascript">
    function listaRoles(){
                $.ajax({
                   type:"GET",
                   url:"roles",
                   data:{action:'listaRoles'},
                   success:function(data){
                       $("#listaRoles").load("roles?action=listaRoles");
                   }
                });
    }
    //window.onload=listaRoles();
</script>-->

<!-- javaScript Roles (Mostrar/Ocultar)-->
<script src="js/rol.js" type="text/javascript"></script>

