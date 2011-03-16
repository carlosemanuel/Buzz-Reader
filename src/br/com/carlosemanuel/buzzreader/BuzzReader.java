package br.com.carlosemanuel.buzzreader;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import br.com.carlosemanuel.buzzreader.adapters.AuthorAdapter;
import br.com.carlosemanuel.buzzreader.adapters.BuzzAdapters;
import br.com.carlosemanuel.buzzreader.exception.BuzzAuthenticationException;
import br.com.carlosemanuel.buzzreader.exception.BuzzIOException;
import br.com.carlosemanuel.buzzreader.exception.BuzzParsingException;
import br.com.carlosemanuel.buzzreader.model.BuzzFeed;
import br.com.carlosemanuel.buzzreader.model.BuzzFeedEntry;
import br.com.carlosemanuel.buzzreader.model.BuzzUserProfile;

public class BuzzReader extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
		System.setProperty("org.xml.sax.driver", "org.xmlpull.v1.sax2.Driver");

        super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);

		Buzz buzz = new Buzz();

		try {
			buzz.setTokenWithSecret("594265767867.apps.googleusercontent.com",
					"VJn78ZkNvfQRIk3GJcLyX69/",
					"1/vjQy0RVcZgQKDQhc5qIBtsVwnZDBS5XreR_0eNS9-2Y",
					"V0I10DHven99pI/66Tu838vH");
			listBuzz(buzz);
			// listFollowing(buzz);

		} catch (BuzzAuthenticationException e) {
			Log.e("BuzzReader", e.getMessage(), e);
		} catch (BuzzIOException e) {
			Log.e("BuzzReader", e.getMessage(), e);
		} catch (BuzzParsingException e) {
			Log.e("BuzzReader", e.getMessage(), e);
		}

    }

	private void listBuzz(Buzz buzz) throws BuzzIOException,
			BuzzAuthenticationException, BuzzParsingException {

		BuzzFeed feed = buzz.getPosts("cariocae", BuzzFeed.Type.CONSUMPTION);
		if (!feed.getEntries().isEmpty()) {
			List<BuzzFeedEntry> entries = feed.getEntries();
			Log.d("BuzzReader", "entries size: " + entries.size() + "");
			// for (BuzzFeedEntry entry : entries) {
			// Log.d("BuzzReader", "links size: " + entry.getLinks().size()
			// + "");
			// Log.d("BuzzReader", "Activity: " + entry.getActivity());
			// Log.d("BuzzReader", "Author: " + entry.getAuthor());
			// Log.d("BuzzReader", "Content: " + entry.getContent());
			// }
			this.setListAdapter(new BuzzAdapters(this, R.layout.buzzlist,
					entries));
		}
		Toast.makeText(this, "Entries " + feed.getEntries().size(),
				Toast.LENGTH_SHORT).show();
	}

	private void listFollowing(Buzz buzz) throws BuzzIOException,
			BuzzAuthenticationException, BuzzParsingException {

		List<BuzzUserProfile> following = buzz.following("cariocae");
		String[] profilesName = new String[following.size()];
		int index = 0;
		for (BuzzUserProfile profile : following) {
			profilesName[index++] = profile.getName();
		}

		this.setListAdapter(new AuthorAdapter(this, R.layout.buzzlist,
				following));
	}
}