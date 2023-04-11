package com.mari.demo.controller;

import com.mari.demo.dto.ChildDTO;
import com.mari.demo.service.ParentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parents")
@AllArgsConstructor
public class ParentController {


    private final ParentService parentService;

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/names")
    public List<String> getAllFatherNames() {
        return parentService.getFatherNames();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/more-than-one-child")
    public List<String> getParentsWithManyChildren() {
        return parentService.getParentsWithManyChildren();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("child-parents")
    public List<ChildDTO> getChildParents() {
        return parentService.getChildParents();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/children-john-has")
    public int getNumberOfJohnChildren(){
        return parentService.getNumberOfJohnChildren();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/children-mary-has")
    public int getNumberOfMaryChildren() {
        return parentService.getNumberOfMaryChildren();
    }
}
