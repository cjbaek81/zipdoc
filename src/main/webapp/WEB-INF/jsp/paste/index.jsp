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
    <select id="postform-expiration" class="form-control select2-hidden-accessible" name="PostForm[expiration]" data-s2-options="s2options_7ebc6538" data-krajee-select2="select2_a09a7382" data-select2-id="postform-expiration" tabindex="-1" aria-hidden="true">
        <option value="N" data-select2-id="4">Never</option>
        <%--<option value="B" data-select2-id="11">Burn after read</option>--%>
        <option value="10M" data-select2-id="12">10 Minutes</option>
        <option value="1H" data-select2-id="13">1 Hour</option>
        <option value="1D" data-select2-id="14">1 Day</option>
        <option value="1W" data-select2-id="15">1 Week</option>
        <option value="2W" data-select2-id="16">2 Weeks</option>
        <option value="1M" data-select2-id="17">1 Month</option>
        <option value="6M" data-select2-id="18">6 Months</option>
        <option value="1Y" data-select2-id="19">1 Year</option>
    </select>
</div>
<div class="form-group field-postform-name">
    <label class="control-label col-sm-3" for="postform-name">Paste Name / Title:</label>
    <div class="col-sm-9 field-wrapper">
        <input type="text" id="postform-name" class="form-control" name="PostForm[name]" maxlength="100">
    </div>
</div>
<div class="form-group form-btn-container">
    <button type="button" class="btn -big" onclick="go()">Create New Paste</button>
</div>
</body>
<script>

    var pasteUrl = "";

    function go(){
        var pasteVo = {
            pasteText : $("textarea#postform-text").val(),
            pasteExpiration : $("#postform-expiration").val(),
            pasteNameTitle : $("#postform-name").val()
        }

        $.ajax({
            url : "/api/paste/register",
            method : "post",
            dataType : 'json',
            async : false,
            contentType : "application/json; charset=utf-8",
            data : JSON.stringify(pasteVo),
            success : function(res) {
                console.log(res);
                pasteUrl = res.data;
            },
            complete : function(data) {
                var url = "${pageContext.request.contextPath}/"+ pasteUrl;
                window.open(url, "_self");
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                alert("Status: " + textStatus);
            }
        });
    }
</script>
</html>