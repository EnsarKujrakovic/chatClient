var ChatClass = {
	cCB : document.getElementById("createChannelButton"),
	popup_show: function(){
					ChatClass.cCB.innerHTML = "Cancel";
					document.getElementById("popup").style.display = "block";
				},
	popup_hide: function (){
					ChatClass.cCB.innerHTML = "Create new";
					document.getElementById("popup").style.display = "none";
				},
	popup : function (){
			if(ChatClass.cCB.innerHTML == "Create new")
				ChatClass.popup_show();
			else
				ChatClass.popup_hide();
			},
	update: function(){
				$( "#history" ).load( "msg #messagehistory");
				setTimeout(ChatClass.update, 500);
			},
	submitForm: function (){
					$.ajax({
						url:'snd',
						type:'post',
						data:$('#sendmsgform').serialize(),
						success:function(){
							document.getElementById("mtbox").value = null;
						}
					});
				},
	onLoad: function (){
				ChatClass.update();
			}
			
};
