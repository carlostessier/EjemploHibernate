package ejemplo.dao;

import java.util.ArrayList;
import java.util.List;

import ejemplo.jpa.Departamentos;

public interface DepartamentoDAO {
	

	
	/*	Crear un método que pida por al usuario un departamento e imprima el Apellido, oficio y salario de los empleados de ese departamento. 
	 *
	 */
	public ArrayList<Departamentos> getDepartamentoPorEmp(int empNo);
	
	public List<Departamentos> getDepartamentos();
	
	public Departamentos getDepartamento(int empNo);
	
	public void updateDepartamento(Departamentos departamento);
	
	public void deleteDepartamento(int depNo);

}
