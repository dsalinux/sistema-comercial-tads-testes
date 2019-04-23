package br.edu.ifg.sistemacomercial.logic;

import java.io.Serializable;
import java.util.List;

public interface CrudLogic<E extends Serializable, ID extends Serializable> extends Serializable{
    
    public E salvar(E entity);
    public void deletar(E entity);
    public E buscarPorId(ID id);
    public List<E> buscar(E entity);
    
}
