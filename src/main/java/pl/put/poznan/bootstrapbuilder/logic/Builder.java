package pl.put.poznan.bootstrapbuilder.logic;

import pl.put.poznan.bootstrapbuilder.rest.HeaderType;

public interface Builder {
    public String build();
    public Builder setHeader(HeaderType type);
    public Builder setFooter(boolean footer);
}
