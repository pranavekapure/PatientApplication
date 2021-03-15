package com.patient.pojo;

import java.util.List;

public class Criteria {

	private List<String> listFirstName;
	
	private List<String> listLastName;
	
	private List<String> listDob;
	
	/*
	 * private List<String> listCountry;
	 * 
	 * private List<String> listGender;
	 */
	
	private List<String> listTreatmentLocation;

	public List<String> getListFirstName() {
		return listFirstName;
	}

	public void setListFirstName(List<String> listFirstName) {
		this.listFirstName = listFirstName;
	}

	public List<String> getListLastName() {
		return listLastName;
	}

	public void setListLastName(List<String> listLastName) {
		this.listLastName = listLastName;
	}

	public List<String> getListDob() {
		return listDob;
	}

	public void setListDob(List<String> listDob) {
		this.listDob = listDob;
	}

	/*
	 * public List<String> getListCountry() { return listCountry; }
	 * 
	 * public void setListCountry(List<String> listCountry) { this.listCountry =
	 * listCountry; }
	 * 
	 * public List<String> getListGender() { return listGender; }
	 * 
	 * public void setListGender(List<String> listGender) { this.listGender =
	 * listGender; }
	 */

	public List<String> getListTreatmentLocation() {
		return listTreatmentLocation;
	}

	public void setListTreatmentLocation(List<String> listTreatmentLocation) {
		this.listTreatmentLocation = listTreatmentLocation;
	}
	
	
}

