package com.hr.manage.controller;

import com.hr.manage.config.MySQLConnector;
import com.hr.manage.domain.dto.request.WorkAttendanceRequestDTO;
import com.hr.manage.repository.ManageRepository;
import com.hr.manage.view.InputPrinter;
import com.hr.manage.view.OutputPrinter;

public class ManageController {

	private final ManageRepository manageRepository;
	private final OutputPrinter outputPrinter;
	private final InputPrinter inputPrinter;

	public ManageController() {
		manageRepository = new ManageRepository();
		outputPrinter = new OutputPrinter();
		inputPrinter = new InputPrinter();
	}

	public void run() {

		int mainCommand = -1;

		while (mainCommand != 0) {

			outputPrinter.printMainOption();
			mainCommand = inputPrinter.inputInt(InputPrinter.CHOOSE_MESSAGE);

			int manageCommand = -1;
			while (manageCommand != 0) {

				outputPrinter.printManageOption();
				manageCommand = inputPrinter.inputInt(InputPrinter.CHOOSE_MESSAGE);

			}

		}

		MySQLConnector.close();

	}

	private void conductManageCommand(int manageCommand) {

		switch (manageCommand) {
			case 1:
				updateWorkAttendance();
			case 2:
				insertWorkAttendance();
		}
	}

	private void updateWorkAttendance() {

		int id = inputPrinter.inputInt(InputPrinter.USER_ID_MESSAGE);
		String date = inputPrinter.inputString(InputPrinter.DATE_MESSAGE);
		String workAttendance = inputPrinter.inputString(InputPrinter.WORK_ATTENDANCE_MESSAGE);

		WorkAttendanceRequestDTO workAttendanceRequestDTO = new WorkAttendanceRequestDTO(id, date, workAttendance);
		String resultMessage = manageRepository.update(workAttendanceRequestDTO);
		outputPrinter.printResultMessage(resultMessage);
	}

	private void insertWorkAttendance() {

		int id = inputPrinter.inputInt(InputPrinter.USER_ID_MESSAGE);
		String date = inputPrinter.inputString(InputPrinter.DATE_MESSAGE);
		String workAttendance = inputPrinter.inputString(InputPrinter.WORK_ATTENDANCE_MESSAGE);

		WorkAttendanceRequestDTO workAttendanceRequestDTO = new WorkAttendanceRequestDTO(id, date, workAttendance);
		String resultMessage = manageRepository.insert(workAttendanceRequestDTO);
		outputPrinter.printResultMessage(resultMessage);
	}



}
