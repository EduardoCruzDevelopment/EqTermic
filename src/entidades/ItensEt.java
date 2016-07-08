
package entidades;

public class ItensEt {
    
    private Integer id;
    private Double tempIni,massa,capTermic;
    private Elemento elemento;

    
    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTempIni() {
        return tempIni;
    }

    public void setTempIni(Double tempIni) {
        this.tempIni = tempIni;
    }

    public Double getMassa() {
        return massa;
    }

    public void setMassa(Double massa) {
        this.massa = massa;
    }

    public Double getCapTermic() {
        return capTermic;
    }

    public void setCapTermic(Double capTermic) {
        this.capTermic = capTermic;
    }

}
