package sample15.simple;

public class App {
    public static void main(String[] args) {
        SimpleConcreteClass app = new SimpleConcreteClass();
        app.simpleMethod();
        // 次の行はコメントを外すと、エラーとなる
        // SimpleAbstractClass a = new SimpleAbstractClass();
  }
}
