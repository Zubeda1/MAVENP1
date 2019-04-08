package com.mavenitseleniumtraining.PageObject;

import com.mavenitseleniumtraining.Driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDescriptionPage extends DriverManager {
    @FindBy(xpath = "//div[4]/div[2]/button/span/span")
    private WebElement trolleyBtn;


    @FindBy(xpath = "//a[contains(text(),'Go To Trolley')]")
    private WebElement goToTrolleyBtn;

    public void addToBasket(){
        waitUntilClickable(trolleyBtn).click();
    }
    public void goToTrolley(){
        waitUntilClickable(goToTrolleyBtn).click();
    }
}
