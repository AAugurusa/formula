package edu.austral.ingsis.math.visitor;

/**
 * @author Agustin Augurusa
 */
public class Number implements Visitable {

    private final double val;

    public Number(double val) {
        this.val = val;
    }

    public double getVal() {
        return val;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}