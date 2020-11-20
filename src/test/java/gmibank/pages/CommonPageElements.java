package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPageElements {

    public CommonPageElements(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='My Operations']")
    public WebElement myOperations;

    @FindBy(xpath = "//*[text()='Manage Customers']")
    public WebElement manageCustomer;

    @FindBy(xpath = "//*[text()='Create a new Customer']")
    public WebElement createANewCustomer;

    @FindBy(xpath = "//*[text()='Create Date']/following::input")
    public WebElement dateTextbox;

    @FindBy(xpath = "(//*[@class='d-flex align-items-center dropdown-toggle nav-link'])[2]")
    public WebElement currentUserDropdown;

    @FindBy(xpath = "//*[text()='Manage Accounts']")
    public WebElement manageAccount;

    @FindBy(xpath = "//*[text()='Create a new Account']")
    public WebElement createANewAccount;

    @FindBy(xpath = "//*[text()='Sign out']")
    public WebElement signOutButton;

    @FindBy(xpath = "//*[text()='Administration']")
    public WebElement administrationDropdown;

    @FindBy(xpath = "//*[text()='User management']")
    public WebElement userManagementButton;

    @FindBys({@FindBy(xpath = "//table/tbody/tr")})
    public List<WebElement > allUsers;

}
