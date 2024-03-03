<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>View Job Applications</title>

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

        <h1 class="p-3">Job Applications</h1>

        <form:form>
<!-- 
        <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="Search..." name="keyword">
            <div class="input-group-append">
                <button class="btn btn-outline-secondary" type="submit">Search</button>
            </div>
        </div> -->

            <table class="table table-bordered">
            	<tr>
            		<!-- <th>Id</th> -->
                    <th>Company Name</th>
            		<th>Position</th>
            		<th>Date Applied</th>
            		<th>Status</th>
            		<!-- <th>Mark Hired</th> -->
            		<th>Edit</th>
            		<th>Delete</th>
            	</tr>

            	<c:forEach var="jobApp" items="${list}">
                    <tr>
                		<!-- <td>${jobApp.id}</td> -->
                		<td>${jobApp.company}</td>
                		<td>${jobApp.position}</td>
                		<td>${jobApp.dateApplied}</td>
                		<td>${jobApp.status}</td>
                		<!-- <td><button type="button" class="btn btn-success">
                		    <a href="/updateJobApplicationStatus/${jobApp.id}">Mark Hired</a>
                		</button></td> -->
                		<td><button type="button" class="btn btn-primary">
                		    <a href="/editJobApp/${jobApp.id}">Edit</a>
                		</button></td>
                		<td><button type="button" class="btn btn-danger">
                			<a href="/deleteJobApp/${jobApp.id}">Delete</a>
                		</button></td>
                	</tr>

            	</c:forEach>

            </table>

        </form:form>

        <button type="button" class="btn btn-primary btn-block">
        	<a href="/addJobApp">Add Job Applications</a>
        </button>

    </div>

    <script th:inline="javascript">
                window.onload = function() {

                    var msg = "${message}";
                    
                    if (msg == "Save Success") {
        				Command: toastr["success"]("Added successfully!!")
        			} else if (msg == "Deleted Successfully") {
        				Command: toastr["success"]("Deleted successfully!!")
        			} else if (msg == "Delete Failure") {
        			    Command: toastr["error"]("Some error occurred, couldn't delete item")
        			} else if (msg == "Edit Successfully") {
        				Command: toastr["success"]("Updated successfully!!")
        			}

        			toastr.options = {
                          "closeButton": true,
                          "debug": false,
                          "newestOnTop": false,
                          "progressBar": true,
                          "positionClass": "toast-top-right",
                          "preventDuplicates": false,
                          "showDuration": "300",
                          "hideDuration": "1000",
                          "timeOut": "5000",
                          "extendedTimeOut": "1000",
                          "showEasing": "swing",
                          "hideEasing": "linear",
                          "showMethod": "fadeIn",
                          "hideMethod": "fadeOut"
                        }
        	    }
            </script>

</body>

</html>
