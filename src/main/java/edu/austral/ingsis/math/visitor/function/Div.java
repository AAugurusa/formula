package edu.austral.ingsis.math.visitor.function;

import edu.austral.ingsis.math.visitor.Visitable;
import edu.austral.ingsis.math.visitor.Visitor;

/**
 * @author Agustin Augurusa
 */
public class Div implements Visitable {

    private final Visitable dividend;
    private final Visitable divisor;

    public Div(Visitable dividend, Visitable divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    public Visitable getDividend() {
        return dividend;
    }

    public Visitable getDivisor() {
        return divisor;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}