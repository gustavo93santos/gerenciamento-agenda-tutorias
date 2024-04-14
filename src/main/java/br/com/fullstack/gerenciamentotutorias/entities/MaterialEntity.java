package br.com.fullstack.gerenciamentotutorias.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "material")
public class MaterialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "agenda_id", nullable = false)
    private AgendaEntity agenda;

    @Column(nullable = false)
    private String descriccao;

    @Column(nullable = false)
    private String pathArquivo;
}
