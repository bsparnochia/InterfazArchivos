package com.practica.java.util.files;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface I_File {
    /**
     * Este método imprime en pantalla
     */
   default void print(){
       System.out.println(this.getText());
   }
   void setText(String texto);
   default void clear(){
       this.setText("");
   }
   String getText();
   void append(String texto);
   default void addLine(String linea){
       this.append(linea+"\n");
   }
   default void addlines(List<String> lineas){
       lineas.forEach(this::addLine);
   }
   Stream<String> getStream();
   default List<String> getAll(){
       return this.getStream().collect(Collectors.toList());
   }
   default List<String> getByFilter(String filter){
       return this
               .getStream()
               .filter(s->s.toLowerCase().contains(filter.toLowerCase()))
               .collect(Collectors.toList());
   }
   default List<String> getSortedLines(){
       return this.getStream().sorted().collect(Collectors.toList());
   }
   default List<String> getReversedSortedLines(){
       return this.getStream()
               .sorted(Comparator
                       .reverseOrder())
               .collect(Collectors.toList());
   }
   default LinkedHashSet<String> getLinkedHashSet(){
       LinkedHashSet<String> set = new LinkedHashSet();
       set.addAll(this.getAll());
       return set;
   }
   default TreeSet<String> getTreeSet(){
       TreeSet set= new TreeSet();
       set.addAll(getAll());
       return set;
   }
   default void remove(String line){
       List<String> list= this.getAll();
       list.remove(line);
       clear();
       addlines(list);
   }
}
