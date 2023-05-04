package org.example.Entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Event {
    private Long idEvent;
    private String eventName;
    private String eventPlace;
    private Timestamp dateStart;
    private String duration;
    //private long idUser;

    public Event() {
    }
    public Event(Long idEvent, String eventName, String eventPlace, Timestamp dateStart, String duration){
        this.idEvent=idEvent;
        this.eventName=eventName;
        this.eventPlace=eventPlace;
        this.dateStart=dateStart;
        this.duration=duration;

    }

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
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

    public Timestamp getDateStart() {
        return dateStart;
    }

    public void setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;

    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

//    public long getIdUser() {
//        return idUser;
//    }
//
//    public void setIdUser(long idUser) {
//        this.idUser = idUser;
//    }

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

