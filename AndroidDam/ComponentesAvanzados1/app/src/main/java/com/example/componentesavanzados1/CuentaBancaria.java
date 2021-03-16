package com.example.componentesavanzados1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;

public class CuentaBancaria extends androidx.appcompat.widget.AppCompatEditText {
    private InputFilter[] filters;

    public CuentaBancaria(Context context) {
        super(context);
    }

    public CuentaBancaria(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CuentaBancaria(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        instanceFilers();
        this.setFilters(filters);

        this.setBackgroundColor(Color.RED);

        if (this.getText().toString().length() == 16)
            this.setBackgroundColor(Color.GREEN);
        else if(this.getText().toString().length() < 16)
            this.setBackgroundColor(Color.RED);

        if (this.getText().length() == 4 )
            this.append("-");

    }

    private void instanceFilers(){
        filters = new InputFilter[2];
        filters[0] = new InputFilter.LengthFilter(16);
        filters[1] = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                for (int i = start; i < end; i++){
                    if(!Character.isDigit(source.charAt(i)))
                        return "";
                }
                return null;
            }
        };
    }
}
