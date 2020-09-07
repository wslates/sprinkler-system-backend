package io.slates.controller;

import io.slates.model.SprinklerProgram;
import io.slates.model.Zone;
import io.slates.repository.SprinklerProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sprinklerProgram")
public class SprinklerProgramController {

    @Autowired
    private SprinklerProgramRepository sprinklerRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<SprinklerProgram> getAllSprinklerPrograms() {
        return sprinklerRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SprinklerProgram getSprinklerProgramById(@PathVariable("id") String id) {
        return sprinklerRepository.findOne(id);
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public SprinklerProgram addNewSprinklerProgram(@RequestBody SprinklerProgram sprinklerProgram) {
        return sprinklerRepository.save(sprinklerProgram);
    }

    @RequestMapping(value="", method = RequestMethod.PATCH)
    public void updateSprinklerProgram(@RequestBody SprinklerProgram sprinklerProgram) {
        SprinklerProgram existingProgram = sprinklerRepository.findOne(sprinklerProgram.getId());
        existingProgram.setDay(sprinklerProgram.getDay());
        existingProgram.setTime(sprinklerProgram.getTime());
        existingProgram.setZones(sprinklerProgram.getZones());
    }

    @RequestMapping(value="", method = RequestMethod.DELETE)
    public void deleteSprinklerProgram(@RequestBody SprinklerProgram sprinklerProgram) {
        sprinklerRepository.delete(sprinklerProgram);
    }

}
