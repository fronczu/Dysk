<%--
  Created by IntelliJ IDEA.
  User: Michał
  Date: 28.11.2021
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="font-size: 16px;">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="Chmura">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>Dysk</title>
    <link rel="stylesheet" href="nicepage.css" media="screen">
    <link rel="stylesheet" href="Dysk.css" media="screen">
    <script class="u-script" type="text/javascript" src="jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="nicepage.js" defer=""></script>
    <meta name="generator" content="Nicepage 4.0.3, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i|Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#nowybutton").click(function(){
                $.ajax({url: "UploadServlet", success: function(result){
                        $("#centralContainer").html(result);
                    }});
            });
        });
        $(document).ready(function(){
            $("#mojdysk").click(function(){
                console.log("XDDD");
                $.ajax({url: "DownloadServlet", success: function(result){
                        $("#centralContainer").html(result);
                    }});
            });
        });
    </script>

    <script type="application/ld+json">{
        "@context": "http://schema.org",
        "@type": "Organization",
        "name": ""
    }</script>
    <meta name="theme-color" content="#73a3de">
    <meta property="og:title" content="Dysk">
    <meta property="og:type" content="website">
</head>
<body class="u-body">
<section class="u-clearfix u-section-1" id="sec-e29f">
    <div class="u-clearfix u-sheet u-valign-middle-lg u-valign-middle-md u-valign-middle-sm u-valign-middle-xl u-sheet-1">
        <p class="u-text u-text-1"> &nbsp;</p>
        <h3  id = "nameField" class="u-hidden-xs u-text u-text-default u-text-2">Witaj</h3><span class="u-icon u-icon-circle u-text-palette-1-base u-icon-1" data-href="Chmura.html" data-page-id="863829344"><svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 512 512" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-de92"></use></svg><svg class="u-svg-content" viewBox="0 0 512 512" id="svg-de92" style="enable-background:new 0 0 512 512;"><path d="M398.1,233.2c0-1.2,0.2-2.4,0.2-3.6c0-65-51.8-117.6-115.7-117.6c-46.1,0-85.7,27.4-104.3,67c-8.1-4.1-17.2-6.5-26.8-6.5  c-29.5,0-54.1,21.9-58.8,50.5C57.3,235.2,32,269.1,32,309c0,50.2,40.1,90.9,89.5,91h276.7l0,0c45.2-0.2,81.7-37.5,81.7-83.4  C480,270.6,443.3,233.3,398.1,233.2z"></path></svg></span>
        <script>
            fet

        </script>
        <a href="LoginServlet" class="u-btn u-btn-round u-button-style u-hover-palette-1-light-1 u-palette-1-base u-radius-50 u-btn-1">Zaloguj</a>
        <h2 class="u-text u-text-default u-text-3">Chmura</h2>
    </div>
