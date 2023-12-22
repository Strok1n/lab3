package locationobject.person.bodypart.torso;


import enumeration.Gender;
import locationobject.item.Item;
import locationobject.person.bodypart.pairedbodypart.hand.palm.Palm;

public abstract class Torso {

    protected final Gender type;
    protected Palm palmOnTheLeftSideOfTheBack;
    protected Palm palmOnTheRightSideOfTheBack;
    protected Item itemInLeftArmpit;
    protected Item itemInRightArmpit;
    protected Torso(Gender type){
        this.type = type;
        this.palmOnTheLeftSideOfTheBack = null;
        this.palmOnTheRightSideOfTheBack = null;
        this.itemInLeftArmpit = null;
        this.itemInRightArmpit = null;
    }

    public Palm getPalmOnTheLeftSideOfTheBack() {
        return palmOnTheLeftSideOfTheBack;
    }

    public void setPalmOnTheLeftSideOfTheBack(Palm palmOnTheLeftSideOfTheBack) {
        this.palmOnTheLeftSideOfTheBack = palmOnTheLeftSideOfTheBack;
    }

    public Palm getPalmOnTheRightSideOfTheBack() {
        return palmOnTheRightSideOfTheBack;
    }

    public void setPalmOnTheRightSideOfTheBack(Palm palmOnTheRightSideOfTheBack) {
        this.palmOnTheRightSideOfTheBack = palmOnTheRightSideOfTheBack;
    }

    public Item getItemInLeftArmpit() {
        return itemInLeftArmpit;
    }

    public void setItemInLeftArmpit(Item itemInLeftArmpit) {
        this.itemInLeftArmpit = itemInLeftArmpit;
    }

    public Item getItemInRightArmpit() {
        return itemInRightArmpit;
    }

    public void setItemInRightArmpit(Item itemInRightArmpit) {
        this.itemInRightArmpit = itemInRightArmpit;
    }
}
