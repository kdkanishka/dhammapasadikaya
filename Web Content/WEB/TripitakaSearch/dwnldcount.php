<?php
	$conn=mysql_connect("localhost","dhammame_statmgr","namobuddhayaDM");
	mysql_select_db("dhammame_tsearchstat");

	$queryx="select dcount_win from downloads";
	$resultx=mysql_query($queryx);
	$totViews=mysql_fetch_array($resultx);
	$winDownlds=$totViews[0];

	$queryx="select dcount_lin from downloads";
	$resultx=mysql_query($queryx);
	$totViews=mysql_fetch_array($resultx);
	$linDownlds=$totViews[0];
	
	$queryx="select dcount_oth from downloads";
	$resultx=mysql_query($queryx);
	$totViews=mysql_fetch_array($resultx);
	$othDownlds=$totViews[0];	
	
	echo $winDownlds . "<br>" . $linDownlds . "<br>" . $othDownlds;
	//finally
	mysql_close();

?>