package reivosar.domain.model.message;

import reivosar.common.domain.model.ValueObject;

public class MessageBody extends ValueObject<MessageBody> {

	final MessageBodyType messageBodyType;
	final MessagePayload messagePayload;

	private MessageBody(
		final MessageBodyType messageBodyType,
		final MessagePayload messagePayload)
	{
		this.messageBodyType = messageBodyType;
		this.messagePayload  = messagePayload;
	}

	public static MessageBody of(final MessageBodyType type, final Object value) {
		return new MessageBody(type, new MessagePayload(value));
	}

	public static MessageBody of(String text) {
		return new MessageBody(MessageBodyType.TEXT, new MessagePayload(text));
	}

	public static MessageBody of(Class<?> clazz) {
		return new MessageBody(MessageBodyType.CLASS, new MessagePayload(clazz));
	}
}
