public class PartidaJ {
    private TablaJ tabla;
    private int ciclos;

    public PartidaJ(int matriz, int celulas, int ciclos) {
        tabla = new TablaJ(matriz);
        tabla.poblarTabla(celulas);
        if (ciclos > 20) {
            System.out.println("Son muchos ciclos, se usara 20 como maximo. ");
            this.ciclos = 20;
        } else {
            this.ciclos = ciclos;
        }
    }

    public void jugar() {
        System.out.println("Ciclo: 1.");
        tabla.imprimir();

        for (int i = 2; i <= ciclos; i++) {
            TablaJ proximo = tabla;

            for (CelulaJ[] fila : tabla.getTabla()) {
                for (CelulaJ columna : fila) {
                    columna.setVecinos(tabla.cantVecinos(columna));
                }
            }
            for (CelulaJ[] fila : tabla.getTabla()) {
                for (CelulaJ c : fila) {
                    int vecinos = c.getVecinos();
                    if (vecinos == 3) {
                        c.nacer();
                    } else if (vecinos < 2 || vecinos > 3) {
                        c.matar();
                    } else if (vecinos == 2 || vecinos == 3) {
                        c.sobrevive();
                    }
                }
            }
            tabla = proximo;
            System.out.println("Ciclo: " + i);
            tabla.imprimir();

        }
    }
}
