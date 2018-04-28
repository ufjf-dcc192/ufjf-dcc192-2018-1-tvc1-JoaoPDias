package Modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class Anfitriao {
    private int id;
    private String nome;
    private String categoria;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String telefone;
    private static List<Anfitriao> anfitrioes;

    public Anfitriao(int id,String nome, String categoria, LocalDate dataInicio, LocalDate dataFim) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.telefone = "+5524993056"+id+1*10;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataInicio() {
        return dataInicio.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public LocalDate getFim() {
        return dataFim;
    }
    
    

    public static List<Anfitriao> getAnfitrioes() {
        if (anfitrioes == null) {
            anfitrioes = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                anfitrioes.add(new Anfitriao(i,"Anfitriao " + i, "Categoria " + i, LocalDate.now(), LocalDate.now().plusMonths(i+1*2)));
            }

        }
        return anfitrioes;
    }

    public Anfitriao verificaDisponiveis(LocalDate inicio, LocalDate fim) {
        if ((inicio.isEqual(this.getInicio()) || inicio.isAfter(this.getInicio())) && ((fim.isEqual(this.getFim())) || fim.isBefore(this.getFim()))) {
            return this;
        }
        return null;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
