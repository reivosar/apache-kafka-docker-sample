package reivosar.domain.model.message;

public class MessageBodyChanged extends MessageEventTemplate
{
	private final MessageId messageId;
	private final MessageBody messageBody;

	public MessageBodyChanged(final MessageId messageId, final MessageBody messageBody) {
		this.messageId   = messageId;
		this.messageBody = messageBody;
	}

	public String getMessageId() {
		return messageId.value;
	}

	public Object getMessageBody() {
		return messageBody.messagePayload.value;
	}
}
