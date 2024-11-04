package com.santhosh.springbootdemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dummy_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DummyTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "map_id")
    private Long mapId;

    @ManyToOne // Assuming a Many-to-One relationship
    @JoinColumn(name = "map_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;

    public DummyTable(Long mapId) {
        this.mapId = mapId;
    }
}
