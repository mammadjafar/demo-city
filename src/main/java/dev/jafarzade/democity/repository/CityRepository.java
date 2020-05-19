package dev.jafarzade.democity.repository;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import dev.jafarzade.democity.domain.City;

@RepositoryRestResource(collectionResourceRel = "cities", path = "cities")
public interface CityRepository extends PagingAndSortingRepository<City, Long> {

    Page<City> findAll(Pageable pageable);

    @RestResource(exported = false)
    Optional<City> findById(Long id);

    @RestResource(path = "name", rel = "name")
    Page<City> findByNameIgnoreCase(@Param("q") String name, Pageable pageable);

    @RestResource(path = "nameContains", rel = "nameContains")
    Page<City> findByNameContainsIgnoreCase(@Param("q") String name, Pageable pageable);

    @RestResource(path = "country", rel = "country")
    Page<City> findByCountryIgnoreCase(@Param("q") String name, Pageable pageable);

}
