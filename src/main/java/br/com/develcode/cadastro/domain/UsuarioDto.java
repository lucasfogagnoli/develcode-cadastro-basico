package br.com.develcode.cadastro.domain;

import java.time.LocalDate;

import org.springframework.data.relational.core.mapping.Table;

@Table("usuario")
public class UsuarioDto {

	private Long usu_id;

	private String usu_nome;

	private LocalDate usu_dt_nascimento;

	private byte[] usu_img_blob;

	public UsuarioDto() {
	}

	public Long getUsu_id() {
		return usu_id;
	}

	public void setUsu_id(Long usu_id) {
		this.usu_id = usu_id;
	}

	public String getUsu_nome() {
		return usu_nome;
	}

	public void setUsu_nome(String usu_nome) {
		this.usu_nome = usu_nome;
	}

	public LocalDate getUsu_dt_nascimento() {
		return usu_dt_nascimento;
	}

	public void setUsu_dt_nascimento(LocalDate usu_dt_nascimento) {
		this.usu_dt_nascimento = usu_dt_nascimento;
	}

	public byte[] getUsu_img_blob() {
		return usu_img_blob;
	}

	public void setUsu_img_blob(byte[] usu_img_blob) {
		this.usu_img_blob = usu_img_blob;
	}

}
