package reivosar.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reivosar.domain.model.message.Message;
import reivosar.domain.model.message.MessageBody;
import reivosar.domain.model.message.MessageId;
import reivosar.domain.model.message.MessageReposiory;

@Service
public class CreateMessageUseCase
{
	private final MessageReposiory messageReposiory;

	@Autowired
	public CreateMessageUseCase(MessageReposiory messageReposiory) {
		this.messageReposiory = messageReposiory;
	}

	public Response execute (Request request) {
		final MessageId messageId = this.messageReposiory.generateId();
		final Message message = new Message (
			messageId, MessageBody.of(request.message)
		)
		.createMessage ();
		this.messageReposiory.save (message);
		return new Response (messageId);
	}

	public static class Request {
		private final String message;

		public Request(final String message) {
			this.message = message;
		}
	}

	public static class Response {
		private MessageId messageId;

		private Response(final MessageId messageId) {
			this.messageId = messageId;
		}

		public MessageId getMessageId() {
			return messageId;
		}
	}
}
