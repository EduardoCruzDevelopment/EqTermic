
package entidades;

public class ItensQuantidadeCalor {
    
    private Integer id;
    private Double tempFinal, tempInicial,massa,capTermic;

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

    public ItensQuantidadeCalor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTempFinal() {
        return tempFinal;
    }

    public void setTempFinal(Double tempFinal) {
        this.tempFinal = tempFinal;
    }

    public Double getTempInicial() {
        return tempInicial;
    }

    public void setTempInicial(Double tempInicial) {
        this.tempInicial = tempInicial;
    }

    public Double getMassa() {
        return massa;
    }

    public void setMassa(Double massa) {
        this.massa = massa;
    }
    
    
    
}
