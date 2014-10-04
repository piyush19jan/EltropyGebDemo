package geb.eltropy.test

import spock.lang.Stepwise;
import geb.spock.GebReportingSpec;
import geb.eltropy.page.LoginPage
import geb.eltropy.page.DashboardPage
import geb.eltropy.page.ProfilePage

@Stepwise
class EltropyTestSpec extends GebReportingSpec{
	
static username = ""
static password = ""
static loggedInUser = ""
static searchTerm = ""
static fNameUpdate = ""
static lNameUpdate = ""
static uNameUpdate = ""
static passworUpdate = ""
static rePasswordUpdate = ""
	

	def "Login using linkedIn"(){
		
		given: 'launch base URL and validate the login page components'
			to LoginPage
			validateLoginPage()

		when: 'Click on the SignIn button'
			clickLinkedInSignInButton()
			
		and: 'Enter the login credentails '
			enterLoginCredentials(username, password)
		
		then: 'verify that user lands on his/her Dashboard'
			at DashboardPage
			validateLoggedInUser(loggedInUser)
			Thread.sleep(3000)
			
	}

	def "verify user dashboard"(){
		
		when: 'After Successful login'
			at DashboardPage
			Thread.sleep(3000)
			
		then : 'Dashboard componets are visible'
			verifyDashboardComponents()
	}
	
	def "perform a search on dashboard"(){
		when : 'User search a topic on Dashboard'
			at DashboardPage
			searchTopicOnDashBoard(searchTerm)
		
		then : 'Search result should contain the searched topic'
			verifySearchResult(searchTerm)
	}
	
	def "update user profile"(){
			
		when : 'user clicks on Profile'
			at DashboardPage
			clickProfileTab()
			
		and : 'Update the profile details'
			at ProfilePage
			updateUserDetails(fNameUpdate, lNameUpdate, uNameUpdate, passworUpdate, rePasswordUpdate)
			
		then : 'user profile is successfully updated'
			verifyUpdatedUserProfile(loggedInUser+fNameUpdate)
	}
}
