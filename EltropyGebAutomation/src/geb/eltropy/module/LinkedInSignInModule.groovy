package geb.eltropy.module

import geb.Module;
import geb.eltropy.page.DashboardPage

class LinkedInSignInModule extends Module{
	static content = {
		email { $("#session_key-oauth2SAuthorizeForm") }
		password { $("#session_password-oauth2SAuthorizeForm") }
		allowButton(to : DashboardPage) { $(".allow") }
	}
	
	/**
	 * perform a login action on linkedIn auth page
	 * @param username 
	 * @param  pwd
	 */
	def loginWithLinkedIn(username, pwd){
		email << username
		password << pwd
		allowButton.click()
	}	
	
}
