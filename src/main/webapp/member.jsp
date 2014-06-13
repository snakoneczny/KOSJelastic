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
            <ul class="zawartosc">
                <c:choose>
                    <c:when test="${addingEnabled}">
                        <form action="/editProfile" method="post">
                            <b>First name</b><br/><textarea rows="2" cols="80" type="text" name="firstName" >${user.firstName}</textarea><br>
                            <b>Last name</b><br/><textarea rows="2" cols="80" type="text" name="lastName" >${user.lastName}</textarea><br>
                            <b>E-mail:</b><br/><textarea rows="2" cols="80" type="text" name="email" >${user.email}</textarea><br>
                            <b>Adress:</b><br/><textarea rows="5" cols="80" type="text" name="address" >${user.address}</textarea><br>
                            <b>Office:</b><br/><textarea rows="5" cols="80" type="text" name="office" >${user.office}</textarea><br>
                            <b>Phone:</b><br/><textarea rows="2" cols="80" type="text" name="phone" >${user.phone}</textarea><br>
                            <b>Office hours:</b><br/><textarea rows="5" cols="80" type="text" name="officeHours" > ${user.officeHours}</textarea><br>
                            <b>Main interests:</b><br><textarea rows="5" cols="80" type="text" name="mainInterests" >${user.mainInterests}</textarea><br>
                            <b>CV</b><br/><textarea type="text" rows="5" cols="80" name="cv" >${user.cv}</textarea><br>                            
                            <input type="submit" value="  Submit  ">
                        </form>
                    </c:when>
                    <c:otherwise>

                        <b>E-mail:</b> ${user.email}<br/>
                        <b>Adress:</b> ${user.address}<br/>
                        <b>Office:</b> ${user.office}<br/>
                        <b>Phone:</b> ${user.phone}<br/>
                        <b>Office hours:</b> ${user.officeHours}<br/>
                        <br>Main interests:</b><br> ${user.mainInterests}<br/>
                        <br>
                        <b>CV</b>: ${user.cv}<br/>

                        <br>
                    </c:otherwise>
                </c:choose>
            </ul>
            <ul class="publikacje">
                <b>Publications:</b><br/>
                <c:choose>
                    <c:when test="${addingEnabled}">
                        <form action="/addPublication" method="post">
                            <textarea rows="2" cols="80" type="text" name="name" placeholder="write publication name"></textarea><br>
                            <textarea rows="2" cols="80" type="text" name="description" placeholder="write description"></textarea><br>
                            <input type="submit" value="Add">
                        </form>
                    </c:when>
                </c:choose>

                <c:forEach var="publication" items="${publications}"><br>
                    ${publication.name}<br>
                    ${publication.description}<br>
                </c:forEach> <br/>
            </ul>
            <ul class="konferencje">
                <b>Conferences:</b><br/>
                <c:choose>
                    <c:when test="${addingEnabled}">
                        <form action="/addConference" method="post">
                            <textarea rows="2" cols="80" type="text" name="name" placeholder="write conferences name"></textarea><br>
                            <textarea rows="2" cols="80" type="text" name="description" placeholder="write description"></textarea><br>
                            <input type="submit" value="Add"></input>
                        </form>
                    </c:when>
                </c:choose>

                <c:forEach var="conference" items="${conferences}"><br>
                    ${conference.name}<br>
                    ${conference.description}<br>
                </c:forEach> <br/>
            </ul>
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