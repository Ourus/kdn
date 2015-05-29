package modelos;

import java.util.ArrayList;

public class Ementa extends Disciplina
{

    private String periodoLetivo;
    private ArrayList<BasesTecnologicas> basesTecnologicas = new ArrayList();
    private ArrayList<Habilidades> habilidade = new ArrayList();
    private ArrayList<Competencias> competencias = new ArrayList();

  // periodo letivo 
    public String getPeriodoLetivo() {
        return periodoLetivo;
    }

    public void setPeriodoLetivo(String periodoLetivo) {
        this.periodoLetivo = periodoLetivo;
    }
    
    
    
    
    // ========================================================================

   // bases tecnologicas 
    public ArrayList<BasesTecnologicas> getBasesTecnologicas() {
        return basesTecnologicas;
    }

    public void setBasesTecnologicas(ArrayList<BasesTecnologicas> basesTecnologicas) {
        this.basesTecnologicas = basesTecnologicas;
    }

    public void setsetBasesTecnologicas(BasesTecnologicas basetec) {
        this.basesTecnologicas.add(basetec);
    }

  // Habilidades
    public ArrayList<Habilidades> getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(ArrayList<Habilidades> habilidade) {
        this.habilidade = habilidade;
    }

    public void setHabilidade(Habilidades habili) {
        this.habilidade.add(habili);
    }

   // competencias 
    public ArrayList<Competencias> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(ArrayList<Competencias> competencias) {
        this.competencias = competencias;
    }

    public void setCompetencias(Competencias compte) {
        this.competencias.add(compte);
    }
}
