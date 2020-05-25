package ru.payts.cycleactivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SomeFragment fragment;
    Button fragmentButton;

    private String TAG = "[CycleActivity]";
    private TextView firstRunTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstRunTextView = (TextView) findViewById(R.id.textViewInfo);
        if (savedInstanceState == null) {
            firstRunTextView.setText("Первый запуск!");
        } else {
            firstRunTextView.setText("Повторный запуск!");
        }
        makeMessage("onCreate()");

        fragmentButton = (Button) findViewById(R.id.buttonFragment);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragment = new SomeFragment();

        fragmentTransaction.add(R.id.container, fragment).commit();

        fragmentButton.setOnClickListener(onButtonClickListener);
    }

    Button.OnClickListener onButtonClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            SomeFragment newFragment = null;

            newFragment = new SomeFragment();

            // Create new transaction
            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack
            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        makeMessage("onStart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        firstRunTextView.setText("Повторный запуск!!");
        makeMessage("onRestoreInstanceState()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        makeMessage("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        makeMessage("onPause()");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        makeMessage("onSaveInstanceState()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        makeMessage("onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        makeMessage("onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        makeMessage("onDestroy()");
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonExit:
                finish();
                break;
            default:
                break;
        }
    }

    private void makeMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        Log.i(TAG, message);
    }
}