package com.mamabologtub.playwright_tutorial;

import java.util.Scanner;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

/**
 * @Author Tshepo M Mahudu on Jul 29, 2025.
 */

public class IntacctTest {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
                Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
                    );

            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Navigate to login page
            page.navigate("https://www-p04.intacct.com/ia/acct/login.phtml");

            // Login
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Company ID")).fill("");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("User ID")).fill("");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();

            // Wait for verification field and prompt user
            Locator verifyInput = page.locator("#verify_code");
            verifyInput.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

            String verificationCode;
            while (true) {
                System.out.print("Enter the 6-digit verification code: ");
                verificationCode = scanner.nextLine().trim();
                if (verificationCode.matches("\\d{6}")) break;
                System.out.println("Invalid code. Please enter exactly 6 digits.");
            }

            // Fill code and pause for 4 seconds before continuing
            verifyInput.fill(verificationCode);
            page.waitForTimeout(4000);

            // Continue verification flow
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Verify")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes, trust this device")).click();

            // Navigate to Applications > Time > My timesheets
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Applications ")).click();
            page.waitForLoadState(LoadState.NETWORKIDLE);

            Locator timeLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Time "));
            timeLink.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(30000));
            timeLink.click();

            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("My timesheets")).click();

            // Interact with iframe
            FrameLocator iframe = page.frameLocator("iframe[name=\"iamain\"]");
            iframe.getByRole(AriaRole.LINK, new FrameLocator.GetByRoleOptions().setName("Add")).click();

            // Sample entries for timesheet (simplified)
            iframe.locator("[id=\"_obj__TIMESHEETITEMS_0_-_obj__DAY_0\"]").fill("1");
            iframe.locator("[id=\"_obj__TIMESHEETITEMS_0_-_obj__DAY_1\"]").fill("1");
            iframe.locator("[id=\"_obj__TIMESHEETITEMS_0_-_obj__DAY_2\"]").fill("1");
            iframe.locator("[id=\"_obj__TIMESHEETITEMS_0_-_obj__DAY_3\"]").fill("1");
            iframe.locator("[id=\"_obj__TIMESHEETITEMS_0_-_obj__DAY_4\"]").fill("1");

            // Click to save or continue
            iframe.getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Draft & continue")).click();

            System.out.println("✅ Timesheet submitted successfully!");

        } catch (PlaywrightException e) {
            System.err.println("Playwright error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

}
