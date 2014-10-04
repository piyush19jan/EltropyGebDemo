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
	}
	
	def updateUserDetails(String fName, String lName, String uName, String password, String retypePassword){
			firstName << fName
			lastName << lName
			userName << uName
			if(!password.equalsIgnoreCase("") && !retypePassword.equalsIgnoreCase("")){
				setPassword.click()
				newPassword << password
				confirmPassword << retypePassword
			}
			updateButton.click()
			Thread.sleep(2000)
		
	}
	
	def verifyUpdatedUserProfile(String fName){
		successMessage.isDisplayed()
		
	}
	
}
