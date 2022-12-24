package com.example.jr_task;

import java.io.*;
import java.util.Arrays;

public class Decrypt_Class {

    public static String return_decrypt_message_function() throws IOException {
        char[] array_with_encrypt_symbols = Encrypt_Class.GetEncryptMessage();

        BufferedReader read_key_in_file = null;

        char[] decrypt_array = new char[Encrypt_Class.GetEncryptMessage().length] ;

        try{


            read_key_in_file = new BufferedReader(new FileReader(Encrypt_Class.key_file));

            String key;
            int count = 0;
            while ((key = read_key_in_file.readLine())!= null ) {


                if (Integer.parseInt(key) > 6)
                    decrypt_array[count] = (char) ((byte)array_with_encrypt_symbols[count] + Byte.parseByte(key));
                else
                    decrypt_array[count] = (char)  ((byte)array_with_encrypt_symbols[count] - Byte.parseByte(key));

                count++;
            }

        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e) {

            throw new RuntimeException(e);

        }finally {
            read_key_in_file.close();
            Encrypt_Class.key_file.deleteOnExit();
        }

        String return_decrypt_message = new String(decrypt_array);

        return return_decrypt_message;
    }
}
