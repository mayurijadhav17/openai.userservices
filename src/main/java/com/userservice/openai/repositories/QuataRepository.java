package com.userservice.openai.repositories;



import com.userservice.openai.models.Quota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuataRepository extends JpaRepository<Quota, Long> {
   public Optional<Quota> findByEntityId(Long entityId);
}
