package ru.dexsys.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import org.openqa.selenium.JavascriptException;
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
    private SelenideElement countProductOpeningPageCart = $x("//span[@id=\"summary_products_quantity\"]");
    private SelenideElement countFirstProduct = $x("//dl[@class=\"products\"]//dt[1]//span[@class=\"quantity\"]");

    public static String getBASE_URL() {
        return BASE_URL;
    }

    public void addToCart() throws JavascriptException, AssertionError {
        JavascriptExecutor js = (JavascriptExecutor) addProductToCart.getWrappedDriver();
        js.executeScript("arguments[0].click();", addProductToCart);
        closePopUpWindow.click();
        int countProduct = Integer.parseInt(countProducts.getOwnText());
        Assert.assertTrue(countProduct > 0);
    }

    public void cartNotEmpty() throws AssertionError {
        int text = Integer.parseInt(checkNotEmptyCart.getOwnText());
        Assert.assertTrue(text >= 1);
    }

    public void removeFirstProduct() throws JavascriptException, AssertionError {
        int countProduct = Integer.parseInt(countProducts.getOwnText());
        Assert.assertFalse((countProduct - 1) > 0);
        JavascriptExecutor js = (JavascriptExecutor) removeFirstProduct.getWrappedDriver();
        js.executeScript("arguments[0].click();", removeFirstProduct);
    }

    public void openPageCart() {
        openPageCart.click();
        var temp = WebDriverRunner.currentFrameUrl();
        Assert.assertFalse(WebDriverRunner.currentFrameUrl() == BASE_URL);
    }

    public void checkCountProducts() throws AssertionError {
        String countProduct = countProducts.getOwnText();
        openPageCart();
        String countAfterOpening = countProductOpeningPageCart.getOwnText();
        Assert.assertTrue(countAfterOpening.contains(countProduct));
    }

    public void checkCountFirstProduct() throws AssertionError {
        int countProduct = Integer.parseInt(countFirstProduct.getOwnText());
        Assert.assertTrue(countProduct >= 1);
    }


}
