package com.mamabologtub.playwright_tutorial;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForSelectorOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;

/**
 * @Author Tshepo M Mahudu on Jul 31, 2025.
 */

public class IntacctAutomation {

    public static void main(String[] args) {
        Properties props = new Properties();
        try (InputStream input = IntacctAutomation.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.err.println("application.properties not found in classpath.");
                return;
            }
            props.load(input);
        } catch (IOException e) {
            System.err.println("Failed to load application.properties: " + e.getMessage());
            return;
        }

        String companyId = props.getProperty("compnay.id");
        String userId = props.getProperty("user.id");
        String password = props.getProperty("user.password");

        //        String companyId = JOptionPane.showInputDialog(null, "Enter Company ID:");
        //        String userId = JOptionPane.showInputDialog(null, "Enter User ID:");
        //
        //        JPasswordField pf = new JPasswordField();
        //        int result = JOptionPane.showConfirmDialog(null, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        //        String password = (result == JOptionPane.OK_OPTION) ? new String(pf.getPassword()) : "";

        if (companyId == null || userId == null || password == null || companyId.isEmpty() || userId.isEmpty() || password.isEmpty()) {
            System.err.println("One or more credentials were not provided. Exiting.");
            return;
        }

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Navigate to login page
            page.navigate("https://www-p04.intacct.com/ia/acct/login.phtml");

