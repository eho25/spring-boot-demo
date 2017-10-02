package com.sboot.services.services;

import com.sboot.data.entities.Person;
import com.sboot.data.repositories.PersonRepository;
import com.sboot.services.mappers.PersonMapper;
import com.sboot.services.models.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepo;

    @Autowired
    private PersonMapper personMapper;

    private static final String NAME ="test";


    public List<PersonModel> getAllPeople(){
        List<Person> personData = personRepo.findAll();
        return personMapper.convertEntitiesToModels(personData);
    }

    public void testBatch(){
        int i = 0;
        List<Person> batchSaveList = new ArrayList<>();
        List<Person> normalSaveList = new ArrayList<>();

        for(; i < 100000; ++i){
            Person p = new Person();
            p.setFirstName(NAME);
            p.setLastName(NAME);
            p.setJobId(i);
            p.setId(i);
            batchSaveList.add(p);
        }
        for(; i < 200000; ++i){
            Person p = new Person();
            p.setFirstName(NAME);
            p.setLastName(NAME);
            p.setJobId(i);
            p.setId(i);
            normalSaveList.add(p);
        }
        long startTimeBatch = System.currentTimeMillis();
        personRepo.batchSave(batchSaveList);
        long endTimeBatch = System.currentTimeMillis();
        long startTimeNormal = System.currentTimeMillis();
        personRepo.save(normalSaveList);
        long endTimeNormal = System.currentTimeMillis();
        long batchTime = endTimeBatch - startTimeBatch;
        long normalTime = endTimeNormal - startTimeNormal;
        System.out.println("Batch time: " + batchTime);
        System.out.println("Normal time: " + normalTime);

    }
}
