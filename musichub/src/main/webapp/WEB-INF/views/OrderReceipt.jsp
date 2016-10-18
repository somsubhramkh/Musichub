
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!-- Header file included which contains the menu -->
<!-- ========================================================================================================== -->
<%@include file="/WEB-INF/views/templates/Header.jsp"%>
<br />
<div class="section">
	<div class="container" ng-app="addToCartApp" ng-controller="addToCartCtrl" ng-init="retrieveCart(${order.cart.cartId})">



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
		</script>
 -->
		<!-- Textbox used to implement search option using Angular -->
		<!-- ============================================================================================== -->

		<div class="bs-component">



			<!-- table to show data coming from the JSON file -->
			<!-- ============================================================================================== -->

	<form:form>
		<div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <h1>Shipping Address</h1>
            <ul class="lead list-group">
              <li class="list-group-item">Name: ${order.cart.user.name}</li>
              <li class="list-group-item">Address: ${order.cart.user.billingAddress.address}</li>
              <li class="list-group-item">City: ${order.cart.user.billingAddress.city}</li>
              <li class="list-group-item">Pin: ${order.cart.user.billingAddress.zipCode}</li>
              <li class="list-group-item">Mobile No: ${order.cart.user.billingAddress.mobileNo}</li>
            </ul>
          </div>
          <div class="col-md-6">
            <h3>Products</h3>
            <table class="table table-striped table-hover">
              <thead>
                <tr>
                 
						<th ng-click="sort('product.name')">Name <span class="glyphicon sort-icon" ng-show="sortKey=='id'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
						</th>
						<th ng-click="sort('product.brand')">Product Brand <span class="glyphicon sort-icon" ng-show="sortKey=='name'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
						</th>
						<th ng-click="sort('product.price')">Price <span class="glyphicon sort-icon" ng-show="sortKey=='price'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
						</th>
						<th ng-click="sort('quantity')">Quantity <span class="glyphicon sort-icon" ng-show="sortKey=='category'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
						</th>
						<th ng-click="sort('totalPrice')">Total price <span class="glyphicon sort-icon" ng-show="sortKey=='category'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
						</th>
						<th></th>

					</tr>
				</thead>
				<tbody>
				
					<tr ng-repeat="item in cart.items|orderBy:sortKey:reverse|filter:search">
						<td>{{item.product.name}}</td>
						<td>{{item.product.brand}}</td>
						<td>{{item.product.price}}</td>
						<td>{{item.quantity}}</td>
						<td>{{item.totalPrice}}</td>
	</tr>
					<tr>
					<td></td>
					<td></td>
					<td>Total:</td>
					<td>{{GrandTotalOfItems() | currency: "Rs."}}</td>
					<td><input type="submit" class="btn btn-success" name="_eventId_receiptFormChecked" value="Next"></td>
					<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}">
					</tr>
				</tbody>

              
            </table>
          </div>
        </div>
      </div>
    </div>
</form:form>
		</div>
	</div>
</div>
</div>
</div>
</div>
<script src="<c:url value="/resources/js/ordercontroller.js" /> "></script>
<!-- Footer JSP file included -->
<!-- ===================================================================================================================== -->
<%@include file="/WEB-INF/views/templates/Footer.jsp"%>