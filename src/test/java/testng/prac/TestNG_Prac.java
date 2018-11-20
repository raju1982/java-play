package testng.prac;

import org.testng.annotations.Test;
import appcode.SomeClassToTest;
//required so that you can use assertEquals instedof Assert.assertEquals
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestNG_Prac {

    //For before methods (beforeSuite, beforeTest, beforeTestClass and beforeTestMethod, but not beforeGroups): If set to true, this configuration method will be run regardless of what groups it belongs to.
    @BeforeClass(alwaysRun=true)
    public void setUp() {
        System.out.println("\nThis runs once before class");
        //this will be logged to the testng file.
        Reporter.log("TestNG_ReportsAndLogs -> This runs once before class", true);
    }

    //For after methods (afterSuite, afterClass, ...): If set to true, this configuration method will be run even if one or more methods invoked previously failed or was skipped.
    @AfterClass(alwaysRun=true)
    public void cleanUp() {
        System.out.println("\nThis runs once after class");
        Reporter.log("TestNG_ReportsAndLogs -> This runs once after class", true);
    }

    //objects which are needed in every testcase can be instantiated here.
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("\nThis runs before every method");
        Reporter.log("TestNG_ReportsAndLogs -> This runs before every method", true);
    }

    //logging based on ITestResult
    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed: " + testResult.getMethod().getMethodName());
        }
        if (testResult.getStatus() == ITestResult.SUCCESS) {
            System.out.println("Successful: " + testResult.getName());
        }
    }

    @Test
    public void testSum() {
        System.out.println("\nRunning TestPrac -> testSum");
        SomeClassToTest obj = new SomeClassToTest();
        int result = obj.sumNumbers(1, 2);
        assertEquals(result, 3);
    }

    @Test
    public void testStrings() {
        System.out.println("\nRunning TestPrac -> testStrings");
        String expectedString = "Hello World";
        SomeClassToTest obj = new SomeClassToTest();
        String result = obj.addStrings("Hello", "World");
        assertEquals(result, expectedString);
    }

    //order matter for array.
    @Test
    public void testArrays() {
        System.out.println("\nRunning TestPrac -> testArrays");
        int[] expectedArray = {1,3,2};
        SomeClassToTest obj = new SomeClassToTest();
        int[] result = obj.getArray();
        assertEquals(result, expectedArray);
        System.out.println("\nEnd TestPrac -> testArrays");
    }

    @Test(groups = {"cars", "suv"})
    public void testBMWX6() {
        System.out.println("Running TestPrac - BMW X6");
    }

    @Test(groups = {"cars", "sedan", "bikes"}, priority=2)
    public void testAudiA6() {
        System.out.println("Running TestPrac - Audi A6 ");
    }

    //The priority for this test method. Lower priorities will be scheduled first [P0 -> P1 -> P2].
    @Test(groups = { "bikes" }, priority=0)
    public void testNinja() {
        System.out.println("Running TestPrac - Kawasaki Ninja");
    }

    @Test(groups = { "bikes" }, priority=1)
    public void testHondaCBR() {
        System.out.println("Running TestPrac - Honda CBR");
    }

    @Test
    public void testMethod1() {
        System.out.println("testMethod1");
        SomeClassToTest obj = new SomeClassToTest();
        int result = obj.sumNumbers(1, 2);
        assertEquals(result, 2);
    }

    //alwaysRun=true , this will ensure that test run ebrn if dependent test fails.
    @Test(dependsOnMethods={ "testMethod1" }, alwaysRun=true)
    public void testMethod2() {
        System.out.println("testMethod2");
    }

    @Test(dependsOnMethods={ "testMethod1" })
    public void testMethod3() {
        System.out.println("testMethod3");
    }

    //disable test
    @Test(enabled=false)
    public void testIgnore() {
        System.out.println("testMethod1");
    }

    //timeout
    @Test(timeOut=100)
    public void testTimeout() throws InterruptedException {
        System.out.println("testMethod2");
        Thread.sleep(200);
    }

}