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
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

        import java.util.ArrayList;
        import java.util.Date;

        import static com.prabhav.play.R.id.pauseButton;
        import static com.prabhav.play.R.id.rA1;
        import static com.prabhav.play.R.id.rB1;
        import static com.prabhav.play.R.id.timer;

public class BeerPongActivity extends AppCompatActivity {
    private final String BEER_PONG = "BeerPong";
    int scoreA,scoreB,total=-1;
    TextView textView,t1,t2,date, teamANameHeading, teamBNameHeading ;
    RadioButton RA1,RA2,RA3,RA4,RA5,RA6,RA7,RA8,RA9,RA10,RA11,RA12,RA13,RA14,RA15;
    RadioButton RB1,RB2,RB3,RB4,RB5,RB6,RB7,RB8,RB9,RB10,RB11,RB12,RB13,RB14,RB15;
    String dateString, comment_Save, gameName;
    final Context context = this;
    DatabaseReference beerPong;
    int A[],B[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_pong);
        A=new int[15];
        B=new int[15];
        RA1= (RadioButton)findViewById(R.id.rA1);
        RA2= (RadioButton)findViewById(R.id.rA2);
        RA3= (RadioButton)findViewById(R.id.rA3);
        RA4= (RadioButton)findViewById(R.id.rA4);
        RA5= (RadioButton)findViewById(R.id.rA5);
        RA6= (RadioButton)findViewById(R.id.rA6);
        RA7= (RadioButton)findViewById(R.id.rA7);
        RA8= (RadioButton)findViewById(R.id.rA8);
        RA9= (RadioButton)findViewById(R.id.rA9);
        RA10= (RadioButton)findViewById(R.id.rA10);
        RA11= (RadioButton)findViewById(R.id.rA11);
        RA12= (RadioButton)findViewById(R.id.rA12);
        RA13= (RadioButton)findViewById(R.id.rA13);
        RA14= (RadioButton)findViewById(R.id.rA14);
        RA15= (RadioButton)findViewById(R.id.rA15);
        RB1= (RadioButton)findViewById(R.id.rB1);
        RB2= (RadioButton)findViewById(R.id.rB2);
        RB3= (RadioButton)findViewById(R.id.rB3);
        RB4= (RadioButton)findViewById(R.id.rB4);
        RB5= (RadioButton)findViewById(R.id.rB5);
        RB6= (RadioButton)findViewById(R.id.rB6);
        RB7= (RadioButton)findViewById(R.id.rB7);
        RB8= (RadioButton)findViewById(R.id.rB8);
        RB9= (RadioButton)findViewById(R.id.rB9);
        RB10= (RadioButton)findViewById(R.id.rB10);
        RB11= (RadioButton)findViewById(R.id.rB11);
        RB12= (RadioButton)findViewById(R.id.rB12);
        RB13= (RadioButton)findViewById(R.id.rB13);
        RB14= (RadioButton)findViewById(R.id.rB14);
        RB15= (RadioButton)findViewById(R.id.rB15);
        teamANameHeading = (TextView)findViewById(R.id.teamA_name_beerpong);
        teamBNameHeading = (TextView)findViewById(R.id.teamB_name_beerpong);
        teamANameHeading.setText("Team A");
        teamBNameHeading.setText("Team B");
        gameName = BEER_PONG;
        beerPong = FirebaseDatabase.getInstance().getReference();

    }
    public void addOneForTeamA_1(View view)
    {
        if(A[0]%2==0) {
            total++;
            scoreA += 1;
            A[0]++;
        }
        else {
            RB1.setChecked(false);
            total--;
            scoreA--;
            A[0]--;
        }
        displayForTeamA(scoreA);
    }
    public void addOneForTeamA_2(View view)
    {
        if(A[1]%2==0) {
            total++;
            scoreA += 1;
            A[1]++;
        }
        else {
            RB2.setChecked(false);
            total--;
            scoreA--;
            A[1]--;
        }
        displayForTeamA(scoreA);
    }
    public void addOneForTeamA_3(View view)
    {
        if(A[2]%2==0) {
            total++;
            scoreA += 1;
            A[2]++;
        }
        else {
            RB3.setChecked(false);
            total--;
            scoreA--;
            A[2]--;
        }
        displayForTeamA(scoreA);
    }
    public void addOneForTeamA_4(View view)
    {
        if(A[3]%2==0) {
            total++;
            scoreA += 1;
            A[3]++;
        }
        else {
            RB4.setChecked(false);
            total--;
            scoreA--;
            A[3]--;
        }
        displayForTeamA(scoreA);
    }
    public void addOneForTeamA_5(View view)
    {
        if(A[4]%2==0) {
            total++;
            scoreA += 1;
            A[4]++;
        }
        else {
            RB5.setChecked(false);
            total--;
            scoreA--;
            A[4]--;
        }
        displayForTeamA(scoreA);
    }
    public void addOneForTeamA_6(View view)
    {
        if(A[5]%2==0) {
            total++;
            scoreA += 1;
            A[5]++;
        }
        else {
            RB6.setChecked(false);
            total--;
            scoreA--;
            A[5]--;
        }
        displayForTeamA(scoreA);
    }
    public void addOneForTeamA_7(View view)
    {
        if(A[6]%2==0) {
            total++;
            scoreA += 1;
            A[6]++;
        }
        else {
            RB7.setChecked(false);
            total--;
            scoreA--;
            A[6]--;
        }
        displayForTeamA(scoreA);
    }
    public void addOneForTeamA_8(View view)
    {
        if(A[7]%2==0) {
            total++;
            scoreA += 1;
            A[7]++;
        }
        else {
            RB8.setChecked(false);
            total--;
            scoreA--;
            A[7]--;
        }
        displayForTeamA(scoreA);
    }
    public void addOneForTeamA_9(View view)
    {
        if(A[8]%2==0) {
            total++;
            scoreA += 1;
            A[8]++;
        }
        else {
            RB9.setChecked(false);
            total--;
            scoreA--;
            A[8]--;
        }
        displayForTeamA(scoreA);
    }
    public void addOneForTeamA_10(View view)
    {
        if(A[9]%2==0) {
            total++;
            scoreA += 1;
            A[9]++;
        }
        else {
            RB10.setChecked(false);
            total--;
            scoreA--;
            A[9]--;
        }
        displayForTeamA(scoreA);
    }
    public void addOneForTeamA_11(View view)
    {
        if(A[10]%2==0) {
            total++;
            scoreA += 1;
            A[10]++;
        }
        else {
            RB11.setChecked(false);
            total--;
            scoreA--;
            A[10]--;
        }
        displayForTeamA(scoreA);
    }
    public void addOneForTeamA_12(View view)
    {
        if(A[11]%2==0) {
            total++;
            scoreA += 1;
            A[11]++;
        }
        else {
            RB12.setChecked(false);
            total--;
            scoreA--;
            A[11]--;
        }
        displayForTeamA(scoreA);
    }
    public void addOneForTeamA_13(View view)
    {
        if(A[12]%2==0) {
            total++;
            scoreA += 1;
            A[12]++;
        }
        else {
            RB13.setChecked(false);
            total--;
            scoreA--;
            A[12]--;
        }
        displayForTeamA(scoreA);
    }
    public void addOneForTeamA_14(View view)
    {
        if(A[13]%2==0) {
            total++;
            scoreA += 1;
            A[13]++;
        }
        else {
            RB14.setChecked(false);
            total--;
            scoreA--;
            A[13]--;
        }
        displayForTeamA(scoreA);
    }
    public void addOneForTeamA_15(View view)
    {
        if(A[14]%2==0) {
            total++;
            scoreA += 1;
            A[14]++;
        }
        else {
            RB15.setChecked(false);
            total--;
            scoreA--;
            A[14]--;
        }
        displayForTeamA(scoreA);
    }
    public void addOneForTeamB_1(View view)
    {
        if(B[0]%2==0) {
            total++;
            scoreB += 1;
            B[0]++;
        }
        else {
            RA1.setChecked(false);
            total--;
            scoreB--;
            B[0]--;
        }
        displayForTeamB(scoreB);
    }
    public void addOneForTeamB_2(View view)
    {
        if(B[1]%2==0) {
            total++;
            scoreB += 1;
            B[1]++;
        }
        else {
            RA2.setChecked(false);
            total--;
            scoreB--;
            B[1]--;
        }
        displayForTeamB(scoreB);
    }
    public void addOneForTeamB_3(View view)
    {
        if(B[2]%2==0) {
            total++;
            scoreB += 1;
            B[2]++;
        }
        else {
            RA3.setChecked(false);
            total--;
            scoreB--;
            B[2]--;
        }
        displayForTeamB(scoreB);
    }
    public void addOneForTeamB_4(View view)
    {
        if(B[3]%2==0) {
            total++;
            scoreB += 1;
            B[3]++;
        }
        else {
            RA4.setChecked(false);
            total--;
            scoreB--;
            B[3]--;
        }
        displayForTeamB(scoreB);
    }
    public void addOneForTeamB_5(View view)
    {
        if(B[4]%2==0) {
            total++;
            scoreB += 1;
            B[4]++;
        }
        else {
            RA5.setChecked(false);
            total--;
            scoreB--;
            B[4]--;
        }
        displayForTeamB(scoreB);
    }
    public void addOneForTeamB_6(View view)
    {
        if(B[5]%2==0) {
            total++;
            scoreB += 1;
            B[5]++;
        }
        else {
            RA6.setChecked(false);
            total--;
            scoreB--;
            B[5]--;
        }
        displayForTeamB(scoreB);
    }
    public void addOneForTeamB_7(View view)
    {
        if(B[6]%2==0) {
            total++;
            scoreB += 1;
            B[6]++;
        }
        else {
            RA7.setChecked(false);
            total--;
            scoreB--;
            B[6]--;
        }
        displayForTeamB(scoreB);
    }
    public void addOneForTeamB_8(View view)
    {
        if(B[7]%2==0) {
            total++;
            scoreB += 1;
            B[7]++;
        }
        else {
            RA8.setChecked(false);
            total--;
            scoreB--;
            B[7]--;
        }
        displayForTeamB(scoreB);
    }
    public void addOneForTeamB_9(View view)
    {
        if(B[8]%2==0) {
            total++;
            scoreB += 1;
            B[8]++;
        }
        else {
            RA9.setChecked(false);
            total--;
            scoreB--;
            B[8]--;
        }
        displayForTeamB(scoreB);
    }
    public void addOneForTeamB_10(View view)
    {
        if(B[9]%2==0) {
            total++;
            scoreB += 1;
            B[9]++;
        }
        else {
            RA10.setChecked(false);
            total--;
            scoreB--;
            B[9]--;
        }
        displayForTeamB(scoreB);
    }
    public void addOneForTeamB_11(View view)
    {
        if(B[10]%2==0) {
            total++;
            scoreB += 1;
            B[10]++;
        }
        else {
            RA11.setChecked(false);
            total--;
            scoreB--;
            B[10]--;
        }
        displayForTeamB(scoreB);
    }
    public void addOneForTeamB_12(View view)
    {
        if(B[11]%2==0) {
            total++;
            scoreB += 1;
            B[11]++;
        }
        else {
            RA12.setChecked(false);
            total--;
            scoreB--;
            B[11]--;
        }
        displayForTeamB(scoreB);
    }
    public void addOneForTeamB_13(View view)
    {
        if(B[12]%2==0) {
            total++;
            scoreB += 1;
            B[12]++;
        }
        else {
            RA13.setChecked(false);
            total--;
            scoreB--;
            B[12]--;
        }
        displayForTeamB(scoreB);
    }
    public void addOneForTeamB_14(View view)
    {
        if(B[13]%2==0) {
            total++;
            scoreB += 1;
            B[13]++;
        }
        else {
            RA14.setChecked(false);
            total--;
            scoreB--;
            B[13]--;
        }
        displayForTeamB(scoreB);
    }
    public void addOneForTeamB_15(View view)
    {
        if(B[14]%2==0) {
            total++;
            scoreB += 1;
            B[14]++;
        }
        else {
            RA15.setChecked(false);
            total--;
            scoreB--;
            B[14]--;
        }
        displayForTeamB(scoreB);
    }
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void resetScores(View view)
    {
        RA1.setChecked(false);
        RA2.setChecked(false);
        RA3.setChecked(false);
        RA4.setChecked(false);
        RA5.setChecked(false);
        RA6.setChecked(false);
        RA7.setChecked(false);
        RA8.setChecked(false);
        RA9.setChecked(false);
        RA10.setChecked(false);
        RA11.setChecked(false);
        RA12.setChecked(false);
        RA13.setChecked(false);
        RA14.setChecked(false);
        RA15.setChecked(false);
        RB1.setChecked(false);
        RB2.setChecked(false);
        RB3.setChecked(false);
        RB4.setChecked(false);
        RB5.setChecked(false);
        RB6.setChecked(false);
        RB7.setChecked(false);
        RB8.setChecked(false);
        RB9.setChecked(false);
        RB10.setChecked(false);
        RB11.setChecked(false);
        RB12.setChecked(false);
        RB13.setChecked(false);
        RB14.setChecked(false);
        RB15.setChecked(false);
        for(int i=0;i<15;i++)
        {
            A[i]=0;B[i]=0;
        }
        total=-1;
        scoreA=0;
        scoreB=0;
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
                intent.putExtra("GAME_ID", BEER_PONG);
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
        String gameName = BEER_PONG;
        String aName=teamANameHeading.getText().toString().trim();
        String bName=teamBNameHeading.getText().toString().trim();
        String comment= comment_Save;
        int image =R.drawable.beer_pong;

        String id = beerPong.push().getKey();
        AddScores addScores = new AddScores(image,id,teamAScore,teamBScore,d,gameName,aName,bName,comment);
        beerPong.child(MainActivity.USER_ID).child(gameName).child(id).setValue(addScores);
        Toast.makeText(this,"Event Saved Successfully",Toast.LENGTH_LONG).show();
    }

}

