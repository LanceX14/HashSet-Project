import java.util.*;
import java.util.ArrayList;

public class LinkedList {
  private Node head;

  public LinkedList(){
    head = null;
  }
  public void clear(){
    head = null;
  }

  public ArrayList<String> get_all_element(){
      ArrayList<String> arr = new ArrayList<String>();
      Node cur_node = head;
      while(cur_node!=null){
        arr.add(cur_node.get_value());
        cur_node = cur_node.get_next();
      }
      return arr;
  }

  public boolean delete(String data){
    if (head==null) {
      return false;
    }
    if(head.get_value().equals(data)){
      clear();
      return true;
    }
    Node cur = head;
    while(cur.get_next()!=null){
      if(cur.get_next().get_value().equals(data)){
        cur.set_next(cur.get_next().get_next());
        return true;
      }
      cur = cur.get_next();
    }
    return false;
  }

  public boolean contains(String data){
    Node cur_node = head;
    while(cur_node!=null){
      if (cur_node.get_value().equals(data)) {
        return true;
      }
      cur_node = cur_node.get_next();
    }
    return false;
  }

  public void add_list(String data){
    Node new_node = new Node(data,null);
    if (head==null) {
      head = new_node;
      return;
    }

    Node cur = head;
    while(cur.get_next()!=null){
      cur = cur.get_next();
    }
    cur.set_next(new_node);
  }

  public String to_string(){
    String s = "";
    Node cur = head;
    while(cur!=null){
      s=s+cur.get_value()+" -> ";
      cur = cur.get_next();
    }
    if (s.length()>4) {
      return  s.substring(0,s.length()-4);
    } else{
      return "Empty List";
    }
  }

}

class Node{
  private String data;
  private Node next;

  public String get_value(){
    return data;
  }

  public Node get_next(){
    return next;
  }

  Node(String data,Node next){
    this.data = data;
    this.next = next;
  }

  public void set_next(Node next){
    this.next = next;
  }

}
