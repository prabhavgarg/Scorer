package com.prabhav.play;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    ListView listView;
    TextView record;
    HistoryAdapter adapter;
    DatabaseReference database;
    //a list to store all the artist from firebase database
    List<AddScores> addsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        listView = (ListView)findViewById(R.id.listViewHistory);
        addsc = new ArrayList<>();
        record = (TextView)findViewById(R.id.recordAvailable);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait...");
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        String stringExtra = getIntent().getStringExtra("GAME_ID");
        database = FirebaseDatabase.getInstance().getReference(MainActivity.USER_ID).child(stringExtra);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                addsc.clear();
                progressDialog.cancel();
                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    AddScores add = postSnapshot.getValue(AddScores.class);
                    //adding artist to the list
                    addsc.add(add);
                }
                //creating adapter
                adapter = new HistoryAdapter(HistoryActivity.this, addsc);
                //attaching adapter to the listview
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        displayAlertDialog(position);
                    }
                });
                listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        removeFromList(position);
                        return true;
                    }
                });
                if(addsc.size()==0)
                {
                    record.setVisibility(View.VISIBLE);
                }
                else record.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void removeFromList(final int position) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Confirm Delete...");
        alertDialog.setMessage("Are you sure you want to delete?");
        alertDialog.setIcon(R.drawable.delete_icon);
        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                database.getDatabase().getReference().child(MainActivity.USER_ID).child(addsc.get(position).getScoresGameName()).child(addsc.get(position).getScoresID()).removeValue();
                addsc.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    private void displayAlertDialog(int position) {
        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.history_item_details, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this, AlertDialog.THEME_HOLO_DARK);
        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);
        ImageView historyItemImage = (ImageView)promptsView.findViewById(R.id.history_item_image);
        TextView historyItemDate = (TextView) promptsView.findViewById(R.id.history_item_date);
        TextView historyItemTeamAScore = (TextView) promptsView.findViewById(R.id.history_item_teamAScore);
        TextView historyItemTeamBScore = (TextView) promptsView.findViewById(R.id.history_item_teamBScore);
        TextView historyItemComment = (TextView) promptsView.findViewById(R.id.history_item_comment);
        historyItemImage.setImageResource(addsc.get(position).getImage());
        historyItemComment.setText(addsc.get(position).getScoresComment());
        historyItemDate.setText(addsc.get(position).getScoresDate());
        historyItemTeamAScore.setText(addsc.get(position).getScoresTeamAName()+" : "+addsc.get(position).getScoresTeamA());
        historyItemTeamBScore.setText(addsc.get(position).getScoresTeamBName()+" : "+addsc.get(position).getScoresTeamB());
        // set dialog message
        alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
}
