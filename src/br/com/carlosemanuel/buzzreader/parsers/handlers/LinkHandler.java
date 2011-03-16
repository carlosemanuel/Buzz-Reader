package br.com.carlosemanuel.buzzreader.parsers.handlers;

import org.json.JSONObject;

import br.com.carlosemanuel.buzzreader.exception.BuzzParsingException;
import br.com.carlosemanuel.buzzreader.model.BuzzLink;

/**
 * Handler for xml element: <b>Link</b>
 * 
 * @author roberto.estivill
 */
public class LinkHandler extends BaseHandler {

	public static BuzzLink handle(JSONObject link) throws BuzzParsingException {
		BuzzLink buzzLink = new BuzzLink();
		// TODO
		return buzzLink;
	}
}
