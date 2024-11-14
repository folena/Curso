package com.curso.curso.dto;

import com.Curso.Curso.entity.Aluno;
import com.Curso.Curso.entity.Endereco;

public class AlunoDTO {

    private Long id;
    private double nota;
    private boolean maisContribuicoesNoForum;
    private int cursosConcluidos;
    private boolean temVoucher;
    private boolean premium;
    private String cidade;
    private String estado;
    private String cep;

    public AlunoDTO() {
    }

    // Construtor a partir da entidade Aluno
    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nota = aluno.getNota();
        this.maisContribuicoesNoForum = aluno.isMaisContribuicoesNoForum();
        this.cursosConcluidos = aluno.getCursosConcluidos();
        this.temVoucher = aluno.isTemVoucher();
        this.premium = aluno.isPremium();
        if (aluno.getEndereco() != null) {
            this.cidade = aluno.getEndereco().getCidade();
            this.estado = aluno.getEndereco().getEstado();
            this.cep = aluno.getEndereco().getCep();
        }
    }

    // Métodos estáticos para converter entre Aluno e AlunoDTO
    public static AlunoDTO fromEntity(Aluno aluno) {
        return new AlunoDTO(aluno);
    }

    public Aluno toEntity() {
        Endereco endereco = new Endereco(this.cidade, this.estado, this.cep);
        return new Aluno(this.nota, this.maisContribuicoesNoForum, this.cursosConcluidos, this.temVoucher, this.premium, endereco);
    }

    // Getters e setters
	public void setId(Long id2, Long id) {
		this.id = id;	
	}
    
    public Long getId() {
        return id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public boolean isMaisContribuicoesNoForum() {
        return maisContribuicoesNoForum;
    }

    public void setMaisContribuicoesNoForum(boolean maisContribuicoesNoForum) {
        this.maisContribuicoesNoForum = maisContribuicoesNoForum;
    }

    public int getCursosConcluidos() {
        return cursosConcluidos;
    }

    public void setCursosConcluidos(int cursosConcluidos) {
        this.cursosConcluidos = cursosConcluidos;
    }

    public boolean isTemVoucher() {
        return temVoucher;
    }

    public void setTemVoucher(boolean temVoucher) {
        this.temVoucher = temVoucher;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }


}
