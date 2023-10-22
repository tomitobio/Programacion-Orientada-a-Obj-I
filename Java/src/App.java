public class App {
    public static void main(String[] args) throws Exception {
	// Inicia el juego de la vida los parametros son : TamaÃ±o de la matriz, Cantidad de celulas iniciales y cantidad de generaciones
    Partida genesis = new Partida(10,20,20);
    genesis.evolucion();
    }
}
