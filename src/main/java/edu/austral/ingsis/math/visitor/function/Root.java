package edu.austral.ingsis.math.visitor.function;

import edu.austral.ingsis.math.visitor.Visitable;
import edu.austral.ingsis.math.visitor.Visitor;

/**
 * @author Agustin Augurusa
 */
public class Root implements Visitable {

    private final Visitable base;
    private final Visitable root;

    public Root(Visitable base, Visitable root) {
        this.base = base;
        this.root = root;
    }

    public Visitable getBase() {
        return base;
    }

    public Visitable getRoot() {
        return root;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

}