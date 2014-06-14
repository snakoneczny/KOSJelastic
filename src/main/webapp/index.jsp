<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
    <head>
        <meta charset="UTF-8">
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
                <%@include file="session_test.jsp" %>
            </ul>
        </div>
        <div id="tresc">

            <p align="center" style="margin: 20; margin-right: 5mm; margin-left: 5mm" >
                <img border="0" src="./static/image/wmii.jpg" align="left" width="200" height="200" alt="Collegium Maius" style="margin: 20; margin-right: 5mm" >
            </p>


            <p style="margin-left: 200; margin-top: 6; margin-bottom: 20; padding: 5mm; margin-left: 5mm ">
                <font face="Arial" size="4">Welcome to Chair of Optimization and Control</font>
            </p>

            <p align="justify" style="margin-left: 170; margin-top: 4; margin-bottom: 20; margin-right: 40; padding: 5mm; margin-left: 5mm">
                <font face="Arial" size="2">
                This website reflects both research and scientific activity in the area of computer
                science and mathematics, and experience in teaching at Jagiellonian University
                of a group of people working at the Chair of Optimization and Control.
                Our group in engaged in research in computer science and mathematics.
                </font>
            </p>

            <p align="justify" style="margin-left: 170; margin-top: 4; margin-bottom: 20; margin-right: 40; padding: 5mm">
                <font face="Arial" size="2">
                In Computer Science we are concerned with the modeling, analysis, design, algorithmics and applications
                of computer-related systems. We actively participate in educational programs which provide comprehensive
                and strongly related studies of subjects in artificial intelligence, computer science theory,
                computer system architecture, computer network modeling and analysis, programming languages,
                and scientific computing. We foster research related to databases, software engineering,
                parallel and distributed computations, and dynamics of multi-agent systems.
                </font>
            </p>

            <p align="justify" style="margin-left: 20; margin-top: 4; margin-bottom: 20; margin-right: 40; padding: 5mm">
                <font face="Arial" size="2">
                Within Mathematics and Computational Mathematics our group aims to provide courses that
                introduce students to the fundamentals of maths and allow them to master the most important parts
                of the subject, both pure and applied. In Mathematics our research topics include
                differential equations, nonlinear analysis, calculus of variations,
                mathematical modeling, applications of maths to biology, mechanics and economics.
                </font>
            </p>

            <p align="justify" style="margin-left: 20; margin-top: 4; margin-bottom: 20; margin-right: 40; padding: 5mm">
                <font face="Arial" size="2">
                All students from many different backgrounds who wish to enter the courses
                of our group are warmly welcomed. We offer students the unique possibility
                to participate in interdisciplinary programs and conduct high level research
                in computer science and mathematics.

                Most of us have double degrees in computer science and mathematics.
                We have background in mathematical sciences and research contacts with
                physicists and engineering scientists. We lead doctoral students to the frontiers
                of mathematical research, where they can begin to push back those frontiers.


            <p align="justify" style="margin-left: 20; margin-top: 4; margin-bottom: 5; margin-right: 40; padding: 5mm">
                <font face="Arial" size="2">
                <b>News:</b>

            

            <p align="justify" style="margin-left: 20; margin-top: 4; margin-bottom: 20; margin-right: 40; padding: 5mm">
                <font face="Arial" size="2">
                (1) According to the protocol of the 35th Session of the Poland-China Scientific
                and Technological Cooperation Committee, held in Beijing on November 21, 2012,
                the project no 35-7 on
                <a style="text-decoration: none; color: #A52A2A"
                   href="http://www.nauka.gov.pl/ministerstwo/wspolpraca-z-zagranica/wspolpraca-dwustronna/mapa-swiata/chrl/chrl/artykul/35-posiedzenie-polsko-chinskiej-komisji-ds-wspolpracy-naukowo-technicznej/">
                    "Nonlinear Differential Equations for Multivalued and Nonsmooth Systems with Applications"
                </a>
                submitted by the Chair of Optimization and Control
                has been approved and selected for implementation in 2013-2014. This project is in
                accordance with priority fields for S&T cooperation of both countries.


            <p align="justify" style="margin-left: 20; margin-top: 4; margin-bottom: 20; margin-right: 40; padding: 5mm">
                <font face="Arial" size="2">
                (2) Two world-renowned distinguished scientists Professor Weimin Han (the University of
                Iowa, USA)
                and Professor Mircea Sofonea (University of Perpignan Via Domitia, France)
                are nominated for appointment as
                <a style="text-decoration: none; color: #A52A2A"
                   href="http://www.set.uj.edu.pl/profesorowie-wizytujacy/nabor/wyniki-naboru-3-edycja-listopad-2012">
                    the 2013 Visiting Professors </a>
                at the Chair of Optimization and Control of the Institute of Computer Science supported
                by
                <a style="text-decoration: none; color: #A52A2A"
                   href="http://www.set.uj.edu.pl/en_GB/rok-2013">
                    the SET Project.</a>

                The series of lectures by Professor Mircea Sofonea took place on May 17-27, 2013
                at the Conference Room no 1146 at the Institute of Computer Science, according to the
                <a style="text-decoration: none; color: #A52A2A"
                   href="http://www.ii.uj.edu.pl/~migorski/Forstudents.html">
                    schedule.</a>

                We invite all Master students, PhD students, young doctors and faculty members to
                lectures of
                Professor Weimin Han which will take place on March 17-21, 2014 at the Institute of
                Computer Science.
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