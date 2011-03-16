package br.com.carlosemanuel.buzzreader.parsers.handlers;

import org.json.JSONObject;

import br.com.carlosemanuel.buzzreader.exception.BuzzParsingException;
import br.com.carlosemanuel.buzzreader.model.BuzzAclEntry;

/**
 * Handler for element: <b>Visibility</b>
 * 
 * @author roberto.estivill
 */
public class VisibilityHandler extends BaseHandler {

	// TODO
	public static BuzzAclEntry handle(JSONObject jsonObject)
			throws BuzzParsingException {

		BuzzAclEntry aclEntry = new BuzzAclEntry();

		return aclEntry;
	}
}
