import java.util.Locale;
import java.util.ResourceBundle;

public class Greeter {

  private Locale locale;
  private String name;

  public Greeter(String language, String country, String name) {
    locale = new Locale(language, country);
    this.name = name;
  }

  public String sayHello() {
    ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
   return messages.getString("greeting") + ", " + "**" + name.toUpperCase() + "**";
  }

  public static void main(String[] args) {
    // 新增：检查参数长度，确保有3个参数（语言、国家、姓名）
    if (args.length < 3) {
      System.out.println("错误：请提供语言、国家和姓名参数！示例：java Greeter en US Alice");
      return;
    }
    String language = args[0];
    String country = args[1];
    String name = args[2];
    Greeter greeter = new Greeter(language, country, name);
    System.out.println(greeter.sayHello());
  }
}