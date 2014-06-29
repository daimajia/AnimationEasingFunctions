/*
 *
 *  * The MIT License (MIT)
 *  *
 *  * Copyright (c) 2014 daimajia
 *  *
 *  * Permission is hereby granted, free of charge, to any person obtaining a copy
 *  * of this software and associated documentation files (the "Software"), to deal
 *  * in the Software without restriction, including without limitation the rights
 *  * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  * copies of the Software, and to permit persons to whom the Software is
 *  * furnished to do so, subject to the following conditions:
 *  *
 *  * The above copyright notice and this permission notice shall be included in all
 *  * copies or substantial portions of the Software.
 *  *
 *  * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  * SOFTWARE.
 *
 */

package daimajia.com.eaing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;

public class DrawView extends View{

    private Paint mBackgroundPaint = new Paint();
    private Paint mLinePaint = new Paint();
    private Path path = new Path();
    private boolean start = false;

    private ArrayList<Float> mHistory = new ArrayList<Float>();

    {
        mBackgroundPaint.setColor(Color.WHITE);
        mLinePaint.setColor(Color.rgb(77,83,96));
        mLinePaint.setAntiAlias(true);
        mLinePaint.setStrokeWidth((float) 3.0);
        mLinePaint.setStyle(Paint.Style.STROKE);
    }
    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float l = 0;
        float t = getHeight() - getPaddingBottom() - dipToPixels(getContext(),217);
        float r = getWidth() - getPaddingRight();
        float b = getHeight() - dipToPixels(getContext(),60);
        canvas.drawRect(l,t,r,b,mLinePaint);
        canvas.drawPath(path,mLinePaint);
    }

    public static float dipToPixels(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }

    public void drawPoint(float time, float duration, float y){
        float p = time/duration;
        float x = p*getWidth();
        float z = getHeight() + y;
        if(!start){
            path.moveTo(x,z);
            start = true;
        }
        path.lineTo(x,z);
        invalidate();
    }

    public void clear(){
        path.reset();
        start = false;
        invalidate();
    }

}
