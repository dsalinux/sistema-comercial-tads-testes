package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Produto;
import br.edu.ifg.sistemacomercial.logic.CrudLogic;
import br.edu.ifg.sistemacomercial.util.JsfUtil;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

public abstract class GenericCrud<E extends Serializable, L extends CrudLogic<E, ?>> extends JsfUtil {
    
    private E entity;
    private List<E> entitys;
    private Status statusTela;
    
    private enum Status {
        INSERINDO,
        EDITANDO,
        PESQUISANDO
    }
    
    
    @PostConstruct
    public void init(){
        entitys = new ArrayList<>();   
        statusTela = Status.PESQUISANDO;
    }
    
    public void novo(){
        try {
            entity = getEntityClass().newInstance();
            statusTela = Status.INSERINDO;
        } catch (InstantiationException ex) {
            Logger.getLogger(GenericCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GenericCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void adicionar(){
        try {
            getLogic().salvar(entity);
            addMensagem("Salvo com sucesso!");
            pesquisar();
        } catch (Exception ex) {
            addMensagemErro(ex.getMessage());
        }
    }
    
    public void remover(E entity){
        try {
            getLogic().deletar(entity);
            entitys.remove(entity);
            addMensagem("Deletado com sucesso!");
        } catch (Exception ex) {
            addMensagemErro(ex.getMessage());
        }
    }
    public void editar(E entity){
        //remover(entity);
        this.entity = entity;
        statusTela = Status.EDITANDO;
    }
    
    public void pesquisar(){
        try {
            if(!statusTela.equals(Status.PESQUISANDO)){
                statusTela = Status.PESQUISANDO;
                return;
            }
            entitys = getLogic().buscar(entity);
            if(entitys == null || entitys.isEmpty()){
                addMensagemAviso("Nenhum usuário cadastrado.");
            }
        } catch (Exception ex) {
            addMensagemErro(ex.getMessage());
        }
    }
    
    public Class<E> getEntityClass()
    {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        return (Class<E>) paramType.getActualTypeArguments()[0];
    }
    
    public E getEntity() {
        return entity;
    }

    public void setEntity(E entity) {
        this.entity = entity;
    }

    public List<E> getEntitys() {
        return entitys;
    }

    public String getStatusTela() {
        return statusTela.name();
    }

    public abstract L getLogic();
    
    
}
