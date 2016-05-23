package model;

import java.util.Date;

/**
 * Created by Цымбалюк Сергей on 22.05.2016.
 */
public class Task {
    private int id;
    private Date date;
    private String description;
    private boolean status;

    public Task(int id,Date date, String description, boolean status) {
        this.id=id;
        this.date = date;
        this.description = description;
        this.status = status;
    }

    public Task(Date date,String description,boolean status) {
        this.status = status;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
