package br.com.fullstack.gerenciamentotutorias.repositories;

import br.com.fullstack.gerenciamentotutorias.entities.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {
}
