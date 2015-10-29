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
public class Main {

	public static void main(String[] args) 
        {
            String filename = "D:\\Projects\\Java\\OpenCv0003\\test.jpg";
           IplImage image = cvLoadImage(filename);
        if (image != null) {
            cvSmooth(image, image);
            cvSaveImage(filename, image);
            cvReleaseImage(image);
            System.out.println("done!");
        }
        else
            System.out.println("bad adress");
	}
}
