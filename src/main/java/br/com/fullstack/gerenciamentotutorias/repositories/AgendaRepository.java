package br.com.fullstack.gerenciamentotutorias.repositories;

import br.com.fullstack.gerenciamentotutorias.entities.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {

    @Query(value = "select * from agenda where aluno_id = ?1 order by data asc", nativeQuery = true)
    List<AgendaEntity> findByAlunoId (Long id);

    @Query(value = "select * from agenda where tutor_id = ?1 order by data asc", nativeQuery = true)
    List<AgendaEntity> findByTutorId (Long id);
}
