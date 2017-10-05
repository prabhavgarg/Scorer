package com.prabhav.play;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;

import static com.prabhav.play.R.id.pauseButton;
import static com.prabhav.play.R.id.timer;

public class BossaballActivity extends AppCompatActivity {
    private final String BOSSABALL = "BossaBall";
    int scoreA,scoreB,total=-1;
    TextView textView,t1,t2,date, teamANameHeading, teamBNameHeading ;
    String dateString, comment_Save, gameName;
    final Context context = this;
    DatabaseReference bossaBall;
    ArrayList<Integer> Arr = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bossaball);

        textView = (TextView)findViewById(R.id.timer);
        teamANameHeading = (TextView)findViewById(R.id.teamAName_bossaball);
        teamBNameHeading = (TextView)findViewById(R.id.teamBName_bossaball);
        teamANameHeading.setText("Team A");
        teamBNameHeading.setText("Team B");
        gameName = BOSSABALL;
        bossaBall = FirebaseDatabase.getInstance().getReference();

        TextView whoWho=(TextView) findViewById(R.id.who_won);
        whoWho.setText("");
    }
    public void addOneForTeamA(View view)
    {
        TextView whoWon=(TextView) findViewById(R.id.who_won);
        if(whoWon.getText()=="") {
            total++;
            Arr.add(1);
            scoreA += 1;
            displayForTeamA(scoreA);
            updateResults();
        }
    }
    public void addThreeForTeamA(View view)
    {
        TextView whoWon=(TextView) findViewById(R.id.who_won);
        if(whoWon.getText()=="") {
            total++;
            Arr.add(3);
            scoreA += 3;
            displayForTeamA(scoreA);
            updateResults();
        }
    }
    public void addFiveForTeamA(View view)
    {
        TextView whoWon=(TextView) findViewById(R.id.who_won);
        if(whoWon.getText()=="") {
            total++;
            Arr.add(5);
            scoreA += 5;
            displayForTeamA(scoreA);
            updateResults();
        }
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void addOneForTeamB(View view)
    {
        TextView whoWon=(TextView) findViewById(R.id.who_won);
        if(whoWon.getText()=="") {
            total++;
            Arr.add(11);
            scoreB += 1;
            displayForTeamB(scoreB);
            updateResults();
        }
    }
    public void addThreeForTeamB(View view)
    {
        TextView whoWon=(TextView) findViewById(R.id.who_won);
        if(whoWon.getText()=="") {
            total++;
            Arr.add(13);
            scoreB += 3;
            displayForTeamB(scoreB);
            updateResults();
        }
    }
    public void addFiveForTeamB(View view)
    {
        TextView whoWon=(TextView) findViewById(R.id.who_won);
        if(whoWon.getText()=="") {
            total++;
            Arr.add(15);
            scoreB += 5;
            displayForTeamB(scoreB);
            updateResults();
        }
    }
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void resetScores(View view)
    {
        Arr.clear();
        total=-1;
        scoreA=0;
        scoreB=0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
        updateResults();
    }
    public void undoScore(View view)
    {
        if(scoreA>0&&Arr.get(total)==1){scoreA-=1;Arr.remove(total);total--;}
        else if(scoreA>0&&Arr.get(total)==3){scoreA-=3;Arr.remove(total);total--;}
        else if(scoreA>0&&Arr.get(total)==5){scoreA-=5;Arr.remove(total);total--;}
        else if(scoreB>0&&Arr.get(total)==11){scoreB-=1;Arr.remove(total);total--;}
        else if(scoreB>0&&Arr.get(total)==13){scoreB-=3;Arr.remove(total);total--;}
        else if(scoreB>0&&Arr.get(total)==15){scoreB-=5;Arr.remove(total);total--;}
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
        updateResults();
    }
    private void updateResults() {
        TextView whoWon = (TextView) findViewById(R.id.who_won);
        if(scoreA>=25&&scoreB<24)
        {
            whoWon.setText("Team-A Won");
        }
        else if(scoreB>=25&&scoreA<24)
        {
            whoWon.setText("Team-B Won");
        }
        else if(scoreA>23&&scoreB>23)
        {
            if(scoreA-scoreB>=2)
                whoWon.setText("Team-A Won");
            else if(scoreB-scoreA>=2)
                whoWon.setText("Team-B Won");
            else
                whoWon.setText("");
        }
        else
        {
            whoWon.setText("");
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_teamNames:
                setNames();
                return true;
            case R.id.action_save:
                saveData();
                return true;
            case R.id.action_history:
                Intent intent = new Intent(this,HistoryActivity.class);
                intent.putExtra("GAME_ID", BOSSABALL);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.games_menu, menu);//Menu Resource, Menu
        return true;
    }

    public void saveData(){

        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.save_dialog, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);
        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.editTextDialogUserInput);
        if(scoreA>scoreB)   userInput.setText(teamANameHeading.getText().toString() +" won over "+teamBNameHeading.getText().toString()+"!!");
        else if(scoreA<scoreB)   userInput.setText(teamBNameHeading.getText().toString() +" won over "+teamANameHeading.getText().toString()+"!!");
        else   userInput.setText("Match gets Tied!!");
        t1 = (TextView)promptsView.findViewById(R.id.teamAScore);
        t2 = (TextView)promptsView.findViewById(R.id.teamBScore);
        date = (TextView)promptsView.findViewById(R.id.date);
        t1.setText(teamANameHeading.getText().toString()+" : " +Integer.toString(scoreA));
        t2.setText(teamBNameHeading.getText().toString()+" : " +Integer.toString(scoreB));
        Date d = new Date();
        CharSequence s  = DateFormat.format("MMMM d, yyyy ", d.getTime());
        date.setText(s);
        dateString=s.toString();


        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("SAVE",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text
                                comment_Save = userInput.getText().toString().trim();
                                //save it to the firebase database
                                pushingDataToFirebase();
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
    public void setNames(){

        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.team_names, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);
        final EditText userInputA = (EditText) promptsView
                .findViewById(R.id.teamANameID);
        final EditText userInputB = (EditText) promptsView
                .findViewById(R.id.teamBNameID);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text
                                if (userInputA.getText().toString().trim().length() != 0)
                                    teamANameHeading.setText(userInputA.getText().toString());
                                if (userInputB.getText().toString().trim().length() != 0)
                                    teamBNameHeading.setText(userInputB.getText().toString());

                                //save it to the firebase database
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    public void pushingDataToFirebase(){
        String d = dateString;
        String teamAScore = Integer.toString(scoreA);
        String teamBScore = Integer.toString(scoreB);
        String gameName = BOSSABALL;
        String aName=teamANameHeading.getText().toString().trim();
        String bName=teamBNameHeading.getText().toString().trim();
        String comment= comment_Save;
        int image =R.drawable.bossaball_image;

        String id = bossaBall.push().getKey();
        AddScores addScores = new AddScores(image,id,teamAScore,teamBScore,d,gameName,aName,bName,comment);
        bossaBall.child(MainActivity.USER_ID).child(gameName).child(id).setValue(addScores);
        Toast.makeText(this,"Event Saved Successfully",Toast.LENGTH_LONG).show();
    }

}

