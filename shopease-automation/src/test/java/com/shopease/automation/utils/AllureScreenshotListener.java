package com.shopease.automation.utils;

import java.io.ByteArrayInputStream;

import io.qameta.allure.Allure;
import io.qameta.allure.AttachmentOptions;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;

public class AllureScreenshotListener
        implements TestLifecycleListener {

    @Override
    public void beforeTestStop(TestResult result) {

        byte[] screenshot =
                FailureScreenshotStore.getScreenshot();

        if ("failed".equalsIgnoreCase(
                result.getStatus().value())
                && screenshot != null) {

            Allure.attachment(
                    "Failure Screenshot",
                    "image/png",
                    new ByteArrayInputStream(screenshot),
                    AttachmentOptions.withFileExtension(".png")
            );
        }

        FailureScreenshotStore.clear();
    }
}