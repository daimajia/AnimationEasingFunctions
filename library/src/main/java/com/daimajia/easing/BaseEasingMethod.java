/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 daimajia
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.daimajia.easing;

import android.animation.TypeEvaluator;

import java.util.ArrayList;

public abstract class BaseEasingMethod implements TypeEvaluator<Number> {
    protected float mDuration;

    private ArrayList<EasingListener> mListeners = new ArrayList<EasingListener>();

    public interface EasingListener {
        public void on(float time, float value, float start, float end, float duration);
    }

    public void addEasingListener(EasingListener l){
        mListeners.add(l);
    }

    public void addEasingListeners(EasingListener ...ls){
        for(EasingListener l : ls){
            mListeners.add(l);
        }
    }

    public void removeEasingListener(EasingListener l){
        mListeners.remove(l);
    }

    public void clearEasingListeners(){
        mListeners.clear();
    }

    public BaseEasingMethod(float duration){
        mDuration = duration;
    }

    public void setDuration(float duration) {
        mDuration = duration;
    }


    @Override
    public final Float evaluate(float fraction, Number startValue, Number endValue){
        float t = mDuration * fraction;
        float b = startValue.floatValue();
        float c = endValue.floatValue() - startValue.floatValue();
        float d = mDuration;
        float result = calculate(t,b,c,d);
        for(EasingListener l : mListeners){
            l.on(t,result,b,c,d);
        }
        return result;
    }

    public abstract Float calculate(float t, float b, float c, float d);

}
