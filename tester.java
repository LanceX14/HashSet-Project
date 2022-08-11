import java.util.*;

public class tester{
  public static void main(String[] args) {
    HashSet h = new HashSet();
    Scanner kbd = new Scanner(System.in);
    while(true){
      System.out.println("Type 'ADD' to add name, 'DELETE' to delete name, 'SHOW' to see all elements from the set, 'Search' to find specific element in this set,'EXIT' to end this progrom");
      String action = kbd.nextLine().toUpperCase();
      if (action.equals("ADD")) {
        System.out.println("What name you want to add?");
        String data = kbd.nextLine();
        h.add_element(data);
        while(true){
          System.out.print("Type Name to continue add name, type 'Stop' to Stop adding    ");
          System.out.println(  "**SIZE IS "+h.get_size()+", set will rehash when size exceed "+h.get_rehashing_threshold()+"**");
          data = kbd.nextLine();
          if (data.toUpperCase().equals("STOP")) {
            break;
          }
          h.add_element(data);
        }
      }
      if (action.equals("SHOW")){
        System.out.println(h.to_string());
      }
      if (action.equals("EXIT")) {
        System.out.println("Thanks for using my progrom, have a good day!");
        break;
      }
      if (action.equals("SEARCH")) {
        System.out.println("Type the name that you want to find if that is in this set");
        String data = kbd.nextLine();
        if (h.contains(data)) {
          System.out.println(data + " is in this set!");
        }else {
          System.out.println(data + " is not in this set!");
        }
      }
      if (action.equals("DELETE")){
        System.out.println("What name you want to delete?");
        String data = kbd.nextLine();
        h.delete_element(data);
        System.out.println("SIZE IS "+h.get_size());
        while(true){
          System.out.println("Type Name to continue delete name, type 'Stop' to Stop deleting");
          data = kbd.nextLine();
          if (data.toUpperCase().equals("STOP")) {
            break;
          }
          h.delete_element(data);
          System.out.println("SIZE IS "+h.get_size());
        }
      }
    }
  }
}
