package SistemaDeNotificacion;

import java.util.ArrayList;

interface Notificable {
    void enviarNotificacion(int tipo);
}

interface Priorizable {
    void ordenNoti(ArrayList<Integer> orden);
}

class SMS implements Notificable, Priorizable {
    // Atributos
    private String emisor;
    private String msj;

    // Constructor
    public SMS(String emisor, String msj) {
        this.emisor = emisor;
        this.msj = msj;
    }

    // Getters
    public String getEmisor() {
        return emisor;
    }

    public String getMsj() {
        return msj;
    }

    // Notificable
    @Override
    public void enviarNotificacion(int tipo) {
        if ((tipo > 0) && (tipo <= 2)) {
            switch (tipo) {
                case 1:
                    System.out.println("Mensaje no ha sido enviado.");
                    break;
                case 2:
                    System.out.println("Nuevo mensaje de " + emisor + ".");
                    break;
            }
        } else {
            System.out.println("Este numero no es un tipo de notificacion");
        }
    }

    // Priorizable
    @Override
    public void ordenNoti(ArrayList<Integer> orden) {
        // List<Integer> orden = new ArrayList<Integer>();
        int ultimaN = orden.get(orden.size() - 1);
        if (orden.size() > 0) {
            switch (orden.get(ultimaN)) {
                case 1:
                    orden.remove((orden.size() - 1));
                    orden.add(0, ultimaN);
                    break;
                case 2:
                    orden.remove((orden.size() - 1));
                    orden.add((orden.size() - 1), ultimaN);
                    break;
            }
        } else {
            System.out.println("No debe ordenarse.");
        }
    }
}

class PushNotification implements Notificable, Priorizable {
    // Atributos
    private String noti;
    private String app;

    // Constructor
    public PushNotification(String noti, String app) {
        this.noti = noti;
        this.app = app;
    }

    // Getters
    public String getNoti() {
        return noti;
    }

    public String getApp() {
        return app;
    }

    // Notificable
    @Override
    public void enviarNotificacion(int tipo) {
        if ((tipo > 0) && (tipo <= 2)) {
            switch (tipo) {
                case 1:
                    System.out.println("Ha llegado una notificacion.");
                    break;
                case 2:
                    System.out.println("Notificacion de " + app + ".");
                    break;
            }
        } else {
            System.out.println("Este numero no es un tipo de notificacion");
        }
    }

    // Priorizable
    @Override
    public void ordenNoti(ArrayList<Integer> orden) {
        // List<Integer> orden = new ArrayList<Integer>();
        int ultimaN = orden.get(orden.size() - 1);
        if (orden.size() > 0) {
            switch (orden.get(ultimaN)) {
                case 1:
                    orden.remove((orden.size() - 1));
                    orden.add(0, ultimaN);
                    break;
                case 2:
                    orden.remove((orden.size() - 1));
                    orden.add((orden.size() - 1), ultimaN);
                    break;
            }
        } else {
            System.out.println("No debe ordenarse.");
        }
    }
}

class CorreoElectronico implements Notificable, Priorizable {
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

    // Priorizable
    @Override
    public void ordenNoti(ArrayList<Integer> orden) {
        // List<Integer> orden = new ArrayList<Integer>();
        int ultimaN = orden.get(orden.size() - 1);
        if (orden.size() > 0) {
            switch (orden.get(ultimaN)) {
                case 1:
                    orden.remove((orden.size() - 1));
                    orden.add(0, ultimaN);
                    break;
                case 2:
                    orden.remove((orden.size() - 1));
                    orden.add(1, ultimaN);
                    break;
                case 3:
                    orden.remove((orden.size() - 1));
                    orden.add(2, ultimaN);
                    break;
                case 4:
                    orden.remove((orden.size() - 1));
                    orden.add((orden.size() - 1), ultimaN);
                    break;
            }
        } else {
            System.out.println("No debe ordenarse.");
        }
    }
}

public class SistemaNotificacion {
    public static void main(String[] args) {
        CorreoElectronico correo1 = new CorreoElectronico("tomastobio", "44851196");
        boolean recibioCorreo = true;
        if (recibioCorreo) {
            ArrayList<Integer> ordenCorreo = new ArrayList<Integer>();
            ordenCorreo.add(2);
            ordenCorreo.add(2);
            ordenCorreo.add(1);
            ordenCorreo.add(4);
            ordenCorreo.add(6);
            ordenCorreo.add(3);
            correo1.ordenNoti(ordenCorreo);
            for (int i = 0; i < ordenCorreo.size(); i++) {
                correo1.enviarNotificacion(ordenCorreo.get(i));
            }
        }
    }
}
