package com.digitalsouag.portfolio.services;

import com.digitalsouag.portfolio.entities.Home;

import java.util.List;

public interface HomeService {
    Home create(Home home) throws Exception;
    Home update(Home home, Long id) throws Exception;
    List<Home> getHome();
}
