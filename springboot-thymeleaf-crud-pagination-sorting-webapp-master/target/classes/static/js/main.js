/**
 * 
 */
$(document).ready(function() {


	
	$('.table .delBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#myModal #delRef').attr('href', href); 
		$('#myModal').modal();
		console.log("delBtn");
	});
	
	
	
		$('.formdel .deleteBtn').on('click', function(event) {
		event.preventDefault();
		var hrefDel = $(this).attr('href');
		$('#myModalDel #deleteRef').attr('href',  hrefDel);  
		$('#myModalDel').modal();
		console.log("Delete btn main2.js");
	});
	
	
	
	
	
	
	
	
	$('#updateId .updateBtn').on('click', function(event) {
	/** 	event.preventDefault();
		var hrefUpdate = $(this).attr('href');
		$('#myModalUpdate #updateref').attr('href', hrefUpdate);
		$('#myModalUpdate').modal(); */
		console.log("updateBtn");
	});
	

	// $('#myTable').DataTable();

});