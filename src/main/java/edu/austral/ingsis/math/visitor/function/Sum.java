package edu.austral.ingsis.math.visitor.function;

import edu.austral.ingsis.math.visitor.Visitable;
import edu.austral.ingsis.math.visitor.Visitor;

/**
 * @author Agustin Augurusa
 */
public class Sum  implements Visitable {

    private final Visitable sum1;
    private final Visitable sum2;

    public Sum(Visitable sum1, Visitable sum2) {
        this.sum1 = sum1;
        this.sum2 = sum2;
    }

    public Visitable getSum1() {
        return sum1;
    }

    public Visitable getSum2() {
        return sum2;
    }


    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}