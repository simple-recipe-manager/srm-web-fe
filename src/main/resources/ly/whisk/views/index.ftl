<#-- @ftlvariable name="IndexView" type="ly.whisk.views.IndexView" -->
<!doctype html>
<html>
    <head>

      <title>Whisk.ly Recipe Manager</title>
      <meta name="description" content="Whisk.ly is the most convinient and secure way to store your recipes, new and old." />

      <!-- Schema.org markup for Google+ -->
      <meta itemprop="name" content="Whisk.ly Recipe Manager">
      <meta itemprop="description" content="Whisk.ly is the most convinient and secure way to store your recipes, new and old.">
      <meta itemprop="image" content="http://whisk.ly/img/whiskly_og_twitter.png">

      <!-- Twitter Card data -->
      <meta name="twitter:card" content="summary_large_image">
      <meta name="twitter:site" content="@whisklyapp">
      <meta name="twitter:creator" content="@geohinch">
      <meta name="twitter:title" content="Whisk.ly">
      <meta name="twitter:description" content="Whisk.ly is the most convinient and secure way to store your recipes, new and old.">
      <!-- Twitter summary card with large image must be at least 280x150px -->
      <meta name="twitter:image:src" content="http://whisk.ly/img/whiskly_og_twitter.png">

      <!-- Open Graph data -->
      <meta property="og:title" content="Whisk.ly Recipe Manager" />
      <meta property="og:type" content="product" />
      <meta property="og:url" content="http://whisk.ly/" />
      <meta property="og:image" content="http://whisk.ly/img/whiskly_og_facebook.png" />
      <meta property="og:description" content="Whisk.ly is the most convinient and secure way to store your recipes, new and old." />
      <meta property="og:site_name" content="Whisk.ly" />


      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="assets/css/materialize.css"  media="screen,projection"/>
      <script src="assets/js/jquery-2.1.1.min.js"></script>
    </head>

    <body>
<div id="amazon-root"></div>
<script type="text/javascript">

  window.onAmazonLoginReady = function() {
    amazon.Login.setClientId('amzn1.application-oa2-client.4aa9777d9d07427aa4509cd182b30c76');
    
  };
  (function(d) {
    var a = d.createElement('script'); a.type = 'text/javascript';
    a.async = true; a.id = 'amazon-login-sdk';
    a.src = 'https://api-cdn.amazon.com/sdk/login1.js';
    d.getElementById('amazon-root').appendChild(a);
  })(document);
$(function(a) {
    document.getElementById('LoginWithAmazon').onclick=function(){
    	options = { scope : 'profile' };
    
    	amazon.Login.authorize(options, window.location.protocol + '//' + window.location.host + '/authorize');
    };
});
</script>

	<div class="row">

      <div class="col s2">

		<ul id="slide-out" class="side-nav fixed cyan lighten-3 side-nav-white">
			<li><a href="#" id="LoginWithAmazon">
  <img border="0" alt="Login with Amazon"
    src="https://images-na.ssl-images-amazon.com/images/G/01/lwa/btnLWA_gold_156x32.png"
    width="156" height="32" />
</a></li>
			<li class="profile-badge"><a href="#profile" class="circle"><i class="left"><img src="assets/img/IMG_0421web-50.jpg" class="circle"></i>George H</a></li>
			<hr class="hr-nav">
			<li><a href="#!"><i class="mdi-action-lock left"></i>Private</a></li>
			<li><a href="#!"><i class="mdi-file-cloud left"></i>Public</a></li>
			<li><a href="#!"><i class="mdi-social-people left"></i>Family</a></li>
			<hr class="hr-nav">
			<li><a href="#!"><i class="mdi-maps-local-grocery-store left"></i>Shopping List</a></li>
			<li><a href="#!"><i class="mdi-maps-local-laundry-service left"></i>Devices</a></li>
	  </ul>
	  <a href="#" data-activates="slide-out" class="button-collapse"><i class="mdi-navigation-menu"></i></a>
	  </div>


	  <div class="col s-sort left-align">
	  		<a class='dropdown-button' href='#' data-activates='dropdown1'><i class="small mdi-content-sort"></i></a>
	  </div>



	  <div class="col s8">
        <div class="row card-center">
        <div class="col s12 m10">
		  <div class="input-field search">
		  	<form action="https://encrypted.google.com/search" method="get">
			<input id="search" type="text" name="q" placeholder="search recipes" autofocus x-webkit-speech/>

			</form>
		  </div>


          <div class="card">
            <div class="card-image">
              <img src="assets/img/cookies.jpg">
            </div>
            <div class="card-content">
				<span class="card-title activator">Nestle Toll House Cookies</span>
              	<p>Just break apart the pre-scored dough and bake. Each cookie is bursting with the NESTLE&reg; TOLL HOUSE&reg; Semi-Sweet Morsels you've loved for years.</p>
            </div>
            <div class="card-action">
              <a href="#">Share</a>
              <a href='#'>Open</a>
            </div>
          </div>



		  <div class="card-space-div"></div>



		  <div class="card">
            <div class="card-content">
				<span class="card-title activator">NESTLE TOLL HOUSE Cookies</span>
              <p>Just break apart the pre-scored dough and bake. Each cookie is bursting with the NESTLE&reg; TOLL HOUSE&reg; Semi-Sweet Morsels you've loved for years.</p>
            </div>
            <div class="card-action">
              <a href="#">Share</a>
              <a href='#'>Open</a>
            </div>
          </div>



		  <div class="card-space-div"></div>



		  <div class="card">
            <div class="card-image">
              <img src="assets/img/cookies.jpg">
            </div>
            <div class="card-content">
				<span class="card-title activator">NESTLE TOLL HOUSE Cookies</span>
              <p>Just break apart the pre-scored dough and bake. Each cookie is bursting with the NESTLE&reg; TOLL HOUSE&reg; Semi-Sweet Morsels you've loved for years.</p>
            </div>
            <div class="card-action">
              <a href="#">Share</a>
              <a href='#'>Open</a>
            </div>
          </div>



		  <div class="card-space-div"></div>



		  <div class="card">
            <div class="card-image">
              <img src="assets/img/cookies.jpg">
            </div>
            <div class="card-content">
				<span class="card-title activator">NESTLE TOLL HOUSE Cookies</span>
              <p>Just break apart the pre-scored dough and bake. Each cookie is bursting with the NESTLE&reg; TOLL HOUSE&reg; Semi-Sweet Morsels you've loved for years.</p>
            </div>
            <div class="card-action">
              <a href="#">Share</a>
              <a href='#'>Open</a>
            </div>
          </div>


        </div>
      </div>
      </div>

	  <div class="col s-number number-of-card">
		17 of 97
	  </div>


	</div>




      <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="assets/js/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="assets/js/materialize.min.js"></script>
      <script type="text/javascript" src="assets/js/init.js"></script>
      <script>
  		  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  		  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  		  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  		  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  		  ga('create', 'UA-59476825-1', 'auto');
  		  ga('send', 'pageview');
      </script>


	  <ul id='dropdown1' class='dropdown-content'>
			<li><a href="#!">a <i class="mdi-action-trending-neutral"></i> z</a></li>
			<li><a href="#!">most recent</a></li>
	  </ul>
	</body>
</html>
