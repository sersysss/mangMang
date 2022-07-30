package com.sersys.mangmang.controller;

import com.sersys.mangmang.entity.Manga;
import com.sersys.mangmang.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MangaController {

    private final MangaService mangaService;

    @Autowired
    public MangaController(MangaService mangaService) {
        this.mangaService = mangaService;
    }

    @GetMapping("/mangaList")
    @PreAuthorize("hasAuthority(Role.USER.name())")
    public String getAllManga(Model model) {
        List<Manga> mangaList = mangaService.findAll();

        model.addAttribute("mangas", mangaList);
        model.addAttribute("manga", new Manga());

        return "mangaList";
    }
    @PostMapping("/mangaList")
    @PreAuthorize("hasAuthority(Role.USER.name())")
    public String saveManga(Manga manga) {
        mangaService.saveManga(manga);
        return "redirect:/mangaList";
    }

    @GetMapping("/mangaList/manga-delete/{id}")
    @PreAuthorize("hasAuthority(Role.USER.name())")
    public String deleteManga(@PathVariable("id") Long id){
        mangaService.deleteManga(id);
        return "redirect:/mangaList";
    }
}
