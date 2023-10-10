package parcialito;

public class Baño {
    protected boolean tieneDucha;
    protected boolean tieneBañera;
    protected boolean tieneBidet;

    public Baño(boolean tieneDucha, boolean tieneBañera, boolean tieneBidet) {
        this.tieneDucha = tieneDucha;
        this.tieneBañera = tieneBañera;
        this.tieneBidet = tieneBidet;
    }

    public boolean getBaño() {
        return this.tieneBidet;
    }
}
