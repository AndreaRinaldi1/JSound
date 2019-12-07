package org.jsound.type;

import org.jsound.api.AtomicTypeDescriptor;
import org.jsound.api.ItemTypes;
import org.jsound.facets.FacetTypes;
import org.jsound.facets.Facets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.jsound.facets.FacetTypes.LENGTH;
import static org.jsound.facets.FacetTypes.MAX_LENGTH;
import static org.jsound.facets.FacetTypes.MIN_LENGTH;

public class AnyURIType extends AtomicTypeDescriptor {

    public static final Set<FacetTypes> _allowedFacets = new HashSet<>(Arrays.asList(LENGTH, MIN_LENGTH, MAX_LENGTH));

    public AnyURIType(String name, Facets facets) {
        super(ItemTypes.ANYURI, name, facets);
        this.baseType = this;
    }

    @Override
    public Set<FacetTypes> getAllowedFacets() {
        return _allowedFacets;
    }
}
