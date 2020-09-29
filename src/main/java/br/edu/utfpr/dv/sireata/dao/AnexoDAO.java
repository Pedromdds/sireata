package br.edu.utfpr.dv.sireata.dao;

import br.edu.utfpr.dv.sireata.dao.Algoritmos.BuscarIdDAO;
import br.edu.utfpr.dv.sireata.dao.Algoritmos.carregarObjetoDAO;
import br.edu.utfpr.dv.sireata.dao.Algoritmos.deleteDAO;
import br.edu.utfpr.dv.sireata.dao.Algoritmos.listarAtaDAO;
import br.edu.utfpr.dv.sireata.dao.Algoritmos.saveDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;

public class AnexoDAO extends AuxDAO<Anexo>{
	
    BuscarIdDAO<Anexo> buscarIdDAO;
    carregarObjetoDAO<Anexo> carregarObjetoDAO;
    delteDAO excluirDAO;
    listarAtaDAO<Anexo> listarPorAtaDAO;
    saveDAO<Anexo> salvarDAO;


    public AnexoDAO(BuscarPorIdDAO<Anexo> buscar, carregarObjetoDAO<Anexo> carregar, deleteDAO excluir, listarAtaDAO<Anexo> listar, saveDAO<Anexo> salvar){

        this.buscarIdDAO = buscar;
        this.carregarObjetoDAO = carregar;
        this.deleteDAO = delete;
        this.listarAtaDAO = listar;
        this.saveDAO = save;
    }
}
