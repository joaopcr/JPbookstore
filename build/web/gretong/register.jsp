<%-- 
    Document   : register
    Created on : 17/11/2017, 09:39:17
    Author     : JP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
        -->
        <!DOCTYPE HTML>
    <html>
        <head>
            <title>Gretong a Ecommerce Category Flat Bootstarp Responsive Website Template | Register :: w3layouts</title>

        </head>
        <body>
            <!-- header_top -->
            <%@include file="header.jsp" %>


            <!-- content -->
            <div class="container">
                <div class="main">
                    <!-- start registration -->
                    <div class="registration">
                        <div class="registration_left">
                            <h2>Novo? <span> Criar uma conta </span></h2>
                            <!-- [if IE] 
                                < link rel='stylesheet' type='text/css' href='ie.css'/>  
                             [endif] -->  

                            <!-- [if lt IE 7]>  
                                < link rel='stylesheet' type='text/css' href='ie6.css'/>  
                            <! [endif] -->  
                            <script>
                                (function () {

                                    // Create input element for testing
                                    var inputs = document.createElement('input');

                                    // Create the supports object
                                    var supports = {};

                                    supports.autofocus = 'autofocus' in inputs;
                                    supports.required = 'required' in inputs;
                                    supports.placeholder = 'placeholder' in inputs;

                                    // Fallback for autofocus attribute
                                    if (!supports.autofocus) {

                                    }

                                    // Fallback for required attribute
                                    if (!supports.required) {

                                    }

                                    // Fallback for placeholder attribute
                                    if (!supports.placeholder) {

                                    }

                                    // Change text inside send button on submit
                                    var send = document.getElementById('register-submit');
                                    if (send) {
                                        send.onclick = function () {
                                            this.innerHTML = '...Sending';
                                        }
                                    }

                                })();
                            </script>
                            <div class="registration_form">
                                <!-- Form -->
                                <form id="registration_form" action="../admin/usuario/UsuarioCtl" method="post">
                                    <input type="hidden" value="registrar" name="op" />
                                    <div>
                                        <label>
                                            <input placeholder="nome completo:" name="nome" type="text" tabindex="1" required autofocus>
                                        </label>
                                    </div>

                                    <div>
                                        <label>
                                            <input placeholder="email:" name="email" type="email" tabindex="3" required>
                                        </label>
                                    </div>

                                    <div>
                                        <label>
                                            <input placeholder="senha" name="senha" type="password" tabindex="4" required>
                                        </label>
                                    </div>						
                                    <div>
                                        <label>
                                            <input placeholder="cep:" name="cep" type="text" tabindex="1" required autofocus>
                                        </label>
                                    </div>
                                    <div>
                                        <label>
                                            <input placeholder="uf:" name="uf" type="text" tabindex="1" required autofocus>
                                        </label>
                                    </div>
                                    <div>
                                        <label>
                                            <input placeholder="cidade" name="cidade" type="text" tabindex="1" required autofocus>
                                        </label>
                                    </div>
                                    <div>
                                        <label>
                                            <input placeholder="endereco:" name="endereco" type="text" tabindex="1" required autofocus>
                                        </label>
                                    </div>
                                    <div>
                                        <label>
                                            <input placeholder="fone:" name="fone" type="text" tabindex="1" required autofocus>
                                        </label>
                                    </div>
                                    <div>
                                        <input type="submit" value="Criar conta" id="register-submit">
                                    </div>

                                </form>
                                <!-- /Form -->
                            </div>
                        </div>
                        <div class="registration_left">
                            <h2>Já possui conta?</h2>
                            <div class="registration_form">
                                <!-- Form -->
                                <form id="registration_form" action="../admin/usuario/UsuarioCtl" method="post">
                                    <input type="hidden" value="login" name="op" />
                                    <div>
                                        <label>
                                            <input placeholder="email:" name="email" type="email" tabindex="3" required>
                                        </label>
                                    </div>
                                    <div>
                                        <label>
                                            <input placeholder="senha:" name="senha" type="password" tabindex="4" required>
                                        </label>
                                    </div>						
                                    <div>
                                        <input type="submit" value="Entrar" id="register-submit">
                                    </div>

                                </form>
                                <!-- /Form -->
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <!-- end registration -->
                </div>
            </div>

            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
</body>
</html>
