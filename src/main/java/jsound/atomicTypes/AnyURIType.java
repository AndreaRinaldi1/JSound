package jsound.atomicTypes;

import org.api.TypeDescriptor;
import jsound.typedescriptors.atomic.AtomicTypeDescriptor;
import jsound.atomicItems.AnyURIItem;
import jsound.facets.AtomicFacets;
import jsound.facets.FacetTypes;
import org.api.Item;
import jsound.types.ItemTypes;

import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static jsound.facets.FacetTypes.LENGTH;
import static jsound.facets.FacetTypes.MAX_LENGTH;
import static jsound.facets.FacetTypes.MIN_LENGTH;

public class AnyURIType extends AtomicTypeDescriptor {

    public static final Set<FacetTypes> _allowedFacets = new HashSet<>(Arrays.asList(LENGTH, MIN_LENGTH, MAX_LENGTH));

    public AnyURIType(String name, AtomicFacets facets) {
        super(ItemTypes.ANYURI, name, facets);
    }

    public AnyURIType(AtomicTypeDescriptor typeDescriptor) {
        super(ItemTypes.ANYURI, typeDescriptor.getName(), typeDescriptor.baseType, typeDescriptor.getFacets());
    }

    @Override
    public boolean validate(Item item, boolean isEnumValue) {
        URI uri;
        try {
            uri = URI.create(item.getStringValue());
        } catch (IllegalArgumentException e) {
            return false;
        }
        if (this.getFacets() == null)
            return true;
        item = new AnyURIItem(uri);
        return validateLengthFacets(item, isEnumValue);
    }

    @Override
    protected boolean validateItemAgainstEnumeration(Item item) throws IllegalArgumentException {
        URI uri = item.getAnyURIValue();
        for (Item enumItem : this.getFacets().getEnumeration()) {
            if (uri.equals(URI.create(enumItem.getStringValue())))
                return true;
        }
        return false;
    }

    @Override
    public void checkAgainstTypeDescriptor(TypeDescriptor typeDescriptor) {
        areLengthFacetsMoreRestrictive(typeDescriptor);
    }

    @Override
    public Set<FacetTypes> getAllowedFacets() {
        return _allowedFacets;
    }

    @Override
    public boolean isAnyURIType() {
        return true;
    }

    @Override
    protected boolean hasCompatibleType(TypeDescriptor typeDescriptor) {
        return typeDescriptor.isAnyURIType();
    }
}
