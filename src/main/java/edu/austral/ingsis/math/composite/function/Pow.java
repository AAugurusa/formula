package edu.austral.ingsis.math.composite.function;

import edu.austral.ingsis.math.composite.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Agustin Augurusa
 */
public class Pow implements Function {

    private final Function base;
    private final Function pow;

    public Pow(Function base, Function pow) {
        this.base = base;
        this.pow = pow;
    }

    @Override
    public double evaluate(Map<String, Double> map) {
        return Math.pow(base.evaluate(map), pow.evaluate(map));
    }

    @Override
    public String toString() {
        return base.toString() + " ^ " + pow.toString();
    }

    @Override
    public List<String> getChildren(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        copy.addAll(base.getChildren(copy));
        copy.addAll(pow.getChildren(copy));
        return copy;
    }

    @Override
    public List<String> listVars(List<String> list) {
        return Stream.concat(base.listVars(list).stream(), pow.listVars(list).stream()).collect(Collectors.toList());
    }

}