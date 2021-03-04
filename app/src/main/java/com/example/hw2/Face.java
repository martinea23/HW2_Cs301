package com.example.hw2;

//Written By Axl Martinez

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

import java.util.Random;

public class Face extends SurfaceView implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {

    int hairStyle = 1 ;

    int HairRedVal = 30;
    int HairGreenVal = 60;
    int HairBlueVal = 90;

    int EyesRedVal = 90;
    int EyesGreenVal = 60;
    int EyesBlueVal = 30;


    int SkinRedVal = 190;
    int SkinGreenVal = 85;
    int SkinBlueVal = 150;

    Paint Black = new Paint();
    Paint customHair = new Paint();
    Paint customEyes = new Paint();
    Paint customSkin = new Paint();

    int decider = 1;

    public Face(Context context, AttributeSet attrs){
        super(context,attrs);
        setWillNotDraw(false);
        setBackgroundColor(Color.WHITE);
        Black.setColor(Color.BLACK);

    }
    // Seek Bar
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean X){

                if (getDecider() == 1) {
                    switch (seekBar.getId()) {
                        case R.id.R_Bar:
                            setHairRedVal(progress);
                           // Log.d("Red Bar", "" + getHairRedVal());
                            invalidate();
                            break;

                        case R.id.B_Bar:
                            setHairBlueVal(progress);
                           // Log.d("Blue Bar", "" + getHairBlueVal());
                            invalidate();
                            break;

                        case R.id.G_bar:
                            setHairGreenVal(progress);
                           // Log.d("Green Bar", "" + getHairGreenVal());
                            invalidate();
                            break;
                    }
                }
                else if (getDecider() == 2){
                    switch (seekBar.getId()) {
                        case R.id.R_Bar:
                            setEyesRedVal(progress);
                           // Log.d("Red Bar", "" + getEyesRedVal());
                            invalidate();
                            break;

                        case R.id.B_Bar:
                            setEyesBlueVal(progress);
                           // Log.d("Blue Bar", "" + getEyesBlueVal());
                            invalidate();
                            break;

                        case R.id.G_bar:
                            setEyesGreenVal(progress);
                           // Log.d("Green Bar", "" + getEyesGreenVal());
                            invalidate();
                            break;
                    }
                }
                else if (getDecider() ==  3){
                    switch (seekBar.getId()) {
                        case R.id.R_Bar:
                            setSkinRedVal(progress);
                            //Log.d("Red Bar", "" + getSkinRedVal());
                            invalidate();
                            break;

                        case R.id.B_Bar:
                            setSkinBlueVal(progress);
                            //Log.d("Blue Bar", "" + getSkinBlueVal());
                            invalidate();
                            break;

                        case R.id.G_bar:
                            setSkinGreenVal(progress);
                            //Log.d("Green Bar", "" + getSkinGreenVal());
                            invalidate();
                            break;
                    }
                }
        }

    public void onStartTrackingTouch(SeekBar seekBar){
    }
    public void onStopTrackingTouch(SeekBar seekBar){
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
            invalidate();
        }
        else if (X.equals(E)) {
            decider = 2;
            invalidate();
        }
        else if (X.equals(S)) {
            decider = 3;
            invalidate();
        }
        Log.d("Decider is============", " "+ getDecider());

        // the seek bars have to switch position when there is a change in the radio group
        if (getDecider() == 1) {

            //SeekBar Bar = (SeekBar)findViewById(R.id.R_Bar);// crashes for some reason
          //  Bar.setProgress(getHairRedVal());

        }
        else if (getDecider() == 2){

        }
        else if(getDecider() == 3){

        }

    }

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


    //Button
    @Override
    public void onClick(View v){
        randomizer();
    }

    // Getters and Setters


    public void setHairRedVal(int hairRedVal) {
        HairRedVal = hairRedVal;
    }

    public void setHairBlueVal(int hairBlueVal) {
        HairBlueVal = hairBlueVal;
    }

    public void setHairGreenVal(int hairGreenVal) {
        HairGreenVal = hairGreenVal;
    }

    public void setEyesRedVal(int eyesRedVal) {
        EyesRedVal = eyesRedVal;
    }

    public void setEyesBlueVal(int eyesBlueVal) {
        EyesBlueVal = eyesBlueVal;
    }

    public void setEyesGreenVal(int eyesGreenVal) {
        EyesGreenVal = eyesGreenVal;
    }

    public void setSkinRedVal(int skinRedVal) {
        SkinRedVal = skinRedVal;
    }

    public void setSkinGreenVal(int skinGreenVal) {
        SkinGreenVal = skinGreenVal;
    }

    public void setSkinBlueVal(int skinBlueVal) {
        SkinBlueVal = skinBlueVal;
    }

    public int getEyesBlueVal() {
        return EyesBlueVal;
    }

    public int getEyesGreenVal() {
        return EyesGreenVal;
    }

    public int getEyesRedVal() {
        return EyesRedVal;
    }

    public int getHairBlueVal() {
        return HairBlueVal;
    }

    public int getHairGreenVal() {
        return HairGreenVal;
    }

    public int getHairRedVal() {
        return HairRedVal;
    }

    public int getSkinBlueVal() {
        return SkinBlueVal;
    }

    public int getSkinGreenVal() {
        return SkinGreenVal;
    }

    public int getSkinRedVal() {
        return SkinRedVal;
    }

    public int getHairStyle(){
        return this.hairStyle;
    }

    public int getDecider(){
        return decider;
    }

    public void setHairStyle(int hairStyle) {
        this.hairStyle = hairStyle;
    }

    public void randomizer(){
        Random random = new Random();
        Log.d("Button","Random Works");
        int rand1 = random.nextInt(256);
        int rand2 = random.nextInt(256);
        int rand3 = random.nextInt(256);
        int rand4 = random.nextInt(256);
        int rand5 = random.nextInt(256);
        int rand6 = random.nextInt(256);
        int rand7 = random.nextInt(256);
        int rand8 = random.nextInt(256);
        int rand9 = random.nextInt(256);

        int randH = random.nextInt(3);

        setSkinBlueVal(rand1);
        setSkinGreenVal(rand2);
        setSkinRedVal(rand3);
        setHairBlueVal(rand4);
        setHairGreenVal(rand5);
        setHairRedVal(rand6);
        setEyesBlueVal(rand7);
        setEyesGreenVal(rand8);
        setEyesRedVal(rand9);

        setHairStyle(randH);
        invalidate();
    }

    @Override
    public void onDraw(Canvas canvas){
        customEyes.setARGB(255, getEyesRedVal(),getEyesGreenVal(),getEyesBlueVal());
        customSkin.setARGB(255,getSkinRedVal(),getSkinGreenVal(),getSkinBlueVal());
        customHair.setARGB(255,getHairRedVal(),getHairGreenVal(),getHairBlueVal());
        canvas.drawCircle(375,275,250, customSkin);
        canvas.drawCircle(275, 225,50,customEyes);
        canvas.drawCircle(475, 225,50,customEyes);
        canvas.drawArc(200,250,550,475,180,-180,false,Black);
        drawHair(canvas, getHairStyle());
    }

    public void drawHair(Canvas canvas, int HairStyle){
        if (HairStyle == 1){
            canvas.drawArc(100,0,650,320, 180,180,false, customHair);
        }
        else if (HairStyle == 2){
            for(int X = 0; X<250;X++) {
                canvas.drawLine(125 + X, 300 - X, 125 + X, 25, customHair);
            }
            for(int X = 0; X<250; X++){
                canvas.drawLine(375 + X, 50 + X, 375 + X, 25, customHair);
            }
        }
    }
}
