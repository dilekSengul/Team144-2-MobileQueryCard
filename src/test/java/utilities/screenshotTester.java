package utilities;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import java.io.File;
import java.nio.file.Files;

import static junit.framework.TestCase.assertTrue;


public class ElementVisibilityHelper {
    static {
        nu.pattern.OpenCV.loadLocally(); // OpenCV Kütüphanesini Yükle
    }

    public static void verifyElementVisibility(String templatePath, double threshold) throws Exception {

        AppiumDriver driver = Driver.getAppiumDriver();
        //Ekran görüntüsü
        String screenPath = "screen.png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), new File(screenPath).toPath());

        // openCV ile karşılaştırma expectedSS/actualSS
        Mat screen = Imgcodecs.imread(screenPath);
        Mat template = Imgcodecs.imread(templatePath);

        Mat result = new Mat();
        Imgproc.matchTemplate(screen, template, result, Imgproc.TM_CCOEFF_NORMED);

        //Örtüşme kontrolü
        Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
        boolean isVisible = mmr.maxVal >= threshold;

        //örtüşme sonucu üzerinden junit basit assertion
        try {
            assertTrue("Element görünür değil!",isVisible);
            System.out.println("element görünür/visibilityAssertion basarılı");
        }
        catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }

        //son olarak dosyayı siler
        new File(screenPath).delete();
    }
}

