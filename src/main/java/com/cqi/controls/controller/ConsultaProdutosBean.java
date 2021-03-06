package com.cqi.controls.controller;

import java.io.Serializable;
/**
 * @author cqfb
 */
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cqi.controls.model.Produto;
import com.cqi.controls.repository.Produtos;
import com.cqi.controls.repository.filter.ProdutoFilter;
import com.cqi.controls.util.jsf.FacesUtil;

/**
 * Um managed bean é capaz de passivação (e ativação) SE E SOMENTE SE a classe
 * de bean é serializável
 * 
 * @author cqfb
 *
 */

@Named
@ViewScoped
public class ConsultaProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;

	private ProdutoFilter filtro;
	private List<Produto> produtosFiltrados;

	private Produto produtoSelecionado;

	public ConsultaProdutosBean() {
		filtro = new ProdutoFilter();
	}
	
	public void excluir() {
		produtos.remover(produtoSelecionado);
		produtosFiltrados.remove(produtoSelecionado);
		
		FacesUtil.addInfoMessage("Produto " + produtoSelecionado.getSku() 
				+ " excluído com sucesso.");
	}

	public void pesquisar() {
		produtosFiltrados = produtos.filtrados(filtro);
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public ProdutoFilter getFiltro() {
		return filtro;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

}
