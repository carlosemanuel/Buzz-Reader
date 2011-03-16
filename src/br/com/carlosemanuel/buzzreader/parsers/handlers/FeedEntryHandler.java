package br.com.carlosemanuel.buzzreader.parsers.handlers;

import org.json.JSONObject;

import br.com.carlosemanuel.buzzreader.exception.BuzzParsingException;
import br.com.carlosemanuel.buzzreader.model.BuzzFeedEntry;
import br.com.carlosemanuel.buzzreader.util.DateUtils;

/**
 * Handler for xml element: <b>Feed Entry</b>
 * 
 * @author roberto.estivill
 */
public class FeedEntryHandler extends BaseHandler {

	public static BuzzFeedEntry handle(JSONObject entry)
			throws BuzzParsingException {

		BuzzFeedEntry feedEntry = new BuzzFeedEntry();

		try {
			feedEntry.setTitle(entry.getString("title"));
			feedEntry.setId(entry.getString("id"));
			feedEntry.setPublished(DateUtils.parseDate(entry
					.getString("published")));
			feedEntry.setUpdated(DateUtils
					.parseDate(entry.getString("updated")));
			feedEntry.setSourceActivityTitle(entry.getJSONObject("source")
					.getString("title"));
			if (entry.has("crosspostSource")) {
				feedEntry.setCrosspostSourceId(entry
						.getString("crosspostSource"));
			}
			feedEntry.setActivityVerb(entry.getString("verbs"));

			// feedEntry.setActivity(activity) TODO
			feedEntry.setAuthor(AuthorHandler.handle(entry
					.getJSONObject("actor")));
			feedEntry.setContent(ContentHandler.handle(entry
					.getJSONObject("object")));
			// feedEntry.setLinks(links) TODO
			// feedEntry.setVisibility(visibility) TODO

		} catch (Exception e) {
			throw new BuzzParsingException(e);
		}

		return feedEntry;
	}
}
