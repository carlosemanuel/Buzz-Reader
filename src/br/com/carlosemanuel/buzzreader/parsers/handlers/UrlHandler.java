package br.com.carlosemanuel.buzzreader.parsers.handlers;

import org.json.JSONObject;

import br.com.carlosemanuel.buzzreader.exception.BuzzParsingException;
import br.com.carlosemanuel.buzzreader.model.BuzzUrl;

/**
 * Handler for element: <b>Url</b>
 * 
 * @author roberto.estivill
 */
public class UrlHandler extends BaseHandler {

	// TODO
	public static BuzzUrl handle(JSONObject jsonObject)
			throws BuzzParsingException {

		BuzzUrl buzzUrl = new BuzzUrl();

		return buzzUrl;
	}

}
