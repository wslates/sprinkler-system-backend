package io.slates.controller;

import io.slates.model.Zone;
import io.slates.repository.ZoneRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zone")
public class ZoneController {
    @Autowired
    private ZoneRepository zoneRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Zone> getAllZones() {
        return zoneRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Zone getZoneById(@PathVariable("id") String id) {
        return zoneRepository.findOne(id);
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public Zone addNewZone(@RequestBody Zone zone) {
        return zoneRepository.save(zone);
    }

    @RequestMapping(value="", method = RequestMethod.PATCH)
    public void updateZone(@RequestBody Zone zone) {
        Zone existingZone = zoneRepository.findOne(zone.getId());
        existingZone.setArea(zone.getArea());
        existingZone.setName(zone.getName());
        existingZone.setGpio(zone.getGpio());
    }

    @RequestMapping(value="", method = RequestMethod.DELETE)
    public void deleteZone(@RequestBody Zone zone) {
        zoneRepository.delete(zone);
    }

}
