package Modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class Estrangeiro {
    private int id;
    private String nome;
    private String pais;
    private String cidade;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private static List<Estrangeiro> estrangeiros;

    public Estrangeiro(int id,String nome, String pais, String cidade, LocalDate dataInicio, LocalDate dataFim)
    {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
        this.cidade = cidade;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDataInicio() {
        return dataInicio.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public static List<Estrangeiro> getEstrangeiros() {
        if (estrangeiros == null) {
            estrangeiros = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                estrangeiros.add(new Estrangeiro(i,"Intercambista " + i, "País " + i, "Cidade " + i, LocalDate.now().plusDays(i), LocalDate.now().plusMonths(i+1*3)));
            }

        }
        return estrangeiros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public List<Anfitriao> getAnfitrioesDisponiveis(){
        List<Anfitriao> disponiveis = new ArrayList();
        for(Anfitriao anf : Anfitriao.getAnfitrioes()){
            if(anf.verificaDisponiveis(dataInicio, dataFim)!=null){
                disponiveis.add(anf);
            }
        }
        return disponiveis;
    }
}
