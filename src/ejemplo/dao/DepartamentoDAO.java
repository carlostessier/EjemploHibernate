package ejemplo.dao;

import java.util.ArrayList;
import java.util.List;

import ejemplo.jpa.Departamentos;
import ejemplo.jpa.Empleados;
import org.hibernate.Session;

public interface DepartamentoDAO {

    public Session openCurrentSession();

    public Session openCurrentSessionwithTransaction();

    public void closeCurrentSession();

    public void closeCurrentSessionwithTransaction();

    public Session getCurrentSession();

    /*	Crear un método que pida por al usuario un departamento e imprima el Apellido, oficio y salario de los empleados de ese departamento. 
     *
     */
    public ArrayList<Departamentos> getDepartamentoPorEmp(int empNo);

    public List<Departamentos> getDepartamentos();

    public Departamentos getDepartamento(int empNo);

    public Departamentos getDepartamento(short depNo);

    public void persist(Departamentos departamento);

    public void updateDepartamento(Departamentos departamento);

    public void deleteDepartamento(Departamentos departamento);

    public void addDepartamento(Departamentos departamento);

}
