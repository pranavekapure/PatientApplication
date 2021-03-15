package com.patient.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.connection.pojo.Patient;
import com.patient.pojo.Criteria;
import com.patient.serviceImpl.PatientServiceImpl;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientServiceImpl patientServiceImpl;

	@RequestMapping(method = RequestMethod.GET, path = "/getPatientList")
	public ResponseEntity<List<Patient>> getPatientInfo() {

		return new ResponseEntity<List<Patient>>(patientServiceImpl.getPatientInfo(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/savePatient")
	public ResponseEntity<Patient> saveOrUpdatePatientInfo(@RequestBody Patient patient) {

		return new ResponseEntity<Patient>(patientServiceImpl.saveOrUpdatePatientInfo(patient), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/updatePatient")
	public ResponseEntity<Patient> updatePatientInfo(@RequestBody Patient patient) {

		return new ResponseEntity<Patient>(patientServiceImpl.saveOrUpdatePatientInfo(patient), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/getPatient/{id}")
	public ResponseEntity<Patient> getPatient(@PathVariable Integer id) {

		return new ResponseEntity<>(patientServiceImpl.getPatient(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/deletePatient/{id}")
	public ResponseEntity<String> deletePatientInfo(Integer id) {

		return new ResponseEntity<>(patientServiceImpl.deletePatient(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/filter")
	public ResponseEntity<Set<Patient>> deletePatientInfo(@RequestBody Criteria filterCriteria) {

		return new ResponseEntity<Set<Patient>>(patientServiceImpl.getFilteredPatients(filterCriteria), HttpStatus.OK);
	}
	
}
