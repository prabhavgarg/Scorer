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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;

import static com.prabhav.play.R.id.pauseButton;
import static com.prabhav.play.R.id.timer;

public class ArcheryActivity extends AppCompatActivity {
    private final String ARCHERY = "Archery";
    int scoreA,scoreB,total=-1;
    TextView t1,t2,date, teamANameHeading, teamBNameHeading ;
    ArrayList<Integer> Arr = new ArrayList<Integer>();
    DatabaseReference archery;
    String dateString, comment_Save, gameName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archery);
        teamANameHeading = (TextView)findViewById(R.id.teamANameArchery);
        teamBNameHeading = (TextView)findViewById(R.id.teamBNameArchery);
        teamANameHeading.setText("Team A");
        teamBNameHeading.setText("Team B");
        gameName = ARCHERY;
        archery = FirebaseDatabase.getInstance().getReference();
    }
    public void addThreeForTeamA(View view)
    {
        total++;
        Arr.add(3);
        scoreA+=3;
        displayForTeamA(scoreA);
    }
    public void addTwoForTeamA(View view)
    {
        total++;
        Arr.add(2);
        scoreA+=2;
        displayForTeamA(scoreA);
    }
    public void addOneForTeamA(View view)
    {
        total++;
        Arr.add(1);
        scoreA+=1;
        displayForTeamA(scoreA);
    }
    public void addFourForTeamA(View view)
    {
        total++;
        Arr.add(4);
        scoreA+=4;
        displayForTeamA(scoreA);
    }
    public void addFiveForTeamA(View view)
    {
        total++;
        Arr.add(5);
        scoreA+=5;
        displayForTeamA(scoreA);
    }
    public void addSixForTeamA(View view)
    {
        total++;
        Arr.add(6);
        scoreA+=6;
        displayForTeamA(scoreA);
    }
    public void addSevenForTeamA(View view)
    {
        total++;
        Arr.add(7);
        scoreA+=7;
        displayForTeamA(scoreA);
    }
    public void addEightForTeamA(View view)
    {
        total++;
        Arr.add(8);
        scoreA+=8;
        displayForTeamA(scoreA);
    }
    public void addNineForTeamA(View view)
    {
        total++;
        Arr.add(9);
        scoreA+=9;
        displayForTeamA(scoreA);
    }
    public void addTenForTeamA(View view)
    {
        total++;
        Arr.add(10);
        scoreA+=10;
        displayForTeamA(scoreA);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void addThreeForTeamB(View view)
    {
        total++;
        Arr.add(13);
        scoreB+=3;
        displayForTeamB(scoreB);
    }
    public void addTwoForTeamB(View view)
    {
        total++;
        Arr.add(12);
        scoreB+=2;
        displayForTeamB(scoreB);
    }
    public void addOneForTeamB(View view)
    {
        total++;
        Arr.add(11);
        scoreB+=1;
        displayForTeamB(scoreB);
    }
    public void addFourForTeamB(View view)
    {
        total++;
        Arr.add(14);
        scoreB+=4;
        displayForTeamB(scoreB);
    }
    public void addFiveForTeamB(View view)
    {
        total++;
        Arr.add(15);
        scoreB+=5;
        displayForTeamB(scoreB);
    }
    public void addSixForTeamB(View view)
    {
        total++;
        Arr.add(16);
        scoreB+=6;
        displayForTeamB(scoreB);
    }
    public void addSevenForTeamB(View view)
    {
        total++;
        Arr.add(17);
        scoreB+=7;
        displayForTeamB(scoreB);
    }
    public void addEightForTeamB(View view)
    {
        total++;
        Arr.add(18);
        scoreB+=8;
        displayForTeamB(scoreB);
    }
    public void addNineForTeamB(View view)
    {
        total++;
        Arr.add(19);
        scoreB+=9;
        displayForTeamB(scoreB);
    }
    public void addTenForTeamB(View view)
    {
        total++;
        Arr.add(20);
        scoreB+=10;
        displayForTeamB(scoreB);
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
    }
    public void undoScore(View view)
    {
        if(scoreA>0&&Arr.get(total)==1){scoreA-=1;Arr.remove(total);total--;}
        else if(scoreA>0&&Arr.get(total)==2){scoreA-=2;Arr.remove(total);total--;}
        else if(scoreA>0&&Arr.get(total)==3){scoreA-=3;Arr.remove(total);total--;}
        else if(scoreA>0&&Arr.get(total)==4){scoreA-=4;Arr.remove(total);total--;}
        else if(scoreA>0&&Arr.get(total)==5){scoreA-=5;Arr.remove(total);total--;}
        else if(scoreA>0&&Arr.get(total)==6){scoreA-=6;Arr.remove(total);total--;}
        else if(scoreA>0&&Arr.get(total)==7){scoreA-=7;Arr.remove(total);total--;}
        else if(scoreA>0&&Arr.get(total)==8){scoreA-=8;Arr.remove(total);total--;}
        else if(scoreA>0&&Arr.get(total)==9){scoreA-=9;Arr.remove(total);total--;}
        else if(scoreA>0&&Arr.get(total)==10){scoreA-=10;Arr.remove(total);total--;}
        else if(scoreB>0&&Arr.get(total)==11){scoreB-=1;Arr.remove(total);total--;}
        else if(scoreB>0&&Arr.get(total)==12){scoreB-=2;Arr.remove(total);total--;}
        else if(scoreB>0&&Arr.get(total)==13){scoreB-=3;Arr.remove(total);total--;}
        else if(scoreB>0&&Arr.get(total)==14){scoreB-=4;Arr.remove(total);total--;}
        else if(scoreB>0&&Arr.get(total)==15){scoreB-=5;Arr.remove(total);total--;}
        else if(scoreB>0&&Arr.get(total)==16){scoreB-=6;Arr.remove(total);total--;}
        else if(scoreB>0&&Arr.get(total)==17){scoreB-=7;Arr.remove(total);total--;}
        else if(scoreB>0&&Arr.get(total)==18){scoreB-=8;Arr.remove(total);total--;}
        else if(scoreB>0&&Arr.get(total)==19){scoreB-=9;Arr.remove(total);total--;}
        else if(scoreB>0&&Arr.get(total)==20){scoreB-=10;Arr.remove(total);total--;}
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
                saveData();
                return true;
            case R.id.action_history:
                Intent intent = new Intent(this,HistoryActivity.class);
                intent.putExtra("GAME_ID", ARCHERY);
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
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.save_dialog, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
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
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.team_names, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
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
        String gameName = ARCHERY;
        String aName=teamANameHeading.getText().toString().trim();
        String bName=teamBNameHeading.getText().toString().trim();
        String comment= comment_Save;
        int image =R.drawable.archery_image;

        String id = archery.push().getKey();
        AddScores addScores = new AddScores(image,id,teamAScore,teamBScore,d,gameName,aName,bName,comment);
        archery.child(MainActivity.USER_ID).child(gameName).child(id).setValue(addScores);
        Toast.makeText(this,"Event Saved Successfully",Toast.LENGTH_LONG).show();
    }

}

