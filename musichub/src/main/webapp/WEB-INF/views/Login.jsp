
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/views/templates/Header.jsp"%>

<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-6"></div>
			<div class="col-md-6">

				<%
					String errorString = (String) request.getAttribute("error");
					if (errorString != null && errorString.trim().equals("true")) {
						out.println("Incorrect login name or password. Please retry using correct login name and password.");
					}
				%>
				<form class="form-horizontal" role="form" action="perform_login"
					method="post">
					<div class="form-group">
						<div class="col-sm-2">
							<label for="inputUsername" class="control-label">Username</label>
						</div>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="username"
								placeholder="Username">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="inputPassword" class="control-label">Password</label>
						</div>
						<div class="col-sm-10">
							<input type="password" class="form-control" name="password"
								placeholder="Password">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Sign in</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/templates/Footer.jsp"%>