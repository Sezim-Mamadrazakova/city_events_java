package org.example.Entity;

import java.sql.Date;

public class Event {
    private long idEvent;
    private String eventName;
    private String eventPlace;
    private Date dateStart;
    private String duration;
    private int idUser;

    public Event() {
    }

    public long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(long idEvent) {
        this.idEvent = idEvent;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }
    public String  getEventPlace(){
        return eventPlace;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;

    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Event{" +
                "idEvent=" + idEvent +
                ", eventName='" + eventName + '\'' +
                ", eventPlace='" + eventPlace + '\'' +
                ", dateStart=" + dateStart +
                ", duration=" + duration +
                '}';
    }
}

