package com.shopease.automation.utils;

public class FailureScreenshotStore {

    private static final ThreadLocal<byte[]> screenshot =
            new ThreadLocal<>();

    public static void setScreenshot(byte[] image) {
        screenshot.set(image);
    }

    public static byte[] getScreenshot() {
        return screenshot.get();
    }

    public static void clear() {
        screenshot.remove();
    }
}