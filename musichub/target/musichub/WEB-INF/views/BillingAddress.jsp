
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <%@include file="/WEB-INF/views/templates/Header.jsp" %>

<div class="section">
      <div class="container">
      <form:form commandName="order.cart.user">
      <div class="container">
      <h1>Billing Address</h1>
      <div class="form-group">
        <label class="control-label">Email address</label>
        <form:input class="form-control" path="email" placeholder="Enter email" type="email" />
      </div>
        <div class="form-group">
        <label class="control-label">Name</label>
        <form:input class="form-control" path="name" placeholder="Enter Name" type="text" />
      </div>
      <div class="form-group">
        <label class="control-label">Address</label>
        <form:input class="form-control" path="billingAddress.address" placeholder="Enter Address" />
      </div>
      <div class="form-group">
        <label class="control-label">City</label>
        <form:input class="form-control" path="billingAddress.city" type="text" placeholder="Enter City" />
      </div>
      <div class="form-group">
        <label class="control-label">Zip</label>
        <form:input class="form-control" type="text" path="billingAddress.zipCode" placeholder="Enter Zip" />
      </div>
      <div class="form-group">
        <label class="control-label">Mobile No</label>
        <form:input class="form-control" type="text" path="billingAddress.mobileNo" placeholder="Enter Mobile" />
      </div>
      <div class="form-group">
        <a class="btn btn-default">Back</a> 
        <input class="btn btn-success" type="submit" name="_eventId_billingAddressChecked">Next</a>
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}">
      </div>
    </div>
        </form:form>
      </div>
    </div>
    
  <%@include file="/WEB-INF/views/templates/Footer.jsp" %>