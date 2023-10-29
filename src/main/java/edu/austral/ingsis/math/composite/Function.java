package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

/**
 * @author Agustin Augurusa
 */
public interface Function {

    double evaluate(Map<String, Double> variables);

    default double evaluate(){
        return evaluate(Map.of());
    }

    List<String> listVars(List<String> list);

    List<String> getChildren(List<String> list);

}
