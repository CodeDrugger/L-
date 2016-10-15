<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>书目</title>
<style type="text/css">     
	a{
		text-decoration: none;
		color: #000000;
	}
	th.t2{background-color: #FFFFFF;}
	table.nav{
		height: 35px;
		width: 800px;
		margin-top: 80px;
		background-color: #00E5EE;
		font-family: 微软雅黑;
	}
	table.main{
		height: 550px;
		width: 800px;
		background-color: #FFFFFF;
		overflow: auto;
	}
	td.add{padding-right: 45px;}
	table.data{
		border-width: 1px;
		border-color: #000000;
		border-collapse: collapse;		
	}
	table.data th{
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #000000;
		background-color: #70AD47;
	}
	table.data td{
		border-width: 1px;
		padding: 6px;
		border-style: solid;
		border-color: #000000;
		text-align:center;
	}
	.odd{
		background-color:#C5E0B3;
	}
	.even{
		background-color:#E2EFD9;
	}
	input{color: white;border: none;width: 50px;}
	input.update{background-color: #87CEFA}
	input.delete{background-color: #FF4040}
	input.update:active{background-color: #4876FF}
	input.delete:active{background-color: red}
	div.update{float: left;}
	div.delete{float: right;}
	input.add{
		height: 28px;
		width: 60px;
		background-color: #66CD00;
		text-align: center;
		}
	input.add:active{background-color: green}
 </style>
<body>
<!-- 首页 书目 作者 关于 -->
<div style="position:absolute; width:100%; height:100%; z-index:-1; left:0; top:0;">    
<img width="100%" height="100%" style="left:0; top:0;" src="image/background.jpg">    
</div>
<table class="nav" align="center" border="0">
  <tr>
     <th class="t1"><a href="./mainpage.action">查&nbsp;&nbsp;询</a></th>
    <th class="t2"><a href="./book.action">书&nbsp;&nbsp;目</a></th>
    <th class="t3"><a href="./author.action">作&nbsp;&nbsp;者</a></th>
    <th class="t4"><a href="./about.action">关&nbsp;&nbsp;于</a></th></tr>
</table>
<table class="main" align="center" border="0">
  <tr><td>&nbsp;</td></tr>
  <tr align="right">
    <td class="add">
      <form class="add" action="add" method="get">
        <input class="add" type="submit" value="新增">
      </form>
    </td>
  </tr>
  <tr>
    <td align="center" valign="top">
      <table class="data" width="700" border="1">
        <tr>
          <th>ISBN</th>
          <th>Title</th>
          <th>AuthorID</th>
          <th>Publisher</th>
          <th>PublishDate</th>
          <th>Price</th>
          <th>Operation</th></tr>
        <s:iterator value="list" var="l" status="st">
          <s:if test="#st.odd">
            <tr class="odd">
              <td>${l.isbn }</td>
              <td>${l.title }</td>
              <td>${l.authorid }</td>
              <td>${l.publisher }</td>
              <td>${l.publishdate }</td>
              <td>${l.price }</td>
              <td class="op">
                <div class="update">
                  <form class="update" action="update">
                    <input type="hidden" value="${l.isbn}" name="book.isbn">
                    <input type="hidden" value="${l.title}" name="book.title">
                    <input type="hidden" value="${l.authorid}" name="book.authorid">
                    <input type="hidden" value="${l.publisher}" name="book.publisher">
                    <input type="hidden" value="${l.publishdate}" name="book.publishdate">
                    <input type="hidden" value="${l.price}" name="book.price">
                    <input class="update" type="submit" value="更新">
                  </form>
                </div>
                <div class="delete">
                  <form class="delete" action="delete">
                    <input type="hidden" value="${l.title}" name="book.title">
                    <input class="delete" type="submit" value="删除">
                  </form>
                </div>
                </td></tr>
          </s:if>
          <s:else>
            <tr class="even">
              <td>${l.isbn }</td>
              <td>${l.title }</td>
              <td>${l.authorid }</td>
              <td>${l.publisher }</td>
              <td>${l.publishdate }</td>
              <td>${l.price }</td>
              <td class="op">
                <div class="update">
                  <form class="update" action="update" method="get">
                    <input type="hidden" value="${l.title}" name="book.title">
                    <input class="update" type="submit" value="更新">
                  </form>
                </div>
                <div class="delete">
                  <form class="delete" action="delete" method="get">
                    <input type="hidden" value="${l.isbn}" name="book.isbn">
                    <input type="hidden" value="${l.title}" name="book.title">
                    <input type="hidden" value="${l.authorid}" name="book.authorid">
                    <input type="hidden" value="${l.publisher}" name="book.publisher">
                    <input type="hidden" value="${l.publishdate}" name="book.publishdate">
                    <input type="hidden" value="${l.price}" name="book.price">
                    <input class="delete" type="submit" value="删除">
                  </form>
                </div>
                </td></tr>
          </s:else>
        </s:iterator>
      </table>
  <tr>
    <td align="center">@2016 1140310425 党文杰</td></tr>
</table>
</body>
</html>