package com.klef.Rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Integer> {
    // No need to define additional methods for basic CRUD operations,
    // as JpaRepository provides them out of the box

    // You can add additional custom methods if needed
    // For example:
    // RegistrationEntity findBySomeField(String someField);
}
