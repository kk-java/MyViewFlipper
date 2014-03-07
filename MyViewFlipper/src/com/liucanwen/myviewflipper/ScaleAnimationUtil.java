package com.liucanwen.myviewflipper;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class ScaleAnimationUtil
{

	public static int repeatCount;

	public static void setAmin(final ImageView img_heart)
	{

		/** 设置缩放动画 */
		final ScaleAnimation animation1 = new ScaleAnimation(1.0f, 1.4f, 1.0f,
				1.4f, Animation.RELATIVE_TO_SELF, 0.5f,
				Animation.RELATIVE_TO_SELF, 0.5f);
		animation1.setDuration(1000);// 设置动画持续时间

		final ScaleAnimation animation2 = new ScaleAnimation(1.4f, 1.0f, 1.4f,
				1.0f, Animation.RELATIVE_TO_SELF, 0.5f,
				Animation.RELATIVE_TO_SELF, 0.5f);
		animation2.setDuration(1000);

		animation1.setAnimationListener(new AnimationListener()
		{

			@Override
			public void onAnimationStart(Animation animation)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation animation)
			{

			}

			@Override
			public void onAnimationEnd(Animation animation)
			{
				img_heart.setAnimation(animation2);
				/** 开始动画 */
				animation2.startNow();

			}

		});

		animation2.setAnimationListener(new AnimationListener()
		{

			@Override
			public void onAnimationStart(Animation animation)
			{

			}

			@Override
			public void onAnimationRepeat(Animation animation)
			{

			}

			@Override
			public void onAnimationEnd(Animation animation)
			{
				repeatCount++;

				// if (repeatCount <= 3) {
				if (repeatCount <= 2)
				{
					img_heart.setAnimation(animation1);
					animation1.start();
				} else
				{
					// imgbtn_heart_start.setVisibility(View.VISIBLE);
				}

				// btn_start.setVisibility(View.VISIBLE);

			}
		});

		img_heart.setAnimation(animation1);
		animation1.start();

	}
}
