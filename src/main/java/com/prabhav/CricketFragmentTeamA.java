package com.prabhav.play;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CricketFragmentTeamA extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_cricket_fragment_team_a, container, false);
        view.findViewById(R.id.cricket_start_frg_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CricketActivity) getActivity()).showCricketDialogue();
            }
        });

        view.findViewById(R.id.addZeroCricketA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfGameCountinues()) {
                    ((CricketActivity) getActivity()).addZeroForTeamA();
                }
            }
        });
        view.findViewById(R.id.addOneCricketA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfGameCountinues()) {
                    ((CricketActivity) getActivity()).addOneForTeamA();
                }
            }
        });
        view.findViewById(R.id.addTwoCricketA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfGameCountinues()) {
                    ((CricketActivity) getActivity()).addTwoForTeamA();
                }
            }
        });
        view.findViewById(R.id.addThreeCricketA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfGameCountinues()) {
                    ((CricketActivity) getActivity()).addThreeForTeamA();
                }
            }
        });
        view.findViewById(R.id.addFourCricketA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfGameCountinues()) {
                    ((CricketActivity) getActivity()).addFourForTeamA();
                }
            }
        });
        view.findViewById(R.id.addSixCricketA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfGameCountinues()) {
                    ((CricketActivity) getActivity()).addSixForTeamA();
                }
            }
        });
        view.findViewById(R.id.addWicketCricketA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfGameCountinues()) {
                    ((CricketActivity) getActivity()).addWicketForTeamA();
                }
            }
        });
        view.findViewById(R.id.addWideBallCricketA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfGameCountinues()) {
                    ((CricketActivity) getActivity()).addWideBallForTeamA();
                }
            }
        });
        view.findViewById(R.id.addNoBallCricketA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfGameCountinues()) {
                    ((CricketActivity) getActivity()).addNoBallForTeamA();
                }
            }
        });

        view.findViewById(R.id.cricket_undo_A).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CricketActivity) getActivity()).undoScore(1);
            }
        });
        view.findViewById(R.id.cricket_reset_A).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CricketActivity) getActivity()).resetScores();
            }
        });
        return view;
    }

    private boolean checkIfGameCountinues() {
        if (CricketActivity.finalNumberOfPlayers != ((CricketActivity) getActivity()).numberOfWicketsTeamA &&
                CricketActivity.finalNumberOfOvers != ((CricketActivity) getActivity()).oversA / 6) {
            return true;
        }
        return false;
    }
}
