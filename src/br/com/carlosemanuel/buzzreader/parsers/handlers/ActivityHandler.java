package br.com.carlosemanuel.buzzreader.parsers.handlers;

import org.json.JSONObject;

import br.com.carlosemanuel.buzzreader.exception.BuzzParsingException;
import br.com.carlosemanuel.buzzreader.model.BuzzActivity;

/**
 * Handler for element: <b>Activity</b>
 * 
 * @author roberto.estivill
 */
public class ActivityHandler extends BaseHandler {

	public static BuzzActivity handle(JSONObject activity)
			throws BuzzParsingException {

		BuzzActivity buzzActivity = new BuzzActivity();

		try {

			// TODO
		} catch (Exception e) {
			throw new BuzzParsingException(e);
		}

		return buzzActivity;

	}
}
