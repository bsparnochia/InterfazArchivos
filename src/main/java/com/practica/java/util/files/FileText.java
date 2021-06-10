package com.practica.java.util.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.stream.Stream;

public class FileText implements I_File{
    
    private File archivo;

    public FileText(File archivo) {
        this.archivo = archivo;
    }
    
    public FileText(String ruta){
        this.archivo = new File(ruta); 
    }

    @Override
    public void setText(String texto) {
        try (FileWriter in = new FileWriter(archivo)){            
            in.write(texto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getText() {
        int car;
        StringBuilder sb= new StringBuilder();
        try (FileReader in=new FileReader(archivo)){
            while((car=in.read())!=-1){
                sb.append((char)car);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    public void append(String texto) {
        try (FileWriter in=new FileWriter(this.archivo,true)){
            in.write(texto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Stream<String> getStream() {
        try{
            return new BufferedReader(new FileReader(archivo)).lines();
        } catch (Exception e) {
            return null;
        }
    }
}
