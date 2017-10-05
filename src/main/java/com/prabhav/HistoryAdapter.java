package com.prabhav.play;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HistoryAdapter extends ArrayAdapter<AddScores> {
    private Activity context;
    List<AddScores> addScores;

    public HistoryAdapter(Activity context, List<AddScores> a) {
        super(context, R.layout.history_list_item, a);
        this.context = context;
        this.addScores = a;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.history_list_item, null, true);

        ImageView imageView = (ImageView) listViewItem.findViewById(R.id.game_image);
        TextView textViewTeams = (TextView) listViewItem.findViewById(R.id.team_vs_team);
        TextView dateListView = (TextView) listViewItem.findViewById(R.id.date_listView);

        AddScores add = addScores.get(position);
        imageView.setImageResource(add.getImage());
        String s = add.getScoresTeamAName()+" vs "+add.getScoresTeamBName();
        textViewTeams.setText(s);
        dateListView.setText(add.getScoresDate());

        return listViewItem;
    }
}
