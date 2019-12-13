package org.jsound.atomicTypes;

import org.jsound.facets.AtomicFacets;
import org.jsound.facets.FacetTypes;
import org.jsound.type.AtomicTypeDescriptor;
import org.jsound.type.ItemTypes;

import java.util.Collections;
import java.util.Set;

public class BooleanType extends AtomicTypeDescriptor {

    public BooleanType(String name, AtomicFacets facets) {
        super(ItemTypes.BOOLEAN, name, facets);
    }

    @Override
    public Set<FacetTypes> getAllowedFacets() {
        return Collections.emptySet();
    }

    @Override
    public boolean isBooleanType() {
        return true;
    }
}
