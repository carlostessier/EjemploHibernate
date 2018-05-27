package ejemplo.dao;

import java.util.List;

import ejemplo.jpa.Empleados;
import org.hibernate.Session;

public interface EmpleadoDAO {

    public Session openCurrentSession();

    public Session openCurrentSessionwithTransaction();

    public void closeCurrentSession();

    public void closeCurrentSessionwithTransaction();

    public Session getCurrentSession();

    /*	Crear un método que devuelva en todos los objetos empleados de un departamento dado. */
    public List<Object[]> getEmpleadoPorDep(byte depNo);

    /*Crear un método que devuelva el objeto empleado con el máximo salario.*/
    public Empleados getEmpleadoMaxSalario();

    public List<Empleados> getEmpleados();

    public Empleados getEmpleado(short depNo);
    
    public Empleados loadEmpleado(short empNo);
    
    public void persist(Empleados empleado);

    public void updateEmpleado(Empleados empleado);

    public void deleteEmpelado(Empleados empleado);

    public void addEmpelado(Empleados empleado);

}
