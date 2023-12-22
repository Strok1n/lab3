package locationobject.person;

import enumeration.Orientation;
import geometry.Point;
import locationobject.LocationObject;
import locationobject.Listener;
import locationobject.item.Item;
import locationobject.person.bodypart.head.Head;
import locationobject.person.bodypart.pairedbodypart.hand.Hand;
import locationobject.person.bodypart.pairedbodypart.hand.HandState;
import locationobject.person.bodypart.pairedbodypart.leg.Leg;
import locationobject.person.bodypart.torso.Torso;

import java.util.ArrayList;
import java.util.Objects;

abstract public class Person extends LocationObject implements Listener {
    protected final String firstName;
    protected final String lastName;

    protected final Head head;
    protected final Torso torso;
    protected final Hand leftHand;
    protected final Hand rightHand;
    protected final Leg leftLeg;
    protected final Leg rightLeg;
    protected final Mind subconscious;
    protected boolean isCrying;
    protected boolean isDead;

    protected int hapinessLevel;
    protected int cash;




    protected Person(String firstName, String lastName,
                     Head head, Torso torso,
                     Hand leftHand, Hand rightHand,
                     Leg leftLeg, Leg rightLeg) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.head = head;
        this.torso = torso;
        this.leftHand = leftHand;
        this.rightHand = rightHand;
        this.leftLeg = leftLeg;
        this.rightLeg = rightLeg;
        this.subconscious = new Mind();
        this.isCrying = false;
        this.isDead = false;
        this.hapinessLevel = 50;
        this.observers = new ArrayList<>();
        this.cash = 100;

    }


    public void addMouthListener(Listener listener){
        this.head.getMouth().addListener(listener);
    }


    public Head getHead() {
        return this.head;
    }


    public Hand getLeftHand() {
        return leftHand;
    }

    public Hand getRightHand() {
        return rightHand;
    }

    public void addBelief(String belief){
        if(subconscious.addBelief(belief))
            System.out.println(this + " got new belief: " + belief);
    }

    public void worsenTheMood(int k) throws InterruptedException {
        if (this.hapinessLevel - k <= 0) {
            System.out.println("Mood of " + this + " couldn't be that worse");
            return;
        }
        this.hapinessLevel -= k;
        System.out.println("Mood of " + this + " worsened by " + k + " levels");
        Thread.sleep(500);
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getCash() {
        return cash;
    }

    public void improveTheMood(int k) throws InterruptedException {
        if (this.hapinessLevel + k >= 100) {
            System.out.println("Mood of " + this + " couldn't be that better");
            return;
        }
        this.hapinessLevel += k;
        System.out.println("Mood of " + this + " improved by " + k + " levels");
        Thread.sleep(500);
    }


    public void say(Person toPerson, String words) throws InterruptedException {
        System.out.println(this + " tells " + toPerson + ":");
        this.head.getMouth().sayAText(words);
    }

    public void thank(Person person) throws InterruptedException {
        this.say(person, "thanks.");
        person.improveTheMood(1);

    }

    public void condole(Person person) throws InterruptedException {


        this.say(person, "my condolences.");
        person.improveTheMood(1);
    }

    public void comfort(Person person) throws InterruptedException {
        this.say(person, "It must be hard be for you.");
        person.improveTheMood(2);
    }

    public void nod() throws InterruptedException {
        System.out.println(this + " nods");
        this.head.nod();
        Thread.sleep(500);
    }

    public void wipeTearsAway(Person person) throws InterruptedException {
        if (person.isCrying) {
            System.out.println(this + " wipes the tears away from face of " + person );
            person.head.wipeTearsAway();
            Thread.sleep(500);
        }
    }

    public void cry() throws InterruptedException {
        this.isCrying = true;
        this.worsenTheMood(5);
        this.head.cry();
        System.out.println(this + " started crying");
    }

    public void stopCrying() throws InterruptedException {
        this.head.wipeTearsAway();
        this.isCrying = false;
        this.improveTheMood(5);
        System.out.println(this + " stopped crying");
    }

    public void putPalmOnShoulder(Person person, Orientation handSide, Orientation shoulderSide){
        if (handSide == Orientation.LEFT && shoulderSide == Orientation.RIGHT) {
            person.rightHand.getShoulder().setObjectOnShoulder(this.leftHand.getPalm());
            System.out.println(this + " puts left palm on right shoulder of " + person);
        }
        if (handSide == Orientation.RIGHT && shoulderSide == Orientation.LEFT) {
            person.leftHand.getShoulder().setObjectOnShoulder(this.rightHand.getPalm());
            System.out.println(this + " puts right palm on left shoulder of " + person);

        }
        if (handSide == Orientation.LEFT && shoulderSide == Orientation.LEFT) {
            person.leftHand.getShoulder().setObjectOnShoulder(this.leftHand.getPalm());
            System.out.println(this + " puts left palm on left shoulder of " + person);
        }
        if (handSide == Orientation.RIGHT && shoulderSide == Orientation.RIGHT) {
            person.rightHand.getShoulder().setObjectOnShoulder(this.rightHand.getPalm());
            System.out.println(this + " puts right palm on right shoulder of " + person);
        }
    }

    public void removePalmFromShoulder(Person person, Orientation handSide, Orientation shoulderSide){
        if (handSide == Orientation.LEFT && shoulderSide == Orientation.RIGHT) {
            person.rightHand.getShoulder().setObjectOnShoulder(null);
            System.out.println(this + " removes left palm from right shoulder of " + person);
        }
        if (handSide == Orientation.RIGHT && shoulderSide == Orientation.LEFT) {
            person.leftHand.getShoulder().setObjectOnShoulder(null);
            System.out.println(this + " removes right palm from left shoulder of " + person);

        }
        if (handSide == Orientation.LEFT && shoulderSide == Orientation.LEFT) {
            person.leftHand.getShoulder().setObjectOnShoulder(null);
            System.out.println(this + " removes left palm from left shoulder of " + person);
        }
        if (handSide == Orientation.RIGHT && shoulderSide == Orientation.RIGHT) {
            person.rightHand.getShoulder().setObjectOnShoulder(null);
            System.out.println(this + " removes right palm from right shoulder of " + person);
        }
    }

    public void plungeIntoSorrowsAndFantasies() throws InterruptedException {
        this.worsenTheMood(10);
    }
    public void putHeadOnShoulder(Person person, Orientation shoulderSide) throws InterruptedException {
        Thread.sleep(500);
        if (shoulderSide == Orientation.LEFT) {
            person.leftHand.getShoulder().setObjectOnShoulder(this.head);
            System.out.println(this + " puts head on left shoulder of " + person);
        }
        if (shoulderSide == Orientation.RIGHT){
            person.rightHand.getShoulder().setObjectOnShoulder(this.head);
            System.out.println(this + " puts head on right shoulder of " + person);
        }
    }

    public void removeHeadFromShoulder(Person person, Orientation headSide) throws InterruptedException {
        Thread.sleep(500);
        if (headSide == Orientation.LEFT) {
            person.leftHand.getShoulder().setObjectOnShoulder(null);
            System.out.println(this + "removes head from left shoulder of " + person);
        }
        if (headSide == Orientation.RIGHT) {
            person.rightHand.getShoulder().setObjectOnShoulder(null);
            System.out.println(this + "removes head from right shoulder of " + person);
        }
    }



    @Override
    public void handleEvent(Character character) throws InterruptedException {
        this.subconscious.putInWorkingMemory(character, this);
    }





    public void hug(Person person) throws InterruptedException {
        person.torso.setPalmOnTheLeftSideOfTheBack(this.leftHand.getPalm());
        person.torso.setPalmOnTheRightSideOfTheBack(this.rightHand.getPalm());
        leftHand.setHandState(HandState.HUGGING);
        rightHand.setHandState(HandState.HUGGING);
        Thread.sleep(500);
        System.out.println(this + " start hugging " + person);
    }

    public void stopHugging(Person person) throws InterruptedException {
        person.torso.setPalmOnTheLeftSideOfTheBack(null);
        person.torso.setPalmOnTheRightSideOfTheBack(null);
        leftHand.setHandState(HandState.RELAXED);
        rightHand.setHandState(HandState.RELAXED);
        Thread.sleep(500);
        System.out.println(this + " stop hugging " + person);
    }

    public void takeItemByArmpit(Orientation armpitOrientation, Item item) throws InterruptedException {
        Thread.sleep(1000);
        switch (armpitOrientation){
            case LEFT:
                if (this.torso.getItemInLeftArmpit() == null) {
                    this.torso.setItemInLeftArmpit(item);
                    this.leftHand.setHandState(HandState.PRESSED_TO_THE_BODY);
                    System.out.println(this +" took the "+ item +" by left armpit.");
                } else
                    System.out.println("there is already an item in the " + armpitOrientation + " armpit");
            case RIGHT:
                if (this.torso.getItemInRightArmpit() == null) {
                    this.torso.setItemInRightArmpit(item);
                    this.rightHand.setHandState(HandState.PRESSED_TO_THE_BODY);
                    System.out.println(this +" took the "+ item +" by right armpit.");

                } else
                    System.out.println("there is already an item in the " + armpitOrientation + " armpit");
        }
    }

    public void takeItemByPalm(Orientation palmOrientation, Item item) throws InterruptedException {
        Thread.sleep(1000);
        switch (palmOrientation){
            case LEFT:
                if (this.leftHand.getPalm().getItem() == null) {
                    System.out.println(this +" took the "+ item +" with left hand.");
                    this.leftHand.getPalm().setItem(item);
                }
                else
                    System.out.println("there is already an item in the " + palmOrientation + " palm");
                break;
            case RIGHT:
                if (this.rightHand.getPalm().getItem() == null) {
                    this.rightHand.getPalm().setItem(item);
                    System.out.println(this +" took the "+ item +" with right hand.");
                }
                else
                    System.out.println("there is already an item in the " + palmOrientation + " palm");
                break;
        }
    }










    @Override
    public void setPoint(Point point) throws InterruptedException {
        this.point = point;
        this.head.getMouth().setPoint(point);
        notifyObservers(point);
    }






    @Override
    public boolean equals(Object otherObject){
        if (!super.equals(otherObject)) return false;

        Person other = (Person) otherObject;
        return Objects.equals(this.firstName, other.lastName) &&
                Objects.equals(this.lastName, other.lastName) &&
                Objects.equals(this.head, other.head) &&
                Objects.equals(this.torso, other.torso) &&
                Objects.equals(this.leftHand, other.leftHand) &&
                Objects.equals(this.rightHand, other.rightHand) &&
                Objects.equals(this.leftLeg, other.rightLeg) &&
                Objects.equals(this.subconscious, other.subconscious) &&
                Objects.equals(this.isCrying, other.isCrying) &&
                Objects.equals(this.isDead, other.isDead) &&
                Objects.equals(this.hapinessLevel, other.hapinessLevel);
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), firstName, lastName, head,
                torso, leftHand, rightHand, leftLeg, subconscious, isCrying,
                isDead, hapinessLevel);
    }


    @Override
    public String toString(){
        return this.firstName + " " + this.lastName;
    }







}
