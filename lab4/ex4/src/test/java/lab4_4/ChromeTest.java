package lab4_4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.seljup.BrowserType;
import io.github.bonigarcia.seljup.DockerBrowser;
import io.github.bonigarcia.seljup.SeleniumJupiter;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SeleniumJupiter.class)
public class ChromeTest {
  

  @Test
  public void test(@DockerBrowser(type = BrowserType.CHROME) WebDriver driver) {

    ChooseTripPage tripPage = new ChooseTripPage(driver);
    driver.manage().window().setSize(new Dimension(1064, 760));

    tripPage.selectDeparturePlace("Boston");
    tripPage.selectDestinationPlace("New York");
    tripPage.clickSearch();

    ChooseFlightPage flightPage = new ChooseFlightPage(driver);

    assertThat(flightPage.getDepartureText()).isEqualTo("Departs: Boston");
    assertThat(flightPage.getDestinationText()).isEqualTo("Arrives: New York");

    flightPage.chooseFlight();

    ChoosePaymentPage paymentPage = new ChoosePaymentPage(driver);

    assertThat(paymentPage.getFlightAirline()).isEqualTo("Airline: United");
    assertThat(paymentPage.getFlightPrice()).isEqualTo("Price: 400");

    paymentPage.setName("Benny Lenny");
    paymentPage.setAddress("123 Main Avenue");
    paymentPage.setCity("New York");
    paymentPage.setState("New York");
    paymentPage.setZipCode("12345");
    paymentPage.chooseCardType("Visa");
    paymentPage.setCardNumber("987654321");
    paymentPage.setCardMonth("6");
    paymentPage.setCardYear("2025");
    paymentPage.setNameOnCard("Benny Lenny");

    paymentPage.clickOnPurchaseFlight();

    assertThat(driver.getTitle()).isEqualTo("BlazeDemo Confirmation");
  }
}