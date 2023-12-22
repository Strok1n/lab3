package action;

import locationobject.person.Person;

public class Nod implements Action{

    private final Person person;

    public Nod(Person person){
        this.person = person;
    }
    @Override
    public void execute() throws InterruptedException {
        person.nod();
    }
}
