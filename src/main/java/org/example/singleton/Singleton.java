package org.example.singleton;

public class Singleton {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();

        String appName = appConfig.getProperty("app.name");
        String appVersion = appConfig.getProperty("app.version");
        String appAuthor = appConfig.getProperty("app.author");

        System.out.println("Application Name: " + appName);
        System.out.println("Application Version: " + appVersion);
        System.out.println("Application Author: " + appAuthor);
    }
}
