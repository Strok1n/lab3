package action;

import locationobject.person.Person;

public class AddBelief implements Action{

    private final String belief;
    private final Person person;

    public AddBelief(Person person, String belief){
        this.person = person;
        this.belief = belief;
    }

    @Override
    public void execute() throws InterruptedException {
        this.person.addBelief(this.belief);
    }
}
