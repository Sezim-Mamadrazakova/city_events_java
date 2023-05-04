package org.example.Dao;


import org.example.Entity.Favorites;

public interface FavoriteDao {
    public Favorites get(Long idFavorite);

    public void insert(Favorites favorites);

    public void update(Favorites favorites);

    public void delete(Long idFavorite);
}
