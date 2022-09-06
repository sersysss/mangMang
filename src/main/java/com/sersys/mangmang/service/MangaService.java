package com.sersys.mangmang.service;

import com.sersys.mangmang.entity.Manga;
import com.sersys.mangmang.entity.User;
import com.sersys.mangmang.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class MangaService {

    private final MangaRepository mangaRepository;

    @Autowired
    public MangaService(MangaRepository mangaRepository) {
        this.mangaRepository = mangaRepository;
    }

    public List<Manga> findAllByUser(User user) {
        return mangaRepository.findAllByUser(user);
    }

    public void saveManga(Manga manga) {
        mangaRepository.save(manga);
    }

    public void deleteManga(Long id) {
        mangaRepository.deleteById(id);
    }

}
