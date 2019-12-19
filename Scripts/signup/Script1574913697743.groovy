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

String vcode = null

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.prod)

WebUI.maximizeWindow()

WebUI.click(findTestObject('page_signup_wizard/link_Dont_have_an_account_Sign_Up'))

WebUI.delay(7)

WebUI.waitForElementVisible(findTestObject('page_signup_wizard/input_email'), 30)

WebUI.delay(5)

dateS = CustomKeywords.'customKeywords.utilities.getDateString'()

signup_email = (('automation_qa_' + dateS) + '@mailinator.com')

WebUI.comment('Sign up email::: ') + signup_email

WebUI.setText(findTestObject('page_signup_wizard/input_email'), signup_email)

WebUI.click(findTestObject('page_signup_wizard/select_why_are_you_signing_up'))

WebUI.click(findTestObject('page_signup_wizard/itemSelect_I am an Employer'))

WebUI.setEncryptedText(findTestObject('page_signup_wizard/input_password'), '+xoIk16sSBQXH9m06zjgiA==')

WebUI.click(findTestObject('page_signup_wizard/button_Next'))

WebUI.delay(10)

WebUI.setText(findTestObject('page_signup_wizard/input_fullName'), 'Automation QA')

WebUI.setText(findTestObject('page_signup_wizard/input_companyName'), 'QA Corporation')

WebUI.setText(findTestObject('page_signup_wizard/input_phoneNumber'), '+63 949 094 5584')

WebUI.click(findTestObject('page_signup_wizard/button_Finish'))

WebUI.delay(20)

WebUI.verifyElementNotPresent(findTestObject('page_signup_wizard/label_Sign Up failed'), 0)

WebUI.click(findTestObject('page_welcome_wizard/button_Next'))

WebUI.waitForElementVisible(findTestObject('page_welcome_wizard/input_verification_code'), 30)

WebUI.delay(5)

WebUI.navigateToUrl('https://www.mailinator.com/')

WebUI.delay(10)

WebUI.setText(findTestObject('mailinator/input_email'), signup_email)

WebUI.sendKeys(findTestObject('mailinator/input_email'), Keys.chord(Keys.ENTER))

WebUI.delay(10)

WebUI.click(findTestObject('mailinator/link_email'))

WebUI.delay(5)

WebUI.switchToFrame(findTestObject('mailinator/msg_body'), 5)

WebUI.delay(5)

vcode = WebUI.getText(findTestObject('mailinator/label_vcode'))

vcode1 = vcode.replace('Verification Code:', '')

WebUI.switchToDefaultContent()

WebUI.delay(5)

WebUI.navigateToUrl('https://dashboard.myinterview.com/admin/')

WebUI.delay(5)

WebUI.click(findTestObject('page_welcome_wizard/button_Next'))

WebUI.delay(3)

WebUI.setText(findTestObject('page_welcome_wizard/input_verification_code'), vcode1)

WebUI.sendKeys(findTestObject('page_welcome_wizard/input_verification_code'), Keys.chord(Keys.ENTER))

WebUI.delay(10)

WebUI.click(findTestObject('page_welcome_wizard/section_Sales_Question'))

WebUI.click(findTestObject('page_welcome_wizard/button_create_my_first_interview'))

WebUI.delay(10)

WebUI.verifyElementText(findTestObject('label_jobTitle'), 'Sales Interview')

WebUI.takeScreenshot()

