//import PageObject.*;
//import org.junit.Assert;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class TestCasesPageObject {
//    private FirefoxDriver driver;
//
//    @BeforeMethod
//    public void Setup() {
//        Setup.driver("gecko", "windows");
//        driver = new FirefoxDriver();
//        Setup setup = new Setup(driver);
//        setup.addWindow(1, "https://select.by/kurs/");
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        TearDown tearDown = new TearDown(driver);
//        tearDown.close();
//    }
//
//        @Test//ДАЖЕ ЕСЛИ КЕЙС ПРОЙДЕН НЕ УСПЕШНО ПИШЕТ PASSED!?
//    public void TestCase1() {
//
//        TestCase1PageFactory testCase1 = new TestCase1PageFactory(driver);
//
//        testCase1.unsortClick();
//        testCase1.firstClick();
//
//        WebElement firstNumber = testCase1.firstNumber();
//        WebElement exchangeRates = testCase1.exchangeRates();
//
//        if (firstNumber.getText().equals(exchangeRates.getText())) {
//            System.out.println("--------------------------------------------------");
//            System.out.println("Тест пройден успешно!");
//            System.out.println("Лучшее = " + firstNumber.getText());
//            System.out.println("Лучший курс = " + exchangeRates.getText());
//            System.out.println("--------------------------------------------------");
//        } else {
//            System.out.println("--------------------------------------------------");
//            System.out.println("Тест не пройден,курсы не соответствуют!");
//            System.out.println("Первое число в столбце = " + firstNumber.getText());
//            System.out.println("Лучший курс = " + exchangeRates.getText());
//            System.out.println("--------------------------------------------------");
//        }
//    }
//
//    @Test
//    public void TestCase2() {
//
//        TestCase2PageFactory testCase2 = new TestCase2PageFactory(driver);
//
//        testCase2.unsortClick();
//        testCase2.firstClick();
//
//        String hex = testCase2.getHexColor();
//
//        if (hex.equals("#afffaf")) {
//            System.out.println("--------------------------------------------------");
//            System.out.println("Тест пройден успешно!");
//            System.out.println("Цвет " + hex);
//            System.out.println("--------------------------------------------------");
//        } else {
//            System.out.println("--------------------------------------------------");
//            System.out.println("Тест не пройден,курсы не соответствуют!");
//            System.out.println("Цвет не соответствует");
//            System.out.println("Применён " + hex + ". Должен быть - #afffaf");
//            System.out.println("--------------------------------------------------");
//        }
//    }
//    @Test
//    public void TestCase3() {
//
//        String BankList = "/html/body[@id='bd']/div[@id='ja-wrapper']/div[@id='ja-wrapper-inner']/div[@id='ja-containerwrap']/div[@id='ja-container']/div[@id='ja-mainbody']/div[@id='ja-contentwrap']/div[@id='ja-content']/table[@id='curr_table']/tbody/tr/td[3]";
//
//        TestCase3PageFactory testCase3 = new TestCase3PageFactory(driver);
//
//        testCase3.oneClick();
//
//        ArrayList<String> obtainedList = new ArrayList();
//
//        testCase3.getObtainedList(obtainedList);
//
//        double[] unsort = new double[obtainedList.size()];
//
//        testCase3.writeInArray(obtainedList, unsort);
//
//        double[] sort = new double[obtainedList.size()];
//
//        testCase3.writeInArray(obtainedList, sort);
//
//        Arrays.sort(sort);
//
//        if (Arrays.equals(sort, unsort)) {
//            System.out.println("--------------------------------------------------");
//            System.out.println("Тест пройден успешно!");
//            System.out.println("--------------------------------------------------");
//            System.out.println("Массив c Web страницы:");
//            System.out.println(Arrays.toString(unsort));
//            System.out.println("Правильно отсортированный массив:");
//            System.out.println(Arrays.toString(sort));
//            System.out.println("--------------------------------------------------");
//        } else {
//            System.out.println("--------------------------------------------------");
//            System.out.println("Тест не пройден,сортировка не верная!");
//            System.out.println("--------------------------------------------------");
//            System.out.println("Массив c Web страницы:");
//            System.out.println(Arrays.toString(unsort));
//            System.out.println("Правильно отсортированный массив:");
//            System.out.println(Arrays.toString(sort));
//            System.out.println("--------------------------------------------------");
//        }
//    }
//
//    @Test
//    public void TestCase4() {
//
//        TestCase4PageFactory testCase4 = new TestCase4PageFactory(driver);
//
//        testCase4.oneClick();
//
//        ArrayList<String> obtainedList = new ArrayList();
//        ArrayList<String> sortedList = new ArrayList();
//
//        testCase4.getObtainedList(obtainedList);
//        testCase4.fromListToListAndSort(obtainedList, sortedList);
//
//        try {
//            Assert.assertTrue(sortedList.equals(obtainedList));
//            System.out.println("--------------------------------------------------");
//            System.out.println("Все ОК! Значения отсортированны верно.");
//            System.out.println("--------------------------------------------------");
//            System.out.println("Результат с Web-страницы:");
//            System.out.println(obtainedList);
//            System.out.println("Правильная сортировака:");
//            System.out.println(sortedList);
//            System.out.println("--------------------------------------------------");
//        } catch (Exception e) {
//            System.out.println("--------------------------------------------------");
//            System.out.println("Значения отсортированы не верно");
//            System.out.println("--------------------------------------------------");
//            System.out.println("Результат с Web-страницы:");
//            System.out.println(obtainedList);
//            System.out.println("Правильная сортировака:");
//            System.out.println(sortedList);
//            System.out.println("--------------------------------------------------");
//            System.err.println(e);
//        }
//    }
//}
