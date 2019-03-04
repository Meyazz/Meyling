package com.example.droidcafe1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    private static final String TAG_ACTIVITY = OrderActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()) {
            case R.id.same:
                if (checked)
                    displayToast(getString(R.string.chosen) +
                            getString(R.string.same_messenger));
                break;
            case R.id.next:
                if (checked)
                    displayToast(getString(R.string.chosen) +
                            getString(R.string.pickup));

                break;
                default:
                    Log.d(TAG_ACTIVITY, getString(R.string.nothing_click));

                    break;
        }
    }
}
