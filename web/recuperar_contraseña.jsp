<%-- 
    Document   : login
    Created on : 28/08/2018, 05:07:44 PM
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>Recuperar Contraseña - SIPLAE</title>    
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main_login.css">
    </head>
    <body>    
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <form class="login100-form validate-form">
                        <span class="login100-form-title p-b-15">
                            <img src="images/logo_ep_web_b.png" height="150" width="130"/>
                        </span>	
                        <span class="login100-form-title p-b-30" />
                        Recuperar Contraseña <br> SISMAP
                        </span>
                        <div class="alert alert-warning" style="text-align: justify;margin-bottom: 0px;padding-top: 5px;padding-bottom: 5px;padding-right: 8px;padding-left: 8px;">                                
                            <span class="txt4" >
                                Ingrese su <b>correo institucional </b>registrado, le enviaremos un correo electronico con <b>su nombre de usuario y un enlace </b>para restablecer su contraseña.
                            </span>
                            <br>                                     
                        </div> 
                        <br><br>
                        <div class="wrap-input100 validate-input" data-validate = "Ingrese Correo Institucional">
                            <input class="input100" type="email" name="username" required="">
                            <span class="focus-input100" data-placeholder="Correo Institucional"></span>
                        </div>
                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <button class="btn-lg btn-success btn-block" type = "submit" >
                                    Enviar
                                </button>
                            </div>
                        </div>
                        <br>
                        <div class="text-center p-t-30">
                            <span class="txt1">
                                SIPLAE
                            </span>
                            <br>
                            <span class="txt1">
                                2018 ® Derechos Reservados
                            </span>                                
                            <br>   
                        </div>
                    </form>
                </div>
            </div>
            <div class="ac_footer">
                <a href="login.jsp">[ Ingresar al Sistema ]</a>
            </div>
        </div>
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="js/main.js"></script> 
    </body>
</html>
