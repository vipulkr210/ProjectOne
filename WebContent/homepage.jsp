<script  src="https://code.jquery.com/jquery-3.1.1.min.js"  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="  crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" ></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<%@taglib prefix="v" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/functions" %>
        <div class="body">
		<center>
		<div class="submit">
                   <%if(session.getAttribute("role") != null && session.getAttribute("role").equals("IT_ADMIN")){%>
                   <form action="user" method="post">
                        <input type="hidden" name="access" value="listCompany">
                        <input type="submit" value="View Company">
                    </form>
                        <%} else {%>
                        <form action="company" method="post">
                        <input type="hidden" name="access" value="getCompany">
                        <input type="submit" value="View Company">
                    </form>
                        <%}%>
                </div>
                <div class="submit" >
                    <form action="user" method="post">
                        <input type="submit" value="LOGOUT">
                        <input type="hidden" name="access" value="logout">
                    </form>
                </div><div class="veen">
			<div class="login-btn splits" style="width:200px;height:100px">

                            
                                <button class="active" >Add Company</button>
			</div>
                    <div class="wrapper" style="width: 500px;">
				<form id="login" tabindex="500" action="company" method="post">
					<h3>Add Company</h3>
					<input type="hidden" name="access" value="register">
					<input type="hidden" name="userId" value="<%=session.getAttribute("userId")%>">
						<div class="uid">
						<input type="text" name="cName">
                                                <label>Company Name</label>
					</div>
                                        <div class="uid">
						<input type="text" name="address">
						<label>Company Address</label>
					</div>
                                        <div class="uid">
                                            <input type="text" name="createdBy" <%if(session.getAttribute("role") != null && session.getAttribute("role").equals("IT_ADMIN")){%> value="<%=session.getAttribute("role")%>" readonly="readonly"<%} else {%> value="<%=session.getAttribute("name")%>"<%}%>>
						<label>Created By</label>
					</div>
					<div class="submit">
						<input type="submit" value="Register">
					</div>
				</form>
                      
                    </div>
                </div>                              
                                                
      	
	</div>

<<script type="text/javascript">
console.info("hii");
$(document).ready(function(){
	$(".veen .rgstr-btn button").click(function(){
		$('.veen .wrapper').addClass('move');
		$('.body').css('background','#e0b722');
		$(".veen .login-btn button").removeClass('active');
		$(this).addClass('active');

	});
	$(".veen .login-btn button").click(function(){
		$('.veen .wrapper').removeClass('move');
		$('.body').css('background','#ff4931');
		$(".veen .rgstr-btn button").removeClass('active');
		$(this).addClass('active');
	});
});
<!--

//-->
</script>
	<style type="text/css">
            
            .popup {
    display: inline-table;
}
.popup .popuptext {
    visibility: hidden;
    width: 400px;
    background-color: #fff;
    color:#000;
    text-align: center;
    border-radius: 6px;
    padding: 20px;
    position:relative;
    top:-100px;
    right:150px;
}
.popup .show {
    visibility: visible;
    -webkit-animation: fadeIn 1s;
    animation: fadeIn 1s;
}
.popup .hide {
    visibility: collapse;
    -webkit-animation: fadeIn 1s;
    animation: fadeIn 1s;
}
	.body{
			background: #ff4931;
			transition: all .5s;
			padding: 1px;
		}
		.veen{
			width: 70%;
			margin: 100px auto;
			background: rgba(255,255,255,.5);
			min-height: 400px;
			display:table;
			position: relative;
			box-shadow: 0 0 4px rgba(0,0,0,.14), 0 4px 8px rgba(0,0,0,.28);
		}
		.veen > div {
			display: table-cell;
			vertical-align: middle;
			text-align: center;
			color: #fff;
		}
		.veen button{
			background: transparent;
			display: inline-block;
			padding: 10px 30px;
			border: 3px solid #fff;
			border-radius: 50px;
			background-clip: padding-box;
			position: relative;
			color: #FFF;
			transition: all .25s;
		}
		.veen button.dark{
			border-color: #ff4931;
			background: #ff4931;
		}
		.veen .move button.dark{
			border-color: #e0b722;
			background: #e0b722;
		}
		.veen .splits p{
			font-size: 18px;
		}
		.veen button:active{
			box-shadow: none;			
		}
		.veen button:focus{
			outline: none;			
		}
		.veen > .wrapper {
			position: absolute;
			width: 40%;
			height: 130%;
			top: -10%;
			left: 5%;
			background: #fff;
			box-shadow: 0 0 4px rgba(0,0,0,.14), 0 4px 8px rgba(0,0,0,.28);
			transition: all .5s;
			color: #303030;
			overflow: hidden;
		}
		.veen .wrapper > form{
			padding: 15px 30px 30px;
			width: 100%;
			transition: all .5s;
			background: #fff;
			width: 100%; 
		}
