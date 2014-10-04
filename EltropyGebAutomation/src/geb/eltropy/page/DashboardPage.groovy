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
	
	def validateLoggedInUser(username){
		user.text() == username
	}
	
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
	
	def logoutFromApplication(){
		waitFor{
			searchPageModule.searchBox.isDisplayed()
		}
		Thread.sleep(2000)
		userDropdown.click()
		logoutButton.click()
		
	}
	
	def verifySearchResult(topic){
		 searchPageModule.checkSearchResult(topic)
	}

	def clickProfileTab(){
		profileTab.click()
	}	
}
	

