package com.javaseleniumtemplate.tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "TestDataDrivenCSV.csv")
public class TestDataDrivenCSV {
    //Objects

    //Teste DDT via class
    @Test
    public void pesquisaGoogle(@Param(name = "nomePesquisa") String nomePesquisa){

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://google.com.br");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.name("q"));
        username.sendKeys(nomePesquisa);
    }


}
