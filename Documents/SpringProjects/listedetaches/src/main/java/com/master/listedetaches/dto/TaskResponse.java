package com.master.listedetaches.dto;

import com.master.listedetaches.model.Status;

public class TaskResponse {
    //@Getter
    //@Setter
    private Long id;

   // @Getter
    //@Setter
    private String titre;

   // @Getter
   // @Setter
    private String description;

    private Status statut;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatut() {
        return statut;
    }

    public void setStatut(Status statut) {
        this.statut = statut;
    }
}
