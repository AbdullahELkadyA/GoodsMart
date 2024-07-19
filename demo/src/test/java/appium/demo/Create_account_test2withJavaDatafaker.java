package appium.demo;

import java.util.Random;

import org.testng.annotations.Test;

import net.datafaker.Faker;

public class Create_account_test2withJavaDatafaker extends TestBase {

	
	Create_account_Screen crobj;
	Faker fakedata = new Faker();
	String Fname = fakedata.name().firstName();
	String Lname = fakedata.name().lastName();
	String email = fakedata.internet().emailAddress();
	String password = generatePassword(fakedata, 8);
	 public static String generatePassword(Faker faker, int length) {
	        String upperCaseLetters = faker.lorem().characters(2, true, true).toUpperCase();
	        String lowerCaseLetters = faker.lorem().characters(2, true, true).toLowerCase();
	        String digits = faker.number().digits(2);
	        String specialCharacters = "!@#$%^&*()_+";
	        String combinedChars = upperCaseLetters + lowerCaseLetters + digits + specialCharacters;
	        Random random = new Random();
	        char[] password = new char[length];

	        for (int i = 0; i < length; i++) {
	            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
	        }
	        return new String(password);
	    }
	String phone = fakedata.phoneNumber().phoneNumber();
	String streetAddress = fakedata.address().streetAddress();




	//Verify that a user can successfully sign up with all valid inputs.
	@Test
	public void Create_successfully_sign_up_with_all_valid_inputs() throws InterruptedException 
	{
		crobj = new Create_account_Screen(driver);
		crobj.Create_Account(Fname,Lname,phone,email,password,streetAddress);
	}
	
	//Verify that user cannot sign up with any mandatory fields
	@Test
	public void Create_testVerify_that_the_user_cannot_sign_up_with_any_mandatory_fields_left_empty() throws InterruptedException 
	{
		crobj = new Create_account_Screen(driver);
		crobj.Create_Account_without_mandatory(Fname, phone,email,password,streetAddress);
	}
	

	//Verify valid invalid email
	@Test(priority = 3)
	public void Create_test_Invalid_Email_Format() throws InterruptedException 
	{
		crobj = new Create_account_Screen(driver);
		crobj.Create_Account(Fname,Lname,phone,"Abdulla@asgmsaail.casdom",password,streetAddress);
	}

	
	// verify duplicate email address
	@Test(priority = 4)
	public void Create_Duplicate_Email_Address() throws InterruptedException 
	{
		crobj = new Create_account_Screen(driver);
		crobj.Create_Account(Fname,Lname,phone,"Abdulla@gmail.com",password,streetAddress);
	}

	
	@Test(priority = 5)
	public void Create_Duplicate_Phone_number() throws InterruptedException 
	{
		crobj = new Create_account_Screen(driver);
	    crobj.Create_Account(Fname,Lname,"1016606186",email,password,streetAddress);
	}
	
	
//	
//	@Test(priority = 6)// Based on valid promo code
//	public void Create_Valid_Promo_Referral_Code() 
//	{
//		crobj = new Create_account_Screen(driver);
//		crobj.Create_Account_Add_promoCode("Abdullah","Amin","10116606153","Abdulla@gmail.com","dfg","Valid Promo code");
//	}
//	
//		
	@Test(priority = 7)
	public void Create_Valid_Mobile_Number_Validation() throws InterruptedException 
	{
		crobj = new Create_account_Screen(driver);
		crobj.Create_Account(Fname,Lname,"999" ,email,password,streetAddress);
	} 
		
	
	
	
	
	
	
}
