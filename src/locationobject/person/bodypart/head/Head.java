package locationobject.person.bodypart.head;

import enumeration.GazeModifier;
import enumeration.HairColor;
import geometry.Point;
import locationobject.LocationObject;
import locationobject.Observer;
import locationobject.person.ObjectOnShoulder;
import locationobject.person.bodypart.head.mouth.Mouth;

import java.util.ArrayList;

public abstract class Head implements ObjectOnShoulder, Observer {
    protected GazeModifier gazeModifier;

    protected Mouth mouth;

    protected ArrayList<Tear> tears;

    protected int inclinationAngleInDegrees;

    protected Point pointILookingAt;
    HairColor hairColor;

    protected Head(HairColor hairColor, Mouth mouth){
        this.gazeModifier = GazeModifier.NORMAL;
        this.tears = new ArrayList<>();
        this.inclinationAngleInDegrees = 0;
        this.hairColor = hairColor;
        this.mouth = mouth;
    }

    public Point getPointILookingAt() {
        return pointILookingAt;
    }

    public void setPointILookingAt(Point pointILookingAt) {
        this.pointILookingAt = pointILookingAt;
    }

    @Override
    public void handleEvent(Point point) throws InterruptedException {
        this.pointILookingAt = point;
    }

    public Mouth getMouth() {
        return mouth;
    }

    public void cry(){
        for (int i = 0; i < 4; i++)
            this.tears.add(new Tear());
    }

    public void wipeTearsAway(){
        this.tears.clear();
    }

    public void nod() throws InterruptedException {
        System.out.println("Inclination angle of head:");
        for (int i = 0; i < 25; i++) {
            inclinationAngleInDegrees++;


            System.out.print(inclinationAngleInDegrees);
            Thread.sleep(100);
            System.out.print("\r");
            System.out.print("\r");
        }

        for (int i = 0; i < 25; i++) {
            inclinationAngleInDegrees--;
            System.out.print(inclinationAngleInDegrees);
            Thread.sleep(100);
            System.out.print("\r");
            System.out.print("\r");
        }
        System.out.println(inclinationAngleInDegrees);
    }

    public GazeModifier getGazeModifier() {
        return gazeModifier;
    }
    public void setGazeModifier(GazeModifier gazeModifier) {
        this.gazeModifier = gazeModifier;
    }



}
