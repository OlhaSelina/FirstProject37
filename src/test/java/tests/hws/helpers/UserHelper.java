package tests.hws.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.hws.dto.UserDTO;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }
    By btnLogout = By.xpath("//a[contains(text(),'Log out')]");
    By linkRegister = By.xpath("//a[@href='/register']");
    By emailRegisterLink = By.xpath("//div[@class='header-links-wrapper']//a[@class='account']");
    By btnLogIn = By.xpath("//a[contains(text(),'Log in')]");
    public void clickLogoutBtn() {
        clickBase(btnLogout);
    }
    public void clickLoginOnNavBar() {
       clickBase(btnLogIn);
    }

    //registration------------
    public void clickRegisterLink(){
        clickBase(linkRegister);
    }
    public void newRegister(UserDTO userDTO){
        fillFirstNameRegister(userDTO.getFirstName());
        fillLastNameRegister(userDTO.getLastName());
        fillEmailRegister(userDTO.getEmail());
        fillPasswordRegister(userDTO.getPassword());
        fillConfirmPassword(userDTO.getConfirmPassword());
        clickRegisterBtn();
    }
    public void fillFirstNameRegister(String firstName){
        typeText(firstName, By.xpath("//input[@name='FirstName']"));
    }
    public void fillLastNameRegister(String lastName) {
        typeText(lastName, By.xpath("//input[@name='LastName']") );
    }
    public void fillEmailRegister(String email) {
         typeText( email, By.xpath("//input[@name='Email']"));
    }
    public void fillPasswordRegister(String password) {
        typeText(password, By.xpath("//input[@name='Password']"));
    }
    public void fillConfirmPassword(String confirmPassword) {
        typeText( confirmPassword, By.xpath("//input[@id='ConfirmPassword']"));
    }
    public void clickRegisterBtn(){
        driver.findElement(By.xpath("//input[@name='register-button']")).click();
    }

    public String getEmailRegisterLinkText() {
        return getTextBaseByLocator(emailRegisterLink);
    }

    public void navigateToHomePage(){
        driver.navigate().to("https://demowebshop.tricentis.com/");
    }
    //------------------------------
    // Login-----------------

    public void login(UserDTO user) {
        fillEmailOnLogin(user.getEmail());
        fillPasswordOnLogin(user.getPassword());
        clickLoginBtn();
    }

    public void fillPasswordOnLogin(String password) {
        WebElement inputPassword = driver.findElement(By
                .xpath("//input[@id='Password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }

    public void fillEmailOnLogin(String email) {
        WebElement inputEmail = driver.findElement(By
                .xpath("//input[@id='Email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }
    public void clickLoginBtn() {
        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
    }



}
