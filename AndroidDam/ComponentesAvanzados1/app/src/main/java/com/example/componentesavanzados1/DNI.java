package com.example.componentesavanzados1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DNI extends androidx.appcompat.widget.AppCompatEditText{
    private InputFilter[] filters;
    private char[] arrayLetras = new char[] { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
    private char letraFinal;


    public DNI(Context context) {
        super(context);
    }

    public DNI(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DNI(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        instanceFilers();
        this.setFilters(filters);

        this.setBackgroundColor(Color.RED);
        letraFinal = 'F';

        if (this.getText().toString().length() >= 8)
            this.setBackgroundColor(Color.GREEN);
        else if(this.getText().toString().length() < 8)
            this.setBackgroundColor(Color.RED);

        if(this.getText().length() == 8) {
            letraFinal = arrayLetras[Integer.parseInt(String.valueOf(this.getText())) % 23];
            this.append(String.valueOf(letraFinal));
        }

    }

    private void instanceFilers(){
        filters = new InputFilter[2];
        filters[0] = new InputFilter.LengthFilter(9);
        filters[1] = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                for (int i = start; i < --end; i++){
                    if(!Character.isDigit(source.charAt(i)))
                        return "";
                }
                return null;
            }
        };
    }

}
