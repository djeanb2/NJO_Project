<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>View Character List</title>

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

    <style>
        a{
            color: white;
        }
        a:hover {
            color: white;
            text-decoration: none;
        }
    </style>

</head>
<body>

    <div class="container">
    
    	<h1 class="p-3"> Character List </h1>
    	
    	<form:form>
    	
    		<table class="table table-bordered">
            	<tr>
            		<th>Id</th>
            		<th>Name</th>
            		<th>Ability</th>
            		<th>Universe</th>
            		<th>Edit</th>
            		<th>Delete</th>
            	</tr>

            	<c:forEach var="character" items="${characterList}">
                    <tr>
                		<td>${character.id}</td>
                		<td>${character.name}</td>
                		<td>${character.ability}</td>
                		<td>${character.universe}</td>
                		<td><button type="button" class="btn btn-success">
                		    <a href="/editCharacter/${character.id}">Edit</a>
                		</button></td>
                		<td><button type="button" class="btn btn-danger">
                			<a href="/deleteCharacter/${character.id}">Delete</a>
                		</button></td>
                	</tr>

            	</c:forEach>

            </table>
    	
    	</form:form>
    	
    	<button type="button" class="btn btn-primary btn-block">
        	<a href="/addCharacter">Add New Character</a>
        </button>
    
    </div>

</body>

</html>