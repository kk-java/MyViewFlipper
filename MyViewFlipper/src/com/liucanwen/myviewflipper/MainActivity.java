package com.liucanwen.myviewflipper;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ViewFlipper;

public class MainActivity extends Activity
{
	private View one_layout1, two_layout2;

	private int oneOrTwo = 1;// 1 one 2 two

	private ViewFlipper viewFlipper;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

		one_layout1 = findViewById(R.id.one_layout1);
		two_layout2 = findViewById(R.id.two_layout2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * ”“…œΩ««–ªªΩÁ√Ê
	 */
	private void changeOneOrTwo()
	{
		float halfWidth = viewFlipper.getWidth() / 2.0f;
		float halfHeight = viewFlipper.getHeight() / 2.0f;
		int duration = 300;
		int depthz = 0;// viewFlipper.getWidth()/2;

		if (oneOrTwo == 1)
		{
			oneOrTwo = 2;
			Rotate3dAnimation in = new Rotate3dAnimation(-90, 0, halfWidth,
					halfHeight, depthz, false);
			in.setDuration(duration);
			in.setStartOffset(duration);

			viewFlipper.setInAnimation(in);
			Rotate3dAnimation out = new Rotate3dAnimation(0, 90, halfWidth,
					halfHeight, depthz, false);
			out.setDuration(duration);

			viewFlipper.setOutAnimation(out);
			viewFlipper.showNext();

		} else
		{
			oneOrTwo = 1;
			one_layout1.setVisibility(View.VISIBLE);
			two_layout2.setVisibility(View.GONE);

			Rotate3dAnimation in = new Rotate3dAnimation(90, 0, halfWidth,
					halfHeight, depthz, false);
			in.setDuration(duration);
			in.setStartOffset(duration);
			viewFlipper.setInAnimation(in);

			Rotate3dAnimation out = new Rotate3dAnimation(0, -90, halfWidth,
					halfHeight, depthz, false);
			out.setDuration(duration);

			viewFlipper.setOutAnimation(out);
			viewFlipper.showPrevious();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		changeOneOrTwo();

		return super.onOptionsItemSelected(item);
	}

}