.veen .wrapper > form:focus{
  outline: none;
}
		.veen .wrapper #login{
			padding-top: 20%;
      visibility: visible;
		}
		.veen .wrapper #register{
			transform: translateY(-80%) translateX(100%);
      visibility: hidden;
		}
		.veen .wrapper.move #register{
			transform: translateY(-80%) translateX(0%);
      visibility: visible;
		}
		.veen .wrapper.move #login{
			transform: translateX(-100%);
      visibility: hidden;
		}
		.veen .wrapper > form > div {
			position: relative;
			margin-bottom: 15px;
		}
		.veen .wrapper label{
			position: absolute;
			top: -7px;
			font-size: 12px;
			white-space: nowrap;
			background: #fff;
			text-align: left;
			left: 15px;
			padding: 0 5px;
			color: #999;
			pointer-events: none;
		}
		.veen .wrapper h3{
			margin-bottom: 25px;
		}
		.veen .wrapper input{
			height: 40px;
			padding: 5px 15px;
			width: 100%;
			border: solid 1px #999;
		}
.veen .wrapper input{
			height: 40px;
			padding: 5px 15px;
			width: 100%;
			border: solid 1px #999;
		}
		.veen .wrapper input:focus{
			outline: none;
			border-color: #ff4931;
		}
		.veen > .wrapper.move{
			left: 45%;
		}
		.veen > .wrapper.move input:focus{
			border-color: #e0b722;
		}
		@media (max-width: 767px){
			.veen{
				padding: 5px;
				margin: 0;
				width: 100%;
				display: block;
			}
			.veen > .wrapper{
				position: relative;
				height: auto;
				top: 0;
				left: 0;
				width: 100%;
			}
			.veen > div{
				display: inline-block;
			}
			.splits{
				width: 50%;
				background: #fff;
				float: left;
			}
			.splits button{
				width: 100%;
				border-radius: 0;
				background: #505050; 
				border: 0;
				opacity: .7;
			}
			.splits button.active{
				opacity: 1;
			}
			.splits button.active{
				opacity: 1;
				background: #ff4931;
			}
			.splits.rgstr-btn button.active{
				background: #e0b722;
			}
			.splits p{
				display: none;
			}
			.veen > .wrapper.move{
				left: 0%;
			}
		}

input:-webkit-autofill, textarea:-webkit-autofill, select:-webkit-autofill{
  box-shadow: inset 0 0 0 50px #fff
}
		.site-link{
      padding: 5px 15px;
			position: fixed;
			z-index: 99999;
			background: #fff;
			box-shadow: 0 0 4px rgba(44,0,0,.14), 0 4px 8px rgba(0,0,0,.28);
			right: 30px;
			bottom: 30px;
			border-radius: 10px;
		}
		.site-link img{
			width: 30px;
			height: 30px;
		}
		.message {
		color: #ff4931;
		font-weight: bold;
		}
	</style>