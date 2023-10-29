package edu.austral.ingsis.math.composite.function;

import edu.austral.ingsis.math.composite.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Agustin Augurusa
 */
public class Parentesis implements Function {

    private final Function par;

    public Parentesis(Function par) {
        this.par = par;
    }

    @Override
    public String toString() {
        return "(" + par.toString() + ")";
    }

    @Override
    public double evaluate(Map<String, Double> map) {
        return par.evaluate(map);
    }

    @Override
    public List<String> getChildren(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        copy.addAll(par.getChildren(copy));
        return copy;
    }

    @Override
    public List<String> listVars(List<String> list) {
        return par.listVars(list);

    }
}