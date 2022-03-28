package Controller;

import DAO.CategoriaDAO;
import Model.Categoria;


import java.util.List;

public class CategoriaController {

    CategoriaDAO categoriaDAO = new CategoriaDAO();

    public void cadastrarCategoria(Categoria categoria) {
        categoriaDAO.cadastrarCategoria(categoria);
    }
    public List<Categoria> listarCategorias() {
        return categoriaDAO.listarCategorias();
    }
    public void removerCategoria(Long idCategoria) {
        categoriaDAO.removerCategoria(idCategoria);
    }
    public Categoria selecionarCategoria(long idCategoria) {
        return categoriaDAO.selecionarCategoria(idCategoria);
    }
    public void editarCategoria(Categoria categoria) {
        categoriaDAO.editarCategoria(categoria);
    }
}