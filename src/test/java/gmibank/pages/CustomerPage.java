package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage extends CommonPageElements{

    public CustomerPage(){
        super();
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "search-ssn")
    public WebElement ssnTextbox;

    @FindBy(xpath = "//*[text()='Search']")
    public WebElement searchButton;

    @FindBy(name = "firstname")
    public WebElement firstNameTextbox;

    @FindBy(name = "lastname")
    public WebElement lastNameTextbox;

    @FindBy(name = "middleInitial")
    public WebElement middleInitialTextbox;

    @FindBy(name = "email")
    public WebElement emailTextbox;

    @FindBy(name = "address")
    public WebElement addressTextbox;

    @FindBy(name = "mobilePhoneNumber")
    public WebElement mobilePhoneNumberTextbox;

    @FindBy(name = "phoneNumber")
    public WebElement phoneNumberTextbox;

    @FindBy(name = "zipCode")
    public WebElement zipCodeTextbox;

    @FindBy(name = "username")
    public WebElement usernameTextbox;

    @FindBy(name = "city")
    public WebElement cityTextbox;

    @FindBy(name = "ssn")
    public WebElement ssnTextbox2;

    @FindBy(name = "country.id")
    public WebElement countryDropdown;

    @FindBy(name = "state")
    public WebElement stateTextbox;

    @FindBy(name = "country.id")
    public WebElement userDropdown;

    @FindBy(name = "accounts")
    public WebElement accountsDropdown;

    @FindBy(name = "zelleEnrolled")
    public WebElement zelloEnrolledCheckmark;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

}
