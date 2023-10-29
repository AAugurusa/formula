package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.Number;
import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.visitor.function.*;

import java.util.Map;

/**
 * @author Agustin Augurusa
 */
public class EvaluateVisitor implements Visitor<Double> {

    private final Map<String,Double> variables;

    public EvaluateVisitor(Map<String,Double> variables) {
        this.variables = variables;
    }

    public EvaluateVisitor() {
        this(Map.of());
    }

    @Override
    public Double visit(Sum sum) {
        return sum.getSum1().accept(this) + sum.getSum2().accept(this);
    }

    @Override
    public Double visit(Sub sub) {
        return sub.getSub1().accept(this) - sub.getSub2().accept(this);
    }

    @Override
    public Double visit(Mul mul) {
        return mul.getA().accept(this) * mul.getB().accept(this);
    }

    @Override
    public Double visit(Div div) {
        return div.getDividend().accept(this) / div.getDivisor().accept(this);
    }

    @Override
    public Double visit(Pow pow) {
        return Math.pow(pow.getBase().accept(this), pow.getPow().accept(this));
    }

    @Override
    public Double visit(Abs abs) {
        return Math.abs(abs.getAbs().accept(this));
    }

    @Override
    public Double visit(Root root) {
        return Math.pow(root.getBase().accept(this), 1 / root.getRoot().accept(this));
    }

    @Override
    public Double visit(Parentesis parentesis) {
        return parentesis.getA().accept(this);
    }

    @Override
    public Double visit(Number number) {
        return number.getVal();
    }

    @Override
    public Double visit(Variable variable) {
        return variables.containsKey(variable.getName()) ? variables.get(variable.getName()) : 0;
    }
}