package org.example.Entity;

import java.time.LocalDateTime;

public class Event {
    private long idEvent;
    private String eventName;
    private String eventPlace;
    private LocalDateTime dateStart;
    private int duration;
    private int idUser;

    public Event() {
    }

    public long getIdEvent() {
        return idEvent;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
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

