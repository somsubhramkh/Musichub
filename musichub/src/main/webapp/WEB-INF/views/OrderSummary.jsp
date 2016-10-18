
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!-- Header file included which contains the menu -->
<!-- ========================================================================================================== -->
<%@include file="/WEB-INF/views/templates/Header.jsp"%>
<br />
<div class="section">
	<div class="container" ng-app="addToCartApp">



		<!-- retrieving the prodData attribute sent from the controller which contains the JSON as string -->
		<!-- ============================================================================================== -->

		<%
			String type = (String) request.getAttribute("prodData");
		%>


		<!-- Angular script to generate the productlist and sorting -->
		<!-- ============================================================================================== -->

		<!-- <script>
			var prod = [{"id":82,"brand":"Fender","desc":"The American Special series Jazz Bas guitar puts genuine U.S-made Fender quality into the hands of players at any level","name":"AMERICAN SPECIAL JAZZ BASS","price":118000,"category":"Bass"},
			            {"id":83,"brand":"Fender","desc":"The American Special series Jazz Bas guitar puts genuine U.S-made Fender quality into the hands of players at any level","name":"AMERICAN SPECIAL JAZZ BASS","price":118000,"category":"Bass"}];

			angular.module('repeatSample', []).controller('repeatController',
					function($scope) {
						$scope.products = prod;

						$scope.sort = function(keyname) {
							$scope.sortKey = keyname; //set the sortKey to the param passed
							$scope.reverse = !$scope.reverse; //if true make it false and vice versa
						}
						
						$scope.total = function() {
					        var total = 0;
					        angular.forEach($scope.products, function(product) {
					            total += product.price;
					        })

					        return total;
					    }

					});
		</script> -->
		

		<!-- Textbox used to implement search option using Angular -->
		<!-- ============================================================================================== -->

		<div class="bs-component" ng-controller="addToCartCtrl" ng-init="retrieveCart(${order.cart.cartId})">



			<!-- table to show data coming from the JSON file -->
			<!-- ============================================================================================== -->

	<form:form>
			<table class="table table-striped table-hover">
				<thead>
					<tr>

						<!-- Performing sort functionality using angular both in ascending and descending manner -->
						<!-- ============================================================================================== -->

						<th>Name</th>
						<th>Brand</th>
						<th>price</th>
						<th>Quantity</th>
						<th>Item Total</th>
						

						<th></th>

					</tr>
				</thead>
				<tbody>
					<!-- dynamically generating the table data -->
					<!-- ============================================================================================== -->

					<tr
						ng-repeat="item in cart.items|orderBy:sortKey:reverse|filter:search">
						<td>{{item.product.name}}</td>
						<td>{{item.product.brand}}</td>
						<td>{{item.product.price}}</td>
						<td>{{item.quantity}}</td>
						<td>{{item.totalPrice}}</td>

						<!-- Info button that maps to the ProductDetails view. Required Info for ProductDetails view is passed through request parameters -->
						<!-- ============================================================================================== -->

						<td><a
							href="#" ng-click="removeItemFromCart(item.itemId)"><i class="fa fa-times" aria-hidden="true"></i></a></td>
					</tr>
					<tr>
					<td></td>
					<td></td>
					<td>Total:</td>
					<td>{{GrandTotalOfItems()}}</td>
					<td><input type="submit" class="btn btn-success" name="_eventId_orderSummaryChecked" value="Next"></td>
					<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
					</tr>
				</tbody>
			</table>
</form:form>
<script src="<c:url value="/resources/js/ordercontroller.js" /> "></script>
		</div>
	</div>
</div>
</div>
</div>
</div>

<!-- Footer JSP file included -->
<!-- ===================================================================================================================== -->

<%@include file="/WEB-INF/views/templates/Footer.jsp"%>