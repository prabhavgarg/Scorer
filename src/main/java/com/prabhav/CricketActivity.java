package com.prabhav.play;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CricketActivity extends AppCompatActivity {


    final Context context = this;
    private final String CRICKET = "Cricket";
    int scoreA, scoreB, total = -1, total2 = -1, numberOfWicketsTeamA = 0, numberOfWicketsTeamB = 0, won = 0;
    static int finalNumberOfPlayers = 0, finalNumberOfOvers = 0;
    int oversA = 0, oversB = 0, numABalls = 0, numBBalls = 0, undoNumABallsCalled = 0, undoNumBBallsCalled = 0, runsNeeded = 1;
    float runRateA = 0.0F, reqRateB = 0.0F;
    String dateString, comment_Save, gameName;
    TextView teamANameHeading, teamBNameHeading, t1, t2, date;
    DatabaseReference cricket;
    ArrayList<String> ListItemA = new ArrayList<>(), ListItemB = new ArrayList<>();
    ArrayList<Integer> Arr2 = new ArrayList<>(), Arr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket);
        getSupportActionBar().setElevation(0);
        gameName = CRICKET;
        cricket = FirebaseDatabase.getInstance().getReference();
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.cricket_tablayout);
        tabLayout.setupWithViewPager(viewPager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(context, fragmentManager));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    public void addZeroForTeamA() {
        resetListofBallA();
        total++;
        Arr.add(0);
        if (undoNumABallsCalled == 0) {
            listViewVisibilityA2();
            ListItemA.add(0, "0");
            numABalls++;
        } else {
            undoNumABallsCalled++;
        }
        scoreA += 0;
        oversA++;
        displayForTeamA(scoreA);
    }

    public void addOneForTeamA() {
        resetListofBallA();
        total++;
        Arr.add(1);
        if (undoNumABallsCalled == 0) {
            listViewVisibilityA2();
            ListItemA.add(0, "1");
            numABalls++;
        } else {
            undoNumABallsCalled++;
        }
        scoreA += 1;
        oversA++;
        displayForTeamA(scoreA);
    }

    public void addTwoForTeamA() {
        resetListofBallA();
        total++;
        Arr.add(2);
        if (undoNumABallsCalled == 0) {
            listViewVisibilityA2();
            ListItemA.add(0, "2");
            numABalls++;
        } else {
            undoNumABallsCalled++;
        }
        scoreA += 2;
        oversA++;
        displayForTeamA(scoreA);
    }

    public void addThreeForTeamA() {
        resetListofBallA();
        total++;
        Arr.add(3);
        if (undoNumABallsCalled == 0) {
            listViewVisibilityA2();
            ListItemA.add(0, "3");
            numABalls++;
        } else {
            undoNumABallsCalled++;
        }
        scoreA += 3;
        oversA++;
        displayForTeamA(scoreA);
    }

    public void addFourForTeamA() {
        resetListofBallA();
        total++;
        Arr.add(4);
        if (undoNumABallsCalled == 0) {
            listViewVisibilityA2();
            ListItemA.add(0, "4");
            numABalls++;
        } else {
            undoNumABallsCalled++;
        }
        scoreA += 4;
        oversA++;
        displayForTeamA(scoreA);
    }

    public void addSixForTeamA() {
        resetListofBallA();
        total++;
        Arr.add(6);
        if (undoNumABallsCalled == 0) {
            listViewVisibilityA2();
            ListItemA.add(0, "6");
            numABalls++;
        } else {
            undoNumABallsCalled++;
        }
        scoreA += 6;
        oversA++;
        displayForTeamA(scoreA);
    }

    public void addWicketForTeamA() {
        resetListofBallA();
        total++;
        numberOfWicketsTeamA++;
        Arr.add(10);
        if (undoNumABallsCalled == 0) {
            listViewVisibilityA2();
            ListItemA.add(0, "W");
            numABalls++;
        } else {
            undoNumABallsCalled++;
        }
        scoreA += 0;
        oversA++;
        displayForTeamA(scoreA);
    }

    public void addNoBallForTeamA() {
        resetListofBallA();
        total++;
        Arr.add(20);
        if (undoNumABallsCalled == 0) {
            listViewVisibilityA2();
            ListItemA.add(0, "Nb");
        }
        scoreA += 1;
        displayForTeamA(scoreA);
    }

    public void addWideBallForTeamA() {
        resetListofBallA();
        total++;
        Arr.add(21);
        if (undoNumABallsCalled == 0) {
            listViewVisibilityA2();
            ListItemA.add(0, "Wb");
        }
        scoreA += 1;
        displayForTeamA(scoreA);
    }

    private void listViewVisibilityA2() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_cricket_A);
        recyclerView.setVisibility(View.VISIBLE);
        TextView textView = (TextView) findViewById(R.id.previousOverA);
        textView.setVisibility(View.GONE);
    }

    private void resetListofBallA() {
        if (numABalls == 6) {
            numABalls = 0;
            ListItemA.clear();
        }
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.cricket_teamA_score);
        scoreView.setText("Score : " + String.valueOf(score) + "/" + String.valueOf(numberOfWicketsTeamA));
        TextView oversView = (TextView) findViewById(R.id.cricket_teamA_overs);
        oversView.setText("Overs : " + String.valueOf(oversA / 6) + "." + String.valueOf(oversA % 6));
        TextView runrateView = (TextView) findViewById(R.id.cricket_teamA_runrate);
        if (oversA != 0) {
            runrateView.setText("RunRate : " + String.format("%.2f", (float) score * 6 / oversA));
        } else {
            runrateView.setText("RunRate : -:--");
        }
        if (score == 0) {
            runrateView.setText("RunRate : 0.00");
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_cricket_A);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        CricketTeamAAdapter adapter = new CricketTeamAAdapter(ListItemA);
        recyclerView.setAdapter(adapter);
        runsNeeded = scoreA + 1;
        if (oversA / 6 == finalNumberOfOvers)
            displayForTeamB(scoreB);
    }

    public void addZeroForTeamB() {
        resetListofBallB();
        total2++;
        Arr2.add(99);
        if (undoNumBBallsCalled == 0) {
            listViewVisibilityB2();
            ListItemB.add(0, "0");
            numBBalls++;
        } else {
            undoNumBBallsCalled++;
        }
        scoreB += 0;
        oversB++;
        displayForTeamB(scoreB);
    }

    public void addOneForTeamB() {
        resetListofBallB();
        total2++;
        Arr2.add(11);
        if (undoNumBBallsCalled == 0) {
            listViewVisibilityB2();
            ListItemB.add(0, "1");
            numBBalls++;
        } else {
            undoNumBBallsCalled++;
        }
        scoreB += 1;
        oversB++;
        displayForTeamB(scoreB);
    }

    public void addTwoForTeamB() {
        resetListofBallB();
        total2++;
        Arr2.add(12);
        if (undoNumBBallsCalled == 0) {
            listViewVisibilityB2();
            ListItemB.add(0, "2");
            numBBalls++;
        } else {
            undoNumBBallsCalled++;
        }
        scoreB += 2;
        oversB++;
        displayForTeamB(scoreB);
    }

    public void addThreeForTeamB() {
        resetListofBallB();
        total2++;
        Arr2.add(13);
        if (undoNumBBallsCalled == 0) {
            listViewVisibilityB2();
            ListItemB.add(0, "3");
            numBBalls++;
        } else {
            undoNumBBallsCalled++;
        }
        scoreB += 3;
        oversB++;
        displayForTeamB(scoreB);
    }

    public void addFourForTeamB() {
        resetListofBallB();
        total2++;
        Arr2.add(14);
        if (undoNumBBallsCalled == 0) {
            listViewVisibilityB2();
            ListItemB.add(0, "4");
            numBBalls++;
        } else {
            undoNumBBallsCalled++;
        }
        scoreB += 4;
        oversB++;
        displayForTeamB(scoreA);
    }

    public void addSixForTeamB() {
        resetListofBallB();
        total2++;
        Arr2.add(16);
        if (undoNumBBallsCalled == 0) {
            listViewVisibilityB2();
            ListItemB.add(0, "6");
            numBBalls++;
        } else {
            undoNumBBallsCalled++;
        }
        scoreB += 6;
        oversB++;
        displayForTeamB(scoreB);
    }

    public void addWicketForTeamB() {
        resetListofBallB();
        total2++;
        numberOfWicketsTeamB++;
        Arr2.add(100);
        if (undoNumBBallsCalled == 0) {
            listViewVisibilityB2();
            ListItemB.add(0, "W");
            numBBalls++;
        } else {
            undoNumBBallsCalled++;
        }
        scoreB += 0;
        oversB++;
        displayForTeamB(scoreB);
    }

    public void addNoBallForTeamB() {
        resetListofBallB();
        total2++;
        Arr2.add(101);
        if (undoNumBBallsCalled == 0) {
            listViewVisibilityB2();
            ListItemB.add(0, "Nb");
        }
        scoreB += 1;
        displayForTeamB(scoreB);
    }

    public void addWideBallForTeamB() {
        resetListofBallB();
        total2++;
        Arr2.add(102);
        if (undoNumBBallsCalled == 0) {
            listViewVisibilityB2();
            ListItemB.add(0, "Wb");
        }
        scoreB += 1;
        displayForTeamB(scoreB);
    }

    private void listViewVisibilityB2() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_cricket_B);
        recyclerView.setVisibility(View.VISIBLE);
        TextView textView = (TextView) findViewById(R.id.previousOverB);
        textView.setVisibility(View.GONE);
    }

    private void resetListofBallB() {
        if (numBBalls == 6) {
            numBBalls = 0;
            ListItemB.clear();
        }
    }

    public void displayForTeamB(int score) {
        if (won == 0) {
            runsNeeded = scoreA - scoreB + 1;
            if (runsNeeded <= 0) won = 2;
            int ballsLeft = finalNumberOfOvers * 6 - oversB;
            TextView scoreView = (TextView) findViewById(R.id.cricket_teamB_score);
            scoreView.setText("Score : " + String.valueOf(score) + "/" + String.valueOf(numberOfWicketsTeamB));
            TextView oversView = (TextView) findViewById(R.id.cricket_teamB_overs);
            oversView.setText("Overs : " + String.valueOf(oversB / 6) + "." + String.valueOf(oversB % 6));
            TextView needView = (TextView) findViewById(R.id.runsNeeded);
            needView.setText("Need " + runsNeeded + " runs in " + ballsLeft + " balls.");
            if(ballsLeft>500000)
            needView.setText("Need " + runsNeeded + " runs to win.");
            TextView reqrateView = (TextView) findViewById(R.id.cricket_teamB_reqrate);
            reqRateB = (float) runsNeeded / ballsLeft;
            reqrateView.setText("Req. Rate : " + String.format("%.2f", (float) reqRateB));
            if(finalNumberOfOvers*6 - oversB == 0)
            reqrateView.setText("Req. Rate : --");
            if (scoreA == 0 && scoreB == 0) {
                needView.setText("Need -- runs in -- balls.");
                reqrateView.setText("Req. Rate : --");
            }
            if (won == 2) {
                needView.setText(teamBNameHeading.getText().toString() + " Won");
                reqrateView.setText("Req. Rate : -:--");
                saveData();
            }
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_cricket_B);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
            CricketTeamAAdapter adapter = new CricketTeamAAdapter(ListItemB);
            recyclerView.setAdapter(adapter);
        }
    }

    public void resetScores() {
        Arr.clear();
        Arr2.clear();
        ListItemA.clear();
        ListItemB.clear();
        runsNeeded = 0;
        total = -1;
        total2 = -1;
        scoreA = 0;
        scoreB = 0;
        oversA = 0;
        oversB = 0;
        runRateA = 0;
        reqRateB = 0;
        numberOfWicketsTeamA = 0;
        numberOfWicketsTeamB = 0;
        if (won != 0)
            won = 0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }

    public void undoScore(int team) {
        if (won != 0)
            won = 0;
        if (team == 1 && scoreA > 0 && Arr.get(total) == 1) {
            scoreA -= 1;
            Arr.remove(total);
            if (ListItemA.size() != 0)
                ListItemA.remove(0);
            if (numABalls != 0)
                numABalls--;
            else {
                undoNumABallsCalled--;
                listViewVisibilityA1();
            }
            oversA--;
            total--;
        } else if (team == 1 && total > -1 && Arr.get(total) == 0) {
            scoreA -= 0;
            Arr.remove(total);
            if (ListItemA.size() != 0)
                ListItemA.remove(0);
            if (numABalls != 0)
                numABalls--;
            else {
                undoNumABallsCalled--;
                listViewVisibilityA1();
            }
            oversA--;
            total--;
        } else if (team == 1 && scoreA > 0 && Arr.get(total) == 2) {
            scoreA -= 2;
            Arr.remove(total);
            if (ListItemA.size() != 0)
                ListItemA.remove(0);
            if (numABalls != 0)
                numABalls--;
            else {
                undoNumABallsCalled--;
                listViewVisibilityA1();
            }
            oversA--;
            total--;
        } else if (team == 1 && scoreA > 0 && Arr.get(total) == 3) {
            scoreA -= 3;
            Arr.remove(total);
            if (ListItemA.size() != 0)
                ListItemA.remove(0);
            if (numABalls != 0)
                numABalls--;
            else {
                undoNumABallsCalled--;
                listViewVisibilityA1();
            }
            oversA--;
            total--;
        } else if (team == 1 && scoreA > 0 && Arr.get(total) == 4) {
            scoreA -= 4;
            Arr.remove(total);
            if (ListItemA.size() != 0)
                ListItemA.remove(0);
            if (numABalls != 0)
                numABalls--;
            else {
                undoNumABallsCalled--;
                listViewVisibilityA1();
            }
            oversA--;
            total--;
        } else if (team == 1 && scoreA > 0 && Arr.get(total) == 6) {
            scoreA -= 6;
            Arr.remove(total);
            if (ListItemA.size() != 0)
                ListItemA.remove(0);
            if (numABalls != 0)
                numABalls--;
            else {
                undoNumABallsCalled--;
                listViewVisibilityA1();
            }
            oversA--;
            total--;
        } else if (team == 1 && scoreA > 0 && Arr.get(total) == 10) {
            scoreA -= 0;
            numberOfWicketsTeamA--;
            Arr.remove(total);
            if (ListItemA.size() != 0)
                ListItemA.remove(0);
            if (numABalls != 0)
                numABalls--;
            else {
                undoNumABallsCalled--;
                listViewVisibilityA1();
            }
            oversA--;
            total--;
        } else if (team == 1 && scoreA > 0 && Arr.get(total) == 20) {
            scoreA -= 1;
            Arr.remove(total);
            if (ListItemA.size() != 0)
                ListItemA.remove(0);
            total--;
        } else if (team == 1 && scoreA > 0 && Arr.get(total) == 21) {
            scoreA -= 1;
            Arr.remove(total);
            if (ListItemA.size() != 0)
                ListItemA.remove(0);
            total--;
        } else if (team == 2 && scoreB > 0 && Arr2.get(total2) == 11) {
            scoreB -= 1;
            Arr2.remove(total2);
            if (ListItemB.size() != 0)
                ListItemB.remove(0);
            if (numBBalls != 0)
                numBBalls--;
            else {
                undoNumBBallsCalled--;
                listViewVisibilityB1();
            }
            oversB--;
            total2--;
        } else if (team == 2 && total2 > -1 && Arr2.get(total2) == 99) {
            scoreB -= 0;
            Arr2.remove(total2);
            if (ListItemB.size() != 0)
                ListItemB.remove(0);
            if (numBBalls != 0)
                numBBalls--;
            else {
                undoNumBBallsCalled--;
                listViewVisibilityB1();
            }
            oversB--;
            total2--;
        } else if (team == 2 && scoreB > 0 && Arr2.get(total2) == 12) {
            scoreB -= 2;
            Arr2.remove(total2);
            if (ListItemB.size() != 0)
                ListItemB.remove(0);
            if (numBBalls != 0)
                numBBalls--;
            else {
                undoNumBBallsCalled--;
                listViewVisibilityB1();
            }
            oversB--;
            total2--;
        } else if (team == 2 && scoreB > 0 && Arr2.get(total2) == 13) {
            scoreB -= 3;
            Arr2.remove(total2);
            if (ListItemB.size() != 0)
                ListItemB.remove(0);
            if (numBBalls != 0)
                numBBalls--;
            else {
                undoNumBBallsCalled--;
                listViewVisibilityB1();
            }
            oversB--;
            total2--;
        } else if (team == 2 && scoreB > 0 && Arr2.get(total2) == 14) {
            scoreB -= 4;
            Arr2.remove(total2);
            if (ListItemB.size() != 0)
                ListItemB.remove(0);
            if (numBBalls != 0)
                numBBalls--;
            else {
                undoNumBBallsCalled--;
                listViewVisibilityB1();
            }
            oversB--;
            total2--;
        } else if (team == 2 && scoreB > 0 && Arr2.get(total2) == 16) {
            scoreB -= 6;
            Arr2.remove(total2);
            if (ListItemB.size() != 0)
                ListItemB.remove(0);
            if (numBBalls != 0)
                numBBalls--;
            else {
                undoNumBBallsCalled--;
                listViewVisibilityB1();
            }
            oversB--;
            total2--;
        } else if (team == 2 && scoreB > 0 && Arr2.get(total2) == 100) {
            scoreB -= 0;
            numberOfWicketsTeamB--;
            Arr2.remove(total2);
            if (ListItemB.size() != 0)
                ListItemB.remove(0);
            if (numBBalls != 0)
                numBBalls--;
            else {
                undoNumBBallsCalled--;
                listViewVisibilityB1();
            }
            oversB--;
            total2--;
        } else if (team == 2 && scoreB > 0 && Arr2.get(total2) == 101) {
            scoreB -= 1;
            Arr2.remove(total2);
            if (ListItemB.size() != 0)
                ListItemB.remove(0);
            total2--;
        } else if (team == 2 && scoreB > 0 && Arr2.get(total2) == 102) {
            scoreB -= 1;
            Arr2.remove(total2);
            if (ListItemB.size() != 0)
                ListItemB.remove(0);
            total2--;
        }
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }

    private void listViewVisibilityA1() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_cricket_A);
        recyclerView.setVisibility(View.GONE);
        TextView textView = (TextView) findViewById(R.id.previousOverA);
        textView.setVisibility(View.VISIBLE);
    }

    private void listViewVisibilityB1() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_cricket_B);
        recyclerView.setVisibility(View.GONE);
        TextView textView = (TextView) findViewById(R.id.previousOverB);
        textView.setVisibility(View.VISIBLE);
    }

    public void showCricketDialogue() {
        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.start_cricket_dialogue, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);
        final EditText userInputA = (EditText) promptsView.findViewById(R.id.cricketTeamANameID);
        final EditText userInputB = (EditText) promptsView.findViewById(R.id.cricketTeamBNameID);
        final EditText players = (EditText) promptsView.findViewById(R.id.number_of_players);
        final EditText overs = (EditText) promptsView.findViewById(R.id.number_of_overs);
        final CheckBox testMatch = (CheckBox) promptsView.findViewById(R.id.test_match);

        // set dialog message
        alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                resetScores();
                if (userInputA.getText().toString().trim().length() != 0) {
                    teamANameHeading = (TextView) findViewById(R.id.teamACricketHeading);
                    teamANameHeading.setText(userInputA.getText().toString());
                }
                if (userInputB.getText().toString().trim().length() != 0) {
                    teamBNameHeading = (TextView) findViewById(R.id.teamBCricketHeading);
                    teamBNameHeading.setText(userInputB.getText().toString());
                }
                if (players.getText().toString().trim().length() != 0)
                    finalNumberOfPlayers = Integer.parseInt(players.getText().toString());
                if (overs.getText().toString().trim().length() != 0)
                    finalNumberOfOvers = Integer.parseInt(overs.getText().toString());
                if (testMatch.isChecked())
                    finalNumberOfOvers = 100000;
                findViewById(R.id.first_screen_cricket).setVisibility(View.GONE);
                findViewById(R.id.second_screen_cricket).setVisibility(View.GONE);

                //save it to the firebase database
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_newGame:
                showCricketDialogue();
                return true;
            case R.id.action_teamNames:
                setNames();
                return true;
            case R.id.action_save:
                saveData();
                return true;
            case R.id.action_history:
                Intent intent = new Intent(this, HistoryActivity.class);
                intent.putExtra("GAME_ID", CRICKET);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cricket_menu, menu);//Menu Resource, Menu
        return true;
    }

    public void saveData() {

        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.save_dialog, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);
        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.editTextDialogUserInput);
        if (scoreA > scoreB)
            userInput.setText(teamANameHeading.getText().toString() + " won over " + teamBNameHeading.getText().toString() + "!!");
        else if (scoreA < scoreB)
            userInput.setText(teamBNameHeading.getText().toString() + " won over " + teamANameHeading.getText().toString() + "!!");
        else userInput.setText("Match gets Tied!!");
        t1 = (TextView) promptsView.findViewById(R.id.teamAScore);
        t2 = (TextView) promptsView.findViewById(R.id.teamBScore);
        date = (TextView) promptsView.findViewById(R.id.date);
        teamANameHeading = (TextView) findViewById(R.id.teamACricketHeading);
        teamBNameHeading = (TextView) findViewById(R.id.teamBCricketHeading);
        t1.setText(teamANameHeading.getText().toString() + " : " + Integer.toString(scoreA));
        t2.setText(teamBNameHeading.getText().toString() + " : " + Integer.toString(scoreB));
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
                                teamANameHeading = (TextView) findViewById(R.id.teamACricketHeading);
                                teamBNameHeading = (TextView) findViewById(R.id.teamBCricketHeading);
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
        String gameName = CRICKET;
        String aName = teamANameHeading.getText().toString().trim();
        String bName = teamBNameHeading.getText().toString().trim();
        String comment = comment_Save;
        int image = R.drawable.cricket_image;

        String id = cricket.push().getKey();
        AddScores addScores = new AddScores(image, id, teamAScore, teamBScore, d, gameName, aName, bName, comment);
        cricket.child(MainActivity.USER_ID).child(gameName).child(id).setValue(addScores);
        Toast.makeText(this, "Event Saved Successfully", Toast.LENGTH_LONG).show();
    }

}

class MyAdapter extends FragmentPagerAdapter {

    Context mContext;

    public MyAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new CricketFragmentTeamA();
        } else {
            fragment = new CricketFragmentTeamB();
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.teamA);
        } else {
            return mContext.getString(R.string.teamB);
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}

class CricketTeamAAdapter extends RecyclerView.Adapter<CricketTeamAAdapter.MyViewHolder> {

    private List<String> runList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView runCount;

        MyViewHolder(View view) {
            super(view);
            runCount = (TextView) view.findViewById(R.id.runsList);
        }
    }


    public CricketTeamAAdapter(List<String> list) {
        this.runList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cricket_ball_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.runCount.setText(runList.get(position));
    }

    @Override
    public int getItemCount() {
        return runList.size();
    }
}