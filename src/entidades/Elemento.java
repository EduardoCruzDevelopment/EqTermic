
package entidades;


public class Elemento {
    
    private Integer id;
    private String nome;
    private Double cSolido, cLiquido, cGasoso,lFusao,lVapor,tF,tV;

    public Double gettF() {
        return tF;
    }

    public void settF(Double tF) {
        this.tF = tF;
    }

    public Double gettV() {
        return tV;
    }

    public void settV(Double tV) {
        this.tV = tV;
    }

    public Elemento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getcSolido() {
        return cSolido;
    }

    public void setcSolido(Double cSolido) {
        this.cSolido = cSolido;
    }

    public Double getcLiquido() {
        return cLiquido;
    }

    public void setcLiquido(Double cLiquido) {
        this.cLiquido = cLiquido;
    }

    public Double getcGasoso() {
        return cGasoso;
    }

    public void setcGasoso(Double cGasoso) {
        this.cGasoso = cGasoso;
    }

    public Double getlFusao() {
        return lFusao;
    }

    public void setlFusao(Double lFusao) {
        this.lFusao = lFusao;
    }

    public Double getlVapor() {
        return lVapor;
    }

    public void setlVapor(Double lVapor) {
        this.lVapor = lVapor;
    }

    

}
