/**
 * 
 */
function login() {
	$.ajax({
		type: "POST",
		url: "http://localhost:7070/login",
		data: {
			user_name : $('#user_name').val(),
			password : $('#password').val()
		},
		dataType: "text",
		success: function(data){
			if (data == "dummy"){
				alert("error");
			}
			else {
				alert("success");
				window.name = data;
				window.location.replace('./home.html');
			}
		},
		error: function(){
			alert("error");
		}
	});
}

function register() {
	$.ajax({
		type: "POST",
		url: "http://localhost:7070/register",
		data: {
			userName : $('#user_name').val(),
			firstname : $('#first_name').val(),
			last : $('#last_name').val(),
			password : $('#password').val()
		},
		dataType: "text",
		success: function(data){
			if (data == "dummy" || data == null || data == ""){
				alert("error");
			}
			else {
				alert("success");
			}
		},
		error: function(){
			alert("error");
		}
	});
}

function isUserNameAvailable(username) {
	if (username == ""){
		return;
	}
	$.ajax({
		type: "GET",
		url: "http://localhost:7070/isUsernameAvailable",
		data: {
			userName: username
		},
		dataType: "text",
		success: function(data){
			if (data == "false" || data == null || data == ""){
				$('#user_name_validity').html('UNAME ALREADY TAKEN');
				$('#register_btn').prop('disabled', true);
			}
			else {
				$('#user_name_validity').html('UNAME AVAILABLE');
				$('#register_btn').prop('disabled', false);
			}
		},
		error: function(){
			alert("error");
		}
	});
}


function getDetails(){
	$.ajax({
		type: "POST",
		url: "http://localhost:7070/getDetails",
		data: {
			token_id: window.name
		},
		dataType: "text",
		success: function(data){
			$('#first_name').html(data.firstName);
		},
		error: function(){
			alert("error");
		}
	});
}