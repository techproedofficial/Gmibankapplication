package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserManagementPage {
    public UserManagementPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindAll({@FindBy(xpath = "//*[@class='page-item']")})
    public List<WebElement> allPages ;


    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[2]")})
    public List<WebElement> allUsers ;


    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[4]")})
    public List<WebElement> userActivations ;

}
