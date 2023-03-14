package org.example.Dao;

import org.example.Entity.Favorites;

public interface FavoriteDao {
    public Favorites get(long idFavorite);
    public void insert(Favorites favorites);
    public void update(Favorites favorites);
    public void delete(long idFavorite);
}
