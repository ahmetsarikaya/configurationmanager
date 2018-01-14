
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Konfigürasyon Yönetimi</title>
<script src="webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		type : "GET",
		url : "/data/all-configs",
		success: function(result){
			$.each(result, function(i, config){
				
				var configRow = '<tr>' +
									'<td>' + config.id + '</td>' +
									'<td>' + config.name + '</td>' +
									'<td>' + config.type + '</td>' +
									'<td>' + config.value + '</td>' +
									'<td>' + config.active + '</td>' +
									'<td>' + config.applicationName + '</td>'+
								  '</tr>';
				
				$('#configTable tbody').append(configRow);
				
	        });
			
			$( "#configTable tbody tr:odd" ).addClass("info");
			$( "#configTable tbody tr:even" ).addClass("success");
		},
		error : function(e) {
			alert("ERROR: ", e);
			console.log("ERROR: ", e);
		}
	});
	
	$('#search_field').on('keyup', function() {
					var value = $(this).val();
					var patt = new RegExp(value, "i");
					$('#configTable tbody').find('tr').each(function() {
						if (!($(this).find('td').text().search(patt) >= 0)) {
							$(this).not('.myHead').hide();
						}
						if (($(this).find('td').text().search(patt) >= 0)) {
							$(this).show();
						}
					});
				});

			});
</script>
</head>
<body>
	<div class="container">
		<input type="text" class="form-control"  placeholder="Search..." id="search_field">
		
		<table id="configTable"
			class="table table-bordered table-hover table-responsive">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Type</th>
					<th>Value</th>
					<th>IsActive</th>
					<th>Application Name</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
	</div>
</body>
</html>