package edu.austral.ingsis.math.composite.function;

import edu.austral.ingsis.math.composite.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Agustin Augurusa
 */
public class Abs implements Function {
    private final Function fun;

    public Abs(Function fun) {
        this.fun = fun;
    }
    @Override
    public double evaluate(Map<String, Double> map) {
        return Math.abs(fun.evaluate(map));
    }

    @Override
    public String toString() {
        return "|" + fun.toString() + "|";
    }

    @Override
    public List<String> listVars(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        copy.addAll(fun.getChildren(copy));
        return copy;
    }

    @Override
    public List<String> getChildren(List<String> list) {
        return fun.listVars(list);
    }
}
