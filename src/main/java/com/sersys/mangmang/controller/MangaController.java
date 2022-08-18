package com.sersys.mangmang.controller;

import com.sersys.mangmang.entity.Manga;
import com.sersys.mangmang.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MangaController {

    @Autowired
    private MangaService mangaService;

    @GetMapping("/mangaList")
    public String getAllManga(Model model) {
        List<Manga> mangaList = mangaService.findAll();

        model.addAttribute("mangas", mangaList);
        model.addAttribute("manga", new Manga());

        return "mangaList";
    }
    @PostMapping("/mangaList")
    public String saveManga(Manga manga) {
        mangaService.saveManga(manga);
        return "redirect:/mangaList";
    }

    @GetMapping("/mangaList/manga-delete/{id}")
    public String deleteManga(@PathVariable("id") Long id){
        mangaService.deleteManga(id);
        return "redirect:/mangaList";
    }
}
