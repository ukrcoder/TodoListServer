package com.event.planner.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Anton Shvechikov on 23.02.16.
 */
@Entity
public class Task implements Serializable {

    @Id @GeneratedValue
    private Long id;

    @NotEmpty
    private String task;

    public Long getId() {
        return id;
    }

    public LocalDate creationDate = LocalDate.now();

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
