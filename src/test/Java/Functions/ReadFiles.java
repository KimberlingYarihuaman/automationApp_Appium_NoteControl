package Functions;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ReadFiles{


    String chain="";
    int lineCounter=0;
    FileReader reading;
    BufferedReader storage;
    List<String> data;       //Storage for rows


    //This method reads a specific line of the txt file

    public ArrayList<String> ReadSpecificLine(String dir, int line){

        try {

            reading=new FileReader(new File(dir));
            storage = new BufferedReader(reading);

           while ((chain=storage.readLine())!=null){

               lineCounter++;

                   if (lineCounter == line){      //Equal to the searched line?
                       data = new ArrayList<String>(Arrays.asList(chain.split(";")));     //Take the last value
                       break;
                   }
           }
            storage.close();
            reading.close();

        }catch (Exception e){
          System.out.println(e);
        }

        return (ArrayList<String>) data;
    }

/*
    This function takes various lines of the txt

    public List<List<String>>  ReadVariousLines(String dir, int columsNumber) {

        String aux[];
        List<List<String>> list_data = new ArrayList<List<String>>();


        for(int n=0;n<columsNumber;n++){
            list_data.add(new ArrayList<String>());       //Add columns at the main List (sub-lists)
        }


        try {

            reading=new FileReader(new File(dir));
            storage = new BufferedReader(reading);


            while ((chain=storage.readLine())!=null){

                aux=chain.split(";");

                for(int i=0;i<columsNumber;i++) {    //Add data to every colum at the matrix

                    list_data.get(i).add(aux[i]);
                    //System.out.print(list_data.get(i).get(lineCounter) + " ");

                }
                lineCounter++;     //Number of rows
                //System.out.println();
            }
        }
         catch (FileNotFoundException e1) {
                 e1.printStackTrace();
        } catch (IOException e) {
                 e.printStackTrace();
        }

        return list_data;
    }*/
}