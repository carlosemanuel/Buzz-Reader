package br.com.carlosemanuel.buzzreader.parsers.handlers;

import org.json.JSONObject;

import br.com.carlosemanuel.buzzreader.exception.BuzzParsingException;
import br.com.carlosemanuel.buzzreader.model.BuzzAuthor;

/**
 * Handler for element: <b>Author</b>
 * 
 * @author roberto.estivill
 */
public class AuthorHandler extends BaseHandler {

	public static BuzzAuthor handle(JSONObject author)
			throws BuzzParsingException {

		BuzzAuthor buzzAuthor = new BuzzAuthor();
		
		try {
			
			buzzAuthor.setId(author.getString("id"));
			buzzAuthor.setName(author.getString("name"));
			buzzAuthor.setProfileUrl(author.getString("profileUrl"));
			buzzAuthor.setThumbnailUrl(author.getString("thumbnailUrl"));
			
			
		} catch (Exception e) {
			throw new BuzzParsingException(e);
		}
		
		return buzzAuthor;
		
	}
}
