package edu.austral.ingsis.math.visitor;

/**
 * @author Agustin Augurusa
 */
public class Variable implements Visitable {

    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

}