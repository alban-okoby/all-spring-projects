package com.digitalsouag.portfolio.services.impl;

import com.digitalsouag.portfolio.entities.Home;
import com.digitalsouag.portfolio.repositories.HomeRepository;
import com.digitalsouag.portfolio.services.HomeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class HomeServiceImpl implements HomeService {

    private final HomeRepository homeRepository;

    @Override
    public Home create(Home home) throws Exception {
        if (homeRepository == null) {
            throw new Exception("Home must not be null");
        }
        Home newHome = new Home();
             newHome.setDescription(home.getDescription());
             newHome.setSalutation(home.getSalutation());
        return homeRepository.save(home);
    }

    @Override
    public Home update(Home home, Long id) throws Exception {
        if (homeRepository == null) {
            throw new Exception("Home must not be null");
        }
        if (!homeRepository.existsById(home.getId())) {
            throw new Exception("Not found");
        }
        Home updateHome = this.homeRepository.findByIdHome(id);
        updateHome.setDescription(home.getDescription());
        updateHome.setSalutation(home.getSalutation());
        updateHome.setQuote(home.getQuote());
        return homeRepository.saveAndFlush(home);
    }

    @Override
    public List<Home> getHome() {
        return homeRepository.findFirstById();
    }
}
