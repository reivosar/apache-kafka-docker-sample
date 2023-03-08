package reivosar.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageUseCaseStore
{
	private final CreateMessageUseCase createMessageUseCase;
	private final GetMessageUseCase getMessageUseCase;

	@Autowired
	public MessageUseCaseStore(
	    final CreateMessageUseCase createMessageUseCase,
	    final GetMessageUseCase getMessageUseCase)
	{
		this.createMessageUseCase = createMessageUseCase;
		this.getMessageUseCase    = getMessageUseCase;
	}

	public CreateMessageUseCase getCreateMessageUseCase() {
		return createMessageUseCase;
	}

	public GetMessageUseCase getGetMessageUseCase() {
		return getMessageUseCase;
	}
}
