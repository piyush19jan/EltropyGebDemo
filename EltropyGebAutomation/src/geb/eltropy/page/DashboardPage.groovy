package geb.eltropy.page

import geb.Page;
import geb.eltropy.module.SearchModule
import geb.eltropy.page.ProfilePage

class DashboardPage extends Page{

	static at = {
		waitFor("slow"){
			title == "Dashboard" || title == "Topics"
		}
	}
	
	static content = {
		searchPageModule {module SearchModule}
		user { $("#user-dropdown") }
		topicTab { $("#topicsTab") }
		profileTab(to : ProfilePage ) { $("#profileTab") }
		userDropdown { $("#user-dropdown") }
		logoutButton { $("a#nav-logout-button") }
	}
	
	/**
	 * This function validate the first name of the logged in user on the dashboard
	 */
	def validateLoggedInUser(username){
		user.text() == username
	}
	
	/**
	 *  This function perform a topic search on the dashboard
	 *  @param topic = Name of topic to be searched
	 */
	def searchTopicOnDashBoard(topic){
		waitFor{
			searchPageModule.searchBox.isDisplayed()
		}
		Thread.sleep(2000)
		searchPageModule.searchTopic(topic)
		Thread.sleep(1000)
		}
	
	def verifyDashboardComponents(){
		topicTab.isDisplayed()
		profileTab.isDisplayed()
		searchPageModule.searchBox.isDisplayed()
		searchPageModule.topics.isDisplayed()
		
	}
	
	/**
	 * logout from application
	 */
	def logoutFromApplication(){
		waitFor{
			searchPageModule.searchBox.isDisplayed()
		}
		Thread.sleep(2000)
		userDropdown.click()
		logoutButton.click()
		
	}
	
	/**
	 * This function validate the search result. It will call the Search module to validate the search result.
	 * @param topic = Topic name that was searched
	 */
	def verifySearchResult(topic){
		 searchPageModule.checkSearchResult(topic)
	}

	/**
	 * This function performs a click operation on profile button
	 */
	def clickProfileTab(){
		profileTab.click()
	}	
}
	

