package reivosar.domain.model.message;

import reivosar.common.domain.model.event.EventPublishableEntity;

public class Message extends EventPublishableEntity<MessageId, Message>
{
	private MessageId messageId;
	private MessageMetaData messageMetaData;
	private MessageBody messageBody;

	public Message(
		final MessageId messageId,
		final MessageBody messageBody)
	{
		this(messageId, new MessageMetaData(), messageBody);
	}

	public Message(
	    final MessageId messageId,
	    final MessageMetaData messageMetaData,
	    final MessageBody messageBody)
	{
		setMessageId       (messageId);
		setMessageMetaData (messageMetaData);
		setMessageBody     (messageBody);
	}

	public Message createMessage() {
		apply(
			new MessageCreated (
				this.messageId,
				this.messageMetaData,
				this.messageBody
			)
		);
		return this;
	}

	public Message changeMessageBody(final MessageBody messageBody) {
	    final Message message = new Message(messageId, messageBody);
		apply(new MessageBodyChanged(messageId, messageBody));
		return message;
	}
    
    @Override
    public MessageId identity() {
        return messageId;
    }

	private void setMessageId(final MessageId messageId) {
		this.messageId = messageId;
	}

	private void setMessageMetaData(final MessageMetaData messageMetaData) {
		this.messageMetaData = messageMetaData;
	}

	private void setMessageBody(final MessageBody messageBody) {
		this.messageBody = messageBody;
	}

}
