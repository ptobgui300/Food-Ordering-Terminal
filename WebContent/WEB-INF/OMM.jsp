<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	

<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Online Menu</title>

<link rel="stylesheet"

	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<style type="text/css">

body {

	padding-top: 6em;

}

</style>

</head>

<body>

	<div class="container">



		<nav class="navbar fixed-top navbar-dark bg-dark">

	        <button class="navbar-toggler" data-toggle="dropdown">

	        	<span class="navbar-toggler-icon"></span>

	        </button>

	        <div class="dropdown-menu" id="dropButton">

	            <div id="drop">

	            </div>

	            <hr>

	            <form action = "OrderController" method = "get">

	            	<input type="hidden" name="food" id="order1">

	            	<input type="hidden" name="food" id="order2">

	            	<input type="hidden" name="food" id="order3">

	            	<input type="hidden" name="tableID" value="${tableId}">

	            	<input type="submit" value="Submit" id="submit">

	            </form>

	        </div>

	

	        <h1>DART</h1>

    	</nav>



		<div class="row">

			<c:forEach items="${menu}" var="menu" varStatus="status">

				<c:if test="${menu.quantity > 0}">

					<div class="col-sm-3">

						<div class="card" onclick="addItem('${menu.name}',${menu.id})">

							<img class="img-card-top" style="width:254.5px;height:auto" src="../images/${menu.name}.jpg" alt="${menu.name}">

							<div class="card-body">

					        	<h5 class="card-title"><c:out value="${menu.name}"/></h5>

							</div>

						</div>

					</div>

				</c:if>

			</c:forEach>

		</div>

		

		<nav class="navbar fixed-bottom navbar-dark bg-dark">

	        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Service</button>

	        <div id="botnav"></div>

	        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Check</button>

    	</nav>

	</div>

	

	<script>

		document.getElementById("dropButton").addEventListener("click", function(e) {

			e.stopPropagation();

		});

		document.getElementById("submit").addEventListener("click", submitOrder);

	

		function item(name, id) {

			this.name = name;

			this.id = id;

		}

		

		var order = [];

		

		function addItem(name, id) {

			if (order.length < 3) {

				order.push(new item(name, id));

				

				var food = document.createElement("div");

				var name = document.createTextNode(name + "\t");

				food.append(name);

				

				var remove = document.createElement("button");

				remove.innerHTML = "-";

				remove.className = "btn btn-danger btn-number";

				remove.onclick = function(id){

					order.pop(id);

					this.parentElement.parentElement.removeChild(this.parentElement);

				}

				food.append(remove);

				

				document.getElementById("drop").appendChild(food);

				

				alert(name.data + "was added.");

			} else {

				alert("Max 3 items per order.");

			}

		}

		

		function submitOrder() {

			var order1;

			var order2;

			var order3;

			

			for(var i = 0; i < order.length; i++) {

				if(i == 0) {

					order1 = document.getElementById("order1").value = order[0].id;

				} else if (i == 1) {

					order2 = document.getElementById("order2").value = order[1].id;

				} else {

					order3 = document.getElementById("order3").value = order[2].id;

				}

			}

			

			order.length = 0;

		}

	</script>

</body>

</html>