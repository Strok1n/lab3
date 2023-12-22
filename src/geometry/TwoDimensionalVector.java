package geometry;

import java.util.Objects;

public class TwoDimensionalVector implements Vector{

    private final int x;
    private final int y;

    public TwoDimensionalVector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public Vector add(Vector vector) {
        return new TwoDimensionalVector(x + ((TwoDimensionalVector)vector).x, y + ((TwoDimensionalVector)vector).y);
    }
    @Override
    public Vector getOppositeVector() {
        return new TwoDimensionalVector( - this.x, - this.y);
    }

    @Override
    public boolean isCodirectedTo(Vector vector) {
        TwoDimensionalVector twoDimensionalVector = (TwoDimensionalVector) vector;

        return ((this.x * twoDimensionalVector.y) - (this.y * twoDimensionalVector.x)) == 0;
    }

    public TwoDimensionalVector getLeftPerpendicularVector(){
        return new TwoDimensionalVector(-this.y , this.x);
    }

    public TwoDimensionalVector getRightPerpendicularVector(){
        return new TwoDimensionalVector(this.y , -this.x);
    }


    @Override
    public String toString(){
        return "(" + this.x + ", " + this.y + ")";
    }

    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }

    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;

        TwoDimensionalVector other = (TwoDimensionalVector) otherObject;

        return Objects.equals(this.x, other.x) &&
                Objects.equals(this.y, other.y);
    }

}
