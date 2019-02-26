<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecalho.jsp" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Gerenciamento de Classificações

        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="index.jsp">listagem</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> listagem de registros
            </li>
        </ol>
    </div>
</div>
<!-- /.row -->
<div class="row">
    <div class="panel panel-default">

        <div class="panel-body">

            <a  href="add.jsp" class="btn  btn-primary btn-sm fa fa-plus-square-o" >Novo</a>

        </div>
    </div>
</div>
<!-- /.row -->
<div class="row">
    <div class="panel panel-default">
        <form action="ClassificacaoCtl" method="get">
            <input type="hidden" name="acao" value="list" />
            <div class="form-group input-group">
                <input type="text" name="filtro" class="form-control"/>
                <span class="input-group-btn"><button class="btn btn-default" type="submit"><i class="fa fa-search"></i></button></span>
            </div>
        </form>
        <div class="panel-body">


            <div class="table-responsive">                
                <table class="table table-bordered table-hover" id="myTable">
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Nome</th>
                            <th >Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${lista}" var="obj">
                            <tr>
                                <td><c:out value="${obj.id}" /></td>
                                <td><c:out value="${obj.nome}" /></td>
                                <td><a href="ClassificacaoCtl?acao=upd&id=<c:out value="${obj.id}"/>" class="btn  btn-primary btn-sm">Alterar</a>
                                    <a href="ClassificacaoCtl?acao=del&id=<c:out value="${obj.id}"/>" class="btn  btn-primary btn-sm">Excluir</a>  
                                </td>
                            </tr>  
                        </c:forEach>
                    </tbody>
                </table>

                <!-- /.table-responsive -->
            </div>

        </div>
        <!-- /.panel-body -->
    </div>
    <!-- /.panel -->
</div>
<%@include file="../rodape.jsp" %>
