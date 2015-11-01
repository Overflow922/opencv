/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import org.bytedeco.javacpp.opencv_photo;
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
    
    public void  blurGauss()
    {
        int aperture = 3;
        GaussianBlur(cvarrToMat(this.image), cvarrToMat(this.image), new Size(aperture, aperture), 0, 0, BORDER_DEFAULT);
    }
    
    public void  blurMedian()
    {
        medianBlur(cvarrToMat(this.image), cvarrToMat(this.image), 11);
    }
    
    
    private void MorphEx(int radius, int type, int iterations)
    {
        IplImage temp = cvCreateImage(cvGetSize(this.image), IPL_DEPTH_8U, 1);
        IplConvKernel kern = cvCreateStructuringElementEx(radius*2+1, radius*2+1, radius, radius, CV_SHAPE_RECT);
        cvMorphologyEx( this.image, 
                        this.image, 
                        temp,
                        kern,
                        type,
                        iterations);
    }
    
    public void morphClose(int radius, int iterations )
    {
        MorphEx(radius, CV_MOP_CLOSE, iterations);
    }
    
    public void denoizeGrayscale()
    {
  //      fastNlMeansDenoising(this.image, this.image, 10, 21, 7);
    }
    private void sobel(int dx, int dy, int aperture)
    {
        cvSobel(this.image, this.image, dx, dy, aperture);
    }
    
    public void sobel()   {this.sobel(1, 0, 3);}
    public void sobel(int dx, int dy)   
    { 
        if (dy + dy == 0)
            this.sobel();
        else
        {
            this.sobel(dx, dy, 3);
        }
    }
    
    public void Dilate(int dilation_size)
    {
        Mat element1 = getStructuringElement(MORPH_RECT, new  Size(2*dilation_size + 1, 2*dilation_size+1));
        dilate(cvarrToMat(this.image), cvarrToMat(this.image), element1);
    }
    
    public void threshold()
    {
        adaptiveThreshold(cvarrToMat(this.image), cvarrToMat(this.image), 225, CV_ADAPTIVE_THRESH_MEAN_C, CV_THRESH_BINARY_INV, 11, 11);
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
