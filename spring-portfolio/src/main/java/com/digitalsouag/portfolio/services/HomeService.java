package com.digitalsouag.portfolio.services;

import com.digitalsouag.portfolio.entities.Home;

public interface HomeService {
    Home create(Home home) throws Exception;
    Home update(Home home) throws Exception;
}
