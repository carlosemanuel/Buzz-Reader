package br.com.carlosemanuel.buzzreader.adapters;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.carlosemanuel.buzzreader.R;
import br.com.carlosemanuel.buzzreader.model.BuzzPhoto;
import br.com.carlosemanuel.buzzreader.model.BuzzUserProfile;
import br.com.carlosemanuel.buzzreader.util.BuzzUtils;


public class AuthorAdapter extends ArrayAdapter<BuzzUserProfile> {

	private List<BuzzUserProfile> buzzs;

	public AuthorAdapter(Context context, int textViewResourceId,
			List<BuzzUserProfile> buzzs) {
		super(context, textViewResourceId);

		this.buzzs = buzzs;
	}

	@Override
	public int getCount() {
		return buzzs.size();
	}

	@Override
	public BuzzUserProfile getItem(int position) {
		return buzzs.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		BuzzUserProfile buzz = buzzs.get(position);

		LayoutInflater inflater = (LayoutInflater) getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View view = inflater.inflate(R.layout.buzzlist, null);

		TextView title = (TextView) view.findViewById(R.id.BuzzTitle);
		title.setText(buzz.getName());

		TextView content = (TextView) view.findViewById(R.id.Content);
		content.setText("");

		ImageView photo = (ImageView) view.findViewById(R.id.AuthorPhoto);
		List<BuzzPhoto> photos = buzz.getPhotos();
		if (photos.size() > 0) {
			Drawable drawable = BuzzUtils.LoadImageFromWebOperations(photos
					.get(photos.size() - 1).getValue());
			photo.setImageDrawable(drawable);
		}

		return view;
	}
}
