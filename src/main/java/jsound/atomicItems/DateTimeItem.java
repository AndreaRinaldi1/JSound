package jsound.atomicItems;

import org.joda.time.DateTime;
import jsound.item.AtomicItem;

public class DateTimeItem extends AtomicItem {
    DateTime _value;

    public DateTimeItem(DateTime value) {
        this._value = value;
    }

    @Override
    public DateTime getDateTime() {
        return _value;
    }

    @Override
    public String getStringValue() {
        return this._value.toString();
    }

    @Override
    public boolean isDateTimeItem() {
        return true;
    }
}
