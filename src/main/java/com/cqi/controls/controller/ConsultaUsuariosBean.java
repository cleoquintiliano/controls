package com.cqi.controls.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cqi.controls.model.Usuario;
import com.cqi.controls.repository.Usuarios;
import com.cqi.controls.repository.filter.UsuarioFilter;
import com.cqi.controls.util.jsf.FacesUtil;

/**
 * @author cqfb
 */

@Named
@ViewScoped
public class ConsultaUsuariosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;

	private UsuarioFilter filtro;

	private List<Usuario> usuariosFiltrados;

	private Usuario usuarioSelecionado;

	public ConsultaUsuariosBean() {
		filtro = new UsuarioFilter();
	}
	
	public void excluir() {
		usuarios.remover(usuarioSelecionado);
		usuariosFiltrados.remove(usuarioSelecionado);

		FacesUtil.addInfoMessage("Usuário " + usuarioSelecionado.getNome() 
				+ " excluído com sucesso.");
	}

	public void pesquisar() {
		usuariosFiltrados = usuarios.filtrados(filtro);
	}

	public List<Usuario> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}

	public UsuarioFilter getFiltro() {
		return filtro;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

}
