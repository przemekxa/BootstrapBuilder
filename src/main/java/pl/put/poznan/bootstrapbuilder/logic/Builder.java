package pl.put.poznan.bootstrapbuilder.logic;

import pl.put.poznan.bootstrapbuilder.rest.Request;

/**
 * This is Builder class in builder pattern.
 */
public interface Builder {

    public abstract void build(Request request);

}
