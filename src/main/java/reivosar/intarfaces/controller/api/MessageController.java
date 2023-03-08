package reivosar.intarfaces.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import reivosar.application.usecase.CreateMessageUseCase;
import reivosar.application.usecase.MessageUseCaseStore;
import reivosar.intarfaces.model.api.MessageRequest;

@RestController
@RequestMapping("message")
public class MessageController
{
	private final MessageUseCaseStore messageUseCaseStore;

	@Autowired
    public MessageController(MessageUseCaseStore messageUseCaseStore) {
		this.messageUseCaseStore = messageUseCaseStore;
	}

	@ResponseBody
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public void postMessage(@RequestBody MessageRequest message) {
		final CreateMessageUseCase useCase = messageUseCaseStore.getCreateMessageUseCase();
		final CreateMessageUseCase.Request request = new CreateMessageUseCase.Request(message.getMessage());
		useCase.execute (request);
	}
}
