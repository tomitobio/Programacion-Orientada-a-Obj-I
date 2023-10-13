package SistemaDeNotificacion;

interface Notificable {
    void enviarNotificacion(int tipo);
}

class CorreoElectronico implements Notificable {
    // Atributos
    private String casilla;
    private String contra;

    // Constructor
    public CorreoElectronico(String casilla, String contra) {
        this.casilla = casilla;
        this.contra = contra;
    }

    // Getters
    public String getCasilla() {
        return casilla;
    }

    public String getContra() {
        return contra;
    }

    // Notificable
    @Override
    public void enviarNotificacion(int tipo) {
        if ((tipo > 0) && (tipo <= 4)) {
            switch (tipo) {
                case 1:
                    System.out.println("Mail o contraseña erróneos, vuelva a intentar.");
                    break;
                case 2:
                    System.out.println("Bienvenido al sistema.");
                    break;
                case 3:
                    System.out.println("Mail enviado.");
                    break;
                case 4:
                    System.out.println("Mail recibido.");
                    break;
            }
        } else {
            System.out.println("Este numero no es un tipo de notificacion");
        }

    }
}

public class SistemaNotificacion {
    public static void main(String[] args) {
        CorreoElectronico correo1 = new CorreoElectronico("tomastobio", "44851196");
        boolean recibioCorreo = true;
        if (recibioCorreo) {
            correo1.enviarNotificacion(4);
        }
    }
}
