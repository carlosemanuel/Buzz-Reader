package br.com.carlosemanuel.buzzreader.parsers.handlers;

import org.json.JSONObject;

import br.com.carlosemanuel.buzzreader.exception.BuzzParsingException;
import br.com.carlosemanuel.buzzreader.model.BuzzAttachment;

public class AttachmentHandler extends BaseHandler {

	// TODO
	public static BuzzAttachment handle(JSONObject attachment)
			throws BuzzParsingException {

		BuzzAttachment buzzAttachment = new BuzzAttachment();

		return buzzAttachment;
	}
}
