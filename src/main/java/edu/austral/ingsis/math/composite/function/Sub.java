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
public class Sub implements Function {

    private final Function sub1;
    private final Function sub2;

    // a - b
    public Sub(Function sub1, Function sub2) {
        this.sub1 = sub1;
        this.sub2 = sub2;
    }

    @Override
    public double evaluate(Map<String, Double> map) {
        return sub1.evaluate(map) - sub2.evaluate(map);
    }

    @Override
    public String toString() {
        return sub1.toString() + " - " + sub2.toString();
    }

    @Override
    public List<String> getChildren(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        copy.addAll(sub1.getChildren(copy));
        copy.addAll(sub2.getChildren(copy));
        return copy;
    }

    @Override
    public List<String> listVars(List<String> list) {
        return Stream.concat(sub1.listVars(list).stream(), sub2.listVars(list).stream()).collect(Collectors.toList());
    }

}
