


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/WEB-INF/views/templates/Header.jsp"%>


<!-- Carousel -->
<!-- =============================================================================================== -->	
<div id="fullcarousel-example" data-interval="3000"
	class="carousel slide" data-ride="carousel">
	<div class="carousel-inner" style="background: black;">

		<div class="item active">
			<img class="img-responsive"
				src="<c:url value='/resources/images/intl-home-slide-american-elite.jpg' />">
			<div class="carousel-caption">
				<h2>The American Elite Series</h2>
				<p>Build for the pursuit of perfection</p>
			</div>
		</div>
		<div class="item">
			<img class="img-responsive"
				src="<c:url value='/resources/images/intl-home-slide-bassbreaker.jpg' />">
			<div class="carousel-caption">
				<h2>BASSBREAKER GUITAR AMPLIFIER SERIES</h2>
				<p>A NEW GENERATION OF SOUND LAUNCHING</p>
			</div>
		</div>

		<div class="item">

			<img class="img-responsive"
				src="<c:url value='/resources/images/intl-home-slide-edge.jpg' />"
				style="height: 350 !important; width: 420 !important;">

			<div class="carousel-caption">
				<h2>THE EDGE SIGNATURE STRATOCASTER</h2>
				<p>THE ICONIC ONE</p>
			</div>
		</div>
		<div class="item">
			<img
				src="<c:url value='/resources/images/intl-home-slide-paramount-2.jpg' />"
				style="height: 350 !important; width: 420 !important;">
			<div class="carousel-caption">
				<h2>THE PARAMOUNT SERIES</h2>
				<p>A NEW GENERATION OF ACCOUSTIC GUITARS</p>
			</div>
		</div>
	</div>
	
<!-- Carousel Control -->
<!-- =============================================================================================================== -->	
	<a class="left carousel-control" href="#fullcarousel-example"
		data-slide="prev"><i class="icon-prev fa fa-angle-left"></i></a> <a
		class="right carousel-control" href="#fullcarousel-example"
		data-slide="next"><i class="icon-next fa fa-angle-right"></i></a>
</div>


<br />
<br />

<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h1 class="text-primary">Product Spotlight</h1>
				<h3>Gibson 2014 Les paul Standard Premium</h3>
				<p>Experience the comfort of a modern weight-relieved mahogany
					body</p>
				<p>Push-pull tuned coil tap switches for scooped tones, phase
					switching, and pure bypass enhance the inherently warm BurstBucker
					Pro timbres</p>
				<p>Depend on the stability, sustain, and resonance of locking
					Keystone Grover tuners and Tune-o-Matic bridge</p>
				<p>AAA Figured Quilted MAPLE TOP—A work of art</p>
			</div>
			<div class="col-md-6">
			
			
			<!-- Embedding a video from youtube -->
			<!-- ======================================================================================= -->
				<div class="embed-responsive embed-responsive-16by9">
					<iframe width="560"
						height="
                                          315"
						src="https://www.youtube.com/embed/BIt9VMT7Jq8" frameborder="0"
						allowfullscreen=""></iframe>
					315" src="https://www.youtub
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Category Selectors -->
<!-- ================================================================================================================ -->

<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center text-primary">Products</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<a href="/musichub/Product/Guitar"> <img
					src="<c:url value='/resources/images/category_guitar.JPG' />"
					class="center-block img-responsive img-thumbnail"></a>
				<h3 class="text-center">Guitars</h3>
			</div>
			<div class="col-md-4">
				<a href="/musichub/Product/Bass"><img
					src="<c:url value='/resources/images/category_base.JPG' />"
					class="center-block img-responsive img-thumbnail"></a>
				<h3 class="text-center">Bass</h3>
			</div>
			<div class="col-md-4">
				<a href="/musichub/Product/Amps"><img
					src="<c:url value='/resources/images/category_amp.JPG' />"
					width="85%" class="center-block img-responsive img-thumbnail"></a>
				<h3 class="text-center">Amps</h3>
			</div>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/views/templates/Footer.jsp"%>