package edu.austral.ingsis.math.visitor;

/**
 * @author Agustin Augurusa
 */
public interface Visitable {

    <T> T accept(Visitor<T> visitor);
}
