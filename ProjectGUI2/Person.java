import java.util.*;
import java.io.Serializable;

public class Person implements Serializable {
  private String name;

  private static final long serialVersionUID = -8050658235857325594L;

  public Person(String someName) {
    this.name = someName;
  }

  public Person() {

  }

  public String getName() {
    return name;
  }

  public void setName(String someName) {
    this.name = someName;
  }
}
