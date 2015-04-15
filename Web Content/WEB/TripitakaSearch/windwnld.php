<?php
	$path="static/windowsXP/Dhamma_Pasadikaya_Setup.exe";
	header( 'Location: '. $path ) ;
	$conn=mysql_connect("localhost","dhammame_statmgr","namobuddhayaDM");
	mysql_select_db("dhammame_tsearchstat");

	$query="update downloads set dcount_win=dcount_win+1";
	mysql_query($query);
?>
