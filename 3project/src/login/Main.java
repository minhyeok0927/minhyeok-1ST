package login;

import java.security.NoSuchAlgorithmException;
public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        //작성 클래스의 인스턴스 생성
        SHA256 sha256 = new SHA256();
        String password = "비밀번호";
        String password2 = "비밀번호2";

        //cryptogram : SHA256으로 암호화된 비밀번호
        String cryptogram = sha256.encrypt(password);

        System.out.println("input         : "+password);
        System.out.println("After SHA256  : "+ cryptogram);
        //비밀번호 일치 여부
        System.out.println(password+" : "+cryptogram.equals(sha256.encrypt(password)));
        System.out.println(password2+" : "+cryptogram.equals(sha256.encrypt(password2)));
    }
}
