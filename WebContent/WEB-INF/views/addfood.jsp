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