package autotest.page;

import static com.codeborne.selenide.Selenide.page;

/**
 * Elements, which displayed on all pages
 */
public abstract class BasePage {
    public MainMenu mainMenu = page(MainMenu.class);
}
