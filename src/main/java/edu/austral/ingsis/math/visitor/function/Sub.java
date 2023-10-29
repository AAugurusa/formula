package edu.austral.ingsis.math.visitor.function;

import edu.austral.ingsis.math.visitor.Visitable;
import edu.austral.ingsis.math.visitor.Visitor;

/**
 * @author Agustin Augurusa
 */
public class Sub implements Visitable {

    private final Visitable sub1;
    private final Visitable sub2;

    public Sub(Visitable sub1, Visitable sub2) {
        this.sub1 = sub1;
        this.sub2 = sub2;
    }

    public Visitable getSub1() {
        return sub1;
    }

    public Visitable getSub2() {
        return sub2;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
