package geb.eltropy.module

import geb.Module;
import org.openqa.selenium.Keys

class SearchModule extends Module{
	static content = {
		searchBox { $(".topic-search") }
		closeSearch { $(".icon-remove") }
		topics { $("div.card-heading.simple").children() }
	}
	
	def searchTopic(topic){
		searchBox << topic
		searchBox << Keys.ENTER
	}
	
	def checkSearchResult(topic){
			int topicSize = topics.size()
			if ( topicSize > 0){
				for(int i = 0; i< topicSize; i++){
					assert topics[i].text().contains(topic)
				}
				return true
			}
			else
			return false
		}

	}
