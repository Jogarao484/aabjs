<%@page import="javassist.bytecode.stackmap.BasicBlock.Catch"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@page import="java.io.IOException,java.io.OutputStream,org.apache.commons.io.IOUtils" %> --%>
<table id="object-list" class="display" border="1">
	<thead>
		<tr>
			<td colspan="7">${foodMenu} Menu
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${message}</td>
		</tr>
		<tr>
			<td>Food ID</td>
			<td>Food Category</td>
			<td>Description</td>
			<td>Image Name</td>
			<td>File Type</td>
			<td>Cost</td>
			<td>Image</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="items" items="${foodItems}">
			<tr style="cursor: pointer" onmouseover="this.background='#C0C0C0'">
				<td><c:out value="${items.foodId}"></c:out></td>
				<td><c:out value="${items.foodCategory}"></c:out></td>
				<td><c:out value="${items.description}"></c:out></td>
				<td><c:out value="${items.imageName}"></c:out></td>
				<td><c:out value="${items.fileType}"></c:out></td>
				<td><c:out value="${items.cost}"></c:out></td>
				<%-- <%
					try{
							response.setHeader("Content-Disposition", "inline;filename=\""+"${items.imageName}" + "\"");
							OutputStream out1 = response.getOutputStream();
							/* response.setContentType(${items.fileType()}); */
							/* IOUtils.copy(items.getContent().getBinaryStream(), out1); */
							out1.flush();
							out1.close();
						}catch(Exception e){
							e.printStackTrace();
						}
				%> --%>
				<td><img src="${pageContext.servletContext.contextPath }/skydiningnew?foodId=${items.foodId}" /></td>
				<td><img alt="Sorry No image found" src="<c:out value="${items.fileData}"></c:out>"></td>
				<%-- <td><a href="AddItems.htm?foodId=${items.foodId}&foodCategory=${items.foodCategory}&description=${items.description}&imageName=${items.imageName}&fileType=${items.fileType}&cost=${items.cost}">Update</a></td>
						    		<td><a href="deleteItems.htm?foodId=${items.foodId}" onclick="return confirm('Are you sure Do You want to DELETE this Food Item?')">Delete</a></td> --%>
			</tr>
		</c:forEach>
	</tbody>
</table>


