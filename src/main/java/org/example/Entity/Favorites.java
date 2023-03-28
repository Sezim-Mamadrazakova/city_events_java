package org.example.Entity;

public class Favorites {
    private long idFavorite;
    private long idUser;
    private long idEvent;

    public Favorites() {
    }

    public long getIdFavorite() {
        return idFavorite;
    }

    public void setIdFavorite(long idFavorite) {
        this.idFavorite = idFavorite;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(long idEvent) {
        this.idEvent = idEvent;
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "idFavorite=" + idFavorite +
                ", idUser=" + idUser +
                ", idEvent=" + idEvent +
                '}';
    }
}
