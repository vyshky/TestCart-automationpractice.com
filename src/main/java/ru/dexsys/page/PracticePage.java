package ru.dexsys.page;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import org.openqa.selenium.*;
import ru.dexsys.util.ColorCode;

import java.time.chrono.JapaneseEra;

import static com.codeborne.selenide.Selenide.*;

public class PracticePage {
    private static final String BASE_URL = "http://automationpractice.com/index.php";
    private SelenideElement openPageCart = $x("//div[@class=\"shopping_cart\"]/a");
    private SelenideElement checkNotEmptyCart = $x("//div[@class=\"shopping_cart\"]/a/span[1]");

    private SelenideElement addProductToCart = $x("//a[@data-id-product=\"1\"]");
    private SelenideElement closePopUpWindow = $x("//span[@class=\"cross\"]");
    private SelenideElement removeFirstProduct = $x("//dl[@class=\"products\"]/dt[1]/span/a");

    private SelenideElement countProductOpeningPageCart = $x("//span[@id=\"summary_products_quantity\"]");
    private SelenideElement countProducts = $x("//div[@class=\"shopping_cart\"]//span[1]");
    private SelenideElement countFirstProduct = $x("//dl[@class=\"products\"]//dt[1]//span[@class=\"quantity\"]");

    private SelenideElement blockButton = $x("//div[@class=\"shopping_cart\"]/a[1]");


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
        int cartNotEmpty = Integer.parseInt(checkNotEmptyCart.getOwnText());
        Assert.assertTrue(cartNotEmpty > 0);
    }

    public void removeFirstProduct() throws JavascriptException, AssertionError {
        int countProduct = Integer.parseInt(countProducts.getOwnText());
        Assert.assertFalse((countProduct - 1) > 0);
        JavascriptExecutor js = (JavascriptExecutor) removeFirstProduct.getWrappedDriver();
        js.executeScript("arguments[0].click();", removeFirstProduct);
    }

    public void openPageCart() {
        openPageCart.click();
        Assert.assertFalse(WebDriverRunner.currentFrameUrl() == BASE_URL);
    }

    public void checkCountProducts() throws AssertionError {
        String countProduct = countProducts.getOwnText();
        openPageCart();
        String countProductsPage = countProductOpeningPageCart.getOwnText();
        Assert.assertTrue(countProductsPage.contains(countProduct));
    }

    public void checkCountFirstProduct() throws AssertionError {
        int firstProduct = Integer.parseInt(countFirstProduct.getOwnText());
        Assert.assertTrue(firstProduct > 0);
    }

    public void checkColorIcon() {
        JavascriptExecutor js = (JavascriptExecutor) blockButton.getWrappedDriver();
        String colorIcon = js.executeScript("return window.getComputedStyle(document.querySelector('.shopping_cart > a'),'::before').getPropertyValue('color')")
                .toString();
        Assert.assertTrue(colorIcon.equals(ColorCode.white));
    }
}

