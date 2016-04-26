/*For Food Amount Calculations*/

$(document).ready(function(){
	$(".foodAmtPlus").click(function(){
		var foodAmount = 0;
		foodAmount = $("#amtPlus").val();
		/*alert("food "+foodAmount);*/		
		var totalAmount = $("#totalAmount").val();
		if(totalAmount==null){
			totalAmount = 0;
		}			
		var total = (totalAmount+foodAmount);
		alert(total)
		$("#totalAmountdiv").html(0);
		$("#totalAmountdiv").html("<input type='number' value='"+(total)+"' id='totalAmount'>");
		/*alert("total"+totalAmount+foodAmount);*/
	});
	
	$(".foodAmtMinus").click(function(){
		var foodAmount = 0;
		foodAmount = $("#amtMinus").val();
		/*alert(foodAmount)
		alert("food "+foodAmount);*/
		var totalAmount = $("#totalAmount").val();
		var total = totalAmount+foodAmount;
		alert(total)
		if(totalAmount>foodAmount){
			$("#totalAmountdiv").html(0);
			$("#totalAmountdiv").html("<input type='number' value='"+total+"' id='totalAmount'>");
		}else{
			$("#totalAmountdiv").html(0);
			$("#totalAmountdiv").html("<input type='number' value='"+total+"' id='totalAmount'>");
		}
		/*alert("total"+totalAmount-foodAmount);*/
	});
});

/* End Code For Food Amount Calculations*/

/*File Uploading */
$(document).ready(function(){
	$(".submit").click(function(){
		var val = $("#file").val();
		$("#filePath").html("<input type='hidden' name='filePath' value="+val+">");		
	});
});

/* End File Uploading */
