package db.entity;

public class Contract {

    private int id;
    private String lastUpdated;
    private String date;

    public Contract(int id, String lastUpdated, String date) {
        this.id = id;
        this.lastUpdated = lastUpdated;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
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
}
