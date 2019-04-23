package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Categoria;
import br.edu.ifg.sistemacomercial.entity.Produto;
import br.edu.ifg.sistemacomercial.logic.CategoriaLogic;
import br.edu.ifg.sistemacomercial.logic.CrudLogic;
import br.edu.ifg.sistemacomercial.logic.ProdutoLogic;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ProdutoBean extends GenericCrud<Produto, CrudLogic<Produto, ?>>{

    @Inject
    private ProdutoLogic logic;
    
    @Inject
    private CategoriaLogic categoriaLogic;
    
    public List<Categoria> getCategorias(){
        return categoriaLogic.buscar(null);
    }
    
    @Override
    public CrudLogic<Produto, ?> getLogic() {
        return logic;
    }
    
    
}
