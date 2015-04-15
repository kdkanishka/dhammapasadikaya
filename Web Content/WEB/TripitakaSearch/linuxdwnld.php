<?php
	$path="static/linux/Dhamma_Pasadikaya.tar.gz";
	header( 'Location: '. $path ) ;
	$conn=mysql_connect("localhost","dhammame_statmgr","namobuddhayaDM");
	mysql_select_db("dhammame_tsearchstat");

	$query="update downloads set dcount_lin=dcount_lin+1";
	mysql_query($query);
?>
