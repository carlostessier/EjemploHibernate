/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.service;

import ejemplo.dao.EmpleadoDAOImp;
import ejemplo.jpa.Empleados;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class EmpleadoServicio {

    private EmpleadoDAOImp emplDAO;

    public EmpleadoServicio() {
        emplDAO = new EmpleadoDAOImp();
    }

    public void persist(Empleados empleado) {
        emplDAO.openCurrentSessionwithTransaction();
        emplDAO.persist(empleado);
        emplDAO.closeCurrentSessionwithTransaction();

    }

    public List<Object[]> getEmpleadoPorDep(short depNo) {
        emplDAO.openCurrentSession();
        List<Object[]> listado = emplDAO.getEmpleadoPorDep(depNo);
        emplDAO.closeCurrentSession();
        return listado;
    }

    public Empleados getEmpleadoMaxSalario() {
        emplDAO.openCurrentSessionwithTransaction();
        Empleados emp = emplDAO.getEmpleadoMaxSalario();
        emplDAO.closeCurrentSessionwithTransaction();
        return emp;
    }

    public List<Empleados> getEmpleados() {
        emplDAO.openCurrentSession();
        List<Empleados> listEmp = emplDAO.getEmpleados();
        emplDAO.closeCurrentSession();
        return listEmp;
    }

    public Empleados getEmpleado(short depNo) {
        emplDAO.openCurrentSession();
        Empleados emp = emplDAO.getEmpleado(depNo);
        emplDAO.closeCurrentSession();
        return emp;

    }

    public void updateEmpleado(Empleados empleado) {
        emplDAO.openCurrentSessionwithTransaction();
        emplDAO.updateEmpleado(empleado);
        emplDAO.closeCurrentSessionwithTransaction();

    }

    public void deleteEmpelado(Empleados empleado) {
        emplDAO.openCurrentSessionwithTransaction();
        emplDAO.deleteEmpelado(empleado);
        emplDAO.closeCurrentSessionwithTransaction();
    }

    public void addEmpelado(Empleados empleado) {
        emplDAO.openCurrentSessionwithTransaction();
        emplDAO.addEmpelado(empleado);
        emplDAO.closeCurrentSessionwithTransaction();
    }

    public EmpleadoDAOImp emplDAO() {
        return emplDAO;
    }
}
