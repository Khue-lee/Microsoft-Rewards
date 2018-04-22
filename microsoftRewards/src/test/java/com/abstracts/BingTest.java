package com.abstracts;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BingTest {

    WebDriver driver;
    @Test

        public void open(){

        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\klee0\\IdeaProjects\\microsoftRewards\\src\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

            driver.get("https://rewards.microsoft.com/");
            driver.findElement(By.xpath("//*[@id=\"signIn\"]/p/a")).click();
            login();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);


            String arr[] = {"What is happening today", "How to tie a tie", "how to kiss", "how to lose weight", "how to draw",
                    "how to make money", "pancakes", "cover letter", "french toast", "muscle workouts", "resume", "boil eggs",
                    "rose", "fruits", "bow tie", "make slime", "love", "rid of acne","poker", "passport", "save money",
                    "rising bands", "amazon", "google", "berkshire", "apple", "interview", "laugh", "cry", "cheapest food",
                    "where to buy almonds", "Cola", "fries", "movies out now", "movies coming out", "movies in theaters",
                    "man caves", "vacation trips", "real estate", "new houses", "zillow", "coupons", "trending topics",
                    "cheap shoes", "running shoes", "alibaba", "computer software", "new jobs near me", "baseball", "basket ball",
                    "football", "soccer", "tennis", "golf", "ping pong", "swimming", "next olympics", "new indie music", "rising indie artists", "investing"};

            for(int i=0; i< 31; i++){
                search(arr[i]);
           }
            Thread.sleep(2000);
            driver.navigate().to("https://account.microsoft.com/rewards/");
            pageclick();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    private void login(){
        try {
            driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("YOUR_EMAIL@hotmail.com"); // type in hotmail
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys("YOUR_PASSWORD");  // Type in password
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
            Thread.sleep(5000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void search(String elements){
        try {
            driver.get("https://bing.com");
            driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]")).sendKeys(elements);
            driver.findElement(By.xpath("//*[@id=\"sb_form_go\"]")).click();
            Thread.sleep(1000);
            driver.navigate().back();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void pageclick(){
        try{
            driver.findElement(By.xpath("//*[@id=\"daily-sets\"]/mee-card-group[1]/div/mee-card[1]/div/card-content/mee-rewards-daily-set-item-content/div/mee-rewards-points/div/div/span[2]")).click();
            ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            Thread.sleep(5000);
            quiz();
            driver.close();
            driver.switchTo().window(tabs2.get(0));
            driver.findElement(By.xpath("//*[@id=\"daily-sets\"]/mee-card-group[1]/div/mee-card[2]/div/card-content/mee-rewards-daily-set-item-content/div/mee-rewards-points/div/div/span[2]")).click();
            ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs3.get(1));
            Thread.sleep(5000);
            quiz();
            driver.close();
            driver.switchTo().window(tabs3.get(0));
            driver.findElement(By.xpath("//*[@id=\"daily-sets\"]/mee-card-group[1]/div/mee-card[3]/div/card-content/mee-rewards-daily-set-item-content/div/mee-rewards-points/div/div/span[2]")).click();
            ArrayList<String> tabs4 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs4.get(1));
            Thread.sleep(5000);
            quiz();
            driver.close();
            driver.switchTo().window(tabs4.get(0));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void quiz() {
        try {
            driver.findElement(By.xpath("//*[@id=\"rqStartQuiz\"]/span[2]")).click();
            for(int i=0; i< 5; i++) {
                Thread.sleep(5000);
                driver.findElement(By.xpath("//*[@id=\"rqAnswerOption0\"]")).click();
                Thread.sleep(5000);
                driver.findElement(By.xpath("//*[@id=\"rqAnswerOption1\"]")).click();
                Thread.sleep(5000);
                driver.findElement(By.xpath("//*[@id=\"rqAnswerOption2\"]")).click();
                Thread.sleep(5000);
                driver.findElement(By.xpath("//*[@id=\"rqAnswerOption3\"]")).click();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {

        BingTest obj = new BingTest();
        obj.open();


    }


}
