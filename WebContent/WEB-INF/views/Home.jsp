TESTING

<%-- <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>

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
</form>
<br>
<div class="">
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
</li>
<!-- <span id="totalAmount"></span> -->

