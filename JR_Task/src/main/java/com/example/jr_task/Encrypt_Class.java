package com.example.jr_task;

import java.io.*;
import java.util.Arrays;


public class Encrypt_Class {

    public static File key_file = null;

    public static char[] array_encrypt_symbols = null;

    public static String return_encrypt_message_function(String message_for_encrypt) throws IOException {
        char[] char_array_with_variable_message_for_encrypt = message_for_encrypt.toCharArray();

        key_file = File.createTempFile("key", ".txt");

        array_encrypt_symbols = new char[char_array_with_variable_message_for_encrypt.length];

        Writer write_key_in_file = null;

        try{

            write_key_in_file = new FileWriter(key_file,false);

            for (int i = 0; i < char_array_with_variable_message_for_encrypt.length; i++) {
                int write_random_key_value_in_file = (int)Math.round(Math.random()*20);

                String byte_in_string = Integer.toString(write_random_key_value_in_file) + '\n';

                write_key_in_file.write(byte_in_string);

                if (write_random_key_value_in_file > 6)
                    array_encrypt_symbols[i] = (char) ((byte)char_array_with_variable_message_for_encrypt[i] - write_random_key_value_in_file );
                else
                    array_encrypt_symbols[i] = (char)  ((byte)char_array_with_variable_message_for_encrypt[i] + write_random_key_value_in_file );

            }



        } catch (IOException e) {

            throw new RuntimeException(e);

        }finally {

            write_key_in_file.close();

        }

        String return_encrypt_message = new String(array_encrypt_symbols);

        return return_encrypt_message ;
    }

    public static char[] GetEncryptMessage(){
        return Encrypt_Class.array_encrypt_symbols;
    }



}
