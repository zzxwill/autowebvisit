<%@ page language="java" import="java.util.*,java.net.URL,java.sql.*" pageEncoding="UTF-8"%>

<%@page import="database.*" %>
<%@ include file="../check/index.jsp"%> 
<%@ include file="../check/checkAdmin.jsp"%>  

<table width="100%" align="center" border="1" cellpadding="0" cellspacing="0" rules=rows>
	<tr align="center" bgcolor="#D5D5D5">
		<td align="center"><strong>用户编号</strong></td>
		<td align="center"><strong>用户名</strong></td>
		<td align="center"><strong>电 &nbsp;话</strong></td>
		<td align="center"><strong>权 &nbsp;限</strong></td>
		<td align="center"><strong>状&nbsp;态</strong></td>
		<td align="center"><strong>编&nbsp;辑</strong></td>
	</tr>
	<%
	UserDao userAdminDao = new UserDao();
	int userNum = 0;
	userNum = userAdminDao.getUserNum();
	
	int id = 0;
	for(id=1;id<=userNum;id++){
		userAdminDao.getUserInfo(id);
	%>

	<tr align="center" >
		<td align="center"><%=id %></td>
		<td align="center"><%=userAdminDao.UserName %></td>
		<td align="center"><%=userAdminDao.UserTel %></td>
		<td align="center">
			<%=(userAdminDao.UserGroup==1)?"管理员":"普&nbsp;通" %>				
		</td>
		<td align="center" >
			<%=(userAdminDao.IsUserDel(id)==1)?"<p style='color: red;'>禁&nbsp;用</p>":"<p style='color: green;'>正&nbsp;常</p>" %>
		</td>
		<td align="center" valign="middle" >
				
			<form class="form-horizontal" id="userForm<%=id %>" method="post" action="../admin/editUserInfo.jsp?type=edit&userId=<%=id %>">	
				<div class="view"> 
			       <!-- Button to trigger modal --> 
			       <div align="right">
			       <center><a id="myModalLinkUser<%=id %>" href="#myModalContainerUser<%=id %>" role="button" class="btn btn-primary" data-toggle="modal">编辑</a> </center>
			       </div>
			       <!-- Modal -->
			       <div id="myModalContainerUser<%=id %>" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabelUser<%=id %>" aria-hidden="true">
			         <div class="modal-header">
			           <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			           <h3 id="myModalLabelUser<%=id %>" contenteditable="true">编辑用户信息</h3>
			         </div>
			         
					<div class="modal-body">
					
<script>
    function checkEditUserInput(TelId)
    {
       //alert(TelId);
	   var telephoneEdit = document.getElementById('telephone'+TelId).value; 
	   var message = null;
	   var msg = document.getElementById("msgUser"+TelId);
	   var flag = 1;   
	   if(null==telephoneEdit||telephoneEdit == ""){
			  flag = 0;
		 	  message = "请输入正确的电话！";
			  msg.innerHTML = "<a style='color:red;'>" + message + "</a>";
			  //alert(message);
	   }
	   if(flag==1){
	      //var addrForm = document.forms("addrForm");
	      var userForm = document.getElementById("userForm"+TelId);
	      userForm.submit(); 
	   }
    }

</script>
					
					<div align="center" style="color: red">密码若不修改请勿填写！</div>
					<table width="58%" align="center" border="0" cellpadding="0" cellspacing="0">
						<tr style="color: #CC3300">
							<td align="left" width="25%">删除用户:</td>
							<td align="center" width="70%">
							<table width="100%">
								<tr>
								<%
								if(userAdminDao.IsUserDel(id)==1){
								%>
									<td align="right" width="25%">否</td>
									<td valign="middle" align="left" width="20%">
										<input type="radio" name="radio<%=id %>" value="0"></td>
		
									<td align="right" width="25%">是</td>
									<td valign="middle" align="left" width="20%">
										<input type="radio" checked name="radio<%=id %>" value="1"></td>
								<%
								}else{
								%>
									<td align="right" width="25%">否</td>
									<td valign="middle" align="left" width="20%">
										<input type="radio" checked name="radio<%=id %>" value="0"></td>
		
									<td align="right" width="25%">是</td>
									<td valign="middle" align="left" width="20%">
										<input type="radio" name="radio<%=id %>" value="1"></td>
								
								<%} %>
									<td align="right" width="10%">&nbsp;</td>
								</tr>
							</table>
							</td>
							<td width="5%"><a style="color: red;">&nbsp;&nbsp;*</a></td>
						</tr>
						<tr>
							<td align="left" width="25%">用户名:</td>
							<td align="center" width="70%">
								<input style="height: 30px" type="text" name="username<%=id %>" id="username<%=id %>" style="width:90%;" value="<%=userAdminDao.UserName %>" disabled="disabled" /></td>
							<td width="5%"><a style="color: red;">&nbsp;&nbsp;*</a></td>
						</tr>
						<tr>
							<td align="left" width="25%">密 &nbsp;码:</td>
							<td align="center" width="70%">
								<input style="height: 30px" type="password" name="password<%=id %>" style="width:90%;" /></td>
							<td width="5%"><a style="color: red;">&nbsp;&nbsp;*</a></td>
						</tr>
						<tr>
							<td align="left" width="25%">电 &nbsp;话:</td>
							<td align="center" width="70%">
								<input style="height: 30px" type="text" id="telephone<%=id %>" name="telephone<%=id %>" style="width:90%;" value="<%=userAdminDao.UserTel %>" /></td>
							<td width="5%"><a style="color: red;">&nbsp;&nbsp;*</a></td>
						</tr>
						<tr>
							<td align="left" width="25%">权 &nbsp;限:</td>
							<td align="center" width="70%">
							<table width="100%" border="0" cellpadding="0" cellspacing="0" >
								<tr>
								<%
								if(userAdminDao.UserGroup==1){
								%>
									<td align="right" width="25%">普通</td>
									<td valign="middle" align="left" width="20%">
										<input type="radio"  name="authority<%=id %>" value="0"></td>
		
									<td align="right" width="25%">管理员</td>
									<td valign="middle" align="left" width="20%">
										<input type="radio" checked name="authority<%=id %>"value="1"></td>
								
								<%
								}else{
								%>
									<td align="right" width="25%">普通</td>
									<td valign="middle" align="left" width="20%">
										<input type="radio" checked name="authority<%=id %>"value="0"></td>
		
									<td align="right" width="25%">管理员</td>
									<td valign="middle" align="left" width="20%">
										<input type="radio" name="authority<%=id %>"value="1"></td>
								<%} %>
									<td align="right" width="10%">&nbsp;</td>
								</tr>
							</table>
							</td>
							<td width="5%"><a style="color: red;">&nbsp;&nbsp;*</a></td>
						</tr>
					</table>
					
					</div>
			         
			         <div class="modal-footer">
			         <table width="95%">
			         	<tr>
			         		<td width="66%" align="center" valign="top">&nbsp;
			         			<div id="msgUser<%=id %>"></div>
			         		</td>
			         		<td width="17%" align="center"  valign="bottom">
			          			 <button class="btn" data-dismiss="modal" aria-hidden="true" contenteditable="true">取消</button>
			          		</td>
							<td width="17%" align="center"  valign="bottom">
			           			<input class="btn btn-primary" type="button" value="保存设置"  onclick="checkEditUserInput(<%=id %>)"/>
			           		</td>
			           	</tr>
			          </table>
			         </div>
			       </div>
			     </div>
			</form>

		</td>
	</tr>
	<%} %>
</table>
