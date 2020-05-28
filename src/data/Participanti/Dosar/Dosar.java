package data.Participanti.Dosar;

import java.util.List;

public class Dosar {
    private Integer numar_documente;
    private List<String> lista_documente;

    public Dosar(Integer numar_documente, List<String> lista_documente){
        this.numar_documente = numar_documente;
        this.lista_documente = lista_documente;
    }

    public List<String> get_documente() { return lista_documente; }

    public void set_documente(List<String> lista_documente) { this.lista_documente = lista_documente; }

    public Integer get_numar_documente() { return numar_documente; }

    public void set_numar_documente(Integer numar_documente) { this.numar_documente = numar_documente; }
}