<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form commandName="form" action="/register" method="POST" cssClass="form-horizontal">
	<legend>Account Registration Form</legend>
	
	<div class="control-group">
	<form:label path="username" cssClass="control-label">Username</form:label>
		<div class="controls">
		<form:input path="username"/>
		</div>
	</div>
	
	<div class="control-group">
	<form:label path="password" cssClass="control-label">Password</form:label>
		<div class="controls">
		<form:password path="password"/>
		</div>
	</div>
	
	<div class="control-group">
	<form:label path="passwordConfirm" cssClass="control-label">Confirm Password</form:label>
		<div class="controls">
		<form:password path="passwordConfirm"/>
		</div>
	</div>
	
	<div class="control-group">
	<form:label path="screenName" cssClass="control-label">Screen Name</form:label>
		<div class="controls">
		<form:input path="screenName"/>
		</div>
	</div>
	
	
	<div class="control-group">
	<form:label path="firstName" cssClass="control-label">First Name</form:label>
		<div class="controls">
		<form:input path="firstName"/>
		</div>
	</div>
	
	<div class="control-group">
	<form:label path="middleName" cssClass="control-label">Middle Name</form:label>
		<div class="controls">
		<form:input path="middleName"/>
		</div>
	</div>
	
	<div class="control-group">
	<form:label path="lastName" cssClass="control-label">Last Name</form:label>
		<div class="controls">
		<form:input path="lastName"/>
		</div>
	</div>
	
	<div class="control-group">
		<div class="controls">
		<button type="submit" class="btn btn-primary btn-large">Register Account</button>
		</div>
	</div>
</form:form>