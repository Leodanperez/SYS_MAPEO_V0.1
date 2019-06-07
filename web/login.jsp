<%-- 
    Document   : login
    Created on : 28/08/2018, 05:07:44 PM
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>Login SGDDN</title>    
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main_login.css">
    </head>
    <body>    
        <div class="limiter">
            <div class="container-login100">
                <!--<div class="svg">
                    <object>
                        <embed src="dclogo_1.svg" width="200%" height="200%">
                    </object>
                </div>-->
                <div class="wrap-login100">
                    <form class="login100-form validate-form" method="POST" action="Login">
                        <span class="login100-form-title p-b-15">
                            <img src="images/logo_ep_web_b.png" height="150" width="130"/>
                        </span>	
                        <span class="login100-form-title p-b-30">
                        SISTEMA DE GESTIÓN PARA LA TOMA DE DESICIÓN ANTE DESASTRES
                        </span>
                        <div class="wrap-input100 validate-input" data-validate = "Ingrese Usuario">
                            <input class="input100" type="text" name="username" required="">
                            <span class="focus-input100" data-placeholder="Usuario"></span>
                        </div>  
                        <div class="wrap-input100 validate-input" data-validate="Ingrese Clave">                                
                            <input class="input100" type="password" name="password" id="Passwd" minlength="5" required>
                            <span class="focus-input100" data-placeholder="Contraseña" ></span>
                        </div>
                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <button class="btn-lg btn-success btn-block" type = "submit" >
                                    Ingresar
                                </button>
                            </div>
                        </div>
                        <br>
                        <div class="text-center p-t-30">
                            <span class="txt1">
                                SGDDN
                            </span>
                            <br>
                            <span class="txt1">
                                2019 ® Derechos Reservados
                            </span>                                
                            <br>   
                        </div>
                    </form>
                </div>
                
            </div>

            <div class="ac_footer">
                <a href="recuperar_contraseña.jsp">[ Cambiar Contraseña ]</a>
            </div>

        </div>

    </body>
    <script src="vendor/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="js/main.js"></script> 
</html>
