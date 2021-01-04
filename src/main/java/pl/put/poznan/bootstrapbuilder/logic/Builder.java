package pl.put.poznan.bootstrapbuilder.logic;

import pl.put.poznan.bootstrapbuilder.rest.HeaderType;
import pl.put.poznan.bootstrapbuilder.rest.MetaTags;
import pl.put.poznan.bootstrapbuilder.rest.MetaType;

public interface Builder {
    public String build();
    public Builder setHeader(HeaderType type);
    public Builder setFooter(boolean footer);
    public Builder addMeta(MetaType type, MetaTags tags);
}
