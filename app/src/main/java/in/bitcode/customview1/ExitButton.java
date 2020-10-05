package in.bitcode.customview1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

@SuppressLint("AppCompatCustomView")
public class ExitButton extends Button {

    private Context mContext;
    private boolean mExitable;

    public ExitButton(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public ExitButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        mExitable = true;
        this.setLayoutParams(
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        );
        setText("Exit");
        setOnClickListener( new BtnExitClickListener());
    }

    public void setExitable(boolean exitable) {
        mExitable = exitable;
    }

    public boolean isExitable() {
        return mExitable;
    }

    private class BtnExitClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            if( !mExitable ) {
                Toast.makeText( mContext, "Button is not exitable!", Toast.LENGTH_LONG).show();
                return;
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setMessage("Are you sure, you want to exit the app?");
            builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    System.exit(0);
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    dialogInterface.dismiss();
                }
            });
            builder.create().show();

        }
    }
}
