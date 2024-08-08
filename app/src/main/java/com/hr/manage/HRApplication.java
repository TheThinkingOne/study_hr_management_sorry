package com.hr.manage;

import com.hr.manage.controller.ManageController;

public class HRApplication {
	public static void main(String[] args) {
		ManageController manageController = new ManageController();
		manageController.run();
	}
}
