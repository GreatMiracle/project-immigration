package com.nghiahd.server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "taskforassistant")
public class TaskForAssistant {
    @Id
    private UUID id;

    @Column(name = "employeeid")
    private UUID employeeID;

    @Column(name = "profileid")
    private UUID profileID;

    @Column(name = "description")
    private String description;

    @Column(name = "result")
    private String result;

    @Column(name = "expirationdate")
    private LocalDateTime expirationDate;

    @Column(name = "createdate")
    private LocalDateTime createDate;

    public TaskForAssistant(UUID id, UUID employeeID, UUID profileID, String description, String result, LocalDateTime expirationDate, LocalDateTime createDate) {
        this.id = id;
        this.employeeID = employeeID;
        this.profileID = profileID;
        this.description = description;
        this.result = result;
        this.expirationDate = expirationDate;
        this.createDate = createDate;
    }

    public TaskForAssistant() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(UUID employeeID) {
        this.employeeID = employeeID;
    }

    public UUID getProfileID() {
        return profileID;
    }

    public void setProfileID(UUID profileID) {
        this.profileID = profileID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
