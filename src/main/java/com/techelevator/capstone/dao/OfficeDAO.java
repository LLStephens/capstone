package com.techelevator.capstone.dao;


import java.util.List;

import com.techelevator.capstone.model.Office;

public interface OfficeDAO {
	
	public List<Office> getAllOffices();
	public Office getOfficeById(int officeId);
	public Office addOffice(Office office);
	public void updateOffice(int officeId, String address, String phoneNumber, String imageName, String hours, String name);
	public void deleteOffice(int officeId);
}
