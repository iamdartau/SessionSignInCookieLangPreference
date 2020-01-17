<%@ page import="java.util.ArrayList" %>
<%@ page import="models.News" %>
<%@ page import="models.User" %>
<%@ page import="javax.jws.soap.SOAPBinding" %>
<%@ page import="dao.Dbmanager" %><%--
  Created by IntelliJ IDEA.
  User: Alexey.Dartau
  Date: 17.01.2020
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    User user = (User) request.getSession().getAttribute("user_data");
    ArrayList<News> news = Dbmanager.getAllNews();
    out.print(user.getLogin());
    Cookie []cookies = request.getCookies();
    for (Cookie c :
            cookies) {
        if(c.getValue().equals("kaz")){
            for (News n: news
                 ) {
                if(n.getId() == 1){
                    out.print("     " + n.getNewsText());
                }
            }
        }else if (c.getValue().equals("rus")){
            for (News n: news
                 ) {
                if(n.getId() == 2){
                    out.print("  " + n.getNewsText());
                }
            }
        }else if(c.getValue().equals("eng")){
            for (News n: news
                 ) {
                if(n.getId() ==3){
                    out.print("  " + n.getNewsText());
                }
            }
        }
    }


%>

<a href="/Logout">log out</a>
</body>
</html>
