package edu.austral.ingsis.math.visitor.function;

import edu.austral.ingsis.math.visitor.Visitable;
import edu.austral.ingsis.math.visitor.Visitor;

/**
 * @author Agustin Augurusa
 */
public class Parentesis implements Visitable {

    private final Visitable a;

    public Parentesis(Visitable a) {
        this.a = a;
    }

    public Visitable getA() {
        return a;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

}