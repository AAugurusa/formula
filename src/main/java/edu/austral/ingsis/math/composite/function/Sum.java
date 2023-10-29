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
public class Sum implements Function {

    private final Function sum1;
    private final Function sum2;

    public Sum(Function sum1, Function sum2) {
        this.sum1 = sum1;
        this.sum2 = sum2;
    }

    @Override
    public double evaluate(Map<String, Double> map) {
        return sum1.evaluate(map) + sum2.evaluate(map);
    }

    @Override
    public String toString() {
        return sum1.toString() + " + " + sum2.toString();
    }

    @Override
    public List<String> listVars(List<String> list) {
        return Stream.concat(sum1.listVars(list).stream(), sum2.listVars(list).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> getChildren(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        copy.addAll(sum1.getChildren(copy));
        copy.addAll(sum2.getChildren(copy));
        return copy;
    }

}
