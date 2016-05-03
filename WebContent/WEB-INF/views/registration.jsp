<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<table>
	<thead>
		<tr>
			<th colspan="2">Sign Up</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>User Name</th>
			<td><input type="text" name="userName" required="required"></td>
		</tr>
		<tr>
			<th>Email</th>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<th>User Role</th>
			<td>
				<select name="userRole">
					<option value=""></option>
					<option value="Admin">Admin</option>
					<option value="Customer">Customer</option>					
				</select>
			</td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Register"></td>
		</tr>
	</tbody>
</table>


<%-- <form:form method="POST">
<table>
    <tr>
        <td>User Name :</td>
        <td><form:input path="userName" /></td>
    </tr>
    <tr>
    	<td>Email :</td>
    	<td><form:input path="email"/></td>
    </tr>
    <tr>
    	<td>User Role :</td>
    	<td>
    		<form:select path="userRole">
    			<form:option value="Admin" label="Admin"></form:option>
    			<form:option value="Customer" label="Customer"></form:option>
    		</form:select>
    	</td>
    </tr>
    <tr>
        <td>Password :</td>
        <td><form:password path="password" /></td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit" value="Register"></td>
    </tr>
</table>
</form:form> --%>