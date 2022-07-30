package com.sersys.mangmang.service;

import com.sersys.mangmang.entity.Manga;
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

    public Manga findById(Long id) {

        Optional<Manga> optional = mangaRepository.findById(id);

        return optional.orElseThrow(() -> new EntityNotFoundException("id"));
    }

    public List<Manga> findAll() {
        return mangaRepository.findAll();
    }

    public void saveManga(Manga manga) {
        mangaRepository.save(manga);
    }

    public void deleteManga(Long id) {
        mangaRepository.deleteById(id);
    }

}
