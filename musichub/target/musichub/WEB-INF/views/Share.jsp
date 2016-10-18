<%@include file="/WEB-INF/views/templates/Header.jsp"%>

    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-8">
            <form role="form" action="sendMail">
              <div class="form-group">
                <label class="control-label">Email address</label>
                <input class="form-control" name="email" placeholder="Enter Email"
                type="email">
              </div>
              <div class="form-group">
                <label class="control-label">Subject</label>
                <input class="form-control" name="subject" placeholder="Subject"
                type="text" value="Hi!! Check out this cool product from MusicHub">
              </div>
              <div class="form-group">
                <label class="control-label">Body</label>
                <textarea class="form-control" name="content" placeholder="Email Content"
                 rows="3">Hi, Please check out the following product from MusicHub: http://localhost:8080/musichub/ProductDetails?<%=request.getQueryString()%></textarea>
              </div>
              <button type="submit" class="btn btn-default">Send</button>
            </form>
          </div>
        </div>
      </div>
    </div>

<%@include file="/WEB-INF/views/templates/Footer.jsp"%>