package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gmibank.pages.CommonPageElements;
import gmibank.pages.UserManagementPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import gmibank.utilities.ReadTxt;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UserManagementSteps {

    CommonPageElements commonPageElements = new CommonPageElements();
    UserManagementPage userManagementPage = new UserManagementPage();

    @Given("user clicks on the administration dropdown")
    public void user_clicks_on_the_administration_dropdown() {
        Driver.waitAndClick(commonPageElements.administrationDropdown,5);
    }

    @Given("user clicks on the userManagement button")
    public void user_clicks_on_the_userManagement_button() {
        Driver.waitAndClick(commonPageElements.userManagementButton,5);
    }

    @Given("user gets all users from usermanagement")
    public void user_gets_all_users_from_usermanagement() {

        List<String> list = new ArrayList<>();

        for (WebElement each :commonPageElements.allUsers){
            System.out.println( each.getText());
            list.add(each.getText());
        }

        System.out.println("===============================================");
        System.out.println("list size: "+list.size());
        System.out.println(list);
        System.out.println("===============================================");

    }



    @When("user reads all users using pagination")
    public void user_reads_all_users_using_pagination() {
        int lastIndex = userManagementPage.allPages.size()-3;
        System.out.println(userManagementPage.allPages.get(lastIndex).getText());
        int iterateTimes = Integer.parseInt(userManagementPage.allPages.get(lastIndex).getText());
        int current =0;
        boolean flag = false;

        String expectedUser = ReadTxt.returnAllCustomerCredentials(ConfigurationReader.getProperty("fileNameOfCustomer")).get(1);
          String lastPage="";

                for(int i =iterateTimes; i>=1;i--) {
                    int  activationIndex = 1;
                    if(flag)break;
                    System.out.println("<====== Current Users on Page "+i+" =======>");
                    sleep(1000);
                    Driver.waitForClickablility(Driver.getDriver().findElement(By.xpath("//*[text()='" +i+"']")),5);
                    Driver.getDriver().findElement(By.xpath("//*[text()='" +i+"']")).click();
                    sleep(1000);
                    System.out.println(i);

                    for (WebElement eachElement : userManagementPage.allUsers){
                        sleep(1000);
                        System.out.println(eachElement.getText());
                        if(eachElement.getText().equalsIgnoreCase(expectedUser)) {
//                            System.out.println(Driver.getDriver().findElement(By.xpath("//*[text()='pader49']/following::td[2]")).getText());
                            Driver.getDriver().findElement(By.xpath("//*[text()='"+eachElement.getText()+"']/following::td[2]")).click();
                            flag = true;
                            System.out.println("Congrats! Your user has been found and activated!!");
                            break;
                        }
                        activationIndex++;
                    }
//
//
//
//                }


//        for(int i =iterateTimes; i>= 1;i--) {
//            int  activationIndex = 1;
//            System.out.println("<====== Current Users on Page "+i+" =======>");
//            sleep(1000);
//            Driver.waitForClickablility(Driver.getDriver().findElement(By.xpath("//*[text()='" +i+"']")),5);
//            Driver.getDriver().findElement(By.xpath("//*[text()='" +i+"']")).click();
//            sleep(1000);
//            System.out.println(i);
//
//            for (WebElement eachElement : userManagementPage.allUsers){
//                sleep(1000);
//                System.out.println(eachElement.getText());
//                if(eachElement.getText().equalsIgnoreCase(expectedUser)) {
//                    System.out.println(Driver.getDriver().findElement(By.xpath("//*[text()='pader49']/following::td[2]")).getText());
//                    Driver.getDriver().findElement(By.xpath("//*[text()='"+eachElement.getText()+"']/following::td[2]")).click();
//                    break;
//                }
//                activationIndex++;
//            }
//
//
//
//        }
      }
    }


     public void sleep(int timeOut){
         try {
             Thread.sleep(timeOut);
         }catch (Exception e){
             e.printStackTrace();
         }
     }

}
