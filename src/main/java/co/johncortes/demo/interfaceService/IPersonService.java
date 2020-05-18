package co.johncortes.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import co.johncortes.demo.model.Person;

public interface IPersonService {
	
	public List< Person > list();
	
	public Optional<Person> listById(int id);
	
	public int save(Person p);
	
	public void delete(int id);

}
