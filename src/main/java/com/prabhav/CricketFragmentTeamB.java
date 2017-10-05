package com.prabhav.play;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CricketFragmentTeamB extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_cricket_fragment_team_b, container, false);
        view.findViewById(R.id.cricket_start_frg_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CricketActivity) getActivity()).showCricketDialogue();
            }
        });
        view.findViewById(R.id.addZeroCricketB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfGameCountinues() && checkIfTeamAOvers()) {
                    ((CricketActivity) getActivity()).addZeroForTeamB();
                } else if (!checkIfGameCountinues()) {
                    ((CricketActivity) getActivity()).saveData();
                }
            }
        });
        view.findViewById(R.id.addOneCricketB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfGameCountinues() && checkIfTeamAOvers()) {
                    ((CricketActivity) getActivity()).addOneForTeamB();
                } else if (!checkIfGameCountinues()) {
                    ((CricketActivity) getActivity()).saveData();
                }
            }
        });
        view.findViewById(R.id.addTwoCricketB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfGameCountinues() && checkIfTeamAOvers()) {
                    ((CricketActivity) getActivity()).addTwoForTeamB();
                } else if (!checkIfGameCountinues()) {
                    ((CricketActivity) getActivity()).saveData();
                }
            }
        });
        view.findViewById(R.id.addThreeCricketB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfGameCountinues() && checkIfTeamAOvers()) {
                    ((CricketActivity) getActivity()).addThreeForTeamB();
                } else if (!checkIfGameCountinues()) {
                    ((CricketActivity) getActivity()).saveData();
                }
            }
        });
        view.findViewById(R.id.addFourCricketB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfGameCountinues() && checkIfTeamAOvers()) {
                    ((CricketActivity) getActivity()).addFourForTeamB();
                } else if (!checkIfGameCountinues()) {
                    ((CricketActivity) getActivity()).saveData();
                }
            }
        });
        view.findViewById(R.id.addSixCricketB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfGameCountinues() && checkIfTeamAOvers()) {
                    ((CricketActivity) getActivity()).addSixForTeamB();
                } else if (!checkIfGameCountinues()) {
                    ((CricketActivity) getActivity()).saveData();
                }
            }
        });
        view.findViewById(R.id.addWicketCricketB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfGameCountinues() && checkIfTeamAOvers()) {
                    ((CricketActivity) getActivity()).addWicketForTeamB();
                } else if (!checkIfGameCountinues()) {
                    ((CricketActivity) getActivity()).saveData();
                }
            }
        });
        view.findViewById(R.id.addWideBallCricketB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfGameCountinues() && checkIfTeamAOvers()) {
                    ((CricketActivity) getActivity()).addWideBallForTeamB();
                } else if (!checkIfGameCountinues()) {
                    ((CricketActivity) getActivity()).saveData();
                }
            }
        });
        view.findViewById(R.id.addNoBallCricketB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfGameCountinues() && checkIfTeamAOvers()) {
                    ((CricketActivity) getActivity()).addNoBallForTeamB();
                } else if (!checkIfGameCountinues()) {
                    ((CricketActivity) getActivity()).saveData();
                }
            }
        });
        view.findViewById(R.id.cricket_undo_B).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CricketActivity) getActivity()).undoScore(2);
            }
        });
        view.findViewById(R.id.cricket_reset_B).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CricketActivity) getActivity()).resetScores();
            }
        });
        return view;
    }

    private boolean checkIfGameCountinues() {
        if (CricketActivity.finalNumberOfPlayers != ((CricketActivity) getActivity()).numberOfWicketsTeamB && CricketActivity.finalNumberOfOvers != ((CricketActivity) getActivity()).oversB / 6) {
            return true;
        }
        return false;
    }

    private boolean checkIfTeamAOvers() {
        if (CricketActivity.finalNumberOfPlayers == ((CricketActivity) getActivity()).numberOfWicketsTeamA || CricketActivity.finalNumberOfOvers == ((CricketActivity) getActivity()).oversA / 6) {
            return true;
        }
        return false;
    }
}
