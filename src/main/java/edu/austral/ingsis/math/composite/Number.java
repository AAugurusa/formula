package edu.austral.ingsis.math.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Agustin Augurusa
 */
public class Number implements Function{

    private final double value;

    public Number(double value) {
        this.value = value;
    }

    @Override
    public String toString () {return (value % 1 != 0) ? Double.toString(value) : Integer.toString((int) value);}

    @Override
    public double evaluate(Map<String, Double> variables) {
        return value;
    }

    @Override
    public List<String> listVars(List<String> list) {
        return List.of();
    }

    @Override
    public List<String> getChildren(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        copy.add(Double.toString(value));
        return copy;
    }
}
