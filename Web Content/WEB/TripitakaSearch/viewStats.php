<html>
<head>
<style type="text/css">
table, td, th
{
border:1px solid green;
}
th
{
background-color:green;
color:white;
}
</style>
<title>Document Statistics</title>
</head>
<body>
<div align="center">
<?php
	$name=$_POST['userID'];
	$pass=$_POST['passwd'];
	if($name=="pemindu" && $pass=="namobuddhayaDM"){
		$conn=mysql_connect("localhost","dhammame_statmgr","namobuddhayaDM");
		mysql_select_db("dhammame_docstat");
		echo "<h3>Document Statistics for Let's Meditate Articles</h3>";
		$queryx="select sum(readc) from dhammame_LetsMeditate_stat";
		$resultx=mysql_query($queryx);
		$totViews=mysql_fetch_array($resultx);
		echo "Total Views : " . $totViews[0];
		
		$query="select * from dhammame_LetsMeditate_stat";
		$result=mysql_query($query);

		echo "<table border='1'>";
		echo "<thead><tr><th>Document</th>";
		echo "<th>Reads</th>";
		echo "<th>Percentage</th></tr></thead>";
		echo "<tbody>";	
		while($row=  mysql_fetch_array($result)){
				echo "<tr>";
				echo "<td>".$row['docName']."</td>";
				echo "<td>".$row['readc']."</td>";
				//echo "<td>".."</td>";
				$number=(($row['readc']/$totViews[0])*100);
				echo "<td><b>".number_format($number, 2, '.', '')."%</b></td>";
				echo "</tr>";
		}
		echo "</tbody>";
		echo "</table>";
		mysql_close();
	}else{
		die ("Invalid Username or Password");
	}	
?>
<h5>Copyright 2010 - DhammaMedicine. All Rights Reserved</h5>
</div>
</body>
</html>
