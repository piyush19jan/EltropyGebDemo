package geb.eltropy.page

import geb.Page;
import geb.eltropy.module.LinkedInSignInModule

class LoginPage extends Page{
	static url
	
	 /*****Validate the title of Login Page******/
	static at = { waitFor {
		title == 'Eltropy Home'
	 }
	}
	
	/******Page Objects under content closure********/
	 static content = {
		 linkedInModule { module LinkedInSignInModule }
		 logo { $("a#nav-logo") }
		 signInButton { $(".nav-signin-button") }
		 aboutEltropyButton { $(".card-heading.simple") }
		 signInModal { $("#signinModal") }
		 signInGoogle { $(".btn.eltropy-social-text.eltropy-google-text") }
		 signInLinkedIn { $(".btn.eltropy-social-text.eltropy-linkedin-text") }
		 signIn { $(".email-choice-button.email-ch-signin") }
		 signUp { $(".email-choice-button.email-ch-signup") }
		 loginErrorMessage { $("#yui-gen1>p>strong") }
		 
	 }
	 
		 def validateLoginPage(){
			 assert logo
			 assert signInButton
			 assert aboutEltropyButton
		 }
		 
		 /**
		  * Perform a click on sign in button on Home page, wait for the modal to appear and click on SignIn using linkedIn 
		  */
		 
		 def clickLinkedInSignInButton(){
			 signInButton.click()
			 waitFor {
				 signInModal.isDisplayed()
				 }
			 signInLinkedIn.click()
		 }
		 
		 /**
		  * validate that user has landed on correct page and then enter login credentails'
		  * @param username = Email address of the user 
		  * @param password = password of the user 
		  */
		 
		 def enterLoginCredentials(username, password){
			 waitFor {
				 title == "Authorize | LinkedIn"
			 }
			 linkedInModule.loginWithLinkedIn(username, password)
		 }
		 
		 /**
		  * validate the login error page in case of incorrect login credentails 
		  */
		 
		 def validateLoginErrorPage(){
			 loginErrorMessage.text() == "The email address or password you provided does not match our records."
		 }
		 
}
