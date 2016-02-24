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
    private String description;

    public Task() { }

    public Task(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public LocalDate creationDate = LocalDate.now();

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task1 = (Task) o;

        if (id != null ? !id.equals(task1.id) : task1.id != null) return false;
        if (description != null ? !description.equals(task1.description) : task1.description != null) return false;
        return !(creationDate != null ? !creationDate.equals(task1.creationDate) : task1.creationDate != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }
}
