package com.prabhav.play;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WordAdapter extends ArrayAdapter<Word> implements Filterable
{
    private ArrayList<Word> friendList;
    private List<Word> searchList;
    public WordAdapter(Activity context, ArrayList<Word> words) {
        super(context, 0, words);
        this.friendList = words;
        this.searchList = new ArrayList<>();
        this.searchList.addAll(friendList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_view, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView gameName = (TextView) listItemView.findViewById(R.id.game_name);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        gameName.setText(currentWord.getGameName());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.game_image);
            imageView.setImageResource(currentWord.getGameImage());

        return listItemView;
    }

    // Filter method
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        friendList.clear();
        if (charText.length() == 0) {
            friendList.addAll(searchList);
        } else {
            for (Word s : searchList) {
                if (s.getGameName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    friendList.add(s);
                }
            }
        }
        notifyDataSetChanged();
    }
}
