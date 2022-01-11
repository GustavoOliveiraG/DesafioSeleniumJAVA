package com.javaseleniumtemplate.utils;


import atu.testrecorder.ATUTestRecorder;
import com.javaseleniumtemplate.GlobalParameters;
import org.openqa.selenium.WebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Recording {

    ATUTestRecorder recorder;

    public void startMove() throws Exception {

        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
        Date date = new Date();
        //Created object of ATUTestRecorder
        //Provide path to store videos and file name format.
        recorder = new ATUTestRecorder(GlobalParameters.REPORT_PATH,"Video-"+dateFormat.format(date),false);
        //To start video recording.
        recorder.start();
    }

    public void stopMove() throws Exception {
        recorder.stop();
    }

}
