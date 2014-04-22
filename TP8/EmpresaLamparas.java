package TP8;

import java.util.Scanner;

public class EmpresaLamparas {
    private SearchBinTree lamparas;

    public EmpresaLamparas(){
        lamparas = new SearchBinTree();
        while (true){
            System.out.println("Ingrese el numero de la operacion a realizar: ");
            System.out.println("1) Nueva lampara");
            System.out.println("2) Eliminar lampara");
            System.out.println("3) Modificar lampara");
            System.out.println("4) Mostrar lamparas");
            System.out.println("5) Salir \n");

            Scanner scanner = new Scanner(System.in);
            int accion = scanner.nextInt();
            switch (accion){
                case 1:
                    agregar();
                    break;
                case 2:
                    eliminar();
                    break;
                case 3:
                    modificar();
                    break;
                case 4:
                    mostrar();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Accion invalida");
                    break;
            }

        }
    }

    private void agregar(){
        System.out.println("Ingrese el codigo de la nueva lampara (5 caracteres): ");
        Scanner scanner = new Scanner(System.in);
        String codigo = scanner.next();
        if (codigo.length() != 5){
            System.out.println("Codigo invalido");
            return;
        }
        System.out.println("Ingrese el tipo de lampara (Max 10 caracteres): ");
        String descripcion = scanner.next();
        if (descripcion.length() > 10){
            System.out.println("Descripcion invalida");
            return;
        }
        System.out.println("Ingrese los watts: ");
        int watts = scanner.nextInt();
        if (watts <= 0){
            System.out.println("Watts invalidos");
            return;
        }
        System.out.println("Ingrese la cantidad: ");
        int stock = scanner.nextInt();
        if (stock < 0){
            System.out.println("Cantidad invalida");
            return;
        }
        try {
            lamparas.add(new Lampara(codigo, descripcion, watts, stock));
        } catch (RepeatedObjectException e) {
            System.out.println("Lampara ya existente");
        }
    }

    private void eliminar(){
        System.out.println("Ingrese el codigo de la lampara a eliminar (5 caracteres): ");
        Scanner scanner = new Scanner(System.in);
        String codigo = scanner.next();
        if (codigo.length() == 5){
            try {
                lamparas.eliminar(new Lampara(codigo));
                System.out.println("Operacion exitosa");
            } catch (ObjectExistenceException e) {
                System.out.println("No existe");
            }
        } else {
            System.out.println("Codigo invalido");
            eliminar();
        }
    }

    private void modificar(){
        System.out.println("Ingrese el codigo de la lampara a modificar (5 caracteres): ");
        Scanner scanner = new Scanner(System.in);
        String codigo = scanner.next();
        if (codigo.length() == 5){
            try {
                Lampara temp = (Lampara)lamparas.buscar(new Lampara(codigo));
                System.out.println("Ingrese el numero de la opcion: ");
                System.out.println("1) Nuevo tipo de lampara");
                System.out.println("2) Nuevo voltaje");
                System.out.println("3) Modificar Stock");
                int accion = scanner.nextInt();
                switch (accion){
                    case 1:
                        modificarTipo(temp);
                        break;
                    case 2:
                        modificarVoltaje(temp);
                        break;
                    case 3:
                        modificarStock(temp);
                        break;
                    default:
                        System.out.println("Accion invalida");
                        modificar();
                        break;
                }
            } catch (ObjectExistenceException e) {
                System.out.println("Lampara inexistente");
                modificar();
            }

        } else {
            System.out.println("Codigo invalido");
            modificar();
        }
    }

    public void modificarTipo(Lampara aModificar){
        try {
            lamparas.eliminar(aModificar);
            System.out.println("Ingrese el nuevo tipo (Max 10 caracteres): ");
            Scanner scanner = new Scanner(System.in);
            String descr = scanner.next();
            if (descr.length() > 10){
                System.out.println("Descripcion invalida");
            } else {
                aModificar.setTipo(descr);
                lamparas.add(aModificar);
            }
        } catch (ObjectExistenceException e) {
            e.printStackTrace();
        } catch (RepeatedObjectException e) {
            e.printStackTrace();
        }
    }

    public void modificarVoltaje(Lampara aModificar){
        try {
            lamparas.eliminar(aModificar);
            System.out.println("Ingrese el voltaje: ");
            Scanner scanner = new Scanner(System.in);
            int descr = scanner.nextInt();
            if (descr <= 0){
                System.out.println("Voltaje invalido");
            } else {
                aModificar.setWatts(descr);
                lamparas.add(aModificar);
            }
        } catch (ObjectExistenceException e) {
            e.printStackTrace();
        } catch (RepeatedObjectException e) {
            e.printStackTrace();
        }
    }

    public void modificarStock(Lampara aModificar){
        try {
            lamparas.eliminar(aModificar);
            System.out.println("Ingrese el stock: ");
            Scanner scanner = new Scanner(System.in);
            int descr = scanner.nextInt();
            if (descr < 0){
                System.out.println("Stock invalido");
            } else {
                aModificar.setStock(descr);
                lamparas.add(aModificar);
            }
        } catch (ObjectExistenceException e) {
            e.printStackTrace();
        } catch (RepeatedObjectException e) {
            e.printStackTrace();
        }
    }

    private void mostrar(){
        while(!lamparas.isEmpty()){
            try {
                Lampara temp = (Lampara) lamparas.getMin();
                temp.informar();
                lamparas.eliminar(temp);
            } catch (EmptyTreeException e) {
                e.printStackTrace();
            } catch (ObjectExistenceException e) {
                e.printStackTrace();
            }
        }
    }
}
