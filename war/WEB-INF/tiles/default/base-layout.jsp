<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<!--[if lt IE 9]>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<!-- stylesheets -->
<tiles:insertAttribute name="stylesheets" />

<link rel="icon" type="image/png" href="/favicon.ico">

<title><tiles:insertAttribute name="title" /></title>

</head>

<body>
	<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
	<div class="container-fluid">
	<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
    	<span class="icon-bar"></span>
    	<span class="icon-bar"></span>
    	<span class="icon-bar"></span>
   	</a>
    
    <a class="brand" href="#">Expense Tracker</a>
    
    <!-- user-menu -->
    <tiles:insertAttribute name="user-menu" />
  	
	<!-- navigation-top -->
	<tiles:insertAttribute name="navigation-top" />
	
	</div>
	</div>
	</div>
	
	<div class="container-fluid">
    <div class="row-fluid">
    <div class="span3">
    
    <!-- navigation-side -->
    <tiles:insertAttribute name="navigation-side" />
    
    </div>
    
    <div class="span9">
    	<!-- body -->
    	<tiles:insertAttribute name="body" />
    </div>
    
    </div>
    
	<!-- footer -->
    <tiles:insertAttribute name="footer" />
    </div>
    
    <!-- javascripts -->
    <tiles:insertAttribute name="javascripts" />
</body>
</html>
