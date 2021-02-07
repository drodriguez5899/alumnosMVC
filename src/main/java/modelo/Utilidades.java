/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class Utilidades {
      public static ArrayList<Alumno> getAlumnos(String fichero) throws FileNotFoundException, UnsupportedEncodingException{
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		
               
                try {
                    BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fichero), "utf-8"));
                    String linea;
                    try{
                        while((linea = buffer.readLine())!=null) {
                            String [] atributosAlumno = linea.split(";");
                            Alumno al = new Alumno( Integer.parseInt(atributosAlumno[0]),atributosAlumno[1],
                                    atributosAlumno[2],atributosAlumno[3]);
                            alumnos.add(al);
                    }
                    
                    buffer.close();
                        
                    }catch (IOException e) {
                    
                    }
                    
                } catch (UnsupportedEncodingException e) {
                    
                }
		return alumnos;		
	}

   
    
}
