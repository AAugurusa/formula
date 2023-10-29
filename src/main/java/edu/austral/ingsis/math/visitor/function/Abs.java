package edu.austral.ingsis.math.visitor.function;

import edu.austral.ingsis.math.visitor.Visitable;
import edu.austral.ingsis.math.visitor.Visitor;

/**
 * @author Agustin Augurusa
 */
public class Abs implements Visitable {

    private final Visitable abs;

    public Abs(Visitable abs) {
        this.abs = abs;
    }

    public Visitable getAbs() {
        return abs;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}