package com.prabhav.play;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.util.Pools;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {

    public static String USER_ID;
    //firebase auth object
    private FirebaseAuth firebaseAuth;
    ListView listView;
    WordAdapter adapter;
    static ArrayList<Word> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String email="";
        if (user != null) {
            // User is signed in
            email = user.getEmail();
        }
        if (email != null) {
            email = email.replace(".","_");
            email = email.replace("@","__");
        }
        USER_ID = email;

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
        arrayList = new ArrayList<>();
        arrayList.add(new Word("AMERICAN FOOTBALL", R.drawable.american_football_image));
        arrayList.add(new Word("ARCHERY", R.drawable.archery_image));
        arrayList.add(new Word("BADMINTON", R.drawable.badminton_image));
//        arrayList.add(new Word("BASEBALL", R.drawable.baseball_image));
        arrayList.add(new Word("BASKETBALL", R.drawable.basketball_image));
        arrayList.add(new Word("BEER PONG", R.drawable.beer_pong));
//        arrayList.add(new Word("BILLIARDS", R.drawable.billiards_image));
        arrayList.add(new Word("BOSSABALL", R.drawable.bossaball_image));
        arrayList.add(new Word("BOWLS", R.drawable.bowls_image));
        arrayList.add(new Word("BOXING", R.drawable.boxing_image));
        arrayList.add(new Word("BROOMBALL", R.drawable.broomball_image));
//        arrayList.add(new Word("BULL RIDING", R.drawable.bull_riding_image));
//        arrayList.add(new Word("CHESS", R.drawable.chess_image));
        arrayList.add(new Word("CRICKET", R.drawable.cricket_image));
        arrayList.add(new Word("CROQUET", R.drawable.croquet_image));
        arrayList.add(new Word("CURLING", R.drawable.curling_image));
//        arrayList.add(new Word("DARTS", R.drawable.darts_image));
//        arrayList.add(new Word("DODGEBALL", R.drawable.dodgeball_image));
        arrayList.add(new Word("FENCING", R.drawable.fencing_image));
        arrayList.add(new Word("FIELD HOCKEY", R.drawable.field_hockey_image));
        arrayList.add(new Word("FOOTBALL", R.drawable.football_image));
//        arrayList.add(new Word("GOLF", R.drawable.golf_image));
        arrayList.add(new Word("HANDBALL", R.drawable.handball_image));
//        arrayList.add(new Word("HORSE RACING", R.drawable.horse_racing_image));
        arrayList.add(new Word("ICE HOCKEY", R.drawable.ice_hockey_image));
//        arrayList.add(new Word("JUDO", R.drawable.judo_image));
        arrayList.add(new Word("KABADDI", R.drawable.kabaddi_image));
        arrayList.add(new Word("KARATE", R.drawable.karate_icon));
//        arrayList.add(new Word("KICKBALL", R.drawable.kickball_image));
        arrayList.add(new Word("KICKBOXING", R.drawable.kickboxing_image));
        arrayList.add(new Word("KIN-BALL", R.drawable.kin_ball_image));
        arrayList.add(new Word("KORFBALL", R.drawable.korfball_image));
//        arrayList.add(new Word("LACROSSE", R.drawable.lacrosse_image));
//        arrayList.add(new Word("MIXED MARTIAL ARTS", R.drawable.mixed_martial_arts_image));
//        arrayList.add(new Word("MUAY THAI", R.drawable.muay_thai_image));
        arrayList.add(new Word("NETBALL", R.drawable.netball_image));
//        arrayList.add(new Word("PADEL", R.drawable.padel_image));
        arrayList.add(new Word("PICKLEBALL", R.drawable.pickleball_image));
//        arrayList.add(new Word("PLATFORM TENNIS", R.drawable.platform_tennis_image));
        arrayList.add(new Word("POLO", R.drawable.polo_image));
        arrayList.add(new Word("POOL", R.drawable.pool_image));
//        arrayList.add(new Word("QUIDDITCH", R.drawable.quidditch_image));
        arrayList.add(new Word("RACQUETBALL", R.drawable.racquetball_image));
//        arrayList.add(new Word("ROLLER DERBY", R.drawable.roller_derby_image));
//        arrayList.add(new Word("ROUNDERS", R.drawable.rounders_image));
        arrayList.add(new Word("RUGBY", R.drawable.rugby_image));
        arrayList.add(new Word("SEPAK TAKRAW", R.drawable.sepak_takraw_image));
//        arrayList.add(new Word("SHUFFLEBOARD", R.drawable.shuffleboard_image));
        arrayList.add(new Word("SLAMBALL", R.drawable.slamball_image));
//        arrayList.add(new Word("SNOOKER", R.drawable.snooker_image));
//        arrayList.add(new Word("SOFTBALL", R.drawable.softball_image));
        arrayList.add(new Word("SQUASH", R.drawable.squash_image));
//        arrayList.add(new Word("SUMO WRESTLING", R.drawable.sumo_wreshtling_image));
        arrayList.add(new Word("TABLE TENNIS", R.drawable.table_tennis_image));
//        arrayList.add(new Word("TAEKWONDO", R.drawable.taekwondo_image));
//        arrayList.add(new Word("TEE-BALL", R.drawable.tee_ball_image));
//        arrayList.add(new Word("TENNIS", R.drawable.tennis_image));
        arrayList.add(new Word("THROWBALL", R.drawable.throwball_image));
//        arrayList.add(new Word("THUMB WRESTLING", R.drawable.thumb_wrestling_image));
//        arrayList.add(new Word("TUG OF WAR", R.drawable.tug_of_war_image));
//        arrayList.add(new Word("ULTIMATE FRISBEE", R.drawable.ultimate_frisbee_image));
//        arrayList.add(new Word("UNDERWATER HOCKEY", R.drawable.underwater_hockey_image));
        arrayList.add(new Word("VOLLEYBALL", R.drawable.volleyball_image));
//        arrayList.add(new Word("WATER POLO", R.drawable.waterpolo_image));
//        arrayList.add(new Word("WIFFLE BALL", R.drawable.wiffleball_image));
        adapter = new WordAdapter(this, arrayList);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (arrayList.get(position).getGameName().equals("AMERICAN FOOTBALL")) {
                    Intent myIntent = new Intent(view.getContext(), AmericanFootballActivity.class);
                    startActivityForResult(myIntent, 0);
                }

                if (arrayList.get(position).getGameName().equals("ARCHERY")) {
                    Intent myIntent = new Intent(view.getContext(), ArcheryActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("BADMINTON")) {
                    Intent myIntent = new Intent(view.getContext(), BadmintonActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("BASEBALL")) {
                    Intent myIntent = new Intent(view.getContext(), BaseBallActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("BASKETBALL")) {
                    Intent myIntent = new Intent(view.getContext(), BasketBallActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("BEER PONG")) {
                    Intent myIntent = new Intent(view.getContext(), BeerPongActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("BILLIARDS")) {
                    Intent myIntent = new Intent(view.getContext(), BilliardsActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("BOSSABALL")) {
                    Intent myIntent = new Intent(view.getContext(), BossaballActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("BOWLS")) {
                    Intent myIntent = new Intent(view.getContext(), BowlsActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("BOXING")) {
                    Intent myIntent = new Intent(view.getContext(), BoxingActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("BROOMBALL")) {
                    Intent myIntent = new Intent(view.getContext(), BroomBallActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("BULL RIDING")) {
                    Intent myIntent = new Intent(view.getContext(), BullRidingActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("CHESS")) {
                    Intent myIntent = new Intent(view.getContext(), ChessActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("CRICKET")) {
                    Intent myIntent = new Intent(view.getContext(), CricketActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("CROQUET")) {
                    Intent myIntent = new Intent(view.getContext(), CroquetActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("CURLING")) {
                    Intent myIntent = new Intent(view.getContext(), CurlingActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("DARTS")) {
                    Intent myIntent = new Intent(view.getContext(), DartsActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("DODGEBALL")) {
                    Intent myIntent = new Intent(view.getContext(), DodgeBallActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("FENCING")) {
                    Intent myIntent = new Intent(view.getContext(), FencingActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("FIELD HOCKEY")) {
                    Intent myIntent = new Intent(view.getContext(), FieldHockeyActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("FOOTBALL")) {
                    Intent myIntent = new Intent(view.getContext(), FootBallActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("GOLF")) {
                    Intent myIntent = new Intent(view.getContext(), GolfActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("HANDBALL")) {
                    Intent myIntent = new Intent(view.getContext(), HandBallActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("HORSE RACING")) {
                    Intent myIntent = new Intent(view.getContext(), HorseRacingActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("ICE HOCKEY")) {
                    Intent myIntent = new Intent(view.getContext(), IceHockeyActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("JUDO")) {
                    Intent myIntent = new Intent(view.getContext(), JudoActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("KABADDI")) {
                    Intent myIntent = new Intent(view.getContext(), KabaddiActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("KARATE")) {
                    Intent myIntent = new Intent(view.getContext(), KarateActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("KICKBALL")) {
                    Intent myIntent = new Intent(view.getContext(), KickBallActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("KICKBOXING")) {
                    Intent myIntent = new Intent(view.getContext(), KickBoxingActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("KIN-BALL")) {
                    Intent myIntent = new Intent(view.getContext(), KinBallActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("KORFBALL")) {
                    Intent myIntent = new Intent(view.getContext(), KorfBallActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("LACROSSE")) {
                    Intent myIntent = new Intent(view.getContext(), LacrosseActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("MIXED MARTIAL ARTS")) {
                    Intent myIntent = new Intent(view.getContext(), MixedMartialArtsActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("MUAY THAI")) {
                    Intent myIntent = new Intent(view.getContext(), MuayThaiActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("NETBALL")) {
                    Intent myIntent = new Intent(view.getContext(), NetBallActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("PADEL")) {
                    Intent myIntent = new Intent(view.getContext(), PadelActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("PICKLEBALL")) {
                    Intent myIntent = new Intent(view.getContext(), PickleBallActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("PLATFORM TENNIS")) {
                    Intent myIntent = new Intent(view.getContext(), PlatformTennisActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("POLO")) {
                    Intent myIntent = new Intent(view.getContext(), PoloActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("POOL")) {
                    Intent myIntent = new Intent(view.getContext(), PoolActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("QUIDDITCH")) {
                    Intent myIntent = new Intent(view.getContext(), QuidditchActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("RACQUETBALL")) {
                    Intent myIntent = new Intent(view.getContext(), RacquetBallActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("ROLLER DERBY")) {
                    Intent myIntent = new Intent(view.getContext(), RollerDerbyActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("ROUNDERS")) {
                    Intent myIntent = new Intent(view.getContext(), RoundersActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("RUGBY")) {
                    Intent myIntent = new Intent(view.getContext(), RugbyActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("SEPAK TAKRAW")) {
                    Intent myIntent = new Intent(view.getContext(), SepakTakrawActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("SHUFFLEBOARD")) {
                    Intent myIntent = new Intent(view.getContext(), ShuffleBoardActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("SLAMBALL")) {
                    Intent myIntent = new Intent(view.getContext(), SlamBallActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("SNOOKER")) {
                    Intent myIntent = new Intent(view.getContext(), SnookerActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("SOFTBALL")) {
                    Intent myIntent = new Intent(view.getContext(), SoftBallActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("SQUASH")) {
                    Intent myIntent = new Intent(view.getContext(), SquashActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("SUMO WRESTLING")) {
                    Intent myIntent = new Intent(view.getContext(), SumoWrestlingActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("TABLE TENNIS")) {
                    Intent myIntent = new Intent(view.getContext(), TableTennisActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("TAEKWONDO")) {
                    Intent myIntent = new Intent(view.getContext(), TeakwondoActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("TEE-BALL")) {
                    Intent myIntent = new Intent(view.getContext(), TeeBallActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("TENNIS")) {
                    Intent myIntent = new Intent(view.getContext(), TennisActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("THROWBALL")) {
                    Intent myIntent = new Intent(view.getContext(), ThrowBallActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("THUMB WRESTLING")) {
                    Intent myIntent = new Intent(view.getContext(), ThumbWrestlingActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("TUG OF WAR")) {
                    Intent myIntent = new Intent(view.getContext(), TugOfWarActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("ULTIMATE FRISBEE")) {
                    Intent myIntent = new Intent(view.getContext(), UltimateFrisbeeActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("UNDERWATER HOCKEY")) {
                    Intent myIntent = new Intent(view.getContext(), UnderWaterHockeyActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("VOLLEYBALL")) {
                    Intent myIntent = new Intent(view.getContext(), VolleyBallActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("WATER POLO")) {
                    Intent myIntent = new Intent(view.getContext(), WaterPoloActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (arrayList.get(position).getGameName().equals("WIFFLE BALL")) {
                    Intent myIntent = new Intent(view.getContext(), WiffleBallActivity.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.profile:
                usersProfile();
                return true;
            case R.id.about:
                aboutUS();
                return true;
            case R.id.rateUs:
                rateOurApp();
                return true;
            case R.id.help:
                helpUser();
                return true;
            case R.id.share:
                shareApp();
                return true;
            case R.id.logout:
                //logging out the user
                firebaseAuth.signOut();
                //closing activity
                finish();
                //starting login activity
                startActivity(new Intent(this, LoginActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void shareApp() {
        String shareBody = "https://play.google.com/store/apps/details?id=com.prabhav.play";

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "APP NAME (Open it in Google Play Store to Download the Application)");

        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    private void aboutUS() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        // Setting Dialog Title
        alertDialog.setTitle("About Scorer");

        // Setting Dialog Message
        alertDialog.setMessage("Hello! This app is used to record the scores in different games. You can save the events details and see them in future.\n" +
        "This app will help the judges, umpires, referees etc to decide the winner of the game and will also help the players to improve their performance. If you like this app please Share and Rate the app.");

        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.ic_report_black_24dp);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

    private void rateOurApp() {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
        //Copy App URL from Google Play Store.
        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.prabhav.play"));
        startActivity(intent);
    }

    private void helpUser() {
        String mailto = "mailto:prabhav.garg.boss@gmail.com";

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse(mailto));

        try {
            startActivity(emailIntent);
        } catch (ActivityNotFoundException e) {
            //TODO: Handle case where no email app is available
        }
    }
    private void usersProfile() {
        AlertDialog alertDialog = new AlertDialog.Builder(
                MainActivity.this).create();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email="";
        if (user != null) {
            // User is signed in
            email = user.getEmail();
        }


        // Setting Dialog Title
        alertDialog.setTitle("User Email Id:");

        // Setting Dialog Message
        alertDialog.setMessage(email);

        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.user);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        // Retrieve the SearchView and plug it into SearchManager
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    adapter.filter("");
                    listView.clearTextFilter();
                } else {
                    adapter.filter(newText);
                }
                return true;
            }
        });

        return true;
    }
}
