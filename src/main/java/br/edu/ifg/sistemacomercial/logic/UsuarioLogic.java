/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifg.sistemacomercial.logic;

import br.edu.ifg.sistemacomercial.dao.UsuarioDAO;
import br.edu.ifg.sistemacomercial.entity.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author danilo
 */
public class UsuarioLogic implements CrudLogic<Usuario, Long>{

    @Inject
    private UsuarioDAO dao;
    
    @Override
    public Usuario salvar(Usuario entity) {
        try {
            dao.salvar(entity);
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void deletar(Usuario entity) {
        try {
            dao.deletar(entity);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Usuario buscarPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> buscar(Usuario entity) {
        try {
            return dao.listar();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
