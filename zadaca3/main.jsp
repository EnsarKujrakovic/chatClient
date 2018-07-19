
<!DOCTYPE html>
<html>
	<head>
		<title>ChatRoom</title>
		<link rel="stylesheet" href="style/chatapp.css">
	</head>
	<body onload="ChatClass.onLoad()">
	<div id="main">
		<div id=chanduname>
			<div id="channels">
				<button id="createChannelButton" class="button" onClick=ChatClass.popup()>Create new</button>
				<div id="popup" style="display:none">
					<form id=popupform method="post" action="createpopup" onsubmit="return false;">
						<input class="tbox" id="ctbox" type="text" name="channel" placeholder="channel name" />
						<input class="button" type="submit" value="Submit" />
					</form>
				</div>
			</div>
			<div id="username">
				<p><%=(String)session.getAttribute("username")%></p>
			</div>
		</div>
		<iframe name="hf" class="hf" style="position:absolute; border:0px; top:0px; left:0px; width:0px; height:0px;"></iframe>
		<div id="handm">
			<div id="history"method="post">${messg} </div>
			<div id="message">
				<form id="sendmsgform" target="hf" method="post" onsubmit="ChatClass.submitForm()">
					<input class="tbox" id="mtbox" type="text" name="message" autocomplete="off" placeholder="type here..." />
					<input id="submit" class="button" type="submit" value="Submit" />
				</form>
			</div>
		</div>
	</div>
		<script type="text/javascript" src="createchannel.js"></script>
		<script type="text/javascript" src="jquery-3.2.1.min.js"></script>
	</body>
</html>
