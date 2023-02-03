// --== CS400 Fall 2022 File Header Information ==--
// Name: <Jingming Yang>
// Email: <jyang668@wisc.edu>
// Team: <AI>
// TA: <Karan>
// Lecturer: <Gary Dahl>
// Notes to Grader: <I am data wrangler, because the AE and I both using the code that we wrote in P3W2,
// graph variable is completely done by me, it is used for my individual code and my individual test in P3W3, the ae
// variable is used for the integration (using the code from ae). So ae is the main one.>

import java.io.FileNotFoundException;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test will test the method of DW, AE, and the integration.
 * @author yangjingming
 *
 * @param <NodeType> The airports
 * @param <EdgeType> The distances between each airports
 */
public class DataWranglerTests <NodeType,EdgeType extends Number> {

  Graph <NodeType,EdgeType > graph=null;        //this one is my method, I will use it to test my individual code
  AirportLoaderDW <NodeType,EdgeType> test=null;
  AlgorithmEngineer <NodeType,EdgeType > ae=null; //this one is AE, it is the main one(used in the integration and test my partner's code )


  //BeforeEach annotation makes a method invoked automatically
  //before each test
  @BeforeEach
  public void createInstane() {
    graph=new  Graph <NodeType,EdgeType >(); //this one is my method, I will use it to test my individual code
    test=new  AirportLoaderDW <NodeType,EdgeType> ();
    ae=new  AlgorithmEngineer <NodeType,EdgeType > (); //this one is AE, it is the main one(used in the integration and test my partner's code)
  }

  /**
   * this test tests airports of CLT and MCO
   */
  @Test
  public void test1(){
    try {
      graph=   test.loadAirportsdw("Airport.dot");

      NodeType start=(NodeType)"CLT";
      NodeType end=(NodeType)"MCO";
      NodeType fake=(NodeType)"AAA";

      assertTrue(graph.containsEdge(start,end));
      assertFalse(graph.containsEdge(fake, end));
      assertTrue(graph.containsVertex(start));
      assertTrue(graph.containsVertex(end));// we test the method of containsVertex
      assertFalse(graph.containsVertex(fake));
      assertEquals(graph.getEdgeCount(),39);//we test the count of edge
      assertEquals(graph.getVertexCount(),8);
      assertFalse(graph.isEmpty());
      graph.removeEdge((NodeType)"LAX", (NodeType)"LAS"); //we test the method of removing an edge
      assertEquals(graph.getEdgeCount(),38);
      graph.removeVertex((NodeType)"ATL");
      assertEquals(graph.getVertexCount(),7);
      assertFalse(graph.isEmpty());//we test the graph is empty or not

    } catch (FileNotFoundException e) {
      e.printStackTrace();
      fail();
    }
  }



  /**
   * this test tests airports of DEN and ORD
   */
  @Test
  public  void test2(){
    try {
      graph=   test.loadAirportsdw("Airport.dot");

      NodeType start=(NodeType)"DEN";
      NodeType end=(NodeType)"ORD";
      NodeType fake=(NodeType)"ALL";

      assertTrue(graph.containsEdge(start,end));
      assertFalse(graph.containsEdge(fake, end));
      assertTrue(graph.containsVertex(start));
      assertTrue(graph.containsVertex(end));// we test the method of containsVertex
      assertFalse(graph.containsVertex(fake));
      assertEquals(graph.getEdgeCount(),39);//we test the count of edge
      assertEquals(graph.getVertexCount(),8);
      assertFalse(graph.isEmpty());
      graph.removeEdge((NodeType)"ATL", (NodeType)"DFW"); //we test the method of removing an edge
      assertEquals(graph.getEdgeCount(),38);
      graph.removeVertex((NodeType)"LAS");
      assertEquals(graph.getVertexCount(),7);
      assertFalse(graph.isEmpty());//we test the graph is empty or not

    } catch (FileNotFoundException e) {
      e.printStackTrace();
      fail();
    }
  }





