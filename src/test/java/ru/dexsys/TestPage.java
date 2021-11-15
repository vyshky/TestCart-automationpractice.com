package ru.dexsys;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.dexsys.page.PracticePage;

public class TestPage {
    private PracticePage page = new PracticePage();

    @Before
    public void openUrl() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        open(PracticePage.getBASE_URL());
    }

    @Test
    public void addToCart() {
        try {
            page.addToCart();
        } catch (AssertionError e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void removeFirstProduct() {
        try {
            page.addToCart();
            page.removeFirstProduct();
        } catch (AssertionError e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void cartNotEmpty() {

        try {
            page.addToCart();
            page.cartNotEmpty();
        } catch (AssertionError e) {
            Assert.fail("В корзине нет всплывающих элементов\n" + e.getMessage() + "\t" + e);
        }
    }

    @Test
    public void openCart() {
        try {
            page.openCart();
        } catch (AssertionError e) {
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void checkCountProducts() {
        try {
            page.addToCart();
            page.checkCountProducts();
        } catch (AssertionError e) {
            Assert.fail("Количество продуктов в блоке Cart не совпадает c содержимым количеством продуктов" + e.getMessage() + "\t" + e);
        }
    }

    @Test
    public void checkCountProtuct() {
        try {
            page.addToCart();
            page.checkCountProduct();
        } catch (AssertionError e) {
            Assert.fail("Количество первого продукта не может быть меньше 1" + e.getMessage() + "\t" + e);
        }
    }


}

