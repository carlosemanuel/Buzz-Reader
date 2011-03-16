package br.com.carlosemanuel.buzzreader.parsers.handlers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import br.com.carlosemanuel.buzzreader.exception.BuzzParsingException;
import br.com.carlosemanuel.buzzreader.model.BuzzUserProfile;

/**
 * Handler for element: <b>User Profile</b>
 * 
 * @author roberto.estivill
 */
public class UserProfilesHandler extends BaseHandler {

	// TODO
	public static List<BuzzUserProfile> handle(JSONObject jsonObject)
			throws BuzzParsingException {

		List<BuzzUserProfile> buzzUserProfiles = new ArrayList<BuzzUserProfile>();

		return buzzUserProfiles;
	}

}
