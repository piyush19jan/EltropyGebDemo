package geb.eltropy.test

import geb.spock.GebReportingSpec;
import geb.eltropy.page.LoginPage
import geb.eltropy.page.DashboardPage
import geb.eltropy.page.ProfilePage

class EltropyTestSpec extends GebReportingSpec{
	
	def "Login using linkedIn"(){
		
		given: 'launch base URL and validate the login page components'
			to LoginPage
			validateLoginPage()

		when: 'Click on the SignIn button'
			clickLinkedInSignInButton()
			
		and: 'Enter the login credentails '
			enterLoginCredentials("piyush19jan@gmail.com", "Metallica@1981")
		
		then: 'verify that user lands on his/her Dashboard'
			at DashboardPage
			validateLoggedInUser("Piyush")
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
			searchTopicOnDashBoard("Piyush")
		
		then : 'Search result should contain the searched topic'
			verifySearchResult("Piyush")
	}
	
	def "update user profile"(){
			
		when : 'user clicks on Profile'
			at DashboardPage
			clickProfileTab()
			
		and : 'Update the profile details'
			at ProfilePage
			updateUserDetails(" Updated", " Updated", "", "", "")
			
		then : 'user profile is successfully updated'
			verifyUpdatedUserProfile("Piyush Updated")
	}
}
