package stepDefination;

import DriverUtilities.ShareDriver;
import Pages.BasePage;
import Pages.loginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ToDoSteps {

    private loginPage page;
    public Scenario scenario;
    public void driverCreation() throws Exception {
        ShareDriver driver = new ShareDriver();
        page = PageFactory.initElements(driver.standaloneDriver(), loginPage.class);
    }


    @Then("user closes the browser")
    public void user_closes_the_browser() {
        page.closeBrowser();
    }


    @Given("user navigates to OrangeHRM home page")
    public void user_navigates_to_orange_hrm_home_page() throws Exception {
        driverCreation();
        page.navigate();

    }

    @When("user logs in by entering username and password")
    public void user_logs_in_by_entering_username_and_password() {
       page.sendInput(page.Input_Username,"Admin");
       page.sendInput(page.Input_Password,"admin123");
       page.click(page.log_button);

    }

    @When("user clicks on Admin Tab")
    public void user_clicks_on_admin_tab() throws InterruptedException {
        Thread.sleep(2000);
        page.jsClick("//a[@class='oxd-main-menu-item']//span[text()='Admin']");
        Thread.sleep(3000);
    }

    @When("user navigates to System User and enters User Details")
    public void user_navigates_to_system_user_and_enters_user_details(DataTable dataTable) throws InterruptedException {

        List<Map<String, String> > data =dataTable.asMaps(String.class, String.class);
        System.out.println("size of elements"+data.size());
        for (Map<String, String> e : data) {

            page.sendKeys("//label[text()='Username']/following::input[@class='oxd-input oxd-input--active']",e.get("UserName"));
            Thread.sleep(2000);
            page.clicked("(//div[text()='-- Select --'])[1]");
            Thread.sleep(2000);
            page.clicked("//div[@class='oxd-select-dropdown --positon-bottom']//div[@role='option']//span[text()='"+e.get("UserRole")+"']");
            Thread.sleep(2000);
            page.sendKeys("//input[@placeholder='Type for hints...']",e.get("EmployeeName"));
            Thread.sleep(2000);
            page.clicked("(//div[text()='-- Select --'])[2]");
            Thread.sleep(2000);
            page.clicked("//div[@class='oxd-select-dropdown --positon-bottom']//div[@role='option']//span[text()='"+e.get("Status")+"']");
            Thread.sleep(2000);
        }
    }

    @Then("user Search for user details")
    public void user_search_for_user_details() throws InterruptedException {
        page.jsClick("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
        Thread.sleep(2000);
    }

    @Then("user validates record found")
    public void user_validates_record_found() throws InterruptedException {
        page.isVisible("//span[text()='(1) Record Found']");
        Thread.sleep(2000);
    }

    @And("user capture the screenshot in local")
    public void userCaptureTheScreenshotInLocal() throws IOException {
        page.captureScreenShot("loginPage");
    }
}
