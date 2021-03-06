<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>dev</title>
</head>
<body>
paste view!!
</body>
<script>

    $( document ).ready(function() {
        var url = "/api/paste/"+"${pageUrl}";
        $.get(url, function(res, status){
            console.log(res);
        });
    });

    /*$.ajax({
        url : "/api/paste/"+"${pageUrl}",
        method : "get",
        dataType : 'json',
        async : false,
        success : function(res) {
            console.log(res);

        },
        complete : function(data) {
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            alert("Status: " + textStatus);
        }
    });*/


</script>
</html>