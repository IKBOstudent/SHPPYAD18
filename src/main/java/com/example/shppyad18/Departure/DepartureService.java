package com.example.shppyad18.Departure;

import com.example.shppyad18.PostOffice.PostOffice;
import com.example.shppyad18.PostOffice.PostOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartureService {
    private final DepartureRepository departureRepository;
    private final PostOfficeRepository postOfficeRepository;

    @Autowired
    public DepartureService(DepartureRepository departureRepository, PostOfficeRepository postOfficeRepository) {
        this.departureRepository = departureRepository;
        this.postOfficeRepository = postOfficeRepository;
    }

    public List<Departure> getAllDepartures() {
        return departureRepository.findAll();
    }

    public List<Departure> getDeparturesByDate(String date) {
        return departureRepository.findByDate(date);
    }

    public List<Departure> getDeparturesByType(String type) {
        return departureRepository.findByType(type);
    }

    public Departure getDepartureById(Long id) {
        return departureRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("no departure with id " + id));
    }

    public Departure addDeparture(Long officeId, Departure departure) {
        PostOffice postOffice = postOfficeRepository.findById(officeId)
                .orElseThrow(() -> new IllegalStateException("no post office with id " + officeId));

        postOffice.addDeparture(departure);
        departure.setPostOffice(postOffice);

        departureRepository.save(departure);
        postOfficeRepository.save(postOffice);


        return departure;
    }

    public void deleteDepartureById(Long id) {
        if (departureRepository.existsById(id))
            departureRepository.deleteById(id);
        else
            throw new IllegalStateException("no departure with id " + id);
    }

}