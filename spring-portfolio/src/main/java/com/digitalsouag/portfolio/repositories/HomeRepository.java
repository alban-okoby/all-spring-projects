package com.digitalsouag.portfolio.repositories;

import com.digitalsouag.portfolio.entities.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {
    @Query(value = "SELECT h FROM Home h WHERE h.id =?1")
    Home findByIdHome(Long id);

    @Query(value = "SELECT h FROM Home h order by h.id desc")
    List<Home> findFirstById();

}