</section>
<section class="u-clearfix u-section-2" id="sec-8ea1">
    <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-border-2 u-border-palette-2-base u-container-style u-expanded-width-lg u-expanded-width-md u-expanded-width-sm u-expanded-width-xs u-group u-radius-3 u-shape-round u-white u-group-1">
            <div id ="centralContainer" class="u-container-layout u-valign-bottom-sm u-container-layout-1">
                <h5 class="u-text u-text-default u-text-1">Moje pliki</h5>
                <div class="u-border-1 u-border-palette-2-base u-container-style u-group u-radius-15 u-shape-round u-white u-group-2">
                    <div class="u-container-layout u-container-layout-2">
                        <div class="u-border-1 u-border-grey-dark-1 u-line u-line-horizontal u-line-1"></div>
                        <p class="u-text u-text-2">Obraz.jpg</p>
                    </div>
                </div>
                <div class="u-border-1 u-border-palette-2-base u-container-style u-group u-radius-15 u-shape-round u-white u-group-3">
                    <div class="u-container-layout u-container-layout-3">
                        <div class="u-border-1 u-border-grey-dark-1 u-line u-line-horizontal u-line-2"></div>
                        <p class="u-text u-text-3">Obraz.jpg</p>
                    </div>
                </div>
                <div class="u-border-1 u-border-palette-2-base u-container-style u-group u-radius-15 u-shape-round u-white u-group-4">
                    <div class="u-container-layout u-container-layout-4">
                        <div class="u-border-1 u-border-grey-dark-1 u-line u-line-horizontal u-line-3"></div>
                        <p class="u-text u-text-4">Obraz.jpg</p>
                    </div>
                </div>
                <div class="u-border-1 u-border-palette-2-base u-container-style u-group u-radius-15 u-shape-round u-white u-group-5">
                    <div class="u-container-layout u-container-layout-5">
                        <div class="u-border-1 u-border-grey-dark-1 u-line u-line-horizontal u-line-4"></div>
                        <p class="u-text u-text-5">Obraz.jpg</p>
                    </div>
                </div>
            </div>
        </div>
        <a id = "nowybutton"  class="u-btn u-btn-round u-button-style u-hover-palette-1-light-1 u-palette-1-base u-radius-50 u-btn-1"><span class="u-icon u-text-white u-icon-1"><svg class="u-svg-content" viewBox="0 0 24 24" style="width: 1em; height: 1em;"><path d="M15,12h-2v-2c0-0.553-0.447-1-1-1s-1,0.447-1,1v2H9c-0.553,0-1,0.447-1,1s0.447,1,1,1h2v2c0,0.553,0.447,1,1,1s1-0.447,1-1  v-2h2c0.553,0,1-0.447,1-1S15.553,12,15,12z"></path><path d="M19.707,7.293l-4-4C15.52,3.105,15.266,3,15,3H7C5.346,3,4,4.346,4,6v12c0,1.654,1.346,3,3,3h10c1.654,0,3-1.346,3-3V8  C20,7.734,19.895,7.48,19.707,7.293z M17.586,8H16.5C15.673,8,15,7.327,15,6.5V5.414L17.586,8z M17,19H7c-0.552,0-1-0.448-1-1V6  c0-0.552,0.448-1,1-1h7v1.5C14,7.879,15.121,9,16.5,9H18v9C18,18.552,17.552,19,17,19z"></path></svg><img></span>&nbsp;Nowy
        </a>

        <a id = "mojdysk"  class="u-border-2 u-border-palette-1-base u-btn u-btn-round u-button-style u-hover-palette-1-base u-none u-radius-6 u-text-body-color u-text-hover-white u-btn-2">Mój Dysk</a>
        <a href="https://nicepage.com/c/text-on-image-html-templates" class="u-border-2 u-border-palette-1-base u-btn u-btn-round u-button-style u-hover-palette-1-base u-none u-radius-6 u-text-body-color u-text-hover-white u-btn-3">Ostatnio dodane</a>
        <div class="u-border-3 u-border-palette-2-base u-hidden-lg u-hidden-md u-hidden-sm u-hidden-xs u-line u-line-horizontal u-line-5"></div>
        <p class="u-text u-text-default u-text-6"><span class="u-icon u-text-palette-1-base u-icon-2"><svg class="u-svg-content" viewBox="0 0 512 512" style="width: 1em; height: 1em;"><path d="M399.3,232.8c0-1.2,0.2-2.4,0.2-3.6c0-64.3-52.8-117.2-116.8-117.2c-46.1,0-85.8,27.9-104.4,67c-8.1-4.1-17.1-6.4-26.8-6.4  c-29.6,0-54.1,23.7-58.9,52C57.4,236.8,32,268.8,32,308.4c0,49.8,40.1,91.6,89.6,91.6H398c45,0,82-38.9,82-84.3  C480,270.1,444.6,232.9,399.3,232.8z"></path></svg><img></span>&nbsp;Miejsce na dane
        </p>
        <p class="u-text u-text-default u-text-7">W użyciu 0 MB</p>
    </div>
</section>


<footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer" id="sec-3337"><div class="u-clearfix u-sheet u-sheet-1">
    <div class="u-align-center u-border-3 u-border-palette-1-light-3 u-expanded-width u-line u-line-horizontal u-line-1"></div>
    <h4 class="u-align-left u-text u-text-1">Chmura</h4>
</div></footer>
<section class="u-backlink u-clearfix u-grey-80">
    <a class="u-link" href="https://nicepage.com/html-templates" target="_blank">
        <span>Free HTML Templates</span>
    </a>
    <p class="u-text">
        <span>created with</span>
    </p>
    <a class="u-link" href="https://nicepage.review" target="_blank">
        <span>Best Free Website Builder</span>
    </a>.
</section>
</body>
</html>