package org.example;

import org.junit.Test;
import org.example.Constant;

import static org.example.Constant.*;

public class PageTest extends BaseTest {


    @Test
    public void login() throws InterruptedException {

            new BasePage(driver).start();
            new BasePage(driver).assertMainPage(FIRST_LINK);
            new BasePage(driver).login(U_MAIL, U_PSW);
            new BasePage(driver).start();
            new BasePage(driver).search(SEARCHING_PRO);
            new BasePage(driver).scroll();
            new BasePage(driver).bekle();
            new BasePage(driver).moreItem();
            new BasePage(driver).randomClick();
            new BasePage(driver).bekle();
            //new LoginPage(driver).randomSize();
            new BasePage(driver).size();
            new BasePage(driver).addToCart();
            new BasePage(driver).goToCart();
            new BasePage(driver).sayıArttır();
            new BasePage(driver).bekle();
          //  new BasePage(driver).assertBack();
            new BasePage(driver).deleteProduct();
            new BasePage(driver).bekle();
            new BasePage(driver).deleteProduct2();
            new BasePage(driver).bekle();


        }

    }



