package com.example.edittextext;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;

// Este no
// import android.widget.EditText;

// El componente EditTextExtendido se extiende de EditText
public class EditTextExtendido extends AppCompatEditText
{
    private Paint pNegro;
    private Paint pBlanco;

    // Hay que reescribiremos siempre los constructores heredados. En este caso son tres
    public EditTextExtendido(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        pinceles();
    }

    public EditTextExtendido(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        pinceles();
    }

    public EditTextExtendido(Context context)
    {
        super(context);
        pinceles();
    }

    // Función que inicia las pinceles que usamos para pintar el cuadradito negro
    private void pinceles()
    {
        pNegro = new Paint(Paint.ANTI_ALIAS_FLAG);
        pNegro.setColor(Color.BLACK);
        pNegro.setStyle(Style.FILL);

        pBlanco = new Paint(Paint.ANTI_ALIAS_FLAG);
        pBlanco.setColor(Color.WHITE);
        pBlanco.setTextSize(20);
    }

    // Para modificar el aspecto del EditText hay que reescribir este método
    @Override
    public void onDraw(Canvas canvas)
    {
        //Invocamos al método de la superclase (EditText)
        super.onDraw(canvas);

        //Dibujamos el fondo negro del contador en la parte de arriba derecha
        canvas.drawRect(this.getWidth()-30, 0, this.getWidth()-5, 25, pNegro);

        //Dibujamos el número de caracteres sobre el contador
        canvas.drawText("" + this.getText().toString().length(), this.getWidth(), this.getHeight(), pBlanco);
    }
}
