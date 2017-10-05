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

public class KickBoxingActivity extends AppCompatActivity {

    private final String KICKBOXING = "KickBoxing";
    int scoreA, scoreB, total = -1, knockOutPressed = 0;
    TextView textView, t1, t2, date, teamANameHeading, teamBNameHeading;
    String dateString, comment_Save, gameName;
    Button start, pause, reset;
    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L;
    Handler handler;
    final Context context = this;
    int Seconds, Minutes, MilliSeconds;
    DatabaseReference kickboxing;
    ArrayList<Integer> Arr = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kick_boxing);
        textView = (TextView) findViewById(R.id.timer);
        start = (Button) findViewById(R.id.startButton);
        pause = (Button) findViewById(R.id.pauseButton);
        reset = (Button) findViewById(R.id.resetButton);
        handler = new Handler();
        teamANameHeading = (TextView) findViewById(R.id.teamANameKickBoxing);
        teamBNameHeading = (TextView) findViewById(R.id.teamBNameKickBoxing);
        teamANameHeading.setText("Team A");
        teamBNameHeading.setText("Team B");
        gameName = KICKBOXING;
        kickboxing = FirebaseDatabase.getInstance().getReference();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);
                reset.setEnabled(false);
                start.setEnabled(false);
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeBuff += MillisecondTime;
                handler.removeCallbacks(runnable);
                reset.setEnabled(true);
                start.setEnabled(true);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetAll();
                start.setEnabled(true);
            }
        });
    }

    private void resetAll() {
        Arr.clear();
        total = -1;
        scoreA = 0;
        scoreB = 0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
        MillisecondTime = 0L;
        StartTime = 0L;
        TimeBuff = 0L;
        UpdateTime = 0L;
        Seconds = 0;
        Minutes = 0;
        MilliSeconds = 0;
        textView.setText("00:00:000");
    }

    public Runnable runnable = new Runnable() {

        public void run() {
            MillisecondTime = SystemClock.uptimeMillis() - StartTime;
            UpdateTime = TimeBuff + MillisecondTime;
            Seconds = (int) (UpdateTime / 1000);
            Minutes = Seconds / 60;
            Seconds = Seconds % 60;
            MilliSeconds = (int) (UpdateTime % 1000);
            if (UpdateTime <= 180000)
                textView.setText("" + Minutes + ":" + String.format("%02d", Seconds) + ":" + String.format("%03d", MilliSeconds));
            else {
                MillisecondTime = 0L;
                StartTime = 0L;
                TimeBuff = 0L;
                UpdateTime = 0L;
                Seconds = 0;
                Minutes = 0;
                MilliSeconds = 0;
                textView.setText("00:00:000");
                start.setEnabled(true);
                if (knockOutPressed == 0) {
                    saveData(null);
                }
                reset.setEnabled(true);
                return;
            }
            handler.postDelayed(this, 0);
        }
    };

    public void addOneForTeamA(View view) {
        total++;
        Arr.add(1);
        scoreA += 1;
        displayForTeamA(scoreA);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addOneForTeamB(View view) {
        total++;
        Arr.add(11);
        scoreB += 1;
        displayForTeamB(scoreB);
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void knockOutA(View view) {
        saveData("A");
        knockOutPressed = 1;
        resetAll();
    }

    public void knockOutB(View view) {
        saveData("B");
        knockOutPressed = 1;
        resetAll();
    }

    public void resetScores(View view) {
        Arr.clear();
        total = -1;
        scoreA = 0;
        scoreB = 0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }

    public void undoScores(View view) {
        if (scoreA > 0 && Arr.get(total) == 1) {
            scoreA -= 1;
            Arr.remove(total);
            total--;
        } else if (scoreA > 0 && Arr.get(total) == 2) {
            scoreA -= 2;
            Arr.remove(total);
            total--;
        } else if (scoreA > 0 && Arr.get(total) == 3) {
            scoreA -= 3;
            Arr.remove(total);
            total--;
        } else if (scoreB > 0 && Arr.get(total) == 11) {
            scoreB -= 1;
            Arr.remove(total);
            total--;
        } else if (scoreB > 0 && Arr.get(total) == 12) {
            scoreB -= 2;
            Arr.remove(total);
            total--;
        } else if (scoreB > 0 && Arr.get(total) == 13) {
            scoreB -= 3;
            Arr.remove(total);
            total--;
        }
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_teamNames:
                setNames();
                return true;
            case R.id.action_save:
                saveData(null);
                return true;
            case R.id.action_history:
                Intent intent = new Intent(this, HistoryActivity.class);
                intent.putExtra("GAME_ID", KICKBOXING);
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

    public void saveData(String ss) {

        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.save_dialog, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);
        final EditText userInput = (EditText) promptsView.findViewById(R.id.editTextDialogUserInput);
        if (ss == null) {
            if (scoreA > scoreB)
                userInput.setText(teamANameHeading.getText().toString() + " won over " + teamBNameHeading.getText().toString() + "!!");
            else if (scoreA < scoreB)
                userInput.setText(teamBNameHeading.getText().toString() + " won over " + teamANameHeading.getText().toString() + "!!");
            else userInput.setText("Match gets Tied!!");
        } else {
            if (ss.equals("A"))
                userInput.setText(teamANameHeading.getText().toString() + " gets Disqualified!!");
            else
                userInput.setText(teamBNameHeading.getText().toString() + " gets Disqualified!!");
        }
        t1 = (TextView) promptsView.findViewById(R.id.teamAScore);
        t2 = (TextView) promptsView.findViewById(R.id.teamBScore);
        date = (TextView) promptsView.findViewById(R.id.date);
        if (ss == null) {
            t1.setText(teamANameHeading.getText().toString() + " : " + Integer.toString(scoreA));
            t2.setText(teamBNameHeading.getText().toString() + " : " + Integer.toString(scoreB));
        } else {
            if (ss.equals("A")) {
                t1.setText(teamANameHeading.getText().toString() + " : KO");
                t2.setText(teamBNameHeading.getText().toString() + " : WON");
            } else {
                t1.setText(teamANameHeading.getText().toString() + " : WON");
                t2.setText(teamBNameHeading.getText().toString() + " : KO");
            }
        }
        Date d = new Date();
        CharSequence s = DateFormat.format("MMMM d, yyyy ", d.getTime());
        date.setText(s);
        dateString = s.toString();


        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("SAVE",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // get user input and set it to result
                                // edit text
                                knockOutPressed = 0;
                                comment_Save = userInput.getText().toString().trim();
                                //save it to the firebase database
                                pushingDataToFirebase();
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
                knockOutPressed = 0;
            }
        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    public void setNames() {

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
                            public void onClick(DialogInterface dialog, int id) {
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

    public void pushingDataToFirebase() {
        String d = dateString;
        String teamAScore = Integer.toString(scoreA);
        String teamBScore = Integer.toString(scoreB);
        String gameName = KICKBOXING;
        String aName = teamANameHeading.getText().toString().trim();
        String bName = teamBNameHeading.getText().toString().trim();
        String comment = comment_Save;
        int image = R.drawable.kickboxing_image;

        String id = kickboxing.push().getKey();
        AddScores addScores = new AddScores(image, id, teamAScore, teamBScore, d, gameName, aName, bName, comment);
        kickboxing.child(MainActivity.USER_ID).child(gameName).child(id).setValue(addScores);
        Toast.makeText(this, "Event Saved Successfully", Toast.LENGTH_LONG).show();
    }

}

