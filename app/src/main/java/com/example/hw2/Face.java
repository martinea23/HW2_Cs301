package com.example.hw2;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.util.Log;
import android.widget.TextView;

public class Face extends SurfaceView implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {

    int hairStyle = 0;

    int RedVal = 128;
    int GreenVal = 128;
    int BlueVal = 128;

    Paint paint = new Paint();
    Paint Black = new Paint();
    Paint custom = new Paint();

    int decider = 0;

    public Face(Context context, AttributeSet attrs){
        super(context,attrs);
        setWillNotDraw(false);
        setBackgroundColor(Color.WHITE);
        Black.setColor(Color.BLACK);

    }
    // Seek Bar
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean X){

                if (getDecider() == 0) {
                    switch (seekBar.getId()) {
                        case R.id.R_Bar:
                            setRedVal(progress);
                            Log.d("Red Bar", "" + getRedVal());
                            invalidate();
                            break;

                        case R.id.B_Bar:
                            setBlueVal(progress);
                            Log.d("Blue Bar", "" + getBlueVal());
                            invalidate();
                            break;

                        case R.id.G_bar:
                            setGreenVal(progress);
                            Log.d("Green Bar", "" + getGreenVal());
                            invalidate();
                            break;
                    }
                }
                else if (getDecider() == 1){
                    switch (seekBar.getId()) {
                        case R.id.R_Bar:
                            setRedVal(progress);
                            Log.d("Red Bar", "" + getRedVal());
                            invalidate();
                            break;

                        case R.id.B_Bar:
                            setBlueVal(progress);
                            Log.d("Blue Bar", "" + getBlueVal());
                            invalidate();
                            break;

                        case R.id.G_bar:
                            setGreenVal(progress);
                            Log.d("Green Bar", "" + getGreenVal());
                            invalidate();
                            break;
                    }
                }
                else if (getDecider() ==  2){
                    switch (seekBar.getId()) {
                        case R.id.R_Bar:
                            setRedVal(progress);
                            Log.d("Red Bar", "" + getRedVal());
                            invalidate();
                            break;

                        case R.id.B_Bar:
                            setBlueVal(progress);
                            Log.d("Blue Bar", "" + getBlueVal());
                            invalidate();
                            break;

                        case R.id.G_bar:
                            setGreenVal(progress);
                            Log.d("Green Bar", "" + getGreenVal());
                            invalidate();
                            break;
                    }
                }
        }

    public void onStartTrackingTouch(SeekBar seekBar){}
    public void onStopTrackingTouch(SeekBar seekBar){}

    // Spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        hairStyle = position;
        if (hairStyle == 0){
            Log.d("spinner", "Hair Style = bald");
            invalidate();
        }
        else if(hairStyle == 1){
            Log.d("spinner", "HairStyle = Bowl");
            invalidate();
        }
        else if (hairStyle == 2){
            invalidate();
            Log.d("spinner", "Hair Style = Square");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    //Radio Group
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId){
        RadioButton choice = (RadioButton) group.findViewById(checkedId);
        Log.d("Radio Group", "Choice: " + choice.getText().toString());
        String X = choice.getText().toString();
        String H = "Hair" ;
        String E = "Eyes";
        String S = "Skin";
        if(X.equals(H)) {
            decider = 1;
        }
        else if (X.equals(E)) {
            decider = 2;
        }
        else if (X.equals(S)) {
            decider = 3;
        }
        Log.d("Decider is============", ""+ getDecider());
            invalidate();
    }

    //Button
    @Override
    public void onClick(View v){
        Log.d("Button","Random Works");
        invalidate();
    }

    // Getters and Setters

    public void setBlueVal(int blueVal) {
        this.BlueVal = blueVal;
    }

    public void setGreenVal(int greenVal) {
        this.GreenVal = greenVal;
    }

    public void setRedVal(int redVal) {
        this.RedVal = redVal;
    }

    public int getBlueVal() {
        return this.BlueVal;
    }

    public int getGreenVal() {
        return this.GreenVal;
    }

    public int getRedVal() {
        return this.RedVal;
    }

    public int getHairStyle(){
        return hairStyle;
    }

    public int getDecider(){
        return decider;
    }

    @Override
    public void onDraw(Canvas canvas){
        custom.setARGB(255, getRedVal(),getGreenVal(),getBlueVal());
        canvas.drawCircle(375,275,250, custom);
        canvas.drawCircle(275, 225,50,Black);
        canvas.drawCircle(475, 225,50,Black);
        canvas.drawArc(200,250,550,475,180,-180,false,Black);
        drawHair(canvas, getHairStyle());
    }

    public void drawHair(Canvas canvas, int HairStyle){
        if (HairStyle == 1){
            canvas.drawArc(100,0,650,320, 180,180,false, Black);
        }
        else if (HairStyle == 2){
            for(int X = 0; X<250;X++) {
                canvas.drawLine(125 + X, 300 - X, 125 + X, 25, Black);
            }
            for(int X = 0; X<250; X++){
                canvas.drawLine(375 + X, 50 + X, 375 + X, 25, Black);
            }
        }
    }
}
