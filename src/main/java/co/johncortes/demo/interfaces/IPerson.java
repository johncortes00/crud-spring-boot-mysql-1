package co.johncortes.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.johncortes.demo.model.Person;

@Repository
public interface IPerson extends CrudRepository<Person, Integer>{

}
