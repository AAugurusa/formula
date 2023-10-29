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
public class Div implements Function {

    private final Function dividend;
    private final Function divisor;

    public Div(Function dividend, Function divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    @Override
    public double evaluate(Map<String, Double> map) {
        return dividend.evaluate(map) / divisor.evaluate(map);
    }

    public String toString() {
        return dividend.toString() + " / " + divisor.toString();
    }

    @Override
    public List<String> listVars(List<String> list) {
        return Stream.concat(dividend.listVars(list).stream(), divisor.listVars(list).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> getChildren(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        copy.addAll(dividend.getChildren(copy));
        copy.addAll(divisor.getChildren(copy));
        return copy;    }
}
