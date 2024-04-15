package br.com.fullstack.gerenciamentotutorias.repositories;

import br.com.fullstack.gerenciamentotutorias.entities.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {
}
