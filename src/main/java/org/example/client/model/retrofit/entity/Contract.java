package org.example.client.model.retrofit.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Contract {

    private int id;
    private String lastUpdated;
    private Boolean valid = false;
    private String date;

    public Contract(int id, String lastUpdated, String date) {
        this.id = id;
        this.lastUpdated = lastUpdated;
        this.date = date;
    }

    public void checkIfValid(LocalDate currentTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateLastUpdated = LocalDate.parse(lastUpdated, formatter);
        valid = ChronoUnit.DAYS.between(dateLastUpdated, currentTime) <= 60;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", valid=" + valid +
                '}';
    }
}
