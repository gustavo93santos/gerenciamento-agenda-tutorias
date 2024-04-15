package br.com.fullstack.gerenciamentotutorias.repositories;

import br.com.fullstack.gerenciamentotutorias.entities.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<TutorEntity, Long> {
}
