package org.academiadecodigo.hackaton.services;

import org.academiadecodigo.hackaton.persistence.model.Pacote;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PackageServiceImpl implements PackageService{

    private Map<Integer, Pacote> packageMap = new HashMap<>();

    @Override
    public Pacote get(Integer id) {
        return packageMap.get(id);
    }

    @Override
    public List<Pacote> list() {
        return new ArrayList<>(packageMap.values());
    }

    @Override
    public void delete(Integer id) {
        packageMap.remove(id);
    }

    @Override
    public void add(Pacote pacote) {

        if (pacote.getId() == null) {
            pacote.setId(getNextId());
        }

        packageMap.put(pacote.getId(), pacote);
    }

    private Integer getNextId() {
        return packageMap.isEmpty() ? 1 : Collections.max(packageMap.keySet()) + 1;
    }
}
