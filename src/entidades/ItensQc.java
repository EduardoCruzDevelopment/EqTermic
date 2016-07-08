
package entidades;

public class ItensQc {
    
    private Integer id;
    private Double tFinal, tInicial,massa,capTermic;

    public Double getCapTermic() {
        return capTermic;
    }

    public void setCapTermic(Double capTermic) {
        this.capTermic = capTermic;
    }
    private Elemento elemento;

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public ItensQc() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double gettFinal() {
        return tFinal;
    }

    public void settFinal(Double tFinal) {
        this.tFinal = tFinal;
    }

    public Double gettInicial() {
        return tInicial;
    }

    public void settInicial(Double tInicial) {
        this.tInicial = tInicial;
    }

    public Double getMassa() {
        return massa;
    }

    public void setMassa(Double massa) {
        this.massa = massa;
    }
    
    
    
}