  /**
   * this test tests airports of LAS and CLT
   */
  @Test
  public  void test3(){

    try {
      graph=   test.loadAirportsdw("Airport.dot");

      NodeType start=(NodeType)"LAS";
      NodeType end=(NodeType)"CLT";
      NodeType fake=(NodeType)"ATE";

      assertTrue(graph.containsEdge(start,end));
      assertFalse(graph.containsEdge(fake, end));
      assertTrue(graph.containsVertex(start));
      assertTrue(graph.containsVertex(end));// we test the method of containsVertex
      assertFalse(graph.containsVertex(fake));
      assertEquals(graph.getEdgeCount(),39);//we test the count of edge
      assertEquals(graph.getVertexCount(),8);
      assertFalse(graph.isEmpty());
      graph.removeEdge((NodeType)"ATL", (NodeType)"MCO"); //we test the method of removing an edge
      assertEquals(graph.getEdgeCount(),38);
      graph.removeVertex((NodeType)"DEN");
      assertEquals(graph.getVertexCount(),7);
      assertFalse(graph.isEmpty());//we test the graph is empty or not

    } catch (FileNotFoundException e) {
      e.printStackTrace();
      fail();
    }

  }

  /**
   * this test tests airports of LAX and MCO
   */
  @Test
  public  void test4(){


    try {
      graph=   test.loadAirportsdw("Airport.dot");

      NodeType start=(NodeType)"LAX";
      NodeType end=(NodeType)"MCO";
      NodeType fake=(NodeType)"TRG";

      assertTrue(graph.containsEdge(start,end));
      assertFalse(graph.containsEdge(fake, end));
      assertTrue(graph.containsVertex(start));
      assertTrue(graph.containsVertex(end));// we test the method of containsVertex
      assertFalse(graph.containsVertex(fake));
      assertEquals(graph.getEdgeCount(),39);//we test the count of edge
      assertEquals(graph.getVertexCount(),8);
      assertFalse(graph.isEmpty());
      graph.removeEdge((NodeType)"ATL", (NodeType)"DEN"); //we test the method of removing an edge
      assertEquals(graph.getEdgeCount(),38);
      graph.removeVertex((NodeType)"LAS");
      assertEquals(graph.getVertexCount(),7);
      assertFalse(graph.isEmpty());//we test the graph is empty or not

    } catch (FileNotFoundException e) {
      e.printStackTrace();
      fail();
    }


  }

  /**
   * this test tests airports of DFW and LAX
   */
  @Test
  public  void test5(){

    try {
      graph=   test.loadAirportsdw("Airport.dot");

      NodeType start=(NodeType)"DFW";
      NodeType end=(NodeType)"LAX";
      NodeType fake=(NodeType)"EAG";

      assertTrue(graph.containsEdge(start,end));
      assertFalse(graph.containsEdge(fake, end));
      assertTrue(graph.containsVertex(start));
      assertTrue(graph.containsVertex(end));// we test the method of containsVertex
      assertFalse(graph.containsVertex(fake));
      assertEquals(graph.getEdgeCount(),39);//we test the count of edge
      assertEquals(graph.getVertexCount(),8);
      assertFalse(graph.isEmpty());
      graph.removeEdge((NodeType)"CLT", (NodeType)"DFW"); //we test the method of removing an edge
      assertEquals(graph.getEdgeCount(),38);
      graph.removeVertex((NodeType)"ORD");
      assertEquals(graph.getVertexCount(),7);
      assertFalse(graph.isEmpty());//we test the graph is empty or not

    } catch (FileNotFoundException e) {
      e.printStackTrace();
      fail();
    }




  }

