<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>关于</title>
<style type="text/css">     
	a{
		text-decoration: none;
		color: #000000;
	}
	th.t4{background-color: #FFFFFF;}
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
	form{margin-bottom: 130px;}
	input.text{
		height: 30px;
		width: 600px;
		font-size: 20px;
	}
	input.submit{
		height: 36px;
		font-size: 17px;
		font-family: 黑体;
		background-color: #4876FF;
		color: #FFFFFF;
		border: none;
	}
	li{text-align: left;}
 </style>
<body>
 
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
  <tr>
    <td align="center">
      <table class="info" align="center" border="0">
        <tr><td align="center">
          <ul>
            <li>在查询页面输入作者名进行查询;</li>
            <li>书目页包含所有的图书信息，用户可以进行添加、删除、更新操作;</li>
            <li>作者页包含所有作者信息。</li>
          </ul>
        </td></tr>
      </table>
      
    </td>
  </tr>
  <tr><td align="center">@2016 1140310425 党文杰</td></tr>
</table>
</body>
</html>