package action;

import locationobject.person.Person;

public class Cry implements Action, Stoppable{

    private final Person person;

    public Cry(Person person){
        this.person = person;
    }
    @Override
    public void execute() throws InterruptedException {
        person.cry();
    }

    @Override
    public void stop() throws InterruptedException {
        person.stopCrying();
    }
}
