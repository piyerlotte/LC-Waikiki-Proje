package org.example;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.List;
import java.util.Random;


public class BasePage extends Constant {
    private static final Logger logger = LogManager.getLogger(BasePage.class);
    WebDriver webDriver;
    WebDriverWait webDriverWait;



    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 30, 150);

    }
    public void start(){

        logger.info("Sayfa açılıyor");
        webDriver.get(FIRST_LINK);
    }

    public void assertMainPage(String link){
        logger.info("Sayfa kontrol ediliyor");
        Assert.assertEquals(FIRST_LINK,webDriver.getCurrentUrl());

    }
            ///------------------------------------GİRİŞ--------------------
    public void login(String username, String password) {
        logger.info("Sayfaya giriş yapılıyor");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.className(LOGIN_BUTTON))).click();
        webDriver.findElement(By.id(MAIL)).clear();
        webDriver.findElement(By.id(MAIL)).sendKeys(username);
        webDriver.findElement(By.id(PSW)).clear();
        webDriver.findElement(By.id(PSW)).sendKeys(password);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(LOGIN_LINK))).click();
    }
        ////--------------------------------------ARAMA--------------------------------
    public void search(String item) {
        logger.info("Ürün aranıyor");
        webDriver.findElement(By.id(SEARCH_ITEM)).clear();
        webDriver.findElement(By.id(SEARCH_ITEM)).sendKeys(item);
        webDriver.findElement(By.id(SEARCH_ITEM)).sendKeys(Keys.ENTER);
    }
        ////---------------------------------AŞAĞI KAYDIRMA------------------------------
    public void scroll() {
        logger.info("Sayfa aşağı çekiliyor");
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
        ////-----------------------------BEKLEME----------------------------------
    public void bekle() throws InterruptedException {
        logger.info("Sayfa yüklenmesi bekleniyor");
        Thread.sleep(3000);

    }
        ////-----------------MORE ITEMS---------------------------
    public void moreItem()  {
        logger.info("Daha fazla ürün gösteriliyor");
        webDriver.findElements(By.className(MORE_BUTTON));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.className(MORE_BUTTON))).click();
    }
    public List<WebElement> listElements() {
    return webDriver.findElements(By.xpath(ELEMENT_LIST));
    }
    ////-------------------RASTGELE TIK----------------------
    public void randomClick(){
        logger.info("Rastgele ürün seçiliyor");
        Random random = new Random();
        listElements().get(random.nextInt(listElements().size())).click();
    }
    ////--------------BEDEN (KULLANILMAYAN KOD)---------------------
    public List<WebElement> listSize() {
        return webDriver.findElements(By.xpath("//div[@class='option-size']/a[1]"));
    }
    public void randomSize(){
        Random randon1 = new Random();
        listElements().get(randon1.nextInt(listSize().size())).click();
    }
    ////---------------SEPETE EKLEME---------------------
    public void addToCart(){
        logger.info("Sepete ekleniyor");
        webDriver.findElements(By.id(ADD_TO_CART));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(ADD_TO_CART))).click();
    }
    public void size(){
        logger.info("Beden seçiliyor");
        webDriver.findElements(By.xpath(SELECT_SIZE));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(SELECT_SIZE))).click();
    }
    public void goToCart(){
        logger.info("Sepete gidiliyor");
        webDriver.findElements(By.xpath(GO_TO_CART));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(GO_TO_CART))).click();
    }
    public void sayıArttır(){
        logger.info("Ürün sayısı arttırılıyor");
        webDriver.findElements(By.xpath(ADD_MORE_ITEM));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADD_MORE_ITEM))).click();
    }
    public void deleteProduct(){
        logger.info("Ürünler siliniyor");
        webDriver.findElements(By.xpath(DELETE_ITEM));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(DELETE_ITEM))).click();
    }
    public void deleteProduct2(){
        logger.info("Çıkan ikinci sayfada ürün temizleye basılıyor");
        webDriver.findElements(By.xpath(DELETE_ITEM_2));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(DELETE_ITEM_2))).click();
    }
    public void assertBack() {
        logger.info("Ürün kontrol ediliyor");
        WebElement element = (WebElement) webDriver.findElement(By.xpath(COUNT_PROS)) ;
        String elText = element.getText();
        System.out.println(elText);
        Assert.assertEquals(COUNT,elText);
        logger.info("ÜRÜNLER KONTROL EDİLDİ");
    }


}






