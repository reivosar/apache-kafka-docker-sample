package reivosar.domain.model.message;

import reivosar.common.domain.model.ValueObject;

public class MessagePayload extends ValueObject<MessagePayload>
{
	final Object value;

	public MessagePayload(final Object value) {
		this.value = value;
	}
}
