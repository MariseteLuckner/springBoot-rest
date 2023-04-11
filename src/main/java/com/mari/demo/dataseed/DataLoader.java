package com.mari.demo.dataseed;

import com.mari.demo.model.Child;
import com.mari.demo.model.Parent;
import com.mari.demo.repository.ChildRepository;
import com.mari.demo.repository.ParentRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private ParentRepository parentRepository;

    private ChildRepository childRepository;

    @Override
    public void run(String... args) throws Exception {
        loadParentData();
        loadChildData();
    }

    private void loadParentData() {
         if(parentRepository.count() == 0) {
             Parent parent1 = new Parent();
             parent1.setName("John");
             parentRepository.save(parent1);

             Parent parent2 = new Parent();
             parent2.setName("Paul");
             parentRepository.save(parent2);

             Parent parent3 = new Parent();
             parent3.setName("Mary");
             parentRepository.save(parent3);

             Parent parent4 = new Parent();
             parent4.setName("Lucy");
             parentRepository.save(parent4);

             Parent parent5 = new Parent();
             parent5.setName("Mark");
             parentRepository.save(parent5);
         }
    }

    private void loadChildData() {
        if(childRepository.count() == 0) {
            Child child1 = new Child();
            child1.setName("John");
            child1.setFather(parentRepository.findById(1L).get());
            child1.setMother(parentRepository.findById(3L).get());
            childRepository.save(child1);

            Child child2 = new Child();
            child2.setName("Paul");
            child2.setFather(parentRepository.findById(1L).get());
            child2.setMother(parentRepository.findById(3L).get());
            childRepository.save(child2);

            Child child3 = new Child();
            child3.setName("Lucy");
            child3.setFather(parentRepository.findById(2L).get());
            child3.setMother(parentRepository.findById(4L).get());
            childRepository.save(child3);

            Child child4 = new Child();
            child4.setName("Claire");
            child4.setFather(parentRepository.findById(1L).get());
            child4.setMother(parentRepository.findById(4L).get());
            childRepository.save(child4);

            Child child5 = new Child();
            child5.setName("Simon");
            child5.setFather(null);
            child5.setMother(parentRepository.findById(4L).get());
            childRepository.save(child5);
        }
    }
}
