package geb.eltropy.page

import geb.Page

class ProfilePage extends Page{
	
	static at = { title == "Profile"
	}
	
	static content = {
		firstName { $("#firstName") }
		lastName { $("#lastName") }
		userName { $("#userName") }
		emailId { $("#accountpgEmail") }
		setPassword { $(".connectEmail") }
		newPassword { $("#newPassword") }
		confirmPassword { $("#confirmPassword") }
		updateButton { $("button", text: "Update") }
		successMessage { $("#topicsTabSuccess") }
		user { $("#user-dropdown") }
	}
	
	
	
	def updateUserDetails(String fName, String lName, String uName, String password, String retypePassword){
			firstName.value("")
			lastName.value("")
			userName.value("")
			firstName << fName
			lastName << lName
			userName << uName
			if(!password.equalsIgnoreCase("") && !retypePassword.equalsIgnoreCase("")){
				setPassword.click()
				newPassword.value("")
				confirmPassword.value("")
				newPassword << password
				confirmPassword << retypePassword
			}
			updateButton.click()
			Thread.sleep(2000)
		
	}
	
	def verifyUpdatedUserProfile(String fName){
		successMessage.isDisplayed()
		user.text() == fName
		
	}
	
}
