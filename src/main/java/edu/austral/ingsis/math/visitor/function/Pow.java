package edu.austral.ingsis.math.visitor.function;

import edu.austral.ingsis.math.visitor.Visitable;
import edu.austral.ingsis.math.visitor.Visitor;

/**
 * @author Agustin Augurusa
 */
public class Pow implements Visitable {

    private final Visitable base;
    private final Visitable pow;

    public Pow(Visitable base, Visitable pow) {
        this.base = base;
        this.pow = pow;
    }

    public Visitable getBase() {
        return base;
    }

    public Visitable getPow() {
        return pow;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}