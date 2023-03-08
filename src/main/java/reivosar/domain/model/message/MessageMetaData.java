package reivosar.domain.model.message;

import reivosar.common.domain.model.ValueObject;

import java.util.Collections;
import java.util.Map;

public class MessageMetaData extends ValueObject<MessageMetaData>
{
	final Map<String, Object> values;

	public MessageMetaData() {
		this(Collections.emptyMap());
	}

    public MessageMetaData(final Map<String, Object> values) {
        this.values = values;
    }

	public MessageMetaData set(final String key, final Object value) {
		this.values.put(key, value);
		return this;
	}
}
