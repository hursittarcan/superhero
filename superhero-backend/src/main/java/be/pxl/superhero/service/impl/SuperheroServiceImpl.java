package be.pxl.superhero.service.impl;

import be.pxl.superhero.api.SuperheroDTO;
import be.pxl.superhero.api.SuperheroRequest;
import be.pxl.superhero.domain.Superhero;
import be.pxl.superhero.repository.SuperheroRepository;
import be.pxl.superhero.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuperheroServiceImpl implements SuperheroService {
    private final SuperheroRepository superheroRepository;

    @Autowired
    public SuperheroServiceImpl(SuperheroRepository superheroRepository) {
        this.superheroRepository = superheroRepository;
    }

    public List<SuperheroDTO> findAllSuperHeroes() {
        return superheroRepository.findAll()
                .stream().map(SuperheroDTO::new)
                .collect(Collectors.toList());
    }

    public SuperheroDTO findSuperheroById(Long superheroId) {
        return superheroRepository.findById(superheroId)
                .map(SuperheroDTO::new)
                .orElseThrow(() -> new ArithmeticException("Exception"));
    }

    public SuperheroDTO createSuperhero(SuperheroRequest superheroRequest) {
        Superhero superhero = new Superhero(superheroRequest.getFirstName(), superheroRequest.getLastName(), superheroRequest.getSuperheroName());
        superheroRepository.save(superhero);
        return new SuperheroDTO(superhero);
    }

    public SuperheroDTO updateSuperhero(Long superheroId, SuperheroRequest superheroRequest) {
        return superheroRepository.findById(superheroId)
                .map(superhero -> {
                    superhero.setFirstName(superheroRequest.getFirstName());
                    superhero.setLastName(superheroRequest.getLastName());
                    superhero.setSuperHeroName(superheroRequest.getSuperheroName());
                    superheroRepository.save(superhero);
                    return new SuperheroDTO(superhero);
                }).orElseThrow(() -> new ArithmeticException("Exception"));
    }

    public boolean deleteSuperhero(Long superheroId) {
        return superheroRepository.findById(superheroId)
                .map(superhero -> {
                    superheroRepository.delete(superhero);
                    return true;
                }).orElseThrow(() -> new ArithmeticException("Exception"));
    }
}
