<%@ page language="java" 
	import="java.util.*, servelet.*"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="/studentManagementSystem/initial.css">
 <link rel="stylesheet" href="/studentManagementSystem/style.css">
  <script src="/studentManagementSystem/js/js2.js"></script>
</head>
<body>s
<div class="container">
    <div class="left">
        <ul class="u1">
            <li ><a class="active" href="">学生信息</a></li>
            <li><a href="">作品展示</a></li>
        </ul>


    </div>
    <div class="right">
        <div class="top">
            <div class="d4">
                <img src="img/logo.jpg" alt="">
            </div>
            	<% if(request.getSession().getAttribute("login") != null){ %>
				<span class="s1">尊敬的用户 <%=request.getSession().getAttribute("login") %>,欢迎登录系统
					
				</span>
			<%} else { %>
            <a class="a1" href="">登录</a>
            <a class="a2" href="">注册</a>
            <%} %>

        </div>
        <div class="center">
            <div class="d5">
                <div class="search">
                    <input class="searchInformation" type="text"><button class="searchBtn">search</button>
                </div>
                <button class="add">增加</button>
<!--                <table class="imagetable">-->
<!--                    <tr>-->
<!--                        <th>Info Header 1</th><th>Info Header 2</th><th>Info Header 3</th><th>Info Header 3</th><th>Info Header 3</th>-->
<!--                    </tr>-->
<!--                    <tr>-->
<!--                        <td>Text 1A</td><td>Text 1B</td><td>Text 1C</td><td>Text 1C</td><td>Text 1C</td><td><button class="b1 changeBtn">修改</button><button class="b1">删除</button></td>-->
<!--                    </tr>-->
<!--                    <tr>-->
<!--                        <td>Text 2A</td><td>Text 2B</td><td>Text 2C</td><td>Text 1C</td><td>Text 1C</td>-->
<!--                    </tr>-->
                
                                <table class="imagetable">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>姓名</th>
                                        <th>性别</th>
                                        <th>作品名称</th>
                                        <th>成绩</th>
                
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                    ArrayList list = (ArrayList)request.getAttribute("list");
                                    for(int i = 0; i < list.size(); i++){
                                    items item = (items)list.get(i);
                                    %>

                                    <tr>
                                        <td><%=item.id%></td>
                                        <td><%=item.name%></td>
                                        <td><%=item.sex%></td>
                                        <td><%=item.workName%></td>
                                        <td><%=item.score%></td>
                                        <td>
                                            <button class="b1 changeBtn">修改</button>
                                         
                                            <a href="/studentManagementSystem/items/delete?id=<%=item.id%>">删除</a>
                                        </td>
                                    </tr>
                                    <%}%>
                                    </tbody>
                                </table>


            </div>



        </div>



    </div>
</div>
<div style="display: none" class="changeWindow">
    <img class="img1" src="img/close.png" alt="">
    <div class="D6">
        <label for="DID">ID：</label>
        <input type="text"
               id="DID"
               name="DID"
               disabled="true"
        />

    </div>
    <div class="D6">
        <label for="Dname">姓名：</label>
        <input type="text"
               id="Dname"
               name="Dname"
        />

    </div>
    <div class="D6">
        <label for="Dsex">性别：</label>
        <input type="text"
               id="Dsex"
               name="Dsex"
        />

    </div>
    <div class="D6">
        <label for="DworkName">作品名称：</label>
        <input type="text"
               id="DworkName"
               name="dworkName"
        />

    </div>
    <div class="D6">
        <label for="Dscore">成绩：</label>
        <input type="text"
               id="Dscore"
               name="Dscore"
        />

    </div>
    <button class="db1">提交</button>

</div>
<div style="display: none" class="addWindow">
    <img class="img2" src="img/close.png" alt="">
    
    <div class="D6">
        <label for="Aname">姓名：</label>
        <input type="text"
               id="Aname"
               name="Aname"
        />

    </div>
    <div class="D6">
        <label for="Asex">性别：</label>
        <input type="text"
               id="Asex"
               name="Asex"
        />

    </div>
    <div class="D6">
        <label for="AworkName">作品名称：</label>
        <input type="text"
               id="AworkName"
               name="AworkName"
        />

    </div>
    <div class="D6">
        <label for="Ascore">成绩：</label>
        <input type="text"
               id="Ascore"
               name="Ascore"
        />

    </div>
    <button class="db1 addBtn">提交</button>

</div>


<a style="display: none" class="funA" href=""></a>
</body>
</html>