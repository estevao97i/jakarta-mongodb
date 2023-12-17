package org.estevao;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, String> {
}
