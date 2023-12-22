package action;

import enumeration.GazeModifier;
import locationobject.person.Person;

public class SetGazeModifier implements Action{
    private final Person person;
    private final GazeModifier gazeModifier;

    public SetGazeModifier(Person person, GazeModifier gazeModifier){
        this.person = person;
        this.gazeModifier = gazeModifier;
    }


    @Override
    public void execute() throws InterruptedException {
        this.person.getHead().setGazeModifier(gazeModifier);
    }
}
