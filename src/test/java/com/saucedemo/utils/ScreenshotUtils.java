package com.saucedemo.utils;

import com.codeborne.selenide.SelenideElement;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saucedemo.model.ScreenDiffer;
import io.qameta.allure.Allure;
import lombok.SneakyThrows;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

public class ScreenshotUtils {

    private static final String SCREENSHOT_FOLDER = "src/test/resources/screenshots/";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static void verifyScreenshot(SelenideElement element) {
        String elementName = getElementName(element);
        String screenshotPath = SCREENSHOT_FOLDER + elementName + ".png";

        File actualScreenshotFile = element.screenshot();
        File expectedScreenshotFile = new File(screenshotPath);

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

            String jsonString = objectMapper.writeValueAsString(screenDiffer);
            Allure.addAttachment("Screenshot diff",
                    "application/vnd.allure.image.diff",
                    jsonString);

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
        return name.replaceAll("[^a-zA-Z0-9_-]", "_"); // Очищаем от недопустимых символов
    }
}
