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
<html>
<head>
    <title>WELCOME</title>
</head>                                                                        
<body>
${userValueObject.name}
<datalist></datalist></datalist>
<h3>Zwierzatka:</h3>
<div>
<li id="petsList">
</li>
    <button id="getPetButton" value="pobierz nastepne"
            />
</div>
<div>
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
        <button type="submit" form="petForm" value="submit"></button>
        </fieldset>
    </form:form>                     
</div>

</body>
</html>