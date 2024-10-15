package org.example;

public class Incident {
    public int incidentId;
    public String reporterUsername;
    public String incidentType;
    public String description;
    public String status;
    public String date;

    public Incident(int incidentId, String reporterUsername, String incidentType, String description, String status, String date){
        this.incidentId = incidentId;
        this.reporterUsername = reporterUsername;
        this.incidentType = incidentType;
        this.description = description;
        this.status = status;
        this.date = date;
    }

    public int getIncidentId() {
        return incidentId;
    }
    public String getReporterUsername(){
        return reporterUsername;
    }
    public String getIncidentType(){
        return incidentType;
    }
    public String getDescription() {
        return description;
    }
    public String getStatus() {
        return status;
    }
    public String getDate() {
        return date;
    }

    public void setIncidentId(int incidentId) {
        this.incidentId = incidentId;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReporterUsername(String reporterUsername) {
        this.reporterUsername = reporterUsername;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "incidentId=" + incidentId +
                ", reporterUsername='" + reporterUsername + '\'' +
                ", incidentType='" + incidentType + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
