package br.com.carlosemanuel.buzzreader.parsers.handlers;

import org.json.JSONObject;

import br.com.carlosemanuel.buzzreader.exception.BuzzParsingException;
import br.com.carlosemanuel.buzzreader.model.BuzzPhoto;

/**
 * Handler for xml element: <b>Photo</b>
 * 
 * @author roberto.estivill
 */
public class PhotoHandler extends BaseHandler {

	public static BuzzPhoto handle(JSONObject jsonObject)
			throws BuzzParsingException {

		BuzzPhoto buzzPhoto = new BuzzPhoto();

		return buzzPhoto;
	}
}
