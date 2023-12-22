package locationobject.person;


import java.util.ArrayList;
import java.util.Objects;

public class Mind {
    private ArrayList<String> beliefs;
    private String workingMemory;
    public Mind(){
        beliefs = new ArrayList<String>();
        workingMemory = "";
    }
    public ArrayList<String> getBeliefs() {
        return beliefs;
    }
    public void setBeliefs(ArrayList<String> beliefs) {
        this.beliefs = beliefs;
    }
    public boolean addBelief(String belief){
        return beliefs.add(belief);
    }



    public void putInWorkingMemory(Character character, Person person) throws InterruptedException {
        workingMemory = workingMemory.concat(String.valueOf(character));
        if(character == '.'){
            System.out.println("working memory of " + person +
                    " is {" + workingMemory + "} will be cleared through 4 seconds.");
            Thread.sleep(4000);
            workingMemory = "";
        }
    }

    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;

        Mind other = (Mind) otherObject;
        if (this.beliefs.size() != other.beliefs.size())
            return false;
        for (int i = 0; i < other.beliefs.size(); i++) {
            if (!Objects.equals(beliefs.get(i), other.beliefs.get(i)))
                return false;
        }
        if (!Objects.equals(workingMemory,other.workingMemory))
            return false;
        return true;

    }

    @Override
    public int hashCode(){
        int hash = 31;
        for (int i = 0; i < beliefs.size(); i++)
            hash += 31 * Objects.hashCode(beliefs.get(i));
        return hash;
    }



    @Override
    public String toString(){
        return beliefs.toString();
    }




}

