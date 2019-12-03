package org.jsound.item;

import org.jsound.api.AtomicItem;
import org.jsound.api.ItemType;

public class NullItem extends AtomicItem {

    NullItem() {
    }

    public boolean isNull() {
        return true;
    }

    @Override
    public boolean isValidAgainst(ItemType itemType) {
        return itemType.isNullType() || super.isValidAgainst(itemType);
    }

    @Override protected Object getValue() {
        return null;
    }
}
