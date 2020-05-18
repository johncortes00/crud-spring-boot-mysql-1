package co.johncortes.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.johncortes.demo.interfaceService.IPersonService;
import co.johncortes.demo.interfaces.IPerson;
import co.johncortes.demo.model.Person;

@Service
public class PersonService implements IPersonService{
	
	@Autowired
	private IPerson data;
	@Override
	public List<Person> list() {
		return (List<Person>) data.findAll();
	}

	@Override
	public Optional<Person> listById(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Person p) {
		int res=0;
		Person person = data.save(p);
		if(!person.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

}
