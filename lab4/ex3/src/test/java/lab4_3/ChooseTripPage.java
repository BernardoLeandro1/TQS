package lab4_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ChooseTripPage {
    
    @SuppressWarnings("unused")
    private WebDriver driver;

    @FindBy(name = "fromPort")
    private WebElement departurePlace;

    @FindBy(name = "toPort")
    private WebElement destinationPlace;

    @FindBy(xpath = "//input[@value=\'Find Flights\']")
    private WebElement findFlightsButton;


    public ChooseTripPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://blazedemo.com/");
        PageFactory.initElements(driver, this);
    }


    public void selectDeparturePlace(String city) {
        departurePlace.click();
        Select select = new Select(departurePlace);
        select.selectByValue(city);
    }

    public void selectDestinationPlace(String city) {
        destinationPlace.click();
        Select select = new Select(destinationPlace);
        select.selectByValue(city);
    }

    public void clickSearch() {
        findFlightsButton.click();
    }
}