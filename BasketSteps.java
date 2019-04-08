package com.mavenitseleniumtraining.StepDef;

import com.mavenitseleniumtraining.PageObject.BasketPage;
import com.mavenitseleniumtraining.PageObject.HeaderPage;
import com.mavenitseleniumtraining.PageObject.ProductDescriptionPage;
import com.mavenitseleniumtraining.PageObject.ResultsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class BasketSteps {
    private HeaderPage headerPage = new HeaderPage();
    private ResultsPage resultsPage = new ResultsPage();
 private ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage();
 private BasketPage basketPage = new BasketPage();
    @When("^I search the product \"([^\"]*)\"$")
    public void i_search_the_product(String item)
    {
        headerPage.searchProduct(item);
    }

    @When("^I select any product$")
    public void i_select_any_product(){

        resultsPage.selectAnyProduct();
    }

    @When("^I add the product on basket$")
    public void i_add_the_product_on_basket(){
        productDescriptionPage.addToBasket();
        productDescriptionPage.goToTrolley();

    }

    @Then("^I should be able to see product in the basket$")
    public void iShouldBeAbleToSeeProductInTheBasket() {
        List<String>productList = basketPage.getProductsInBaskets();
        assertThat(productList,hasItem(ResultsPage.selectProduct));
    }
}
