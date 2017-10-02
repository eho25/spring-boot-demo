package com.sboot.services.mappers;

import com.sboot.data.entities.Person;
import com.sboot.services.models.PersonModel;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper extends BaseMapper<Person, PersonModel>{

    @Override
    public PersonModel convertEntityToModel(Person person){
        PersonModel model = new PersonModel();
        model.setFirstName(person.getFirstName());
        model.setLastName(person.getLastName());
        model.setId(person.getId());
        return model;
    }
}
