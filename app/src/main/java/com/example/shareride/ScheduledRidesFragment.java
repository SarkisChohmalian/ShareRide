package com.example.shareride;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

public class ScheduledRidesFragment extends Fragment {

    private CalendarView calendarView;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scheduled_rides, container, false);

        // Find the CalendarView in the layout
        calendarView = view.findViewById(R.id.calendarView);

        return view;
    }
}
