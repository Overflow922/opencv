/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;


/**
 *
 * @author Юрий
 */
public class Main {

	public static void main(String[] args) 
        {
            String path = "D:\\Projects\\Java\\OpenCv0003\\";
            String filename = "test1.jpg";
            myImage img = new myImage(path+filename);
        if ( img.isLoaded() ) 
        {
            img.blurGauss();
            img.save(path+"1smooth_"+filename);
            myImage gray = img.toGray();
            gray.save(path+"2gray_"+filename);
            gray.sobel(1,0);
            gray.save(path+"3sobel01_"+filename);
            gray.morphClose(10,1);
            gray.save(path+"4mopcl_"+filename);
            System.out.println("done!");
        }
        else
            System.out.println("bad adress");
	}
}
