
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
<script>
    $(document).ready(function() {
        $.getJSON("/getUsers",{},function(data){
            $('#ownerInput').autocomplete(
                    {source : data}
            );    
        });
        
        
        
        $("#getPetButton").click(function(){
                $.getJSON("/getPet",{"id" : 1},function(data){
                        if($("#petsList > *").length === 0){
                            $.each(data.pets,function(index,item){
                            var newUl =$("<ul>"+item.name+"</ul>").hide();
                            $("#petsList").append(newUl.show("normal").fadeIn()); 
                            })
                        } 
                        else{
                            $("li").effect("highlight",{},1000);
                        }
                })
        })

            var form = $('#petForm');
            form.submit(function(e) {
            $.post('/addPet',form.serializeArray(), function(response) {
            if(response.status === "FAILURE"){
                for(var i in response.errorMessageList){
                   $("#petForm fieldset div #" + i + "Error").html(response.errorMessageList[i]);
                }
            }
            else{
                var alertDiv = $("<div id='alertDiv'>User Added</div>")
                $("#petForm").prepend(alertDiv);
                $("#petForm fieldset div .errorSpan").html('');
            }
            },"json");
            return false;
        });
                                                                 
    });
</script>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>WELCOME</title>
  
        <link rel=stylesheet href="${pageContext.request.contextPath}/css/bootstrap.css"/>

</head>                                                                        
<body>

<div class="navbar">
    <div class="navbar-inner">
    <ul class="nav nav-pils">
        <li class="active"><a href="#">Home</a></li>
        <li class="disabled"><a href="#">Profile</a></li>
        <li class="disabled"><a href="#">Other Shit</a></li>
        <li class="dropdown">
            <a class="dropdown-toggle"
               data-toggle="dropdown"
               href="#">
                Show Off
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
                <li>1</li>
                <li>2</li>
                <li>3</li>
            </ul>
        </li>
        <li class="pill">Home</li>
    </ul>
    </div>
</div>
<div class="container-fluid">
<div class="span2">
    <img src="${pageContext.request.contextPath}/img/mugshot.jpg" class="img-rounded">
    <ul class="nav navlist">
        <li><a href="#" class="btn btn-large btn-primary disabled">1</a> </li>
        <li><a href="#" class="btn btn-large btn-primary disabled">2</a></li>
        <li><a href="#" class="btn btn-large btn-primary disabled">3</a></li>
        <li><a href="#" class="btn btn-large btn-primary disabled">4</a></li>
        <li><a href="#" class="btn btn-large btn-primary disabled">5</a></li>
    </ul>
</div>
<div class="span8">
    <h3>Zwierzatka:</h3>
    <li id="petsList">
    </li>
    <h2> Dodaj zwierzaczki </h2>    
    <form:form id="petForm" modelAttribute="petForm">
        <fieldset>
            <div>
                <form:input path="name"/>
                <span id="nameError" class="errorSpan"></span>
            </div>
            <div>
                <form:input path="owner" id="ownerInput"/>
                <span id="ownerError" class="errorSpan"></span>
            </div>
        <button type="submit" form="petForm" class="btn-primary" value="submit"></button>
        </fieldset>
    </form:form>
    <button id="getPetButton" value="pobierz nastepne"/>
</div>
</div>
</body>
</html>