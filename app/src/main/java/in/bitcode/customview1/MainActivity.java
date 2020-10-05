package in.bitcode.customview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    private ExitButton mBtnExit;
    private CheckBox mChkExitState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChkExitState = findViewById(R.id.chkExitState);
        mBtnExit = findViewById(R.id.btnExit);

        mChkExitState.setOnCheckedChangeListener(new ChkExitStateCheckListener());
        /*mBtnExit = new ExitButton(this);
        setContentView(mBtnExit);*/
    }

    private class ChkExitStateCheckListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean state) {
            mBtnExit.setExitable(state);
        }
    }
}