  /**
   * this test tests airports of LAS and CLT
   */
  @Test
  public void CodeReviewOfAlgorithmEngineer1() {

    try {
      ae=   test.loadAirports("Airport.dot"); //we load the data using ae's method

      assertEquals(ae.returnAllAirports().size(),8);
      assertEquals("[ORD, MCO, CLT, ATL, DEN, LAS, LAX, DFW]",ae.returnAllAirports().toString());
      //Test ae's returnALLairpoerts method

      NodeType start=(NodeType)"LAS";
      NodeType end=(NodeType)"CLT";
      NodeType fake=(NodeType)"ATE";
      assertTrue(ae.containsEdge(start,end));
      assertFalse(ae.containsEdge(fake, end));
      assertTrue(ae.containsVertex(start));
      assertTrue(ae.containsVertex(end));// we test the method of containsVertex
      assertFalse(ae.containsVertex(fake));
      assertEquals(ae.getEdgeCount(),39);//we test the count of edge
      assertEquals(ae.getVertexCount(),8);
      assertFalse(ae.isEmpty());
      ae.removeEdge((NodeType)"ATL", (NodeType)"MCO"); //we test the method of removing an edge
      assertEquals(ae.getEdgeCount(),38);
      ae.removeVertex((NodeType)"DEN");
     
      assertEquals(ae.returnAllAirports().size(),7);
      assertEquals("[ORD, MCO, CLT, ATL, LAS, LAX, DFW]",ae.returnAllAirports().toString());
      //Test ae's returnALLairpoerts method
      assertEquals(ae.getVertexCount(),7);
      
      ae.removeVertex((NodeType)"ORD");
      assertEquals(ae.returnAllAirports().size(),6);
      assertEquals("[MCO, CLT, ATL, LAS, LAX, DFW]",ae.returnAllAirports().toString());
      //Test ae's returnALLairpoerts method
      
      
      assertFalse(ae.isEmpty());//we test the graph is empty or not

    } catch (FileNotFoundException e) {
      e.printStackTrace();
      fail();
    }
  }




  /**
   * this test tests airports of DFW and LAX
   */
  @Test
  public void CodeReviewOfAlgorithmEngineer2() {

    try {
      ae=   test.loadAirports("Airport.dot"); //we load the data using ae's method

      assertEquals(ae.returnAllAirports().size(),8);
      assertEquals("[ORD, MCO, CLT, ATL, DEN, LAS, LAX, DFW]",ae.returnAllAirports().toString());
      //Test ae's returnALLairpoerts method

      NodeType start=(NodeType)"DFW";
      NodeType end=(NodeType)"LAX";
      NodeType fake=(NodeType)"ATE";
      assertTrue(ae.containsEdge(start,end));
      assertFalse(ae.containsEdge(fake, end));
      assertTrue(ae.containsVertex(start));
      assertTrue(ae.containsVertex(end));// we test the method of containsVertex
      assertFalse(ae.containsVertex(fake));
      assertEquals(ae.getEdgeCount(),39);//we test the count of edge
      assertEquals(ae.getVertexCount(),8);
      assertFalse(ae.isEmpty());
      ae.removeEdge((NodeType)"ATL", (NodeType)"MCO"); //we test the method of removing an edge
      assertEquals(ae.getEdgeCount(),38);
      ae.removeVertex((NodeType)"LAX");
     
      assertEquals(ae.returnAllAirports().size(),7);
      assertEquals("[ORD, MCO, CLT, ATL, DEN, LAS, DFW]",ae.returnAllAirports().toString());
      //Test ae's returnALLairpoerts method
      assertEquals(ae.getVertexCount(),7);
      
      ae.removeVertex((NodeType)"MCO");
      assertEquals(ae.returnAllAirports().size(),6);
      assertEquals("[ORD, CLT, ATL, DEN, LAS, DFW]",ae.returnAllAirports().toString());
      //Test ae's returnALLairpoerts method
      
      
      assertFalse(ae.isEmpty());//we test the graph is empty or not

    } catch (FileNotFoundException e) {
      e.printStackTrace();
      fail();
    }
  }




