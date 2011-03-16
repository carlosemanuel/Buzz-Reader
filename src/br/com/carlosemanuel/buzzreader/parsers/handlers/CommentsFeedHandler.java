package br.com.carlosemanuel.buzzreader.parsers.handlers;

import org.json.JSONObject;

import br.com.carlosemanuel.buzzreader.exception.BuzzParsingException;
import br.com.carlosemanuel.buzzreader.model.BuzzCommentsFeed;

/**
 * Handler for xml element: <b>Comments</b>
 * 
 * @author roberto.estivill
 */
public class CommentsFeedHandler extends BaseHandler {

	public static BuzzCommentsFeed handle(JSONObject jsonObject)
			throws BuzzParsingException {

		BuzzCommentsFeed buzzCommentsFeed = new BuzzCommentsFeed();

		return buzzCommentsFeed;
	}
}
