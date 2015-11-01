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
            String filename = "test.jpg";
            myImage img = new myImage(path+filename);
        if ( img.isLoaded() ) 
        {
            myImage gray = img.toGray();
            gray.save(path+"gray_"+filename);
            System.out.println("done!");
        }
        else
            System.out.println("bad adress");
	}
}
