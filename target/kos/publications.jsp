<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html charset="UTF-8">
        <title>Chair of Optimization and Control</title>
        <link rel="Search" href="adres"/>
        <meta name="author" content="Mateusz Wdowski & Szymon Nakoneczny"/>
        <link rel="stylesheet" href="./static/style.css" type="text/css"/>
        <script src="/static/app.js"></script>
    </head>

    <body>
        <div id="header">
            <ul class="nazwa_strony">
                <h1>
                    <img src="./static/image/logoOandC.gif" align="left">
                    Optimization and Control @ Jagiellonian University
                </h1>
            </ul>
        </div>

        <div id="header_main">
            <ul class="podstrony">
                <h5>
                    <ul class="active"><a href="/" style="text-decoration: none" title="home">Home</strong></a>&nbsp;&nbsp;&nbsp;
                        <a href="http://www.ii.uj.edu.pl" style="text-decoration: none">Institute of Computer Science</a> &nbsp;&nbsp; &nbsp;
                        <a href="http://kos.ii.uj.edu.pl/Research.html" style="text-decoration: none">Research</a> &nbsp; &nbsp; &nbsp;
                        <a href="/publications" style="text-decoration: none" >Publications</a>&nbsp; &nbsp; &nbsp; &nbsp;
                        <a href="http://kos.ii.uj.edu.pl/Forstudents.html" style="text-decoration: none">For students</a> &nbsp; &nbsp; &nbsp;
                    </ul>
                </h5>
            </ul>
        </div>
        <div id="main">
            <ul class="prowadzacy">
                <h3>Members</h3>
                <h4><i>                
                        <c:forEach var="user" items="${users}">
                            <a href="/member?name=${user.login}" style="text-decoration: none">${user.firstName}&nbsp;${user.lastName}</a></br>
                        </c:forEach>    
                    </i></h4>
                <h5><a href="http://kos.ii.uj.edu.pl/contact/index.html" style="text-decoration: none">FP7 People CONTACT
                        Project</a></h5>
                <h5><a href="http://kos.ii.uj.edu.pl/maestro/" style="text-decoration: none">Maestro Advanced Project</a></h5>
                <c:choose>
                    <c:when test="${isAuthenticated}">
                            <form action="/logout" method="post">
                                <input type="submit" value="Logout">
                            </form>
                    </c:when>
                    <c:otherwise>
                        <nav id="regularMenu" class="menu container">
                        <form action="/login" method="POST">
                            Login:<br/> <input name="login" type="text" value="${loginHelper.login}" size="20"/><br/> ${loginHelper.loginMessage} <br/>
                            Password:<br/> <input name="pass" type="password" size="20"/><br/>${loginHelper.passMessage}<br/>
                            <input type="submit" value="Login"/>
                        </form>
                        </nav>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
        
    <div id="tresc">
        <ul class="publikacja2">
         <b>Publications:</b><br><br>
         
            <c:forEach var="publication" items="${publications}"><br>
                    ${publication.name}<br>
                    ${publication.description}<br>
               </c:forEach> <br/>

    </div>
    <div id="footer_main">
        <ul class="linki">
            <h5>
                <a href="http://www.poczta.uj.edu.pl" style="text-decoration: none">Contact us</a> &nbsp; &nbsp;
                PhD lectures &nbsp; &nbsp;
                MC2 &nbsp; &nbsp;
                <a href="http://www.usosweb.uj.edu.pl" style="text-decoration: none">UsosWeb</a>&nbsp; &nbsp;
                <a href="http://uj.wkraj.pl/#/48942/" style="text-decoration: none">Campus location</a> &nbsp; &nbsp;
                <a href="https://ww2.ii.uj.edu.pl/intra/intra.php" style="text-decoration: none">Intranet login </a>&nbsp;
                &nbsp;
            </h5>
        </ul>
    </div>
    <div id="stopka">
        <ul class="stopka">
            <h6>
                Chair of Optimization and Control, Institute of Computer Science, Lojasiewicza 6, 30-348 Cracow, Poland
            </h6>
        </ul>
    </div>
  </body>
</html>



