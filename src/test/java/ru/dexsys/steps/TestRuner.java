package ru.dexsys.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptException;
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
            page.removeFirstProduct();
        } catch (JavascriptException | AssertionError e) {
            Assert.fail("Не удалось добавить продукт , возможно на странице нет продуктов");
        }
    }

    @Given("I am removing a product")
    public void removeFirstProduct() {
        try {
            page.addToCart();
            page.removeFirstProduct();
        } catch (JavascriptException | AssertionError e) {
            Assert.fail("Не удалось удалить продукт  , возможно ваша корзина пуста");
        }
    }

    @Given("I am checking if there is a product")
    public void cartNotEmpty() {

        try {
            page.addToCart();
            page.cartNotEmpty();
            page.removeFirstProduct();
        } catch (AssertionError e) {
            Assert.fail("В корзине нет всплывающих элементов\n" + e.getMessage() + "\t" + e);
        }
    }

    @Given("I open cart page")
    public void openCart() {
        try {
            page.openPageCart();
        } catch (AssertionError e) {
            Assert.fail("Страница не открылась");
        }
    }


    @Given("I check the number of products in the basket")
    public void checkCountProducts() {
        try {
            page.addToCart();
            page.checkCountProducts();
            page.removeFirstProduct();
        } catch (AssertionError e) {
            Assert.fail("Количество продуктов в блоке Cart не совпадает c содержимым количеством продуктов" + e.getMessage() + "\t" + e);
        }
    }

    @Given("I check the quantity")
    public void checkCountProduct() {
        try {
            page.addToCart();
            page.checkCountProduct();
            page.removeFirstProduct();
        } catch (AssertionError e) {
            Assert.fail("Количество первого продукта не может быть меньше 1" + e.getMessage() + "\t" + e);
        }
    }


}
