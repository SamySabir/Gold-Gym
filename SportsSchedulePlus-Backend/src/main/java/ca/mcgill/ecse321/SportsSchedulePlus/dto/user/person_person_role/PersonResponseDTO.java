package ca.mcgill.ecse321.SportsSchedulePlus.dto.user.person_person_role;

import ca.mcgill.ecse321.SportsSchedulePlus.dto.user.customer.CustomerResponseDTO;
import ca.mcgill.ecse321.SportsSchedulePlus.dto.user.instructor.InstructorResponseDTO;
import ca.mcgill.ecse321.SportsSchedulePlus.dto.user.owner.OwnerResponseDTO;
import ca.mcgill.ecse321.SportsSchedulePlus.model.Person;
import ca.mcgill.ecse321.SportsSchedulePlus.model.PersonRole;
import ca.mcgill.ecse321.SportsSchedulePlus.model.Customer;
import ca.mcgill.ecse321.SportsSchedulePlus.model.Instructor;
import ca.mcgill.ecse321.SportsSchedulePlus.model.Owner;

public class PersonResponseDTO {

    private int id;
    private String name;
    private String email;
    private String password;
    private PersonRoleResponseDTO personRoleDto;

    public PersonResponseDTO(){

    }

    public PersonResponseDTO(int id, String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public PersonResponseDTO(String name, String email, String password, PersonRoleResponseDTO personRoleDto){
        this.id = personRoleDto.getId();
        this.name = name;
        this.email = email;
        this.password = password;
        this.personRoleDto = personRoleDto;
    }

    public PersonResponseDTO (Person p) {
        id = p.getId();
        name = p.getName();
        email = p.getEmail();
        password = p.getPassword();
        PersonRole personRole = p.getPersonRole();
        if (personRole != null) {
            if (personRole instanceof Customer) {
                personRoleDto = new CustomerResponseDTO((Customer) personRole);
            } else if (personRole instanceof Instructor) {
                personRoleDto = new InstructorResponseDTO((Instructor) personRole);
            } else {
                personRoleDto = new OwnerResponseDTO((Owner) personRole);
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public PersonRoleResponseDTO getPersonRoleDto(){
        return personRoleDto;
    }
}