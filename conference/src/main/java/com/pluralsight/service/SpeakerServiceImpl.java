package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service("speakerService")
@Profile("dev")
public class SpeakerServiceImpl implements SpeakerService {

    private final SpeakerRepository repository;

    @Autowired
    public SpeakerServiceImpl(final SpeakerRepository speakerRepository) {
        System.out.println("SpeakerServiceImpl repository constructor");
        this.repository = speakerRepository;
    }

    @PostConstruct
    private void initialize() {
        System.out.println("We're called after the constructor");
    }

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }

}
