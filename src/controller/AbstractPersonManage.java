package controller;

import model.Person;

import java.util.List;
import java.util.Vector;

public abstract class AbstractPersonManage {
    private List<Person> allmember = new Vector<>();

    List<Person> listallmember() {
        return allmember;
    }

    Person getPerson(String firstname, String lastname) {
        for (Person anMember:
             allmember) {
            if (anMember.getFirstname().equals(firstname) && anMember.getLastname().equals(lastname)) {
                return anMember;
            }
        }
        return null;
    }

    void addPerson(Person person) {
        allmember.add(person);
    }

    void deletePerson(Person person) {
        allmember.remove(person);
    }

    void deletePerson(String firstname, String lastname) {
        Person p = getPerson(firstname,lastname);
        deletePerson(p);
    }

    void updatePerson(Person person) {
        Person p = getPerson(person.getFirstname(), person.getLastname());
        if (p != null){
            deletePerson(p);
            addPerson(p);
        }
    }
}
