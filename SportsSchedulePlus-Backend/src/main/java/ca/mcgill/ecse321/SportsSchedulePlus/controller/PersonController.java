package ca.mcgill.ecse321.SportsSchedulePlus.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.SportsSchedulePlus.model.Person;
import ca.mcgill.ecse321.SportsSchedulePlus.service.userservice.PersonService;
import ca.mcgill.ecse321.SportsSchedulePlus.dto.user.person_person_role.PersonListResponseDTO;
import ca.mcgill.ecse321.SportsSchedulePlus.dto.user.person_person_role.PersonResponseDTO;

@CrossOrigin(origins = "*")
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    /*
     * get all persons (all users)
     */
    @GetMapping(value = {"/persons", "/persons/"})
    public PersonListResponseDTO getAllPersons() {
        List<PersonResponseDTO> dtos = new ArrayList<>();
        for (Person p : personService.getAllPersons()) {
            dtos.add(new PersonResponseDTO(p));
        }
        return new PersonListResponseDTO(dtos);
    }

    /*
     * get person by their person id
     */
    @GetMapping(value = {"/persons/{id}", "/persons/{id}/"})
    public PersonResponseDTO getPerson(@PathVariable("id") int id) {
        Person p = personService.getPersonById(id);
        return new PersonResponseDTO(p);
    }
}