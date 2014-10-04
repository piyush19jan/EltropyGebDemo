#################################################

				ELTROPY GEB DEMO

#################################################

1. Project Structure
	This is a maven based project and has been divided into different modules
	1. Test : Contain spock test file which have the test cases
	2. Page : Leverage Geb page object model. Created different groovy classes for different pages. e.g. Login Page, Daskboard Page and Profile Page will have different classes containing their respective loactors and action on them
	3. Module : These are the reusable components of the application which can be triggered from any page of the application. Any module can be referenced from any page object class and the components can be re-used.
	4. ConfigClass: We have a GebConfig class which is implicitely called by geb. It contains basic configuration like, application url, other resources like driver executables and custome functions.
	
2. How to execute
	Curently, the test can be run directly from the IDE as a Junit test. Run EltropyTestSpec.groovy class as Junit and the test will execute. Working on finding a solution to run it thru maven since the surefire plugin is not finding any test to execute. After the problem is resolved it can be rum directly from the command line.

	
	