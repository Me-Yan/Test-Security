import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Me on 2018/8/5.
 */
public class Test {

    public static void main(String[] args) {
        A temp = new B();
        temp.sayLove();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(11);

        System.out.println(passwordEncoder.encode("123456"));
    }
}

abstract class A {
    abstract void sayLove();
}

class B extends A {
    public void sayLove() {
        System.out.println("I Love You B!");
    }
}