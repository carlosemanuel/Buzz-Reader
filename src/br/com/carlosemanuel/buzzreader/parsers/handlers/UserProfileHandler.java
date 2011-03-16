package br.com.carlosemanuel.buzzreader.parsers.handlers;

import org.json.JSONObject;

import br.com.carlosemanuel.buzzreader.exception.BuzzParsingException;
import br.com.carlosemanuel.buzzreader.model.BuzzUserProfile;

/**
 * Handler for element: <b>User Profile</b>
 * 
 * @author roberto.estivill
 */
public class UserProfileHandler extends BaseHandler {

	// TODO
	public static BuzzUserProfile handle(JSONObject jsonObject)
			throws BuzzParsingException {

		BuzzUserProfile buzzUserProfile = new BuzzUserProfile();

		return buzzUserProfile;
	}

}
