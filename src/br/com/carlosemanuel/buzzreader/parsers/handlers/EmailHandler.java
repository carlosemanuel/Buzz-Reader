package br.com.carlosemanuel.buzzreader.parsers.handlers;

import org.json.JSONObject;

import br.com.carlosemanuel.buzzreader.exception.BuzzParsingException;
import br.com.carlosemanuel.buzzreader.model.BuzzEmail;

/**
 * Handler for xml element: <b>Activity</b>
 * 
 * @author roberto.estivill
 */
public class EmailHandler extends BaseHandler {

	// TODO
	public static BuzzEmail handle(JSONObject jsonObject)
			throws BuzzParsingException {

		BuzzEmail buzzEmail = new BuzzEmail();

		return buzzEmail;
	}
}
