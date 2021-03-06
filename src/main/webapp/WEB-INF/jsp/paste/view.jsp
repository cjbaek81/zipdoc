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
<div class="form-group field-postform-text required">
    <textarea id="postform-text" class="textarea -form js-paste-code" name="PostForm[text]" autofocus="" aria-required="true" style="overflow: hidden; overflow-wrap: break-word; height: 300px; width: 100%"></textarea>
</div>
<div class="form-group field-postform-name">
    <label class="control-label col-sm-3" for="postform-viewCnt">조회수 : </label>
    <div class="col-sm-9 field-wrapper">
        <input type="text" id="postform-viewCnt" class="form-control" name="PostForm[viewCnt]">
    </div>
</div>
</body>
<script>

    $( document ).ready(function() {
        var url = "/api/paste/"+"<c:out value='${pageUrl}'/>";
        $.get(url, function(res, status){
            console.log(res)
            if(res.code == 200){
                $("textarea#postform-text").val(JSON.stringify(res.data));
                getViwCount(res.data);
            }else{
                $("textarea#postform-text").val(res.message);
            }
        });
    });

    //조회수
    function getViwCount(data){
        var url = "/api/paste/update/"+data.pasteSeqNo;
        $.get(url, function(res, status){
            console.log(res)
            if(res.code == 200){
                $("#postform-viewCnt").val(res.data);
            }
        });
    }
</script>
</html>