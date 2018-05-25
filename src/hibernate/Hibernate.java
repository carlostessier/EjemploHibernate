/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import ejemplo.dao.EmpleadoDAOImp;
import java.util.Date;


import ejemplo.jpa.Empleados;
import ejemplo.jpa.Departamentos;
import ejemplo.service.EmpleadoServicio;

public class Hibernate {
	public static void main(String[] args) {
                System.out.println("Ejemplo Hibernate");
                
                EmpleadoServicio empServ = new EmpleadoServicio();            
               
		Empleados emp = new Empleados();
                Empleados empR;
		emp.setApellido("Pepito");
		emp.setEmpNo((short)2);
		emp.setDepartamentos(new Departamentos((byte)1,null,null,null));
                emp.setFechaAlt(new Date());
                emp.setOficio("Hibernate");
                emp.setSalario(1000.0f);  
                
               	System.out.println("Guardamos Employee ID=" + emp.getEmpNo());

                //empServ.addEmpelado(emp);                  
	
                System.out.println("Cargamos objeto");
		empR = empServ.getEmpleado(emp.getEmpNo()); 		
		
		System.out.println("Employee=" +empR.getEmpNo()+":"+ empR.getApellido()+":"+empR.getOficio());	
                
                for(Empleados empl: empServ.getEmpleados()){
                    System.out.println(empl.getEmpNo() +" "+ empl.getApellido());
                }
                
                for(Object[] cad: empServ.getEmpleadoPorDep((short)1)){
                    System.out.println(cad[0]+" "+cad[1]);
                }

	}

}
