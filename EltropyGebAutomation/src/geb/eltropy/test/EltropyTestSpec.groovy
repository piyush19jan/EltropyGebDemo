package geb.eltropy.test

import spock.lang.Stepwise;
import geb.spock.GebReportingSpec;
import geb.eltropy.page.LoginPage
import geb.eltropy.page.DashboardPage
import geb.eltropy.page.ProfilePage

@Stepwise
class EltropyTestSpec extends GebReportingSpec{
	
static username = "" // Enter LinkedIn UserID
static password = "" // Enter LinkedIn Password
static loggedInUser = "" // First name of logged in user
static searchTerm = "" // Specify the topic to be searched
static fNameUpdate = "" // First name to be updates
static lNameUpdate = "" // Last name to be updates
static uNameUpdate = "" // User name to be updates
static passworUpdate = "" // Password to be updates
static rePasswordUpdate = "" // Re-enter password to be updates
	
//Test Case 1
	def "Login using linkedIn"(){
		
		given: 'launch base URL and validate the login page components'
			to LoginPage
			validateLoginPage()

		when: 'Click on the SignIn button'
			clickLinkedInSignInButton()
			
		and: 'Enter the login credentails '
			enterLoginCredentials(username, password)
		
		then: 'verify that user lands on his/her Dashboard and confirm user First Name'
			at DashboardPage
			validateLoggedInUser(loggedInUser)
			Thread.sleep(3000)
			
	}

	//Test Case 2
	def "verify user dashboard"(){
		
		when: 'After Successful login'
			at DashboardPage
			Thread.sleep(3000)
			
		then : 'Dashboard componets are visible'
			verifyDashboardComponents()
	}
	
	//Test Case 3
	def "perform a search on dashboard"(){
		when : 'User search a topic on Dashboard'
			at DashboardPage
			searchTopicOnDashBoard(searchTerm)
		
		then : 'Search result should contain the searched topic'
			verifySearchResult(searchTerm)
	}
	
	//Test Case 4
	def "update user profile"(){
			
		when : 'user clicks on Profile'
			at DashboardPage
			clickProfileTab()
			
		and : 'Update the profile details'
			at ProfilePage
			updateUserDetails(fNameUpdate, lNameUpdate, uNameUpdate, passworUpdate, rePasswordUpdate)
			
		then : 'user profile is successfully updated'
			verifyUpdatedUserProfile(fNameUpdate)
	}
}
