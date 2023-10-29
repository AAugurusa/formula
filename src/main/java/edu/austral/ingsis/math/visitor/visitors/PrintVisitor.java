package edu.austral.ingsis.math.visitor.visitors;
import edu.austral.ingsis.math.visitor.Number;
import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.visitor.function.*;
/**
 * @author Agustin Augurusa
 */


public class PrintVisitor implements Visitor<String> {
    @Override
    public String visit(Sum sum) {
        return sum.getSum1().accept(this) + " + " + sum.getSum2().accept(this);
    }

    @Override
    public String visit(Sub sub) {
        return sub.getSub1().accept(this) + " - " + sub.getSub2().accept(this);
    }

    @Override
    public String visit(Mul mul) {
        return mul.getA().accept(this) + " * " + mul.getB().accept(this);
    }

    @Override
    public String visit(Div div) {
        return div.getDividend().accept(this) + " / " + div.getDivisor().accept(this);
    }

    @Override
    public String visit(Pow pow) {
        return pow.getBase().accept(this) + " ^ " + pow.getPow().accept(this);
    }

    @Override
    public String visit(Abs abs) {
        return "|" + abs.getAbs().accept(this) + "|";
    }

    @Override
    public String visit(Root root) {
        return root.getRoot().accept(this) + " √ " + root.getBase().accept(this);
    }

    @Override
    public String visit(Parentesis parentesis) {
        return "(" + parentesis.getA().accept(this) + ")";
    }

    @Override
    public String visit(Number number) {
        return (number.getVal() % 1 == 0) ? String.valueOf((int) number.getVal()) : String.valueOf(number.getVal());
    }

    @Override
    public String visit(Variable variable) {
        return variable.getName();
    }
}
