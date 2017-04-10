package com.techelevator.dao;

import java.util.List;

import com.techelevator.Office;

public interface OfficeDAO {
	
	public List<Office> getAllOffices();
	public Office getOfficeById(int officeId);
	public void addOffice(Office office);
	public void updateOffice(int officeId, String address, String phoneNumber, String imageName, String hours, String name);
	public void deleteOffice(int officeId);
}
