package com.nghiahd.server.domain;

import javax.persistence.*;

@Entity
@Table(name = "statusprofile")
public class StatusProfile {
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public StatusProfile() {
    }

    public StatusProfile(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
