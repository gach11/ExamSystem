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
	
	
	
	
	$('#updateId .updateBtn').on('click', function(event) {
	/** 	event.preventDefault();
		var hrefUpdate = $(this).attr('href');
		$('#myModalUpdate #updateref').attr('href', hrefUpdate);
		$('#myModalUpdate').modal(); */
		console.log("updateBtn");
	});
	

	// $('#myTable').DataTable();

});