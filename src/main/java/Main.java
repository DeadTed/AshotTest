import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, AWTException {
        /////////////////////////////////////////////////////////////////////////////////////
        String path = "c:\\Users\\Minchanka\\Documents\\testScreenshots\\";
        String table ="/html/body[@id='bd']/div[@id='ja-wrapper']/div[@id='ja-wrapper-inner']/div[@id='ja-containerwrap']/div[@id='ja-container']/div[@id='ja-mainbody']/div[@id='ja-contentwrap']/div[@id='ja-content']/table[@id='curr_table']";
        ChromeDriver driver;
        Main m = new Main();
        m.setRootScreenshotsDir(path);
        Setup.driver("chrome", "windows");
        driver = new ChromeDriver();
        Setup setup = new Setup(driver);
        setup.addWindow( "https://select.by/kurs/");
        //////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Здесь должен быть урл " + driver.getCurrentUrl());
        System.out.println("Здесь должен быть размер окна " + driver.manage().window().getSize());
        //////////////////////////////////////////////////////////////////////////////////////
        //уводим мышку в верхний левый угол экрана
        Robot bot = new Robot();
        bot.mouseMove(0, 0);
        //////////////////////////////////////////////////////////////////////////////////////
        // Обычный скриншот страницы
//        Screenshot screenshot = new AShot().takeScreenshot(driver);

        /////////////////////////////////////////////////////////////////////////////////////
        // Скриншот со скроллом:
//        Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
        Screenshot actualScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
        ////////////////////////////////////////////////////////////////////////////////////////
        //Скриншот веб-элемента:
//        WebElement table = driver.findElement(By.xpath(table));
//        Screenshot screenshot2 = new AShot().takeScreenshot(driver, table);
//
//        Screenshot screenshot3 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver,header);
        ////////////////////////////////////////////////////////////////////////////////////////
        //Сохраняем полученный скриншот в файл:

//        File actualFile = new File(path+"\\actual\\screenshot.png");
//        ImageIO.write(screenshot.getImage(), "png", actualFile);
//
//        File actualFile1 = new File(path+"\\actual\\screenshot1.png");
//        ImageIO.write(screenshot1.getImage(), "png", actualFile1);

        File actualFile1 = new File(path+"\\expected\\screenshot1.png");
        ImageIO.write(actualScreenshot.getImage(), "png", actualFile1);
////
//        File actualFile2 = new File(path + "\\actual\\screenshot2.png");
//        ImageIO.write(screenshot2.getImage(), "PNG", actualFile2);
//
//        File actualFile3 = new File(path + "\\actual\\screenshot3.png");
//        ImageIO.write(screenshot3.getImage(), "PNG", actualFile3);
        ////////////////////////////////////////////////////////////////////////////////////////
        //Достаём скриншот,который будет использоваться как EXPECTED
        Screenshot expectedScreenshot = new Screenshot(ImageIO.read(new File(path+"\\actual\\screenshot1.png")));
        //Сравниваем expected с actual
        ImageDiff diff = new ImageDiffer().makeDiff(expectedScreenshot, actualScreenshot);
        ////////////////////////////////////////////////////////////////////////////////////////
        //получаем результат сравнения
        diff.getDiffSize();
        //проверка на колличество отличий(по пикселям)
//        Assert.assertEquals(diff.getDiffSize(), 0);
        //складываем полученный результат
        File diffFile = new File(path+"\\diff\\screenshot1.png");
        ImageIO.write(diff.getMarkedImage(), "png", diffFile);
        //Преобразование в гиф
//        File[] filesArray = {expectedFile, actualFile, diffFile};
//        gifFile = GifSequenceWriter.createGIF(filesArray, resultGifs+name);
        ////////////////////////////////////////////////////////////////////////////////////////
        driver.close();

    }

    //метод для работы с файлами и папками,если указанного нет ,создает,если есть - заносит в переменную!
    public void setRootScreenshotsDir(String absolutePath) {
        Main m = new Main();

        String resourcesImagesDir = absolutePath;
        m.checkAndIfHavant_Create(resourcesImagesDir);

        String expectedDir = resourcesImagesDir + "/expected/";
        m.checkAndIfHavant_Create(expectedDir);

        String actualDir = resourcesImagesDir + "/actual/";
        m.checkAndIfHavant_Create(actualDir);

        String diffDir = resourcesImagesDir + "/diff/";
        m.checkAndIfHavant_Create(diffDir);

        String resultGifsDir = resourcesImagesDir + "/gifs/";
        m.checkAndIfHavant_Create(resultGifsDir);
    }

    //    Метод который проверяет наличие папок file.exists() , в случае их отсутствия - создает (file.mkdirs())
    public void checkAndIfHavant_Create(String Path) {
        File file = new File(Path);
        if (file.exists()) {
            System.out.println("================================================================");
            System.out.println("Всё ок!");
            System.out.println("Путь : " + Path);
            System.out.println("Приятного использования...Class main. Method checkAndIfHavant_Create.");
            System.out.println("================================================================");
        } else {
            file.mkdirs();
            System.out.println("================================================================");
            System.out.println("Указанного пути - не существует!");
            System.out.println("...Создание папки...");
            System.out.println("Путь создан : " + Path);
            System.out.println("Приятного использования...Class main. Method checkAndIfHavant_Create.");
            System.out.println("================================================================");
        }
    }
}
