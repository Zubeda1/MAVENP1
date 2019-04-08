package com.mavenitseleniumtraining.PageObject;

import com.mavenitseleniumtraining.Driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ResultsPage  extends DriverManager {

    //search product n add in  basket
    @FindBy(css=".search-title__term")
    private WebElement headerText;

    @FindBy(css=".ac-product-card__name")
    private List<WebElement> productNames;

    public static String selectProduct;

    //filter by rating and price
    @FindBy(css = ".ac-facet__label")
    private List<WebElement> filtersBy;

    @FindBy(css = ".ac-star-rating")
    private List<WebElement> reviewImageOnProducts;

    @FindBy(css = ".ac-product-price__amount")
    private List<WebElement> pricesOnProducts;


    public String getProductHeader(){

        return headerText.getText();
    }

    public void selectAnyProduct(){
        int totalProducts = productNames.size();
        if(totalProducts<=0){
        throw  new RuntimeException("No Products are available.");
        }
        Random random= new Random();
        int randomnumber = random.nextInt(totalProducts);
        WebElement selectWebElement = productNames.get(randomnumber);
        selectProduct = selectWebElement.getText();
        selectWebElement.click();
    }//search product randomly


//filterby steps --rating n prices
    public void selectFilterBy(String filterChoice) {
          for (WebElement filterElement : filtersBy) {
             if (filterElement.getText().equalsIgnoreCase(filterChoice)) {
               waitUntilClickable(filterElement).click();
                  break;
                }
           }
            sleep(9000);
            waitForInviOfElement(By.cssSelector(".icon--loading"));

        }

        public List<Double> getAllProductsPrices() {
           List<Double> collectedPriceList = new ArrayList<>();

           for (WebElement filterWebelement : pricesOnProducts) {
               double indiPrice = Double.parseDouble(filterWebelement.getText().replace("£", ""));
              collectedPriceList.add(indiPrice);}
          return collectedPriceList;
    }



    public List<Double> getAllRatingOnProducts() {
        List<Double> collectedRatingList = new ArrayList<>();
        for (WebElement filterWebelemt : reviewImageOnProducts) {
            String ratingValueInString = filterWebelemt.getAttribute("data-star-rating");
            double ratingValueInDouble = Double.parseDouble(ratingValueInString);
            collectedRatingList.add(ratingValueInDouble);
        }
        return collectedRatingList;
    }
}





//@FindBy(css = ".ac-facet__filters--rating>li>label")
  //  private List<WebElement> reviewFilterItems;
   // public void selectReviewRating(String cuRating) {
   //     //List<WebElement> ratings = driver.findElements(By.cssSelector(".ac-facet__filters--rating>li>label"));
       // for (WebElement rating : reviewFilterItems) {
           // String ratingsInString = rating.getText();
            //if (ratingsInString.matches(cuRating)) {
            //    waitUntilClickable(rating).click();
             //   break;}}}
/*@FindBy(css = ".ac-star-rating")
    private List<WebElement> reviewRatingStarImg;
    */
//public List<Double> getAllRatings() {
       // List<Double> actualratinglist = new ArrayList<>();//empty arraylist
       // sleep(4000);
        // List<WebElement> ratings = driver.findElements(By.cssSelector(".ac-star-rating"));
        //for (WebElement rating :reviewRatingStarImg) {
          //  String ratingsInString = rating.getAttribute("data-star-rating");
           // double ratingsInDouble = Double.parseDouble(ratingsInString);
            //actualratinglist.add(ratingsInDouble);
       // }
        //return actualratinglist;
    //}

    //@FindBy(css =".sort-select>option")
    //private List<WebElement>sortByValue;
    //public void sorting(String value) {
        // driver.findElement(By.cssSelector(".sort-panel"));
        // driver.findElement(By.cssSelector(".sort-icon>span")).click();
       // List<WebElement> sorts = driver.findElements(By.cssSelector(".sort-select>option"));
       // for (WebElement sort : sortByValue) {
            //String sortsInString = sort.getAttribute("value");
            //if (sortsInString.matches(value)) {
                //sort.click();
            //    break;
           // }
       // }
    //}
    //@FindBy (css=".ac-facet__label.ac-facet__label--default.checkbox__label")
    //private List<WebElement>listByValue;


    //public void listByPrice(String value) {
       // List<WebElement> price = driver.findElements(By.cssSelector(".ac-facet__label.ac-facet__label--default.checkbox__label"));
       // sleep(4000);
        //for (WebElement newprice : listByValue) {
          //  String priceInString = newprice.getText();
          //  if (priceInString.matches(value)) {
         //       newprice.click();
            //    break;
        //    }
      //  }
   // }
   // public void getAllPrice() {
        //List<Double> actualPriceList = new ArrayList<>();
        //sleep(4000);
        //List<WebElement> Price = driver.findElements(By.cssSelector(".ac-product-price__amount"));

       // System.out.println(Price.size());

        //for (int i = 0; i < Price.size(); i++) {
            //System.out.print(Price.get(i).getText() + " , " + " ");}
  //  }//
//}












