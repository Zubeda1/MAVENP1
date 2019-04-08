package com.mavenitseleniumtraining.StepDef;

import com.mavenitseleniumtraining.PageObject.HeaderPage;
import com.mavenitseleniumtraining.PageObject.ResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchSteps {
    private HeaderPage headerPage = new HeaderPage();
    private ResultsPage resultsPage = new ResultsPage();
    @Given("^I am on homepage$")
    public void i_am_on_homepage() {
        String actual =headerPage.getcurrenturl();
        assertThat(actual,is(endsWith("co.uk/")));
    }

    @When("^I search for a product \"([^\"]*)\"$")
    public void i_search_for_a_product(String item) {
        headerPage.searchProduct(item);
    }

    @Then("^I should be able to see respective results$")
    public void i_should_be_able_to_see_respective_results()  {
        String actual =resultsPage.getProductHeader();
        assertThat(actual,is(equalToIgnoringCase(HeaderPage.searchItem)));
    }



}
