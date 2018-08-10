package com.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.assertArrayEquals;

public class TheByteArrayStream {

    @Test
    public void output() {
        byte[] inSrc = {1, 2, 3, 4, 5, 6, 7};
        byte[] outSrc = null;

        try(ByteArrayOutputStream out = new ByteArrayOutputStream();
            ByteArrayInputStream in = new ByteArrayInputStream(outSrc)) {
            int value = 0;
            while ((value=in.read()) != -1) {
                out.write(value);
            }
            outSrc = out.toByteArray();
        }catch (IOException e) {
            e.printStackTrace();
        }

        assertArrayEquals(inSrc, outSrc);
    }

    public void read() {

    }
    public static class Client {
        public static void main(String[] args) {
            try(Socket socket = new Socket("localhost", 8080)) {

            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8080)) {
            Socket socket = null;
            while((socket = serverSocket.accept())!=null) {
                System.out.println("Client is connected. IP Address is " + socket.getInetAddress().getHostAddress());
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }



}
