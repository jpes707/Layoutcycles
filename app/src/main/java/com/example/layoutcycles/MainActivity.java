package com.example.layoutcycles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {
    private static final String STORAGE_KEY = "activityCounts";
    private Gson mGson = new GsonBuilder().create();

    private SharedPreferences mShared;
    private SharedPreferences.Editor mEditor;

    private int[] counts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShared = getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE);
        mEditor = mShared.edit();
        counts = mGson.fromJson(mShared.getString(STORAGE_KEY, "[0, 0, 0, 0, 0, 0, 0]"), int[].class);

        TextView tCreate = findViewById(R.id.onCreateView);
        tCreate.setText("onCreate: " + ++counts[0]);
        TextView tPause = findViewById(R.id.onPauseView);
        tPause.setText("onPause: " + counts[3]);
        TextView tStop = findViewById(R.id.onStopView);
        tStop.setText("onStop: " + counts[4]);
        TextView tRestart = findViewById(R.id.onRestartView);
        tRestart.setText("onRestart: " + counts[5]);
        TextView tDestroy = findViewById(R.id.onDestroyView);
        tDestroy.setText("onDestroy: " + counts[6]);

        Log.i("myTag", Arrays.toString(counts));
        Log.i("myTag", mGson.toJson(counts));
        mEditor.putString(STORAGE_KEY, mGson.toJson(counts));
        mEditor.apply();
        Log.i("myTag", Arrays.toString(mGson.fromJson(mShared.getString(STORAGE_KEY, "[0, 0, 0, 0, 0, 0, 0]"), int[].class)));
        Log.i("myTag", mShared.getString(STORAGE_KEY, "[0, 0, 0, 0, 0, 0, 0]"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView t = findViewById(R.id.onStartView);
        t.setText("onStart: " + ++counts[1]);
        Log.i("myTag", Arrays.toString(counts));
        Log.i("myTag", mGson.toJson(counts));
        mEditor.putString(STORAGE_KEY, mGson.toJson(counts));
        mEditor.apply();
        Log.i("myTag", Arrays.toString(mGson.fromJson(mShared.getString(STORAGE_KEY, "[0, 0, 0, 0, 0, 0, 0]"), int[].class)));
        Log.i("myTag", mShared.getString(STORAGE_KEY, "[0, 0, 0, 0, 0, 0, 0]"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView t = findViewById(R.id.onResumeView);
        t.setText("onResume: " + ++counts[2]);
        Log.i("myTag", Arrays.toString(counts));
        Log.i("myTag", mGson.toJson(counts));
        mEditor.putString(STORAGE_KEY, mGson.toJson(counts));
        mEditor.apply();
        Log.i("myTag", Arrays.toString(mGson.fromJson(mShared.getString(STORAGE_KEY, "[0, 0, 0, 0, 0, 0, 0]"), int[].class)));
        Log.i("myTag", mShared.getString(STORAGE_KEY, "[0, 0, 0, 0, 0, 0, 0]"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        TextView t = findViewById(R.id.onPauseView);
        t.setText("onPause: " + ++counts[3]);
        Log.i("myTag", Arrays.toString(counts));
        Log.i("myTag", mGson.toJson(counts));
        mEditor.putString(STORAGE_KEY, mGson.toJson(counts));
        mEditor.apply();
        Log.i("myTag", Arrays.toString(mGson.fromJson(mShared.getString(STORAGE_KEY, "[0, 0, 0, 0, 0, 0, 0]"), int[].class)));
        Log.i("myTag", mShared.getString(STORAGE_KEY, "[0, 0, 0, 0, 0, 0, 0]"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        TextView t = findViewById(R.id.onStopView);
        t.setText("onStop: " + ++counts[4]);
        Log.i("myTag", Arrays.toString(counts));
        mEditor.putString(STORAGE_KEY, mGson.toJson(counts));
        Log.i("myTag", Arrays.toString(mGson.fromJson(mShared.getString(STORAGE_KEY, "[0, 0, 0, 0, 0, 0, 0]"), int[].class)));
        Log.i("myTag", mShared.getString(STORAGE_KEY, "[0, 0, 0, 0, 0, 0, 0]"));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        TextView t = findViewById(R.id.onRestartView);
        t.setText("onRestart: " + ++counts[5]);
        Log.i("myTag", Arrays.toString(counts));
        mEditor.putString(STORAGE_KEY, mGson.toJson(counts));
        mEditor.apply();
        Log.i("myTag", Arrays.toString(mGson.fromJson(mShared.getString(STORAGE_KEY, "[0, 0, 0, 0, 0, 0, 0]"), int[].class)));
        Log.i("myTag", mShared.getString(STORAGE_KEY, "[0, 0, 0, 0, 0, 0, 0]"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TextView t = findViewById(R.id.onDestroyView);
        counts[6]++;
        Log.i("myTag", Arrays.toString(counts));
        mEditor.putString(STORAGE_KEY, mGson.toJson(counts));
        mEditor.apply();
        Log.i("myTag", Arrays.toString(mGson.fromJson(mShared.getString(STORAGE_KEY, "[0, 0, 0, 0, 0, 0, 0]"), int[].class)));
        Log.i("myTag", mShared.getString(STORAGE_KEY, "[0, 0, 0, 0, 0, 0, 0]"));
    }
}
