package br.com.carlosemanuel.buzzreader.adapters;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.carlosemanuel.buzzreader.R;
import br.com.carlosemanuel.buzzreader.model.BuzzFeedEntry;
import br.com.carlosemanuel.buzzreader.util.BuzzUtils;


public class BuzzAdapters extends ArrayAdapter<BuzzFeedEntry> {

	private List<BuzzFeedEntry> buzzs;

	public BuzzAdapters(Context context, int textViewResourceId,
			List<BuzzFeedEntry> buzzs) {
		super(context, textViewResourceId);

		this.buzzs = buzzs;
	}

	@Override
	public int getCount() {
		return buzzs.size();
	}

	@Override
	public BuzzFeedEntry getItem(int position) {
		return buzzs.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		BuzzFeedEntry buzz = buzzs.get(position);

		LayoutInflater inflater = (LayoutInflater) getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View view = inflater.inflate(R.layout.buzzlist, null);

		String buzzTitle = buzz.getAuthor().getName() + " - "
				+ buzz.getSourceActivityTitle();

		TextView title = (TextView) view.findViewById(R.id.BuzzTitle);
		title.setText(buzzTitle);

		TextView content = (TextView) view.findViewById(R.id.Content);
		content.setText(Html.fromHtml(buzz.getContent().getText()));

		ImageView photo = (ImageView) view.findViewById(R.id.AuthorPhoto);
		if (buzz.getAuthor() != null) {
			String thumbnail = buzz.getAuthor().getThumbnailUrl();

			if (thumbnail != null) {
				Drawable drawable = BuzzUtils
						.LoadImageFromWebOperations(thumbnail);
				photo.setImageDrawable(drawable);
			}
		} else {
			photo.setImageResource(R.drawable.blue_ghost);
		}

		return view;
	}
}
