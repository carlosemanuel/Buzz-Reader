package br.com.carlosemanuel.buzzreader.parsers.handlers;

import org.json.JSONObject;

import br.com.carlosemanuel.buzzreader.exception.BuzzParsingException;
import br.com.carlosemanuel.buzzreader.model.BuzzComment;

/**
 * Handler for xml element: <b>Feed Entry</b>
 * 
 * @author roberto.estivill
 */
public class CommentHandler extends BaseHandler {

	// TODO
	public static BuzzComment handle(JSONObject comment)
			throws BuzzParsingException {
		BuzzComment buzzComment = new BuzzComment();

		return buzzComment;
	}
}
