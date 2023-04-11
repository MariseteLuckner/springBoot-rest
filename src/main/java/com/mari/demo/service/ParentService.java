package com.mari.demo.service;

import com.mari.demo.dto.ChildDTO;
import com.mari.demo.dto.ChildMapper;
import com.mari.demo.model.Child;
import com.mari.demo.model.Parent;
import com.mari.demo.repository.ChildRepository;
import com.mari.demo.repository.ParentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ParentService {

    private final ChildRepository childRepository;

    private final ParentRepository parentRepository;

    public List<String> getFatherNames() {
        List<Parent> fathers = new ArrayList<>();
        List<Child> children = childRepository.findAll();
        children.forEach(child -> {
            if(child.getFather() != null) {
                fathers.add(child.getFather());
            }
        });

       return fathers.stream().distinct().map(Parent::getName).collect(Collectors.toList());
    }


    public List<String> getParentsWithManyChildren() {
        List<String> fathers = new ArrayList<>();
        Set<String> hash = new HashSet<>();
        List<Child> children = childRepository.findAll();
        children.forEach(child -> {
            if(child.getFather() != null) {
                fathers.add(child.getFather().getName());
            }
        });

        return fathers.stream().filter(e -> !hash.add(e))
                .distinct().collect(Collectors.toList());
    }


    public List<ChildDTO> getChildParents() {
        return childRepository.findAll().stream()
                .map(ChildMapper::fromEntityChildDTO).collect(Collectors.toList());

    }

    public int getNumberOfJohnChildren() {
        Parent parent = parentRepository.findByName("John");
        return parent.getFathers().size();

    }

    public int getNumberOfMaryChildren() {
        Parent parent = parentRepository.findByName("Mary");
        return parent.getMother().size();
    }
}
