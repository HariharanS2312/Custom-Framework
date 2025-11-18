package com.Utilities;

import com.Locators.CommonLocators;

public class DirectoryNavigations extends CommonLocators {

	public String getUserDirectory() {
		return System.getProperty("user.dir");
	}

	public String getHomeDirectory() {
		return System.getProperty("user.home");
	}

}
