package name.osher.gil.minivmac.ii;

import name.osher.gil.minivmac.ii.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Keyboard extends LinearLayout implements View.OnClickListener {

	private Button mToggleButton;
	private Boolean mIsAlt;
	
	public Keyboard(Context context, AttributeSet attrs) {
		super(context, attrs);
		setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        setWeightSum(1.0f);

        LayoutInflater.from(context).inflate(R.layout.keyboard, this, true);
        mIsAlt = false;
		
		mToggleButton = (Button) findViewById(R.id.btnHide);
		mToggleButton.setOnClickListener(this);
	}

	public void onClick(View v) {
		this.removeAllViews();
		
		if (mIsAlt) {
			LayoutInflater.from(this.getContext()).inflate(R.layout.keyboard, this, true);
			mIsAlt = false;
		} else {
			LayoutInflater.from(this.getContext()).inflate(R.layout.keyboard_alt, this, true);
			mIsAlt = true;
		}
		
		mToggleButton = (Button) findViewById(R.id.btnHide);
		mToggleButton.setOnClickListener(this);
	}

}
