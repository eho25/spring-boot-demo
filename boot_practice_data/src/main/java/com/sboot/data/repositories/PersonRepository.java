package com.sboot.data.repositories;

import com.sboot.data.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>, BaseRepository<Person, Long> {


}
