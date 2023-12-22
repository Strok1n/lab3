package location;

import geometry.Point;
import geometry.TwoDimensionalPoint;
import geometry.TwoDimensionalVector;
import locationobject.LocationObject;
import locationobject.item.Sandwich;
import locationobject.item.Tray;
import locationobject.person.Person;

import java.util.Iterator;
import java.util.Objects;

public class TwoDimensionalLocation extends Location{

    private final int width;
    private final int length;
    private final boolean[][]spaceOccupation;

    public TwoDimensionalLocation(String name, int width, int length) {
        super(name);
        this.width = width;
        this.length = length;
        spaceOccupation = new boolean[width][length];
    }


    @Override
    public void addLocationObject(LocationObject locationObject, Point toPoint) throws InterruptedException {

        if (toPoint == null){
            if (locationObject instanceof Sandwich){
                Iterator<LocationObject> iterator = locationObjects.iterator();
                while (iterator.hasNext()) {
                    LocationObject o = iterator.next();
                    if (o instanceof Tray){
                        Tray tray = (Tray) o;
                        if (tray.getItemsOnATray().contains(locationObject)){
                            locationObjects.add(locationObject);
                            locationObject.setPoint(tray.getPoint());
                            return;
                        }
                    }

                }
            }
        }



        TwoDimensionalPoint twoDimensionalPoint = (TwoDimensionalPoint) toPoint;
        int x = twoDimensionalPoint.getX();
        int y = twoDimensionalPoint.getY();

        if (locationObjects.contains(locationObject)){

            System.out.println( locationObject + " is already added");
            return;
        }
        if(x >= width || y >= length || x < 0 || y < 0){
            System.out.println("coordinates out of bounds");
            return;
        }
        if(spaceOccupation[x][y]){
            System.out.println("point is occupied.");
            return;
        }

        spaceOccupation[x][y] = true;
        locationObjects.add(locationObject);
        locationObject.setPoint(new TwoDimensionalPoint(x,y));
        locationObject.setVector(new TwoDimensionalVector(0,1));

        if (locationObject instanceof Person) {
            Iterator<LocationObject> iterator = locationObjects.iterator();
            while (iterator.hasNext()) {
                LocationObject o = iterator.next();
                if (o instanceof Person && !Objects.equals(o, locationObject)) {
                    ((Person) o).addMouthListener((Person) locationObject);
                    ((Person) locationObject).addMouthListener((Person) o);
                }
            }

        }

        System.out.println( locationObject + " added to location " + this);
        Thread.sleep(500);
    }

    public boolean removeLocationObject(LocationObject locationObject){
        return this.locationObjects.remove(locationObject);
    }

    @Override
    public void clear(){
        for (int i = 0; i < width; i++)
            for (int j = 0; j < length; j++)
                spaceOccupation[i][j] = false;
        this.locationObjects.clear();
    }

    @Override
    public void makeAPersonWalk(Person person, Point toPoint) throws InterruptedException {
        TwoDimensionalPoint twoDimensionalPoint = (TwoDimensionalPoint) toPoint;
        int x = twoDimensionalPoint.getX();
        int y = twoDimensionalPoint.getY();

        if(x >= this.width || y >= this.length || x < 0 || y < 0){
            System.out.println("Coordinates out of bounds.");
            return;
        }

        boolean[][] spaceOccupationClone = new boolean[this.width][this.length];
        for(int i = 0; i < this.width; i++)
            for(int j = 0; j < this.length; j++)
                spaceOccupationClone[i][j] = this.spaceOccupation[i][j];
        spaceOccupationClone[((TwoDimensionalPoint)person.getPoint()).getX()][((TwoDimensionalPoint)person.getPoint()).getY()] = false;
        TwoDimensionalVector walkingVector = new TwoDimensionalVector(x -
                ((TwoDimensionalPoint)person.getPoint()).getX(), y - ((TwoDimensionalPoint)person.getPoint()).getY());
        person.setVector((new TwoDimensionalVector(Integer.signum(walkingVector.getX()), 0 )));
        for(int i = 0; i < Math.abs(walkingVector.getX()); i++ ){
            int previousX = ((TwoDimensionalPoint)person.getPoint()).getX();
            int previousY = ((TwoDimensionalPoint)person.getPoint()).getY();

            int newX = previousX + (walkingVector.getX() >= 0 ? 1 : -1);
            spaceOccupation[previousX][previousY] = spaceOccupationClone[previousX][previousY];
            person.setPoint(new TwoDimensionalPoint(newX, previousY));
            if(spaceOccupationClone[newX][previousY])
                System.out.println("Oops, person step on something.");
            spaceOccupation[newX][previousY] = true;
            Thread.sleep(500);
            System.out.println(person + " is walking, currently on coordinate " + person.getPoint() + " of location " + name);

        }
        person.setVector(new TwoDimensionalVector(0 ,  Integer.signum(walkingVector.getY())));
        for(int i = 0; i < Math.abs(walkingVector.getY()); i++ ){
            int previousX = ((TwoDimensionalPoint)person.getPoint()).getX();
            int previousY = ((TwoDimensionalPoint)person.getPoint()).getY();
            int newY = previousY + (walkingVector.getY() >= 0 ? 1 : -1);
            spaceOccupation[previousX][previousY] = spaceOccupationClone[previousX][previousY];
            person.setPoint(new TwoDimensionalPoint(previousX, newY));
            if(spaceOccupationClone[previousX][newY])
                System.out.println("Oops, person step on something.");
            spaceOccupation[previousX][newY] = true;
            Thread.sleep(500);
            System.out.println(person + " is walking, currently on coordinate " + person.getPoint() + " of location " + this);
        }

    }

    @Override
    public boolean areLocationObjectsCloseToEachOtherForInteraction(LocationObject firstObject, LocationObject secondObject) {
        return firstObject.getPoint()
                .distanceSquared(secondObject.getPoint()) <= 1 ;
    }

    @Override
    public boolean canAPersonStandHere(Point point) {
        int x = ((TwoDimensionalPoint) point).getX();
        int y = ((TwoDimensionalPoint) point).getY();
        if (x > -1 && x < width && y > -1 && y < length)
            return !spaceOccupation[x][y];
        return false;
    }
}
