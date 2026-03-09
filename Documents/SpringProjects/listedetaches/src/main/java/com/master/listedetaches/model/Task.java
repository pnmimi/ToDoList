package com.master.listedetaches.model;

import jakarta.persistence.*;

@Entity
@Table(name = "taches")
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String titre;

    private String description;
    @Enumerated(EnumType.STRING)
    private Status statut;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Status getStatut() {
        return statut;
    }

    public void setStatut(Status statut) {
        this.statut = statut;
    }
}
