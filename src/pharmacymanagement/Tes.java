/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 *
 * @author drag me to hell
 */
public class Tes {
    public final int MAX_SIZE = 1024;
    public String readBytes(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        byte[] data = new byte[MAX_SIZE+1];
        int offset = 0;
        int bytesRead = 0;
        String str = new String();
        while ((bytesRead = in.read(data, offset, data.length - offset)) != -1) 
        {
        str += new String(data, offset, bytesRead, "UTF-8");
        offset += bytesRead;
        if (offset >= data.length) {
        throw new IOException("Too much input");
        }
        }
        in.close();
        return str;
    }
    
    public static void main(String[] args) throws IOException {
        Tes tes = new Tes();
        tes.readBytes(null);
    }

}
