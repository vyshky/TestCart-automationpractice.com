package ru.dexsys.page;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.*;

public class PracticePage {
    private static final String BASE_URL = "http://automationpractice.com/index.php";
    private SelenideElement addProductToCart = $x("//a[@data-id-product=\"1\"]");
    private SelenideElement closePopUpWindow = $x("//span[@class=\"cross\"]");
    private SelenideElement checkNotEmptyCart = $x("//div[@class=\"shopping_cart\"]/a/span[1]");
    private SelenideElement removeFirstProduct = $x("//dl[@class=\"products\"]/dt[1]/span/a");
    private SelenideElement openPageCart = $x("//div[@class=\"shopping_cart\"]/a");
    private SelenideElement countProducts = $x("//div[@class=\"shopping_cart\"]//span[1]");
    private SelenideElement countProductOpeningCart = $x("//span[@id=\"summary_products_quantity\"]");
    private SelenideElement countFirstProduct = $x("//dl[@class=\"products\"]//dt[1]//span[@class=\"quantity\"]");


    public static String getBASE_URL() {
        return BASE_URL;
    }

    public void addToCart() throws AssertionError {
        JavascriptExecutor js = (JavascriptExecutor) addProductToCart.getWrappedDriver();
        js.executeScript("arguments[0].click();", addProductToCart);
        closePopUpWindow.click();
    }

    public void cartNotEmpty() throws AssertionError {
        int text = Integer.parseInt(checkNotEmptyCart.getOwnText());
        Assert.assertTrue(text >= 1);
    }

    public void removeFirstProduct() throws AssertionError {
        JavascriptExecutor js = (JavascriptExecutor) removeFirstProduct.getWrappedDriver();
        js.executeScript("arguments[0].click();", removeFirstProduct);
    }

    public void openPageCart() {
        openPageCart.click();
    }

    public void checkCountProducts() throws AssertionError {
        String countProduct = countProducts.getOwnText();
        openPageCart();
        String countAfterOpening = countProductOpeningCart.getOwnText();
        Assert.assertTrue(countAfterOpening.contains(countProduct));
    }

    public void checkCountProduct() throws AssertionError {
        int countProduct = Integer.parseInt(countFirstProduct.getOwnText());
        Assert.assertTrue(countProduct >= 1);
    }


}
