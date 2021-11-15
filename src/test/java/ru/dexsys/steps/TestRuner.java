package ru.dexsys.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.junit.runner.RunWith;
import ru.dexsys.page.PracticePage;

@CucumberOptions
        (
                features = "src/test/resources",
                glue = "ru/dexsys/steps",
                plugin = "pretty"
        )
@RunWith(Cucumber.class)
public class TestRuner {
    private PracticePage page = new PracticePage();


    @Given("I open page")
    public void openUrl() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Selenide.open(PracticePage.getBASE_URL());
    }

    @Given("I add a product")
    public void addToCart() {
        try {
            page.addToCart();
        } catch (AssertionError e) {
            Assert.fail(e.getMessage());
        }
    }

    @Given("I am removing a product")
    public void removeFirstProduct() {
        try {
            page.addToCart();
            page.removeFirstProduct();
        } catch (AssertionError e) {
            Assert.fail(e.getMessage());
        }
    }

    @Given("I am checking if there is a product")
    public void cartNotEmpty() {

        try {
            page.addToCart();
            page.cartNotEmpty();
        } catch (AssertionError e) {
            Assert.fail("В корзине нет всплывающих элементов\n" + e.getMessage() + "\t" + e);
        }
    }

    @Given("I open cart page")
    public void openCart() {
        try {
            page.openPageCart();
        } catch (AssertionError e) {
            Assert.fail(e.getMessage());
        }
    }


    @Given("I check the number of products in the basket")
    public void checkCountProducts() {
        try {
            page.addToCart();
            page.checkCountProducts();
        } catch (AssertionError e) {
            Assert.fail("Количество продуктов в блоке Cart не совпадает c содержимым количеством продуктов" + e.getMessage() + "\t" + e);
        }
    }

    @Given("I check the quantity")
    public void checkCountProduct() {
        try {
            page.addToCart();
            page.checkCountProduct();
        } catch (AssertionError e) {
            Assert.fail("Количество первого продукта не может быть меньше 1" + e.getMessage() + "\t" + e);
        }
    }


}
