package com.xcz1899.seekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class NumSeekbar extends SeekBar {
	private Paint paint;

	public NumSeekbar(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint = new Paint();
		paint.setAntiAlias(true);
		paint.setColor(Color.WHITE);
	}

	@Override
	protected synchronized void onDraw(Canvas canvas) {
		super.onDraw(canvas);		
		Rect ThumbRect = getThumb().getBounds();
		Rect ProgressRect = getProgressDrawable().getBounds();
		int i = (ProgressRect.bottom - ProgressRect.top) / 2;// 取默认高度的一半
		getProgressDrawable().setBounds(ProgressRect.left, ProgressRect.top + i - 2, ProgressRect.right, ProgressRect.top + i + 2);// 设置Progress的大小为4
		float f1 = paint.ascent();//tmd 居然是个负数
		float f2 = paint.descent() - f1;
		int ThumbWidth = ThumbRect.width();
		int ThumbHeight = ThumbRect.height();
		String progress=getProgress() +"";
		canvas.drawText(progress, ThumbRect.left + (ThumbWidth - paint.measureText(progress)) / 2.0f, ThumbRect.top -f1 + (ThumbHeight - f2) / 2.0F, paint);
	}

}