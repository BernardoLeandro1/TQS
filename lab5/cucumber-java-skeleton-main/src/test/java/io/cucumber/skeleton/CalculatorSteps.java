package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSteps {

    private Calculator calculator;

    @Given("a calculator I just turned on")
    public void a_calculator_I_just_turned_on() {
        calculator = new Calculator();
    }

    @When("I subtract {int} to {int}")
    public void subtract(int a, int b) {
            calculator.subtract(a, b);
    }

    @When("I add {int} and {int}")
    public void add(int a, int b) {
        calculator.add(a, b);
    }

    @Then("the result is {int}")
    public void the_result_is(int result) {
        assertEquals(calculator.result(), result);
    }

}