  /**
   * this test tests airports of DEN and LAS
   */
  @Test
  public void IntegrationCodeReviewOfAlgorithmEngineer3() {
    try {
      ae=   test.loadAirports("Airport.dot"); //we load the data using ae's method

      assertEquals(ae.returnAllAirports().size(),8);
      assertEquals("[ORD, MCO, CLT, ATL, DEN, LAS, LAX, DFW]",ae.returnAllAirports().toString());
      //Test ae's returnALLairpoerts method

      NodeType start=(NodeType)"DEN";
      NodeType end=(NodeType)"LAS";
      NodeType fake=(NodeType)"ATE";
      assertTrue(ae.containsEdge(start,end));
      assertFalse(ae.containsEdge(fake, end));
      assertTrue(ae.containsVertex(start));
      assertTrue(ae.containsVertex(end));// we test the method of containsVertex
      assertFalse(ae.containsVertex(fake));
      assertEquals(ae.getEdgeCount(),39);//we test the count of edge
      assertEquals(ae.getVertexCount(),8);
      assertFalse(ae.isEmpty());
      ae.removeEdge((NodeType)"ATL", (NodeType)"MCO"); //we test the method of removing an edge
      assertEquals(ae.getEdgeCount(),38);
      ae.removeVertex((NodeType)"CLT");
     
      assertEquals(ae.returnAllAirports().size(),7);
      assertEquals("[ORD, MCO, ATL, DEN, LAS, LAX, DFW]",ae.returnAllAirports().toString());
      //Test ae's returnALLairpoerts method
      assertEquals(ae.getVertexCount(),7);
      
      ae.removeVertex((NodeType)"ATL");
      assertEquals(ae.returnAllAirports().size(),6);
      assertEquals("[ORD, MCO, DEN, LAS, LAX, DFW]",ae.returnAllAirports().toString());
      //Test ae's returnALLairpoerts method
      
      
      assertFalse(ae.isEmpty());//we test the graph is empty or not

    } catch (FileNotFoundException e) {
      e.printStackTrace();
      fail();
    }
  }
  
  
  /**
   * this test tests airports of MCO and ATL
   */
  @Test
  public void IntegrationCodeReviewOfAlgorithmEngineer4() {
  
    try {
      ae=   test.loadAirports("Airport.dot"); //we load the data using ae's method

      assertEquals(ae.returnAllAirports().size(),8);
      assertEquals("[ORD, MCO, CLT, ATL, DEN, LAS, LAX, DFW]",ae.returnAllAirports().toString());
      //Test ae's returnALLairpoerts method

      NodeType start=(NodeType)"MCO";
      NodeType end=(NodeType)"ATL";
      NodeType fake=(NodeType)"ATE";
      assertTrue(ae.containsEdge(start,end));
      assertFalse(ae.containsEdge(fake, end));
      assertTrue(ae.containsVertex(start));
      assertTrue(ae.containsVertex(end));// we test the method of containsVertex
      assertFalse(ae.containsVertex(fake));
      assertEquals(ae.getEdgeCount(),39);//we test the count of edge
      assertEquals(ae.getVertexCount(),8);
      assertFalse(ae.isEmpty());
      ae.removeEdge((NodeType)"ATL", (NodeType)"MCO"); //we test the method of removing an edge
      assertEquals(ae.getEdgeCount(),38);
      ae.removeVertex((NodeType)"LAX");
     
      assertEquals(ae.returnAllAirports().size(),7);
      assertEquals("[ORD, MCO, CLT, ATL, DEN, LAS, DFW]",ae.returnAllAirports().toString());
      //Test ae's returnALLairpoerts method
      assertEquals(ae.getVertexCount(),7);
      
      ae.removeVertex((NodeType)"CLT");
      assertEquals(ae.returnAllAirports().size(),6);
      assertEquals("[ORD, MCO, ATL, DEN, LAS, DFW]",ae.returnAllAirports().toString());
      //Test ae's returnALLairpoerts method
      
      
      assertFalse(ae.isEmpty());//we test the graph is empty or not

    } catch (FileNotFoundException e) {
      e.printStackTrace();
      fail();
    }
  }

}