package com.sersys.mangmang.repository;

import com.sersys.mangmang.entity.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MangaRepository extends JpaRepository<Manga, Long> {
}
