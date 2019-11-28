import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.prod)

WebUI.click(findTestObject('page_signup_wizard/link_Dont_have_an_account_Sign_Up'))

WebUI.waitForElementVisible(findTestObject('page_signup_wizard/input_email'), 30)

WebUI.delay(5)

dateS = CustomKeywords.'customKeywords.utilities.getDateString'()

signup_email = ('automation_qa_' + dateS) + '@mailinator.com'

WebUI.setText(findTestObject('page_signup_wizard/input_email'), signup_email)

WebUI.click(findTestObject('page_signup_wizard/select_why_are_you_signing_up'))

WebUI.click(findTestObject('page_signup_wizard/itemSelect_I am an Employer'))

WebUI.setEncryptedText(findTestObject('page_signup_wizard/input_password'), 'kHwl2Dr6jYzBGMCBnr6EGA==')

WebUI.click(findTestObject('page_signup_wizard/button_Next'))

WebUI.delay(10)

WebUI.setText(findTestObject('page_signup_wizard/input_fullName'), 'Automation QA')

WebUI.setText(findTestObject('page_signup_wizard/input_companyName'), 'QA Corporation')

WebUI.setText(findTestObject('page_signup_wizard/input_phoneNumber'), '+63 949 094 5584')

WebUI.click(findTestObject('page_signup_wizard/button_Finish'))

WebUI.delay(20)

WebUI.verifyElementNotVisible(findTestObject('page_signup_wizard/label_Sign Up failed'))

WebUI.delay(20)

WebUI.closeBrowser()

