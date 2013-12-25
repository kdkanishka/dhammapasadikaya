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
	
	
	//finally
	mysql_close();

?>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Dhamma Pasadikaya - Home</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="icon" href="http://dhammamedicine.info/wp-content/uploads/2011/05/DhammaChakkaL.png" type="image/png"/>
<style type="text/css">
<!--
.style5 {font-size: 20px}
-->
</style>

<!--shadow box elements -->
<link href='http://dhammamedicine.info/TripitakaSearch/shadowbox/shadowbox.css' rel='stylesheet' type='text/css'/>
<script src='http://dhammamedicine.info/TripitakaSearch/shadowbox/shadowbox.js' type='text/javascript'></script>
<script type='text/javascript'>
Shadowbox.init();
</script>
<!--end of shadowbox elements -->
</head>

<body>
<div id="wrapper">
  <div id="header">
		
		<h1>ධම්ම පාසාදිකය </h1>
		<div id="navigation">
			<ul>
				<li class="selected"><a href="index.php" title="About Us">HOME</a></li>
				<li><a href="Help.html" title="Help">Help</a></li>
				<li><a href="Screenshots.html" title="Screenshots">Screenshots</a></li>
				<li><a href="http://dhammamedicine.net" title="DhammaMedicine">Dhammamedicine</a></li>
				<li><a href="http://metta.lk" title="Metta-Net">MettaNet</a></li>
				<li><a target="_blank" href="http://dhammamedicine.net/ContactUs/ContactUs.php" title="Contact Us">CONTACTS</a></li>
			</ul>
		</div><!--end navigation-->
		
		
		
		<form action="">
        </form>
		<h2 id="slogan"><span class="style5">"තථාගතප්පවේදිතෝ භික්ඛවේ, ධම්මවිනයෝ විවටෝ විරෝචති නෝ පටිච්ඡන්නෝ"<br />"පින්වත් මහණෙනි , තථාගතයන් වහන්සේ විසින් දේශනා කරන ලද ධර්මයත් විනයත් බබළන්නේ විවෘත්ත වූ විටය සැඟවී තිබෙනවිට නොවේ."</span></h2>
		
	  <img src="images/project_logo.png" alt="Business" width="702" height="137" id="imagem" />	  </div>
	
	<div id="content">
	  <div id="col_left">
			<div id="welcome">
			  <p align="justify" class="style7">ධම්ම පාසාදිකය යනු ත්‍රිපිඨක සෙවුම් වැඩසටහනකි. මෙමගින් metta.lk හි ඇති ත්‍රිපිඨක පරිවර්තනයේ අන්තර්ගතය තුල සෙවීම් කල හැකිය(අන්තර්ජාල පහසුකම් අවශ්‍ය <strong>නොවේ</strong>).</p>
			  <p align="justify" class="style7">&nbsp;</p>
			  <p align="justify" class="style7"> උදාහරණ වශයෙන් යම් සූත්‍ර දේශනාවක් ත්‍රිපිඨක තුල අන්තර්ගත වන්නේ කවර ස්ථානයේද යන්න නොදත් විට එම සූත්‍ර දේශනාවේ නම මෙම නිවැරදිව මෙම වැඩසටහනට ලබාදීමෙන් අදාල සූත්‍රය(metta-net පරිවර්තනය)  ප්‍රතිඵලය ලෙස ලැබේ. එමෙන්ම කිසියම් වචනයක් උතුම් ත්‍රිපිඨකය තුල සඳහන් වන්නේ කවර සූත්‍ර දේශනා තුලද යන්නද මෙම පරිගණක වැඩසටහන මගින් සොයාගත හැකිය.උදාහරණයක් ලෙස යම් අයෙකුට &quot;සතිපට්ඨානය&quot; යන වදන ත්‍රිපිඨකයේ කවර ස්ථානයන්හි සඳහන්වේද යන්න දැන ගැනීමට &quot;සතිපට්ඨානය&quot; ලෙසින් මෙහි සෙවුමක් යෙදූවිට මහා සතිපට්ඨාන සූත්‍රය ඇතුලු තවත් සූත්‍ර විශාල සංඛ්‍යාවක් ප්‍රථිඵල ලෙස ලැබේ.</p>
			  <p align="justify" class="style7">&nbsp;</p>
			  <p align="justify" class="style7">ධර්මය වඩ වඩාත් බුද්ධ ශ්‍රාවකයින් අතරට ගෙනයාම මෙම පරිගණක වැඩසටහනේ අරමුණයි. </p>
			  <p align="justify" class="style7">&nbsp;</p>
			  <p align="justify" class="style7">පසත සංස්කරණයන්ගෙන් අදාල සංස්කරණය තෝරාගන්න.</p>
			  <p align="left" class="style7">&nbsp;</p>
			  <table width="100%
			  " border="1">
                <tr>
                  <td width="17%"><span class="style10"><span class="style7"><img src="images/Win7.png" alt="windows" width="48" border="0" height="48" /></span></span></td>
                  <td width="83%"><span class="style7">Portable and Windows7 Distribution (වින්ඩෝස් 7 සංස්කරණය) </span></td>
                </tr>
                <tr>
                  <td><span class="style7">Size</span></td>
                  <td><span class="style7">22MB</span></td>
                </tr>
                <tr>
                  <td><span class="style10"><span class="style7">CRC32</span></span></td>
                  <td><span class="style12">F104299C</span></td>
                </tr>
                <tr>
                  <td><span class="style10"></span><a href="othdwnld.php"><img src="images/downlod.png" alt="dwn" width="48"  border="0" height="48" /></a></td>
                  <td><p class="style7"><a href="othdwnld.php">Download </a></p>
                    <p class="style7"><a href="othdwnld.php">Dhamma_Pasadikaya.exe</a></p>
                    <p align="right" class="style14"><?php echo $othDownlds; ?> Downloads</p></td>
                </tr>
              </table>
			  <p align="left" class="style7">&nbsp;</p>
			  <table width="100%
			  " border="1">
                <tr>
                  <td width="17%"><span class="style10"><span class="style7"><img src="images/Windows.png" alt="windows" width="48" border="0" height="48" /></span></span></td>
                  <td width="83%"><span class="style7">Windows Distribution (වින්ඩෝස් සංස්කරණය) : XP, 2000 , Vista </span></td>
                </tr>
                <tr>
                  <td><span class="style7">Size</span></td>
                  <td><span class="style7">22MB</span></td>
                </tr>
                <tr>
                  <td><span class="style10"><span class="style7">CRC32</span></span></td>
                  <td><span class="style12">39DDD306</span></td>
                </tr>
                <tr>
                  <td><span class="style10"></span><img src="images/downlod.png" alt="dwn" width="48"  border="0" height="48" /></td>
                  <td><p class="style7"><a href="windwnld.php">Download </a></p>
                    <p class="style7"><a href="windwnld.php">Dhamma_Pasadikaya_Setup.exe</a></p>
                    <p align="right" class="style14"><?php echo $winDownlds; ?> Downloads</p></td>
                </tr>
              </table>
			  <p align="left" class="style7">&nbsp;</p>
			  <table width="100%
			  " border="1">
                <tr>
                  <td width="17%"><span class="style10"><span class="style7"><img src="images/linux.png" alt="windows" width="48" border="0" height="48" /></span></span></td>
                  <td width="83%"><span class="style7">Linux  Distribution (ලිනක්ස් සංස්කරණය) </span></td>
                </tr>
                <tr>
                  <td><span class="style7">Size</span></td>
                  <td><span class="style7">22MB</span></td>
                </tr>
                <tr>
                  <td><span class="style10"><span class="style7">CRC32</span></span></td>
                  <td><span class="style12">36AEBB82</span></td>
                </tr>
                <tr>
                  <td><span class="style10"></span><img src="images/downlod.png" alt="dwn" width="48"  border="0" height="48" /></td>
                  <td><p class="style7"><a href="linuxdwnld.php">Download</a></p>
                    <p class="style7"><a href="linuxdwnld.php">Dhamma_Pasadikaya.tar.gz</a></p>
                    <p align="right" class="style14"><?php echo $linDownlds; ?> Downloads</p></td>
                </tr>
              </table>
			  <p align="left" class="style7">&nbsp;</p>
		  </div>
		    <!--end welcome-->
      </div>
	  <!--end col_left-->
		<div id="col_right">
			<div id="news">
					<h2>ආශ්‍රිත වෙබ් අඩවි</h2>
					<ul>
						<li>
							<p class="date">METTANET - LANKA </p>
							<p><a href="http://www.metta.lk/" target="_blank"><img src="images/mettanet.png" alt="MettaNet" width="220" height="154" /></a></p>
						</li>
						<li>
							<p class="date">DhammaMedicine </p>
							<p><a href="http://dhammamedicine.net" target="_blank"><img src="images/DhammaMedicine.jpg" alt="DhammaMedicine" width="220" height="46" /></a></p>
						</li>
						<li>
							<p class="date">DhammaMedicine Group </p>
							<p><a href="http://groups.google.com/group/dhammamedicine" target="_blank"><img src="images/google-groups-logo1.png" alt="DhammaMedicine" width="156" height="57" /></a></p>
						</li>
			  </ul>
          </div>
			<!--end news-->
		  <div id="contacts">
		  <h2>Contact Us</h2>
		  <p>send your suggestions</p>
		  <p><span class="green">Email:</span><a href="index.html"> kdkanishka@gmail.com </a></p>
		  </div>
		  
		  <div>
		  <p class="date">Facebook Page </p>
		  <p class="date"><a border="0" target="_blank" href="http://www.facebook.com/pages/%E0%B6%B0%E0%B6%B8%E0%B7%8A%E0%B6%B8-%E0%B6%B4%E0%B7%8F%E0%B7%83%E0%B7%8F%E0%B6%AF%E0%B7%92%E0%B6%9A%E0%B6%BA/216272525068608"><img src="images/facebook.png" alt="FB" width="60" height="60"  /></a></p>
		  </div>
		  
		  

		  

		</div><!--end col_right-->
		
	</div><!--end content-->
	<div style="clear:both"></div>
