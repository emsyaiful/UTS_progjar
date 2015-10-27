/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientuts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class ThreadCli implements Runnable{
    private Socket socket;
    private OutputStream os;
    private InputStream is;
    private int hitung1, hitung2, jawaban;
    
    public ThreadCli(Socket socket) throws IOException{
        this.socket = socket;
        this.os = socket.getOutputStream();
        this.is = socket.getInputStream();
    }
    public int Answer(String a, String b, String c) {
        this.hitung1 = Integer.parseInt(a);
        this.hitung2 = Integer.parseInt(c);
        System.out.println("233");
        System.out.println(b);
        System.out.println("4545");
        if (b.equals("+")) {
            return this.hitung1+this.hitung2;
        }
        else if (b.equals("-")) {
            return this.hitung1-this.hitung2;
        }
        else if (b.equals("*")) {
            return this.hitung1*this.hitung2;
        }
        else if (b.equals("/")) {
            return this.hitung1/this.hitung2;
        }
        else if (b.equals("mod")) {
            return this.hitung1%this.hitung2;
        }
        else
            return 0;
    }
    
    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //byte[] buff = new byte[20];  
            String str;
            String[] data;
            while ((str=br.readLine())!=null) {
                data = str.split("\\s+");
                this.jawaban = Answer(data[0], data[1], data[2]);
                System.out.println(this.jawaban);
            }
        } catch (IOException ex) {
            Logger.getLogger(Thread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
