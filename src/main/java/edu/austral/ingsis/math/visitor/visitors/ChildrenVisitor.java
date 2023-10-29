package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.Number;
import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.visitor.function.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Agustin Augurusa
 */
public class ChildrenVisitor implements Visitor<List<String>> {
    @Override
    public List<String> visit(Sum sum) {
        return merge(sum.getSum1().accept(this), sum.getSum2().accept(this));
    }

    @Override
    public List<String> visit(Sub sub) {
        return merge(sub.getSub1().accept(this), sub.getSub2().accept(this));
    }

    @Override
    public List<String> visit(Mul mul) {
        return merge(mul.getA().accept(this), mul.getB().accept(this));
    }

    @Override
    public List<String> visit(Div div) {
        return merge(div.getDividend().accept(this), div.getDivisor().accept(this));
    }

    @Override
    public List<String> visit(Pow pow) {
        return merge(pow.getBase().accept(this), pow.getBase().accept(this));
    }

    @Override
    public List<String> visit(Abs abs) {
        return abs.getAbs().accept(this);
    }

    @Override
    public List<String> visit(Root root) {
        return root.getBase().accept(this);
    }

    @Override
    public List<String> visit(Parentesis parentesis) {
        return parentesis.getA().accept(this);
    }

    @Override
    public List<String> visit(Number number) {
        return new ArrayList<>(Collections.singleton(Double.toString(number.getVal())));
    }

    @Override
    public List<String> visit(Variable variable) {
        return new ArrayList<>(Collections.singleton(variable.getName()));
    }

    private List<String> merge(List<String> a, List<String> b) {
        return Stream.concat(a.stream(), b.stream()).collect(Collectors.toList());
    }
}
