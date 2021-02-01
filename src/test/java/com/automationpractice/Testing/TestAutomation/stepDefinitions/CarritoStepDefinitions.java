package com.automationpractice.Testing.TestAutomation.stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.automationpractice.Testing.TestAutomation.pages.HomeYourLogoPage;
import com.automationpractice.Testing.TestAutomation.pages.ProductOverviewPage;
import com.automationpractice.Testing.TestAutomation.pages.SearchResultsPage;
import com.automationpractice.Testing.TestAutomation.validationPage.ShoppingCartSummary;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.PageGenerator;

public class CarritoStepDefinitions {

	protected WebDriver driver = Hook.getDriver();

	@Given("^un cliente abre el sitio web de New Experience$")
	public void abrirNavegador() throws Throwable {

		PageGenerator.getInstance(HomeYourLogoPage.class, driver).goToThePage();
	}

	@When("^Busca un vestido '(.*)' y selecciona uno para comprarlo$")
	public void buscarVestido(String product) throws Throwable {

		PageGenerator.getInstance(HomeYourLogoPage.class, driver).encontrarProducto(product);
		PageGenerator.getInstance(SearchResultsPage.class, driver).elegirProducto();
		PageGenerator.getInstance(ProductOverviewPage.class, driver).agregarCarrito();
	}

	@Then("^el carro de compras debe terminar el proceso con un not '(.*)'$")
	public void inTheShoppingCartShowTheProductIsNotNullWithQuantityNotNull(String result) throws Throwable {
		assertEquals(result, PageGenerator.getInstance(ShoppingCartSummary.class, driver).validarCarrito());
	}
}
