package com.patient.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.connection.pojo.Patient;
import com.connection.service.PatientService;
import com.patient.exception.APIException;
import com.patient.pojo.Criteria;

@EnableJpaRepositories(basePackages = {"com.connection.service"})
@Service
public class PatientServiceImpl {

	@Autowired
	private PatientService patientService;


	public List<Patient> getPatientInfo() {
		List<Patient> listPatient = patientService.findAll(Sort.by(Sort.Direction.ASC, "patientId"));
	
		if (listPatient.isEmpty()) {
			throw new APIException(HttpStatus.BAD_REQUEST, "No Patient Available in the DB",
					"No Patient Available in the DB");
		} else {
			return listPatient;
		}
	}

	public Patient saveOrUpdatePatientInfo(Patient patient) throws APIException {
		try {
			
			Patient savedPatient = patientService.save(patient);
		
			return savedPatient;
		} catch (Exception e) {
			throw new APIException(HttpStatus.BAD_REQUEST, "Patient caould not be saved", e.getMessage());
		}

	}

	public Patient getPatient(Integer id) throws APIException {
		try {
			Patient getPatient = patientService.findById(id).get();
			/*
			 * PatientDto patientDto = mapper.map(getPatient, PatientDto.class);
			 * Map<Integer, List<Medicine>> medicineMap = getMapOfListOfMedicine();
			 * List<Medicine> listOfMedicines = medicineMap.get(patientDto.getPatientId());
			 * patientDto.setMedicineList(listOfMedicines);
			 */
			return getPatient;
		} catch (Exception e) {
			throw new APIException(HttpStatus.BAD_REQUEST, "Patient not found", e.getMessage());
		}

	}

	public String deletePatient(Integer id) throws APIException {
		try {
			if (patientService.existsById(id)) {
				patientService.deleteById(id);

				return "Patient has been deleted";
			}
		} catch (Exception e) {
			throw new APIException(HttpStatus.BAD_REQUEST, "Patient not deleted", e.getMessage());
		}
		return "patient with id : " + id + "not found";
	}


	/*-------------------*/
	public Set<Patient> getFilteredPatients(Criteria filterCriteria) {
		List<Patient> patientList = getPatientInfo();
		Set<Patient> filtredPatientSet = new HashSet<Patient>();
		patientList.stream().forEach(patient -> {
			if (filterCriteria.getListDob() != null) {
				filterCriteria.getListDob().stream().filter(dob -> dob.equals(patient.getDob())).forEach(dob -> {
					filtredPatientSet.add(patient);
				});
			}
			if (filterCriteria.getListFirstName() != null) {
				filterCriteria.getListFirstName().stream().filter(firstName -> firstName.equals(patient.getFirstName()))
						.forEach(firstName -> {
							filtredPatientSet.add(patient);
						});
			}

			if (filterCriteria.getListLastName() != null) {
				filterCriteria.getListLastName().stream().filter(lastName -> lastName.equals(patient.getLastName()))
						.forEach(lastName -> {
							filtredPatientSet.add(patient);
						});
			}
			if (filterCriteria.getListTreatmentLocation() != null) {
				filterCriteria.getListTreatmentLocation().stream()
						.filter(treatLocation -> treatLocation.equals(patient.getTreatmentLocation()))
						.forEach(treatLocation -> {
							filtredPatientSet.add(patient);
						});
			}
		});
		return filtredPatientSet;
	}

}
