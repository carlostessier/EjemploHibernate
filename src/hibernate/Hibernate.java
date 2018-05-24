/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.Date;

import org.hibernate.Session;

import ejemplo.jpa.Empleados;
import ejemplo.jpa.Departamentos;
import ejemplo.utilidades.Utilidades;

public class Hibernate {
	public static void main(String[] args) {
                System.out.println("Ejemplo Hibernate");
            
                Departamentos dep = new Departamentos();
                dep.setDeptNo((byte)1);
		Empleados emp = new Empleados();
		Empleados empR;
		emp.setApellido("Pepito");
		emp.setEmpNo((short)1);
		emp.setDepartamentos(dep);
                emp.setFechaAlt(new Date());
                emp.setOficio("Hibernate");
                emp.setSalario(1000.0f);               
               
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		
		// abrimos una transacción
		session.beginTransaction();
		// Guardamos el objeto en la sesión
                System.out.println("Guardando objeto");
		session.save(emp);
		// Commit de la transacción: sino no se hace persistente en BD, sólo actualiza el objeto
		// session.getTransaction().commit();
		System.out.println("Employee ID=" + emp.getEmpNo());
				
		//Recuperamos un objeto cuyo identificador conocemos
		//session.beginTransaction();
                System.out.println("Cargamos objeto");
		empR=(Empleados)session.load(Empleados.class,  emp.getEmpNo());
		//session.getTransaction().commit();
		System.out.println("Employee=" +empR.getEmpNo()+":"+ empR.getApellido()+":"+empR.getOficio());		

		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getSessionFactory().close();
	}

}
