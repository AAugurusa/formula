package edu.austral.ingsis.math.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Agustin Augurusa
 */
public class Variable implements Function{

    private final String variableName;

    public Variable (String variableName) {this.variableName = variableName;}

    @Override
    public double evaluate(Map<String, Double> map) {
        return map.get(variableName);
    }

    @Override
    public String toString() {
        return variableName;
    }

    @Override
    public List<String> listVars(List<String> list) {
        List<String> names = new ArrayList<>();
        names.add(variableName);
        return Stream.concat(list.stream(), names.stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> getChildren(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        copy.add(variableName);
        return copy;
    }
}
