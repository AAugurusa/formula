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
public class Root implements Function {

    private final Function base;
    private final Function root;

    public Root(Function base, Function root) {
        this.base = base;
        this.root = root;
    }

    @Override
    public double evaluate(Map<String, Double> map) {
        return Math.pow(base.evaluate(map), 1 / root.evaluate(map));
    }

    @Override
    public String toString() {
        return root.toString() + " √ " + base.toString();
    }

    @Override
    public List<String> getChildren(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        copy.addAll(base.getChildren(copy));
        copy.addAll(root.getChildren(copy));
        return copy;
    }

    @Override
    public List<String> listVars(List<String> list) {
        return Stream.concat(base.listVars(list).stream(), root.listVars(list).stream()).collect(Collectors.toList());
    }


}