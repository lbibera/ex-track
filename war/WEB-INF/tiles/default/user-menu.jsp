<!-- 	user menu goes here
		if the user is not logged in:
			- show username as guest
			- dropdown should display:
				-- register
				-- forgot login details
				-- sign in
				
		if user is logged in as normal user
			- show dropdown menu with username
			- dropdown should display
				-- profile
				-- sign out
 -->

<div class="btn-group pull-right">
    <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
    	<i class="icon-user"></i> 
       	<span>Username</span>
      	<span class="caret"></span>
    </a>
    <ul class="dropdown-menu">
      	<li><a href="#">Profile</a></li>
      	<li class="divider"></li>
       	<li><a href="#">Sign Out</a></li>
	</ul>
</div>