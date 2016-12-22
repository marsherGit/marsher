<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
	<title><tiles:getAsString name="title" /></title>

  <!-- Bootstrap Core CSS -->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- MetisMenu CSS -->
  <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="../css/sb-admin-2.css" rel="stylesheet">
  <link href="../css/layout.css" rel="stylesheet">

  <!-- Morris Charts CSS -->
  <link href="../vendor/morrisjs/morris.css" rel="stylesheet">

  <!-- Custom Fonts -->
  <link rel="stylesheet" type="text/css" href="../vendor/nanumfont/nanumfont.css" />
  <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- jQuery -->
  <script src="../vendor/jquery/jquery.min.js"></script>
	
</head>
<body>
<tiles:insertAttribute name="header" />

<div class="body_container container">
	<tiles:insertAttribute name="aside" />
	<div class="container content_body">
		<!-- content_title -->
		<header class="content-header-wrapper">
			<h2 class="page_title"><tiles:insertAttribute name="body_title" /></h2>
			<h3 class="desc"><tiles:insertAttribute name="body_title_desc" /></h3>
		</header>
		<!--// content_title -->
		<tiles:insertAttribute name="body" />
	</div>
</div>

<hr class="featurette-divider" />

<tiles:insertAttribute name="footer" />

<!-- Bootstrap Core JavaScript -->
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../vendor/metisMenu/metisMenu.min.js"></script>

<!-- Morris Charts JavaScript -->
<script src="../vendor/raphael/raphael.min.js"></script>
<script src="../vendor/morrisjs/morris.min.js"></script>
<!-- <script src="../data/morris-data.js"></script> -->

<!-- Custom Theme JavaScript -->
<script src="../js/sb-admin-2.js"></script>
<script src="../js/layout.js"></script>
  
</body>    
</html>
