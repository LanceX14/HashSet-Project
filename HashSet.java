import java.util.*;

public class HashSet{
  private int size;
  private LinkedList[] arr;
  private int number_of_bucket;
  public final int MAX_ACCEPTABLE_PER_BUCKET_SIZE = 3;

  public HashSet(){
    size = 0;
    arr = new LinkedList[5];
    for (int i=0;i<5 ;i++ ) {
      arr[i] = new LinkedList();
    }
    number_of_bucket = 5;
  }

  public int get_size(){
    return size;
  }

  public int get_rehashing_threshold(){
    return MAX_ACCEPTABLE_PER_BUCKET_SIZE*number_of_bucket;
  }

  public boolean contains(String data){
    for (int i=0;i<number_of_bucket ;i++ ) {
      if (arr[i].contains(data)) {
        return true;
      }
    }
    return false;
  }

//hashing function
  public int hash_of(String data){
    int hash = 997;
    for (int i=0 ; i< data.length() ; ++i )
      hash = Math.abs( hash * 33 + (short)data.charAt(i) );
    return hash % number_of_bucket;
  }

//add element to hashset
  public void add_element(String data){
    if (contains(data)) {
      System.out.println(data+" is already exist in this HashSet");
      return;
    }
    size++;
    if (size > MAX_ACCEPTABLE_PER_BUCKET_SIZE*number_of_bucket) {
      rehash();
    }
    int hash = hash_of(data);
    LinkedList cur_list = arr[hash];
    if (cur_list == null) {
      arr[hash] = new LinkedList();
      cur_list = arr[hash];
    }
    cur_list.add_list(data);
  }

//delete specific element from hashset
  public void delete_element(String data){
    for (int i=0;i<number_of_bucket ;i++ ) {
      if (arr[i].delete(data)) {
        System.out.println(data +" has been delete");
        size--;
        return;
      }
    }
    System.out.println("Can not find "+data+" in this HashSet");
    }

  public void rehash(){
    System.out.println("HashSet has been rehashed");
    LinkedList[] new_arr = new LinkedList[arr.length*2];
    number_of_bucket = new_arr.length;
    for (int i=0;i<new_arr.length ;i++ ) {
      new_arr[i] = new LinkedList();
    }
    ArrayList<String> linkedlist_element;
    for (int i=0;i<arr.length ;i++ ) {
      LinkedList ll = arr[i];
      linkedlist_element = ll.get_all_element();
      for (String s :linkedlist_element ) {
        int hash_key = hash_of(s);
        new_arr[hash_key].add_list(s);
      }
    }
    arr = new_arr;
  }

  public String to_string(){
    String message = "HashSet: \n";
    for (int i=0;i<number_of_bucket ;i++ ) {
      if (arr[i]==null) {
        arr[i] = new LinkedList();
      }
      LinkedList ll = arr[i];
      message+=ll.to_string();
      message+="\n";
    }
    return message;
  }
}
