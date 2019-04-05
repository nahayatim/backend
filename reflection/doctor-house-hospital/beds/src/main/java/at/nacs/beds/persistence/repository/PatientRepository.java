package at.nacs.beds.persistence.repository;


import at.nacs.beds.persistence.domain.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {
}
