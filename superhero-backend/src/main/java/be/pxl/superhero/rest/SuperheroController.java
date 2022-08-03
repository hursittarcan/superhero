package be.pxl.superhero.rest;

import be.pxl.superhero.api.SuperheroDTO;
import be.pxl.superhero.api.SuperheroRequest;
import be.pxl.superhero.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/superheroes")
public class SuperheroController {
    private final SuperheroService superheroService;

    @Autowired
    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @GetMapping
    public List<SuperheroDTO> getAllSuperheroes() {
        return superheroService.findAllSuperHeroes();
    }

    @GetMapping("/{superheroId}")
    public SuperheroDTO getSuperheroById(@PathVariable Long superheroId) {
        return superheroService.findSuperheroById(superheroId);
    }

    @PostMapping
    public ResponseEntity<SuperheroDTO> createSuperhero(@RequestBody SuperheroRequest superheroRequest) {
        return new ResponseEntity<>(superheroService.createSuperhero(superheroRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{superheroId}")
    public ResponseEntity<SuperheroDTO> updateSuperhero(@PathVariable Long superheroId, @RequestBody SuperheroRequest superheroRequest) {
        return new ResponseEntity<>(superheroService.updateSuperhero(superheroId, superheroRequest), HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteSuperhero(@PathVariable Long superheroId) {
        boolean deleted = superheroService.deleteSuperhero(superheroId);
        return deleted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
