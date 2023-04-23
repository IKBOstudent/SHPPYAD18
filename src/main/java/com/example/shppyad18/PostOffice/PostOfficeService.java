package com.example.shppyad18.PostOffice;

import com.example.shppyad18.Departure.Departure;
import com.example.shppyad18.Departure.DepartureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostOfficeService {
    private final PostOfficeRepository postOfficeRepository;

    @Autowired
    public PostOfficeService(PostOfficeRepository postOfficeRepository) {
        this.postOfficeRepository = postOfficeRepository;
    }

    public List<PostOffice> getAllPostOffices() {
        return postOfficeRepository.findAll();
    }

    public List<PostOffice> getPostOfficesByCity(String city) {
        return postOfficeRepository.findByCity(city);
    }

    public List<PostOffice> getPostOfficesByName(String name) {
        return postOfficeRepository.findByName(name);
    }

    public PostOffice getPostOfficeById(Long id) {
        return postOfficeRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("no post office with id " + id));
    }

    public PostOffice createPostOffice(PostOffice postOffice) {
        postOfficeRepository.save(postOffice);
        return postOffice;
    }

    public void deletePostOfficeById(Long id) {
        if (postOfficeRepository.existsById(id))
            postOfficeRepository.deleteById(id);
        else
            throw new IllegalStateException("no post office with id " + id);
    }

    public List<Departure> getDeparturesByPostOffice(Long id) {
        PostOffice postOffice = postOfficeRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("no post office with id " + id));

        return postOffice.getDepartureList();
    }
}
