//aurreko bertsioarekin diferentziak detektatu eta probatu

package ProbaRuntime;

import java.io.*;

public class Procesos2 {

    public static void main(String args[]) {

        int retorno, retorno2, retorno3;
        boolean error = false;

        if (args.length <= 0) {

            System.err.println("Exekutatzeko programa bat behar da");

        } else {
            Runtime runtime = Runtime.getRuntime();//Runtime klaseko instantzia bat lortzen du
            try {
               
                System.out.println("Aita-prozesuan nago");
                System.out.println("Hiru ume-prozesu abiaraziko ditut");
                Process process = runtime.exec(args);
                retorno = process.waitFor();

                System.out.println(args [0] +" exekuzioak itzuli egiten du "+ retorno);
                Thread.sleep(2000); //2000 milisegundoko atzerapena
                
                process = runtime.exec("c:/Program Files/Internet Explorer/iexplore.exe");
                retorno2 = process.waitFor();
                System.out.println("Nabigatzailearen exekuzioak itzuli egiten du " + retorno2);
                Thread.sleep(2000);
                
                process = runtime.exec("cmd /c start iexplore http://google.es");
                retorno3 = process.waitFor();
                System.out.println("Google-en exekuzioak itzuli egiten du " + retorno3);
                process.destroy();//*
            } catch (InterruptedException ex) {
                System.err.println("Ume-prozesu baten exekuzioak oker amaitu zuen");
                error = true;
            } catch (IOException ex) {
                System.err.println("I/S salbuespena!!");
                error = true;
            }

            if (error == false) {
                System.out.println("Aita-prozesua amaitu da");
                System.out.println("Ume-prozesuak behar bezala amaitu direlako");
            }
        }
    }

}
//Beste programarekin konparatuta hemen erroreak kontrolatzen dira eta prozesua ixten denean ere erakusten da kontsolan