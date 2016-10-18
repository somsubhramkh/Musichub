
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Header file included which contains the menu -->
<!-- ========================================================================================================== -->
<%@include file="/WEB-INF/views/templates/Header.jsp"%>

<br />
<br />
<br />


<div class="section">
	<div class="container" ng-app = "addToCartApp">
		<ul class="breadcrumb">
			<li><a href="/musichub/">Home</a></li>
			<li><a href="/musichub/Product">Product</a></li>
			<li class="active">ProductDetails</a>
			</li>

		</ul>
		<h1>${param.name}</h1>
		<div class="row">

			<div class="col-md-6">
				<img src="<c:url value='/resources/${param.id}.jpg' />"
					class="img-responsive">
			</div>
			<div class="col-md-6" ng-controller="addToCartCtrl">
				<ul>

					<!-- Showing values taken from the request parameters -->
					<!-- ============================================================================================== -->

					<%-- <li>Name:"${param.name}"</li> --%>
					<li><h4>Description:</h4><%=request.getParameter("desc")%></li>
					<li><h4>Brand:</h4><%=request.getParameter("brand")%></li>
					<li><h4>Price:</h4><%=request.getParameter("price")%></li>
					
					<!-- <a class="btn btn-primary" type="submit" name="checkout" href="order">Add to
						Cart</a>
						 -->
					<a class="btn btn-primary" ng-click="addItemToCart('<%=request.getParameter("id")%>')" href="order">Add to
						Cart</a>
						
					<a class="btn btn-primary" href="Share?<%=request.getQueryString()%>">Share</a>		

				</ul>


			</div>

		</div>
	</div>
</div>

 <script src="<c:url value="/resources/js/ordercontroller.js" /> "></script>
<!-- Footer JSP file included -->
<!-- ===================================================================================================================== -->
<%@include file="/WEB-INF/views/templates/Footer.jsp"%>
