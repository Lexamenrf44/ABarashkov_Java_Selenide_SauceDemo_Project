package com.saucedemo.utils;

import com.codeborne.selenide.SelenideElement;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saucedemo.model.ScreenDiffer;
import io.qameta.allure.Allure;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

public class ScreenshotUtils {

    private static final String SCREENSHOT_FOLDER = "src/test/resources/screenshots/";

    public static void verifyScreenshot(SelenideElement element) throws IOException {
        String elementName = getElementName(element);
        String screenshotPath = SCREENSHOT_FOLDER + elementName + ".png";

        File actualScreenshotFile = element.screenshot();
        File expectedScreenshotFile = new File(screenshotPath);
        if (!expectedScreenshotFile.exists()) {
            FileUtils.copyFile(actualScreenshotFile, expectedScreenshotFile);
            Allure.addAttachment("Expected screenshot created",
                    "Expected screenshot was not found. Created a new one: " + screenshotPath);
            return;
        }

        BufferedImage expectedImage = ImageIO.read(expectedScreenshotFile);
        BufferedImage actualImage = ImageIO.read(actualScreenshotFile);
        ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

        if (diff.hasDiff()) {
            BufferedImage diffImage = diff.getMarkedImage();
            ScreenDiffer screenDiffer = ScreenDiffer.builder()
                    .actual("data:image/png;base64," + Base64.getEncoder().encodeToString(imageToBytes(actualImage)))
                    .expected("data:image/png;base64," + Base64.getEncoder().encodeToString(imageToBytes(expectedImage)))
                    .diff("data:image/png;base64," + Base64.getEncoder().encodeToString(imageToBytes(diffImage)))
                    .build();

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(screenDiffer);
            Allure.addAttachment("Screenshot diff",
                    "application/vnd.allure.image.diff",
                    jsonString);

            File diffFile = new File(SCREENSHOT_FOLDER + "diff_" + elementName + ".png");
            ImageIO.write(diffImage, "png", diffFile);

            assertThat(diff.hasDiff()).isFalse();
        } else {
            Allure.addAttachment("Screenshot match", "No differences found for element: " + elementName);
        }
    }

    @SneakyThrows
    private static byte[] imageToBytes(BufferedImage image) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            ImageIO.write(image, "png", byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
    }

    private static String getElementName(SelenideElement element) {
        String name = element.getAttribute("data-test");
        if (name == null || name.isEmpty()) {name = element.getAttribute("id");}
        if (name == null || name.isEmpty()) {name = element.getAttribute("name");}
        if (name == null || name.isEmpty()) {name = "unknown_element";}

        return name.replaceAll("[^a-zA-Z0-9_-]", "_"); // Очищаем от недопустимых символов
    }
}
