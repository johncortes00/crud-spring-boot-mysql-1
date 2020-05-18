function eliminar(id){
	swal({
		  title: "Are you sure of delete it?",
		  text: "Once deleted, you will not be able to recover this record!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				  url:"/delete/"+id,
				  success: function(res){
					  console.log(res);
				  }
			  });
		    swal("Poof! Your record has been deleted!", {
		      icon: "success",
		    }).then((OK)=>{
		    	if(OK){
		    		location.href="/list";
		    	}
		    });
		  } else {
		    swal("Your record is safe!");
		  }
		});	
}

