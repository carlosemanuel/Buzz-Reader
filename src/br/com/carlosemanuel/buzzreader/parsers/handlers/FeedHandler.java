package br.com.carlosemanuel.buzzreader.parsers.handlers;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.carlosemanuel.buzzreader.exception.BuzzParsingException;
import br.com.carlosemanuel.buzzreader.model.BuzzFeed;
import br.com.carlosemanuel.buzzreader.util.DateUtils;

/**
 * Handler for xml element: <b>Feed</b>
 * 
 * @author roberto.estivill
 */
public class FeedHandler extends BaseHandler {

	public static BuzzFeed handle(JSONObject data) throws BuzzParsingException {
		BuzzFeed feed = new BuzzFeed();

		try {
			feed.setId(data.getString("id"));
			feed.setTitle(data.getString("title"));
			feed.setTitleType(data.getString("kind"));
			feed.setUpdated(DateUtils.parseDate(data.getString("updated")));
			JSONArray items = data.getJSONArray("items");

			for (int index = 0; index < items.length(); index++) {
				JSONObject item = items.getJSONObject(index);
				feed.getEntries().add(FeedEntryHandler.handle(item));
			}

		} catch (Exception e) {
			throw new BuzzParsingException(e);
		}

		return feed;
	}
}
