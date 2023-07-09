<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>Edit Character</title>

    <link rel="stylesheet"
        	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
        <script
        	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script
        	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>


</head>
<body>

    <div class="container">
    
    	<h1 class="p-3"> Edit Character</h1>
    	
    	<form:form action="/editSaveCharacter" method="post" modelAttribute="character">

             <div class="row">
             	<div class="form-group col-md-12">
             		<div class="col-md-6">
             			<form:hidden path="id" class="form-control input-sm" />
             		</div>
             	</div>
             </div>

             <div class="row">
             	<div class="form-group col-md-12">
             		<label class="col-md-3" for="name">Name</label>
             		<div class="col-md-6">
             		    <form:input type="text" path="name" id="name"
             		        class="form-control input-sm" required="required" />
             		</div>
             	</div>
             </div>

             <div class="row">
             	<div class="form-group col-md-12">
             		<label class="col-md-3" for="ability">Ability</label>
             		<div class="col-md-6">
             		    <form:input type="text" path="ability" id="ability"
             		        class="form-control input-sm" required="required" />
             		</div>
             	</div>
             </div>
             
             <div class="row">
             	<div class="form-group col-md-12">
             		<label class="col-md-3" for="universe">Universe</label>
             		<div class="col-md-6">
             		    <form:input type="text" path="universe" id="universe"
             		        class="form-control input-sm" required="required" />
             		</div>
             	</div>
             </div>

             <div class="row p-2">
             	<div class="col-md-2">
             		<button type="submit" value="Register" class="btn btn-success">Save</button>
             	</div>
             </div>

         </form:form>
    
    </div>

</body>

</html>