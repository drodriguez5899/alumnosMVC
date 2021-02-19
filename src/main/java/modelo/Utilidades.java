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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author David
 */
public class Utilidades {
    
    public static ArrayList<Alumno> getAlumnos(String grupo){
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_gestionAlumnos_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM alumnos WHERE grupo = '" + grupo + "'";
        Query q = manager.createNativeQuery(sql,Alumno.class);
            List<Alumnos> alumnosBD =  q.getResultList();
        for ( Alumnos a: alumnosBD ){
            Alumno miAlumno = new Alumno(a.getId(),a.getNombre(),a.getApellidos(),a.getCorreo());
            alumnos.add(miAlumno);         
        }
        return alumnos;
        
        
    }
    
    
      public static ArrayList<Alumno> getAlumnosOld(String fichero) throws FileNotFoundException, UnsupportedEncodingException{
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
