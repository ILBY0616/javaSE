package Component;

public class JuniorPhone implements Phone{
    public JuniorPhone() {
        System.out.println("低级手机");
    }
    @Override
    public void sound() {
        System.out.println("发出声音");
    }
}
