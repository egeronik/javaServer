package com.example.taskproject;

import com.example.taskproject.dataManagment.AnimeRecord;
import com.example.taskproject.dataManagment.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/anime")
public class MainController {

    @Autowired
    private AnimeRepository animeRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    AnimeRecord addNewUser(@RequestBody AnimeRecord animeRecord) {
        animeRepository.save(animeRecord);
        return animeRecord;
    }



    @GetMapping
    public AnimeRecord empty(){
        return null;
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<AnimeRecord> getAllAnime() {
        return animeRepository.findAll();
    }

    @GetMapping("{id}")
    public @ResponseBody AnimeRecord getAnimeById(@PathVariable Integer id){
        return animeRepository.findById(id).orElse(null);
    }


    @DeleteMapping("{id}")
    @ResponseBody
    public AnimeRecord deleteAnime(@PathVariable int id){
        if(animeRepository.existsById(id)){
            AnimeRecord tmp = animeRepository.findById(id).orElse(null);
            animeRepository.deleteById(id);
            return tmp;
        }else
            return null;
    }
}