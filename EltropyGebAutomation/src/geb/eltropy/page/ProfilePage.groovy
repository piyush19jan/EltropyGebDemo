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
	
	
	/**
	 * Update the user details as per the given input
	 * @param fName = First name to be updated
	 * @param lName = Last name to be updated
	 * @param uName = Username to be updated
	 * @param password = new password
	 * @param retypePassword = confirm password 
	 */
	
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
	
	/**
	 * Validate that user details has been successfully updated
	 * @param fName = First name of user after update 
	 */
	 
	def verifyUpdatedUserProfile(String fName){
		successMessage.isDisplayed()
		user.text() == fName
		
	}
	
}
