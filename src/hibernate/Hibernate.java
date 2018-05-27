/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import ejemplo.dao.EmpleadoDAOImp;

import ejemplo.jpa.Empleados;
import ejemplo.jpa.Departamentos;
import ejemplo.service.DepartamentoServicio;
import ejemplo.service.EmpleadoServicio;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Hibernate {

    public static void ejercicio3() {

        EmpleadoServicio empServ = new EmpleadoServicio();
        DepartamentoServicio depServ = new DepartamentoServicio();
        
        


        Departamentos departamentos[] = new Departamentos[3];
        
        departamentos[0] = new Departamentos((byte) 70, "PROGRAMACIÓN", "LEÓN", null);
        departamentos[1] = new Departamentos((byte) 80, "DISEÑO GRÁFICOS", "BARCELONA", null);
        departamentos[2] = new Departamentos((byte) 90, "RECURSOS HUMANOS", "MADRID", null);
      
        for (Departamentos dep : departamentos) {
            depServ.addDepartamento(dep);
        }
        
        Empleados empleados[] = new Empleados[5];
        empleados[0] = new Empleados((short) 4902, departamentos[0], "Fernández", "empleado", (short) 0, new Date("2000-12-17"), 1300f, 0f);
        empleados[1] = new Empleados((short) 5134, departamentos[1], "Suárez", "empleado", (short) 0, new Date("2013-01-17"), 1250f, 0f);
        empleados[2] = new Empleados((short) 1200, departamentos[1], "Ámez", "empleado", (short) 0, new Date("2002-02-28"), 2000f, 0f);
        empleados[3] = new Empleados((short) 1234, departamentos[2], "Oriol", "empleado", (short) 0, new Date("2002-06-1"), 4500f, 0f);
        empleados[4] = new Empleados((short) 2360, departamentos[1], "Pujol", "empleado", (short) 0, new Date("2006-03-30"), 2300f, 0f);
        
  

        for (Empleados empl : empleados) {
            empServ.addEmpelado(empl);
        }

    }

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
                
         for(Object[] cad: empServ.getEmpleadoPorDep((byte)1)){
         System.out.println(cad[0]+" "+cad[1]);
         }

        //ejercicio3();
        // ejercicio 4
        //empServ.loadEmpleado((short)1);
                
        /*
        for (Empleados empl : empServ.getEmpleados()) {
            System.out.println(empl.getEmpNo() + " " + empl.getApellido());
        }

        Empleados ricachon = empServ.getEmpleadoMaxSalario();
        System.out.printf("Empleado con más salario es %s con un salario de %f", ricachon.getApellido(), ricachon.getSalario());
*/
    }

}
