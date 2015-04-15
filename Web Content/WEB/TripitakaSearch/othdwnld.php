<?php
	$path="static/windows7/Dhamma_Pasadikaya.exe";
	header( 'Location: '. $path ) ;
	$conn=mysql_connect("localhost","dhammame_statmgr","namobuddhayaDM");
	mysql_select_db("dhammame_tsearchstat");

	$query="update downloads set dcount_oth=dcount_oth+1";
	mysql_query($query);
?>
