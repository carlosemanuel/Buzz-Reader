package br.com.carlosemanuel.buzzreader.parsers.handlers;

import org.json.JSONObject;

import br.com.carlosemanuel.buzzreader.exception.BuzzParsingException;
import br.com.carlosemanuel.buzzreader.model.BuzzContent;

/**
 * Handler for element: <b>Content</b>
 * 
 * @author roberto.estivill
 */
public class ContentHandler extends BaseHandler {

	public static BuzzContent handle(JSONObject content)
			throws BuzzParsingException {

		BuzzContent buzzContent = new BuzzContent();
		try {
			buzzContent.setText(content.getString("content"));
			buzzContent.setType(content.getString("type"));
			// JSONObject links = content.getJSONObject("links");

			// for (int index = 0; index < links.length(); index++) {
			// JSONObject link = links.getJSONObject(index);
			// buzzContent.getLinks().add(LinkHandler.handle(link));
			// }

		} catch (Exception e) {
			throw new BuzzParsingException(e);
		}

		return buzzContent;

	}
}
