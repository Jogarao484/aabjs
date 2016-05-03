TESTING

<%-- <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>

<%@page import="javassist.bytecode.stackmap.BasicBlock.Catch"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-xs-9 banner-body-right">

<c:forEach var="items" items="${foodItems}">
	<div class="blog-grid">
		<div class="col-xs-4 blog-grid-left">
			<a href="single.html"><!-- <img src="images/1.jpg" alt=" " class="img-responsive" /> -->
			<img src="${pageContext.servletContext.contextPath }/skydiningnew?foodId=${items.foodId}" class="img-responsive"/></a>
		</div>
		<div class="col-xs-8 blog-grid-right">
			<h4>
				<a href=""><c:out value="${items.foodName}"></c:out></a>
			</h4>
			<p><c:out value="${items.description}"></c:out></p>
			<a href="single.html"><span class="glyphicon glyphicon-plus"
				aria-hidden="true">ADD</span></a><br> ${foodMenu} Menu
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${message}
		</div>
		<div class="clearfix"></div>
	</div>
</c:forEach>
</div>

<%-- <table id="object-list" class="display" border="1">
	<thead>
		<tr>
			<td colspan="7" align="center">${foodMenu}Menu
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
				<%
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
				%>
				<td><img
					src="${pageContext.servletContext.contextPath }/skydiningnew?foodId=${items.foodId}" /></td>
				<td><img alt="Sorry No image found" src="<c:out value="${items.fileData}"></c:out>"></td>
				<td><a href="AddItems.htm?foodId=${items.foodId}&foodCategory=${items.foodCategory}&description=${items.description}&imageName=${items.imageName}&fileType=${items.fileType}&cost=${items.cost}">Update</a></td>
						    		<td><a href="deleteItems.htm?foodId=${items.foodId}" onclick="return confirm('Are you sure Do You want to DELETE this Food Item?')">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table> --%>
<%-- <br><br><br><br>
<form method="post" action="AddItems.htm" commandName="document" enctype="multipart/form-data">
	<table border="1">
		<tr>
			<td colspan="2"><b>${message}</b><span id="filePath"></span></td>
		</tr>
		<tr>
			<th>FOOD_CATEGORY</th>
			<td><input type="text" value="SnacksItems" name="foodCategory"></td>
		</tr>
		<tr>
			<th>FOOD_NAME</th>
			<td><input type="text" name="foodName"></td>
		</tr>
		<tr>
			<td>DESCRIPTION</td>
			<td><textarea rows="4" cols="15" name="description"></textarea></td>
		</tr>
		<tr>
			<th>FILE_DATA</th>
			<td><input type="file" name="file" id="file"></input></td>
		</tr>
		<tr>
			<th>COST</th>
			<td><input type="text" name="cost"></td>
		</tr>
		<tr>
			<td><input type="reset" value="RESET"></td>
			<td><input type="submit" value="SUBMIT" class="submit"></td>
		</tr>
	</table>
</form> --%>
<br>
<!-- <div class="">
	<div class="foodAmtPlus"><input type="number" value="200" id="amtPlus"><img alt="image not available" src=""></div>
	<div class="foodAmtMinus"><input type="number" value="100" id="amtMinus"><img alt="image not available" src=""></div>
	<span id="totalAmountdiv"></span>
</div>

<li data-index="1">
	<div class="details">
		<div class="nveg-tag" data-icon="ǝ"></div>
		<span class="name"> <a class="edit " data-item_id="10670292">Egg
				Biryani</a>
		</span>
	</div>
	<ul class="options">
		<li><span class="variant-name">Quantity -</span> <span
			class="description">Regular</span></li>
	</ul>
	<div class="count ib left clear ">
		<div class="super_number mr5" data-item_id="10670292">
			<div class="dec" data-icon=""></div>
			<input type="text" value="1" disabled="">
			<div class="inc" data-icon=""></div>
		</div>
		<div class="quantity left pl10 ">x Rs.145.00</div>
	</div>
	<div class="price item-price ">Rs.145.00</div>
	<div class="clear"></div>
</li> -->
<!-- <span id="totalAmount"></span> -->

