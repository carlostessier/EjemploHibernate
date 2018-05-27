/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.service;

import ejemplo.dao.DepartamentoDAOImp;
import ejemplo.jpa.Departamentos;
import ejemplo.jpa.Empleados;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class DepartamentoServicio {

    private DepartamentoDAOImp depDAO;

    public DepartamentoServicio() {
        depDAO = new DepartamentoDAOImp();
    }

    public void persist(Departamentos departamento) {
        depDAO.openCurrentSessionwithTransaction();
        depDAO.persist(departamento);
        depDAO.closeCurrentSessionwithTransaction();

    }

    public List<Departamentos> getDepartamentos() {
        depDAO.openCurrentSession();
        List<Departamentos> listDep = depDAO.getDepartamentos();
        depDAO.closeCurrentSession();
        return listDep;
    }

    public Departamentos getDepartamento(short depNo) {
        depDAO.openCurrentSession();
        Departamentos dep = depDAO.getDepartamento(depNo);
        depDAO.closeCurrentSession();
        return dep;

    }

    public void updateDepartamento(Departamentos departamento) {
        depDAO.openCurrentSessionwithTransaction();
        depDAO.updateDepartamento(departamento);
        depDAO.closeCurrentSessionwithTransaction();

    }

    public void deleteDepartamento(Departamentos departamento) {
        depDAO.openCurrentSessionwithTransaction();
        depDAO.deleteDepartamento(departamento);
        depDAO.closeCurrentSessionwithTransaction();
    }

    public void addDepartamento(Departamentos departamento) {
        depDAO.openCurrentSessionwithTransaction();
        depDAO.addDepartamento(departamento);
        depDAO.closeCurrentSessionwithTransaction();
    }

    public DepartamentoDAOImp depDAO() {
        return depDAO;
    }
}
