package com.prabhav.play;
        import android.os.CountDownTimer;
        import android.os.Handler;
        import android.os.SystemClock;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import java.util.ArrayList;

        import static com.prabhav.play.R.id.pauseButton;
        import static com.prabhav.play.R.id.timer;

public class WiffleBallActivity extends AppCompatActivity {
    int scoreA,scoreB,total=-1;
    TextView textView ;
    Button start, pause, reset;
    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L ;
    Handler handler;
    int Seconds, Minutes, MilliSeconds ;
    ArrayList<Integer> Arr = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiffle_ball);
        textView = (TextView)findViewById(R.id.timer);
        start = (Button)findViewById(R.id.startButton);
        pause = (Button)findViewById(R.id.pauseButton);
        reset = (Button)findViewById(R.id.resetButton);
        handler = new Handler() ;
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);
                reset.setEnabled(false);
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeBuff += MillisecondTime;
                handler.removeCallbacks(runnable);
                reset.setEnabled(true);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Arr.clear();
                total=-1;
                scoreA=0;
                scoreB=0;
                displayForTeamA(scoreA);
                displayForTeamB(scoreB);
                MillisecondTime = 0L ;
                StartTime = 0L ;
                TimeBuff = 0L ;
                UpdateTime = 0L ;
                Seconds = 0 ;
                Minutes = 0 ;
                MilliSeconds = 0 ;
                textView.setText("00:00:00");
            }
        });
    }
    public Runnable runnable = new Runnable() {

        public void run() {
            MillisecondTime = SystemClock.uptimeMillis() - StartTime;
            UpdateTime = TimeBuff + MillisecondTime;
            Seconds = (int) (UpdateTime / 1000);
            Minutes = Seconds / 60;
            Seconds = Seconds % 60;
            MilliSeconds = (int) (UpdateTime % 1000);
            textView.setText("" + Minutes + ":" + String.format("%02d", Seconds) + ":" + String.format("%03d", MilliSeconds));
            handler.postDelayed(this, 0);
        }
    };

    public void addThreeForTeamA(View view)
    {
        total++;
        Arr.add(3);
        scoreA+=3;
        displayForTeamA(scoreA);
    }
    public void addSixForTeamA(View view)
    {
        total++;
        Arr.add(6);
        scoreA+=6;
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
    public void addSixForTeamB(View view)
    {
        total++;
        Arr.add(16);
        scoreB+=6;
        displayForTeamB(scoreB);
    }
    public void addOneForTeamB(View view)
    {
        total++;
        Arr.add(11);
        scoreB+=1;
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
        else if(scoreA>0&&Arr.get(total)==6){scoreA-=6;Arr.remove(total);total--;}
        else if(scoreB>0&&Arr.get(total)==11){scoreB-=1;Arr.remove(total);total--;}
        else if(scoreB>0&&Arr.get(total)==12){scoreB-=2;Arr.remove(total);total--;}
        else if(scoreB>0&&Arr.get(total)==13){scoreB-=3;Arr.remove(total);total--;}
        else if(scoreB>0&&Arr.get(total)==16){scoreB-=6;Arr.remove(total);total--;}
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }

}

