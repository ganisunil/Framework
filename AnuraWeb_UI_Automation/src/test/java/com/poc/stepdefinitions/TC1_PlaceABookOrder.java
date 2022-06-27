package com.poc.stepdefinitions;

import com.poc.base.BaseInitialiser;
import com.poc.pages.AddToCart;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_PlaceABookOrder extends BaseInitialiser {
	
	AddToCart addItem = new AddToCart(driver);
	@Given("User launches Amazon website")
	public void user_launches_amazon_website() {
		
		addItem.launch_WebSite();
	}

	@Then("Verify Title of the website")
	public void verify_title_of_the_website() {
		addItem.Verify_Title();
	}

	@When("change the catagories to Books")
	public void change_the_catagories_to_books() throws InterruptedException {
		addItem.selectCateogiry("Books");
		
	}

	@Then("search for a Book <wings of fire>")
	public void search_for_a_book_wings_of_fire() {
		addItem.searchForaItem("Wings Of Fire");

	}

	@When("Select the Book")
	public void select_the_book() throws InterruptedException {
		addItem.selectTheItem();

	}

	@Then("Click on Buy button")
	public void click_on_buy_button() {

	}

}
