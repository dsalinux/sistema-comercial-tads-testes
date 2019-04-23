/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifg.sistemacomercial.logic;

import br.edu.ifg.sistemacomercial.dao.ProdutoDAO;
import br.edu.ifg.sistemacomercial.entity.Produto;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author danilo
 */
public class ProdutoLogic implements CrudLogic<Produto, Integer>{

    @Inject
    private ProdutoDAO dao;
    
    @Override
    public Produto salvar(Produto entity) {
        try {
            dao.salvar(entity);
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void deletar(Produto entity) {
        try {
            dao.deletar(entity);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Produto buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> buscar(Produto entity) {
        try {
            return dao.listar();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
