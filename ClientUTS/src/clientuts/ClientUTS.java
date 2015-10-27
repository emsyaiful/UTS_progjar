/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientuts;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class ClientUTS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.151.34.155", 6666);
        ThreadCli tc = new ThreadCli(socket);
        Thread t = new Thread(tc);
        t.start();
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        DataOutputStream dos = new DataOutputStream(os);
        os.write("USERNAME:5113100022\n".getBytes());
        os.flush();
    }
}
