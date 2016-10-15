<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>更新</title>
<script type="text/javascript">
	function Clear(){
		document.getElementById("i1").value="";
		document.getElementById("i2").value="";
		document.getElementById("i3").value="";
		document.getElementById("i4").value="";
		document.getElementById("i5").value="";
		document.getElementById("i6").value="";
	}	
</script>
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
	table.utb td{text-align:center;}
	input.text{
		width: 300px;
		height: 25px;
		font-size: 15px;
	}
	input.submit{
		height: 25px;
		width: 80px;
		background-color: #66CD00;
		color: white;
		border: none;
	}
	input.reset{
		height: 25px;
		width: 80px;
		background-color: #FF4040;
		color: white;
		border: none;
	}
	input.submit:active{background-color: green;}
	input.reset:active{background-color: red;}
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
<table class="main" align="center">
  <tr><td align="center">&nbsp;${note }</td></tr>
  <tr>
    <td align="center">
      <form action="postupdate" method="get">
        <table class="utb" align="center" width="700" border="0">
          <tr>
            <td>ISBN:</td>
            <td><input class="text" id="i1" type="text" name="book.isbn" value="${book.isbn}" readonly="readonly"></td></tr>
          <tr>
            <td>Title:</td>
            <td><input class="text" id="i2" type="text" name="book.title" value="${book.title}" readonly="readonly"></td></tr>
          <tr>
            <td>AuthorID:</td>
            <td><input class="text" id="i3" type="text" name="book.authorid" value="${book.authorid}"></td></tr>
          <tr>
            <td>Publisher:</td>
            <td><input class="text" id="i4" type="text" name="book.publisher" value="${book.publisher}"></td></tr>
          <tr>
            <td>PublishDate:</td>
            <td><input class="text" id="i5" type="text" name="book.publishdate" value="${book.publishdate}"></td></tr>
          <tr>
            <td>Price:</td>
            <td><input class="text" id="i6" type="text" name="book.price" value="${book.price}"></td></tr>
            <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td></tr>
          <tr>
            <td>&nbsp;</td>
            <td>
              <input class="submit" type="submit" value="确定">&nbsp;&nbsp;
              <input class="reset" type="button" value="重置" onclick="Clear()">
            </td></tr>
        </table>
      </form>
    </td>
  </tr>
  <tr><td align="center">@2016 1140310425 党文杰</td></tr>
</table>
</body>
</html>