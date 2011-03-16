package br.com.carlosemanuel.buzzreader.parsers.handlers;

import org.json.JSONObject;

import br.com.carlosemanuel.buzzreader.exception.BuzzParsingException;
import br.com.carlosemanuel.buzzreader.model.BuzzReply;

/**
 * Handler for xml element: <b>Link</b>
 * 
 * @author roberto.estivill
 */
public class ReplyHandler extends BaseHandler {

	// TODO
	public static BuzzReply handle(JSONObject jsonObject)
			throws BuzzParsingException {

		BuzzReply buzzReply = new BuzzReply();

		return buzzReply;
	}
}
