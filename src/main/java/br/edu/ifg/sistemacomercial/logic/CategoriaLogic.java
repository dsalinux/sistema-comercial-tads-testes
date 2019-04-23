/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifg.sistemacomercial.logic;

import br.edu.ifg.sistemacomercial.dao.CategoriaDAO;
import br.edu.ifg.sistemacomercial.entity.Categoria;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author danilo
 */
public class CategoriaLogic implements CrudLogic<Categoria, Integer>{

    @Inject
    private CategoriaDAO dao;
    
    @Override
    public Categoria salvar(Categoria entity) {
        try {
            dao.salvar(entity);
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void deletar(Categoria entity) {
        try {
            dao.deletar(entity);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Categoria buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categoria> buscar(Categoria entity) {
        try {
            return dao.listar();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
