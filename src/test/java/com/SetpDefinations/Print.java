package com.SetpDefinations;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class Print {

	@Given("user successfully print the below words in console:")
	public void consolePrint(DataTable data) {
		List<String> items = data.asList(String.class);
		items.forEach(System.out::println);
	}

}
