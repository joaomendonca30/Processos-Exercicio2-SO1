package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KillController {
    private String os() {
        return System.getProperty("os.name");
    }

    public void listaProcessos() throws RuntimeException {

        try {
            Process process;
            if (os().contains("Windows")) {
                process = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
            } else if (os().contains("Linux")) {
                process = Runtime.getRuntime().exec("ps -ef");
            } else {
                System.out.println("Sistema Operacional não suportado.");
                return;
            }

            BufferedReader buffer = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linha;
            while ((linha = buffer.readLine()) != null) {
                System.out.println(linha);
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void mataPid(int pid) {

        try {
            Process process;
            if (os().contains("Windows")) {
                process = Runtime.getRuntime().exec("TASKKILL /PID " + pid);
            } else if (os().contains("Linux")) {
                process = Runtime.getRuntime().exec("kill -9 " + pid);
            } else {
                System.out.println("Sistema Operacional não suportado.");
                return;
            }
            process.waitFor(); // Aguarda o término do processo
            System.out.println("Processo com PID " + pid + " terminado.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void mataNome(String nomeProcesso) {

        try {
            Process process;
            if (os().contains("Windows")) {
                process = Runtime.getRuntime().exec("TASKKILL /IM " + nomeProcesso);
            } else if (os().contains("Linux")) {
                process = Runtime.getRuntime().exec("pkill -f " + nomeProcesso);
            } else {
                System.out.println("Sistema Operacional não suportado.");
                return;
            }

            process.waitFor(); // Aguarda o término do processo
            System.out.println("Processo " + nomeProcesso + " terminado.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
