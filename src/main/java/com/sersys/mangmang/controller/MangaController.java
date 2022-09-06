package com.sersys.mangmang.controller;

import com.sersys.mangmang.entity.Manga;
import com.sersys.mangmang.entity.User;
import com.sersys.mangmang.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
@RequestMapping("/mangaList")
public class MangaController {

    private final MangaService mangaService;

    @Autowired
    public MangaController(MangaService mangaService) {
        this.mangaService = mangaService;
    }

    @GetMapping
    public String getAllManga(@AuthenticationPrincipal User user, Model model) {
        List<Manga> mangaList = mangaService.findAllByUser(user);

        model.addAttribute("mangas", mangaList);
        model.addAttribute("manga", new Manga());

        return "mangaList";
    }
    @PostMapping
    public String addManga(@AuthenticationPrincipal User user, Manga manga) {

        manga.setUser(user);

        mangaService.saveManga(manga);

        return "redirect:/mangaList";
    }

    @GetMapping("/manga-delete/{id}")
    public String deleteManga(@PathVariable("id") Long id){
        mangaService.deleteManga(id);
        return "redirect:/mangaList";
    }
}
