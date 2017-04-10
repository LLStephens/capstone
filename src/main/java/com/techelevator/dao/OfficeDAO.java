package com.techelevator.dao;

import java.util.List;

import com.techelevator.Office;

public interface OfficeDAO {
	
	public List<Office> getAllOffices();
	public Office getOfficeById(int officeId);
	public Office addOffice();
	public Office updateOffice(int officeId);
	public void deleteOffice(int officeId);
}
