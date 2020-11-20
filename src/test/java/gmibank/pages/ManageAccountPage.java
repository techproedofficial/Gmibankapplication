package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageAccountPage extends CommonPageElements{

    public ManageAccountPage(){
        super();
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "tp-account-description")
    public WebElement descriptionTextbox;

    @FindBy(name = "balance")
    public WebElement balanceTextbox;

    @FindBy(id = "tp-account-accountType")
    public WebElement accountTypeDropdown;

    @FindBy(name = "accountStatusType")
    public WebElement accountStatusTypeDropdown;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

}
