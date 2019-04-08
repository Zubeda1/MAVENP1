package com.mavenitseleniumtraining.PageObject;

import com.mavenitseleniumtraining.Driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage  extends DriverManager {
    public static String searchItem;
    @FindBy(id = "searchTerm")
    private WebElement searchTextBox;

    @FindBy(className = "argos-header__search-button")
    private WebElement magniGlass;

    public void searchProduct(String item) {
        searchItem = item;
        searchTextBox.sendKeys(item);

        waitUntilClickable(driver.findElement(By.className("argos-header__search-button")));
        magniGlass.click();
    }
    public void emptysearch(){
        magniGlass.click();
    }
    public String getcurrenturl(){
        return driver.getCurrentUrl();
    }
}

