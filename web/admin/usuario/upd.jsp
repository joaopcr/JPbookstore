<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecalho.jsp" %>
<%
String msg ="testando";
String classe = "alert-danger";

%>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Sistema
            <small>Admin</small>
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="index.jsp">Área Administrativa</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> Aqui vai o conteúdo de apresentação
            </li>
        </ol>
    </div>
</div>
<!-- /.row -->
<div class="row">
    <div class="panel panel-default">
        <div class="panel-heading">
            Usuario
        </div>
        <div class="panel-body">

            <div class="alert <%=classe%>">
                <c:out value="${msg}"/>
            </div>
            <form action="UsuarioCtl" method="post">

                <div class="col-lg-6">

                    <div class="form-group">
                        <label>Email</label>
                        <input class="form-control" type="text" name="txtEmail"  value="<c:out value="${obj.getEmail()}"/>" readonly />
                    </div>
                    <div class="form-group">
                        <label>Senha</label>
                        <input class="form-control" type="text" name="txtSenha" value="<c:out value="${obj.getSenha()}"/>" required />
                    </div>
                    <div class="form-group">
                        <label>Nome</label>
                        <input class="form-control" type="text" name="txtNome" value="<c:out value="${obj.getNome()}"/>" required />
                    </div>
                    <div class="form-group">
                        <label>CEP</label>
                        <input class="form-control" type="text" name="txtCEP" value="<c:out value="${obj.getCep()}"/>" required />
                    </div>
                    <div class="form-group">
                        <label>Endereço</label>
                        <input class="form-control" type="text" name="txtEndereco" value="<c:out value="${obj.getEndereco()}"/>" required />
                    </div>
                    <div class="form-group">
                        <label>CPF</label>
                        <input class="form-control" type="text" name="txtCPF" value="<c:out value="${obj.getCpf()}"/>" required />
                    </div>
                    <div class="form-group">
                        <label>Cidade</label>
                        <input class="form-control" type="text" name="txtCidade" value="<c:out value="${obj.getCidade()}"/>" required />
                    </div>
                    <div class="form-group">
                        <label>UF</label>
                        <input class="form-control" type="text" name="txtUF" value="<c:out value="${obj.getUf()}"/>" required />
                    </div>
                    <div class="form-group">
                        <label>Fone</label>
                        <input class="form-control" type="text" name="txtFone" value="<c:out value="${obj.getFone()}"/>" required />
                    </div>



                    <button class="btn btn-primary btn-sm" type="submit">Salvar</button>

            </form>

        </div>


    </div>
</div>
<!-- /.row -->
<%@include file="../rodape.jsp" %>