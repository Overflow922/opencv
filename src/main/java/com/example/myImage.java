/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;
/**
 *
 * @author Юрий
 */
public class myImage {
    private IplImage image;
    private boolean isLoaded = false;
    
    public myImage(String img_name)
    {
        image = cvLoadImage(img_name);
        
        if (image == null)
            isLoaded = false;
        else
            isLoaded = true;
    }
    
    public myImage(IplImage img)
    {
        image = img;
        if (image == null)
            isLoaded = false;
        else
            isLoaded = true;
    }
    
    public boolean isLoaded()
    {
        return isLoaded;
    }
    
    public myImage toGray()
    {
        IplImage gray = null;
        if ( isLoaded )
        {
            gray = cvCreateImage(cvGetSize(this.image), IPL_DEPTH_8U, 1);
            cvCvtColor(image, gray, CV_BGR2GRAY);
        }
        return new myImage(gray);
    }
    
    public void save(String filename)
    {
        if ( this.isLoaded())
        {
            cvSaveImage(filename, this.image);
        }
    }
    
    public void release()
    {
        image.release();
    }
}