            // Login credentials
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Company ID")).fill(companyId);
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("User ID")).fill(userId);
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill(password);
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();

            // Verification step
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Verify")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Resend >")).click();

            // Wait for user to input verification code
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter the verification code: ");
            String verificationCode = scanner.nextLine();

            page.locator("#verify_code").fill(verificationCode);
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Verify")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes, trust this device")).click();

            // Ensure the page is fully loaded before proceeding
            page.waitForLoadState(LoadState.NETWORKIDLE);
            page.waitForSelector("text=Applications", new Page.WaitForSelectorOptions().setTimeout(60000));

            // Navigate to timesheet
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Applications ")).click();
            page.waitForSelector("text=Time", new WaitForSelectorOptions().setTimeout(60000));
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Time ")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("My timesheets")).click();

            // Wait for the iframe to be attached to the DOM
            page.waitForSelector("iframe[name='iamain']", new Page.WaitForSelectorOptions().setTimeout(30000));

            // Print available frames for debugging
            for (Frame f : page.frames()) {
                System.out.println("Frame name: " + f.name() + " | URL: " + f.url());
            }

            // Switch to iframe by name
            Frame frame = null;
            for (Frame f : page.frames()) {
                if ("iamain".equals(f.name())) {
                    frame = f;
                    break;
                }
            }

            if (frame == null) {
                throw new RuntimeException("Frame 'iamain' not found.");
            }

            // Fill in timesheet details
            frame.getByRole(AriaRole.LINK, new Frame.GetByRoleOptions().setName("Add")).click();

            // Select a projct
            frame.getByPlaceholder("Project").nth(0).click();
            frame.locator("#span__obj__TIMESHEETITEMS_0_-_obj__PROJECTID i").click();
            frame.locator("#_c_obj__TIMESHEETITEMS_0_-_obj__PROJECTIDsel").selectOption(new SelectOption().setLabel("6040--Developers Admin 2025-2026"));

            Locator taskInput = frame.locator("#_obj__TIMESHEETITEMS_0_-_obj__TASKID");
            taskInput.click();
            taskInput.type("OMGDE", new Locator.TypeOptions().setDelay(100));

            // Wait for dropdown to appear
            Locator taskDropdown = frame.locator("#_c_obj__TIMESHEETITEMS_0_-_obj__TASKIDlst");
            taskDropdown.waitFor(new Locator.WaitForOptions().setTimeout(9000).setState(WaitForSelectorState.VISIBLE));

            // Wait for and select option by visible text
            Locator taskOption = frame.locator("option:has-text(\"OMGDE--Developers Admin\")");
            taskOption.waitFor(new Locator.WaitForOptions().setTimeout(9000).setState(WaitForSelectorState.VISIBLE));
            taskOption.click();

            //MOnday
            Locator dayLocator =  frame.locator("#_obj__TIMESHEETITEMS_0_-_obj__DAY_0");
            dayLocator.fill("1");
            dayLocator.dblclick();
            frame.locator("#span__obj__ADDL_TIMESHEETITEMS-_obj__ACTIVITIES i").click();
            frame.locator("#_c_obj__ADDL_TIMESHEETITEMS-_obj__ACTIVITIESsel").selectOption(new SelectOption().setLabel("General - Lunch"));
            frame.getByRole(AriaRole.BUTTON, new Frame.GetByRoleOptions().setName("Done")).click();

            //Tuesday
            Locator day1Locator = frame.locator("#_obj__TIMESHEETITEMS_0_-_obj__DAY_1");
            day1Locator.fill("1");
            day1Locator.dblclick();
            frame.locator("#span__obj__ADDL_TIMESHEETITEMS-_obj__ACTIVITIES i").click();
            frame.locator("#_c_obj__ADDL_TIMESHEETITEMS-_obj__ACTIVITIESsel").selectOption(new SelectOption().setLabel("General - Lunch"));
            frame.getByRole(AriaRole.BUTTON, new Frame.GetByRoleOptions().setName("Done")).click();

            //Wednesdy
            Locator day2Locator = frame.locator("#_obj__TIMESHEETITEMS_0_-_obj__DAY_2");
            day2Locator.fill("1");
            day2Locator.dblclick();
            frame.locator("#span__obj__ADDL_TIMESHEETITEMS-_obj__ACTIVITIES i").click();
            frame.locator("#_c_obj__ADDL_TIMESHEETITEMS-_obj__ACTIVITIESsel").selectOption(new SelectOption().setLabel("General - Lunch"));
            frame.getByRole(AriaRole.BUTTON, new Frame.GetByRoleOptions().setName("Done")).click();

            //Thursday
            Locator day3Locator = frame.locator("#_obj__TIMESHEETITEMS_0_-_obj__DAY_3");
            day3Locator.fill("1");
            day3Locator.dblclick();
            frame.locator("#span__obj__ADDL_TIMESHEETITEMS-_obj__ACTIVITIES i").click();
            frame.locator("#_c_obj__ADDL_TIMESHEETITEMS-_obj__ACTIVITIESsel").selectOption(new SelectOption().setLabel("General - Lunch"));
            frame.getByRole(AriaRole.BUTTON, new Frame.GetByRoleOptions().setName("Done")).click();

            //Friday
            Locator day4Locator = frame.locator("#_obj__TIMESHEETITEMS_0_-_obj__DAY_4");
            day4Locator.fill("1");
            day4Locator.dblclick();
            frame.locator("#span__obj__ADDL_TIMESHEETITEMS-_obj__ACTIVITIES i").click();
            frame.locator("#_c_obj__ADDL_TIMESHEETITEMS-_obj__ACTIVITIESsel").selectOption(new SelectOption().setLabel("General - Lunch"));
            frame.getByRole(AriaRole.BUTTON, new Frame.GetByRoleOptions().setName("Done")).click();

            //second row

            // Select a project
            frame.getByPlaceholder("Project").nth(1).click();
            frame.locator("#span__obj__TIMESHEETITEMS_1_-_obj__PROJECTID i").click();
            frame.locator("#_c_obj__TIMESHEETITEMS_1_-_obj__PROJECTIDsel").selectOption(new SelectOption().setLabel("6040--Developers Admin 2025-2026"));

            Locator taskInput2 = frame.locator("#_obj__TIMESHEETITEMS_1_-_obj__TASKID");
            taskInput2.click();
            taskInput2.type("OMGDE", new Locator.TypeOptions().setDelay(100));

            // Wait for dropdown to appear
            Locator taskDropdown2 = frame.locator("#_c_obj__TIMESHEETITEMS_1_-_obj__TASKIDlst");
            taskDropdown2.waitFor(new Locator.WaitForOptions().setTimeout(9000).setState(WaitForSelectorState.VISIBLE));

            // Wait for and select option by visible text
            Locator taskOption2 = frame.locator("option:has-text(\"OMGDE--Developers Admin\")");
            taskOption2.waitFor(new Locator.WaitForOptions().setTimeout(9000).setState(WaitForSelectorState.VISIBLE));
            taskOption2.click();

            //MOnday
            Locator dayLocator2 =  frame.locator("#_obj__TIMESHEETITEMS_1_-_obj__DAY_0");
            dayLocator2.fill("8");
            dayLocator2.dblclick();
            frame.locator("#span__obj__ADDL_TIMESHEETITEMS-_obj__ACTIVITIES i").click();
            frame.locator("#_c_obj__ADDL_TIMESHEETITEMS-_obj__ACTIVITIESsel").selectOption(new SelectOption().setLabel("General - Lunch"));

            Locator descMon = frame.locator("#_obj__ADDL_TIMESHEETITEMS-_obj__DESCRIPTION");
            descMon.click();
            descMon.fill("c3d");

            frame.getByRole(AriaRole.BUTTON, new Frame.GetByRoleOptions().setName("Done")).click();

            frame.getByRole(AriaRole.BUTTON, new Frame.GetByRoleOptions().setName("Draft & continue")).click();
            System.out.println("Timesheet entry completed.");

            page.waitForTimeout(60000);
        }
    }

}
