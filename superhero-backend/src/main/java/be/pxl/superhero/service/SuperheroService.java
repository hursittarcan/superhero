package be.pxl.superhero.service;

import be.pxl.superhero.api.SuperheroDTO;

import java.util.List;

public interface SuperheroService {

    List<SuperheroDTO> findAllSuperHeroes();

    SuperheroDTO findSuperheroById(Long superheroId);

    SuperheroDTO createSuperhero(SuperheroRequest superheroRequest);

    SuperheroDTO updateSuperhero(Long superheroId, SuperheroRequest superheroRequest);

    boolean deleteSuperhero(Long superheroId);
}
