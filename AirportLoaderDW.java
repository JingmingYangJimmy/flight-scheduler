// --== CS400 Fall 2022 File Header Information ==--
// Name: <Jingming Yang>
// Email: <jyang668@wisc.edu>
// Team: <AI>
// TA: <Karan>
// Lecturer: <Gary Dahl>
// Notes to Grader: <I am data wrangler, loadAirports is the main method.
// loadAirportsdw is used to test my individual code. So loadAirports is the main method and is used in the integration>
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class will load data from dot file into the proper format
 * @author yangjingming
 *
 * @param <NodeType> The airports
 * @param <EdgeType> The distances between each airports
 */
public class AirportLoaderDW <NodeType,EdgeType extends Number> implements IAirportLoaderDW <NodeType,EdgeType>{


  /**
   * this method will remove all of the spaces in the string
   * @param str the String that we want to remove all of the spaces
   * @return the string that have no spaces
   */
  public static String removeSpaces(String str) {

    str=str.trim();
    for(int i=0;i<str.length();i++) {
      if(str.substring(i,i+1).equals(" ")) {

        str=str.substring(0,str.indexOf(" "))+str.substring(str.indexOf(" ")+1);
        i--;
      }     
    }   
    return str;
  }


  /**
   * This method is the main load method, we will load the things from the dot, we use it in the integration
   *  @return we return the list of airports and distance between each airports
   */
  public  AlgorithmEngineer <NodeType,EdgeType> loadAirports(String filePathToDot) throws FileNotFoundException {

    AlgorithmEngineer <NodeType,EdgeType> graph =new  AlgorithmEngineer<NodeType,EdgeType> ();


    // Check if the file exists
    if (!Files.exists(Path.of(filePathToDot)))
      throw new FileNotFoundException();

    Scanner in = new Scanner(new File("Airport.dot"));

    ArrayList<String> list = new ArrayList<>();

    while(in.hasNextLine()) {

      String hold =in.nextLine();



      if(removeSpaces(hold).length()==0||removeSpaces(hold) .startsWith("d")||
          removeSpaces(hold).startsWith("{")||removeSpaces(hold) .startsWith("}")) {
        continue;
      }
      list.add(removeSpaces(hold));
    }



    for(int i=0;i<list.size();i++) {
      String line=list.get(i);
      String start=line.substring(0, line.indexOf("-"));
      String end=line.substring(line.indexOf(">")+1,line.indexOf("["));
      String weight=line.substring(line.indexOf("\"")+1,line.indexOf("]")-1);


      NodeType dep=(NodeType)start;
      NodeType arr=(NodeType)end;
      Integer number=Integer.parseInt(weight);
      EdgeType edge=(EdgeType)number;

      graph.insertVertex(dep);
      graph.insertVertex(arr);
      graph.insertEdge(dep, arr, edge);


    }



    return graph;


  }


  /**
   * this method is used to test my individual code
   * @return we return the list of airports and distance between each airports
   */
  @Override
  public Graph<NodeType, EdgeType> loadAirportsdw(String filePathToDot)  throws FileNotFoundException {

  Graph <NodeType,EdgeType> graph =new  Graph <NodeType,EdgeType> ();


  // Check if the file exists
  if (!Files.exists(Path.of(filePathToDot)))
    throw new FileNotFoundException();

  Scanner in = new Scanner(new File("Airport.dot"));

  ArrayList<String> list = new ArrayList<>();

  while(in.hasNextLine()) {

    String hold =in.nextLine();



    if(removeSpaces(hold).length()==0||removeSpaces(hold) .startsWith("d")||
        removeSpaces(hold).startsWith("{")||removeSpaces(hold) .startsWith("}")) {
      continue;
    }
    list.add(removeSpaces(hold));
  }



  for(int i=0;i<list.size();i++) {
    String line=list.get(i);
    String start=line.substring(0, line.indexOf("-"));
    String end=line.substring(line.indexOf(">")+1,line.indexOf("["));
    String weight=line.substring(line.indexOf("\"")+1,line.indexOf("]")-1);


    NodeType dep=(NodeType)start;
    NodeType arr=(NodeType)end;
    Integer number=Integer.parseInt(weight);
    EdgeType edge=(EdgeType)number;

    graph.insertVertex(dep);
    graph.insertVertex(arr);
    graph.insertEdge(dep, arr, edge);


  }



  return graph;


}

}
