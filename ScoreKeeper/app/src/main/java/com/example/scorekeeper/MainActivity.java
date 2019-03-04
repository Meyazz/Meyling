package com.example.scorekeeper;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Member variables for holding the score
    private int mScore1;
    private int mScore2;

    //Member variable for the two score TextView
    private TextView mScoreText1;
    private TextView mScoreText2;

    //Tag to be used as the key in OnSavedInstanceState
    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Inflate the layout
        setContentView(R.layout.activity_main);

        //Find the TextViews by ID
        mScoreText1 = (TextView)findViewById(R.id.score_1);
        mScoreText2 = (TextView)findViewById(R.id.score_2);

        //Restores the scores if there is savedInstanceState
        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            //Set the score text views
            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu from XML
        getMenuInflater().inflate(R.menu.main_menu, menu);

        //Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night).setTitle(R.string.day);
        } else{
            menu.findItem(R.id.night).setTitle(R.string.night);
        }
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Check if the correct item was clicked
        if(item.getItemId()==R.id.night){
            //Get the night mode state of the app
            int nightMode = AppCompatDelegate.getDefaultNightMode();

            //Set the theme mode for the restarted activity
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }

            //Recreate the activity for the theme change to take effect
            recreate();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void decreaseScore(View view) {
        //Get the ID of the button that was clicked
        int viewID = view.getId();
        switch (viewID){
            //If it was on Team 1
            case R.id.decreaseTeam1:
                //Decrement the score and update the TextView
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            //If it was Team 2
            case R.id.decreaseTeam2:
                //Decrement the score and update the TextView
                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    public void increaseScore(View view) {
        //Get the ID of the button that was clicked
        int viewID = view.getId();
        switch (viewID){
            //If it was on Team 1
            case R.id.increaseTeam1:
                //Increment the score and update the TextView
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            //If it was Team 2
            case R.id.increaseTeam2:
                //Increment the score and update the TextView
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //Save the scores
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }

}