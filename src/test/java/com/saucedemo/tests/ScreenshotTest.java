package com.saucedemo.tests;

import com.codeborne.selenide.Selenide;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saucedemo.jupiter.CookieLogin;
import com.saucedemo.model.ScreenDiffer;
import io.qameta.allure.Allure;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ScreenshotTest extends TestBase {

    @CookieLogin(url = "inventory-item.html?id=4")
    @Test
    public void assertScreenshot() throws IOException {
        File screenshot = $("[data-test='item-sauce-labs-backpack-img']").screenshot();
        FileUtils.copyFile(screenshot, new File("src/test/resources/screenshots/backpack.png"));
    }

    @CookieLogin(url = "inventory-item.html?id=4")
    @Test
    public void assertScreenshot2() throws IOException {
        BufferedImage expected = ImageIO.read(new File("src/test/resources/screenshots/backpackError.png"));
        BufferedImage actual = ImageIO.read($("[data-test='item-sauce-labs-backpack-img']").screenshot());
        ImageDiff imageDiff = new ImageDiffer().makeDiff(expected, actual);
        BufferedImage markedImage = imageDiff.getMarkedImage();

        ScreenDiffer screenDiffer = ScreenDiffer.builder()
                .actual("data:image/png;base64," + Base64.getEncoder().encodeToString(imageToBytes(actual)))
                .expected("data:image/png;base64," + Base64.getEncoder().encodeToString(imageToBytes(expected)))
                .diff("data:image/png;base64," + Base64.getEncoder().encodeToString(imageToBytes(markedImage)))
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(screenDiffer);
        Allure.addAttachment("Screenshot diff",
                "application/vnd.allure.image.diff",
                jsonString);

        assertThat(imageDiff.hasDiff()).isFalse();
    }

    @SneakyThrows
    private static byte[] imageToBytes(BufferedImage image) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            ImageIO.write(image, "png", byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
    }
}
