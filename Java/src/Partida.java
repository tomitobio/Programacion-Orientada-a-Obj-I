public class Partida {
    private Tablero espacio;
    // private int matrizSize;
    private int generaciones;

    // Contructor, crea el espacio y puebla la matriz con n celulas vivas en
    // posiciones al azar
    public Partida(int matriz, int celulas, int generaciones) {
        espacio = new Tablero(matriz);
        espacio.crearMundo(celulas);
        if (generaciones > 20) {
            System.out.println("El numero de generaciones es muy grande, se utilizara el maximo de 20");
            this.generaciones = 20;
        } else {
            this.generaciones = generaciones;
        }
        // this.matrizSize = matriz;
    }

    // Aplica las reglas del juego y genera las diferentes generaciones
    public void evolucion() {
        System.out.println("Generacion: 1");
        espacio.imprimir();

        for (int i = 2; i <= generaciones; i++) {

            Tablero proximaGeneracion = espacio;

            for (Celula[] fila : espacio.getMundo()) {
                for (Celula celula : fila) {
                    celula.setVecinos(espacio.cantVecinos(celula));
                }
            }

            for (Celula[] fila : proximaGeneracion.getMundo()) {
                for (Celula celula : fila) {
                    int vecinos = celula.getVecinos();
                    if (vecinos == 3) {
                        celula.nacer();
                    } else if (vecinos < 2 || vecinos > 3) {
                        celula.morir();
                    } else if (vecinos == 2 || vecinos == 3) {
                        celula.sobrevivir();
                    }
                }
            }
            espacio = proximaGeneracion;
            System.out.println("Generacion: " + i);
            espacio.imprimir();
        }
    }
}
