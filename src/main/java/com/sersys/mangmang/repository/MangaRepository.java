package com.sersys.mangmang.repository;

import com.sersys.mangmang.entity.Manga;
import com.sersys.mangmang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MangaRepository extends JpaRepository<Manga, Long> {

    public List<Manga> findAllByUser(User user);
}