</div>

<!--end wrapper-->
<div id="footer">
  <p>&copy; 2011 <a href="http://dhammamedicine.blogspot.com/">DhammaMedicine.net</a>  Valid CSS &amp; XHTML. Template design by <a href="http://www.chamadigital.com" title="Chama Digital">Chama Digital</a></p>
</div>
</body>

<!-- Histats.com  START  (standard)-->
<script type="text/javascript">document.write(unescape("%3Cscript src=%27http://s10.histats.com/js15.js%27 type=%27text/javascript%27%3E%3C/script%3E"));</script>
<style type="text/css">
<!--
.style7 {font-size: 16px}
.style10 {font-size: 16%}
.style12 {font-size: 16px; font-family: "Courier New", Courier, monospace; }
.style13 {font-size: 16px; color: #00FF00; }
.style14 {font-size: 12px; color: #00FF00; }
-->
</style>
<a href="http://www.histats.com" target="_blank" title="hidden hit counter" ><script  type="text/javascript" >
try {Histats.start(1,1254215,4,0,0,0,"00000000");
Histats.track_hits();} catch(err){};
</script></a>
<noscript><a href="http://www.histats.com" target="_blank"><img  src="http://sstatic1.histats.com/0.gif?1254215&101" alt="hidden hit counter" border="0"></a></noscript>
<!-- Histats.com  END  -->
</html>
