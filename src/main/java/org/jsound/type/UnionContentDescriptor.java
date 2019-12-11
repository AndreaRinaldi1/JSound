package org.jsound.type;

import java.util.ArrayList;
import java.util.List;

public class UnionContentDescriptor {
    private List<TypeOrReference> types;

    public UnionContentDescriptor() {
        types = new ArrayList<>();
    }

    public List<TypeOrReference> getTypes() {
        return types;
    }
}
