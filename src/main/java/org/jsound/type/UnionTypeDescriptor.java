package org.jsound.type;

import jsound.exceptions.InvalidSchemaException;
import org.jsound.facets.FacetTypes;
import org.jsound.facets.UnionFacets;
import org.jsound.item.Item;
import org.tyson.TYSONValue;
import org.tyson.TysonItem;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.jsound.facets.FacetTypes.CONTENT;

public class UnionTypeDescriptor extends TypeDescriptor {

    public static final Set<FacetTypes> _allowedFacets = new HashSet<>(Collections.singletonList(CONTENT));
    private final UnionFacets facets;
    private boolean contentIsValid = false;

    public UnionTypeDescriptor(String name, UnionFacets facets) {
        super(ItemTypes.VALUE, name);
        this.baseType = null;
        this.facets = facets;
        this.subtypeIsValid = true;
        this.hasResolvedAllFacets = true;
    }

    public UnionTypeDescriptor(String name, TypeOrReference baseType, UnionFacets facets) {
        super(ItemTypes.VALUE, name, baseType);
        this.facets = facets;
    }

    @Override
    public Set<FacetTypes> getAllowedFacets() {
        return _allowedFacets;
    }

    @Override
    public boolean isUnionType() {
        return true;
    }

    @Override
    public boolean validate(Item item, boolean isEnumerationItem) {
        for (FacetTypes facetType : this.getFacets().getDefinedFacets()) {
            switch (facetType) {
                case CONTENT:
                    // checkContentCorrectness();
                    if (!validateContentFacet(item))
                        return false;
                    break;
                case ENUMERATION:
                    if (!validateEnumeration(item, isEnumerationItem))
                        return false;
                    break;
                default:
                    break;
            }
        }
        return recursivelyValidate(item);
    }

    private boolean validateContentFacet(Item item) {
        for (TypeOrReference typeOrReference : this.getFacets().getUnionContent().getTypes()) {
            if (typeOrReference.getTypeDescriptor().validate(item, false))
                return true;
        }
        return false;
    }

    @Override
    public TysonItem annotate(Item item) {
        for (TypeOrReference typeOrReference : this.getFacets().getUnionContent().getTypes()) {
            if (typeOrReference.getTypeDescriptor().validate(item, false))
                return new TYSONValue(typeOrReference.getTypeDescriptor().getName(), item);
        }
        throw new InvalidSchemaException(
                item.getStringValue() + " cannot is not valid against any type of union " + this.getName()
        );
    }

    @Override
    public UnionFacets getFacets() {
        return facets;
    }

    @Override
    protected boolean hasCompatibleType(TypeDescriptor typeDescriptor) {
        return typeDescriptor.isUnionType();
    }
}
