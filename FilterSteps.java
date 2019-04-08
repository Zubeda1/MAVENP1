package com.mavenitseleniumtraining.StepDef;

import com.mavenitseleniumtraining.PageObject.ResultsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class FilterSteps {
    ResultsPage resultsPage = new ResultsPage();


    @When("^I apply filter \"([^\"]*)\" on search result$")
    public void i_apply_filter_on_search_result(String filterValue) {
         resultsPage.selectFilterBy(filterValue);
    }


    @Then("^I should see all products \"([^\"]*)\" are filtered \"([^\"]*)\"$")
    public void i_should_see_all_products_are_filtered(String filter, String filterValue){
        if (filter.equalsIgnoreCase("review")) {
            List<Double> actual = resultsPage.getAllRatingOnProducts();
            assertThat("List is storing wrong value",
                    actual, everyItem(greaterThanOrEqualTo(Double.parseDouble(filterValue))));
        }
        if (filter.equalsIgnoreCase("range")) {
            List<Double> actual = resultsPage.getAllProductsPrices();
            List<String> rangeList = Arrays.asList(filterValue.split("-"));
            Double min = Double.parseDouble(rangeList.get(0));
            Double max = Double.parseDouble(rangeList.get(1));
            assertThat(actual, everyItem(is(both(greaterThanOrEqualTo(min)).and(lessThanOrEqualTo(max)))));
        }

    }
}
