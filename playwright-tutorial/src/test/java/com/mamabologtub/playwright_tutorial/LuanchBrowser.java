package com.mamabologtub.playwright_tutorial;



import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitForSelectorState;

/**
 * @Author Tshepo M Mahudu on Jun 12, 2025.
 */

public class LuanchBrowser {

    public static void main(String[] args) {

        //        Playwright playwright = Playwright.create();
        //        Browser browser = playwright.chromium().launch(
        //                new LaunchOptions().setHeadless(false)
        //                );
        //        Page page = browser.newPage();
        //        page.navigate("https://ecommerce-playground.lambdatest.io/index.php");
        //        page.navigate("http://localhost:8080/swagger/swagger-ui/index.html#/");
        // Locator myLocator = page.locator("//a[contains(.,'My account')][@role='button']");
        //        Locator myLoc = page.locator("//a[contains(.,'Report Contoller')][@role='button']");
        //        //        myLocator.hover();
        //        myLoc.hover();
        // page.click("//a[contains(.,'GET')]");
        //        page.click("//a[contains(.,'Login')]");
        //        assertThat(page).hasTitle("Account Login");
        //        page.getByPlaceholder("E-Mail Address").type("tmmmmadi@gmail.com");
        //        page.getByPlaceholder("Password").type("JKC@t54wASN@!Ub");
        //        page.locator("//input[@value='Login']").click();
        //        assertThat(page).hasTitle("My Account");
        //        page.close();
        //        browser.close();
        //        playwright.close();
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
                    );
            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions().setAcceptDownloads(true)
                    );
            Page page = browser.newPage();

            page.navigate("http://localhost:8080/swagger/swagger-ui/index.html#/");

            page.waitForSelector("div.opblock-summary");

            Locator getOperation = page.locator(
                    "//div[contains(@class, 'opblock-summary-get')]//span[contains(@class, 'opblock-summary-path') and contains(., '/api/v1/download-report')]"
                    );

            getOperation.scrollIntoViewIfNeeded();
            getOperation.hover();

            Locator expandButton = getOperation.locator("xpath=ancestor::button");
            expandButton.click();

            Locator tryItOutButton = page.locator("button.btn.try-out__btn");
            tryItOutButton.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
            tryItOutButton.click();
            System.out.println("We are here");
            //            if (tryItOut.isVisible()) {
            //                System.out.println("we've arrived");
            //                tryItOut.click();
            //            }

            Locator reportTypeDropdown = page.locator("td.parameters-col_description select:not([disabled])").first();
            reportTypeDropdown.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
            reportTypeDropdown.selectOption("Call_Type");

            Locator startDateInput = page.locator("input[placeholder='startDate']:not([disabled])");
            startDateInput.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
            startDateInput.fill("2025-01-01");

            Locator endDateInput = page.locator("input[placeholder='endDate']:not([disabled])");
            endDateInput.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
            endDateInput.fill("2025-06-17");

            Locator provinceSelect = page.locator("select[multiple]:not([disabled])");
            provinceSelect.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
            provinceSelect.selectOption(new String[]{"GAUTENG", "LIMPOPO", "KWAZULU_NATAL"});

            Locator executeBtn = page.locator("//button[text()='Execute']");
            executeBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
            executeBtn.click();

            Locator downloadLink = page.locator("div:has(h5:has-text('Response body')) a[download]");
            downloadLink.waitFor(new Locator.WaitForOptions().setTimeout(60000));

            page.evaluate("() => document.querySelector('a[download]').click()");
            System.out.println("✅ File download triggered automatically.");


            String blobUrl = downloadLink.getAttribute("href");
            System.out.println("Download URL: " + blobUrl);

            page.evaluate("url => window.open(url, '_blank')", blobUrl);

            System.out.println("Opened blob URL in new tab.");

            page.waitForTimeout(100000); // or wait for the response element
        }

    }

}
