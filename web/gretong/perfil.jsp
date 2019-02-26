<%-- 
    Document   : perfil
    Created on : 17/12/2017, 23:06:01
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
        <%@include file="header.jsp" %>

        <div class="container">
            <h1>Compras</h1>
            <table class="table table-bordered">
                <tr>
                    <th>ID</th>
                    <th>Data</th>
                    <th>Total</th>
                    <th>Livros</th>
                    <th>Ação</th>
                </tr>
                <c:forEach items="${listaVendas}" var="venda">
                    <tr>
                        <td>${venda.id}</td>
                        <td><fmt:formatDate pattern='dd/MM/yyyy' value="${venda.data}"/></td>
                        <td>R$ ${venda.total}</td>
                        <td><c:forEach items="${venda.getItemvendaList()}" var="itemvenda">
                                ${itemvenda.getLivro().getTitulo()} x
                                ${itemvenda.getQuantidade()}
                                <br>
                            </c:forEach></td>
                        <td><c:forEach items="${venda.getItemvendaList()}" var="itemvenda">
                                <a href="SiteCtl?pagina=detalhes&id=${itemvenda.getLivro().getId()}">Avaliar Livro</a>
                                <br>
                            </c:forEach></td>
                        
                    </tr>
                </c:forEach>
            </table>
        </div>

        <%@include file="footer.jsp" %>
    </body>
</html>
