package org.example.Entity;

public class Favorites {
    private int idFavorite;
    private int idUser;
    private int idEvent;

    public Favorites() {
    }

    public int getIdFavorite() {
        return idFavorite;
    }

    public void setIdFavorite(int idFavorite) {
        this.idFavorite = idFavorite;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
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
