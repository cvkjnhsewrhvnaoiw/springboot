<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="app"></c:set>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>写博客</title>
    <link rel="stylesheet" href="${app}/statics/boot/css/bootstrap.min.css">

    <link rel="stylesheet" href="${app}/statics/jqgrid/css/trirand/ui.jqgrid-bootstrap.css">
    <link rel="stylesheet" href="${app}/statics/mycss.css">
    <link rel="stylesheet" href="${app}/static/editormd/css/editormd.css">

    <%--引入js文件--%>
    <script src="${app}/statics/boot/js/jquery-3.3.1.min.js"></script>
    <script src="${app}/statics/boot/js/bootstrap.min.js"></script>
    <script src="${app}/statics/jqgrid/js/trirand/i18n/grid.locale-cn.js"></script>
    <script src="${app}/statics/jqgrid/js/trirand/jquery.jqGrid.min(1).js"></script>
    <script src="${app}/static/editormd/editormd.js"></script>

    <title>Document</title>
    <script type="text/javascript">
        //    调用编辑器
        var testEditor;
        $(function() {
            testEditor = editormd("test-editormd", {
                width   : "1000px",
                height  : 640,
                syncScrolling : "single",
                path    : "${pageContext.request.contextPath}/static/editormd/lib/"
            });
        });
    </script>



</head>
<body>
<form method="post" action="${app}/boke/update">
    <br>
    <div class="container">
        <div class="row">
            <div class="col-sm-4 col-sm-offset-4">
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon1">标题</span>
                    <input type="text" class="form-control" name="titel" value="${requestScope.boke.titel}"/>
                    <input type="hidden" class="form-control" name="id" value="${requestScope.boke.id}"/>
                </div>
            </div>
        </div>
    </div>
    <br>
    <!--文本标记区-->
    <div id="layout">
        <div id="test-editormd">
            <textarea style="display:none;" name="content">${requestScope.boke.content}</textarea>
        </div>
    </div>

    <!--提交按钮-->
    <div class="row">
        <div class="col-sm-6 col-sm-offset-6">
            <p>
                <input type="submit" class="btn btn-primary btn-lg" role="button" value="发表">
            </p>
        </div>
    </div>

</form>

</body>
</html>
