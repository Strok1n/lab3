package geometry;

public interface Vector {
    Vector add(Vector vector);
    default Vector subtract(Vector vector){
        return this.add(vector.getOppositeVector());
    }
    Vector getOppositeVector();
    boolean isCodirectedTo(Vector vector);
}
