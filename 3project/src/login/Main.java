package login;

import java.security.NoSuchAlgorithmException;
public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        //�ۼ� Ŭ������ �ν��Ͻ� ����
        SHA256 sha256 = new SHA256();
        String password = "��й�ȣ";
        String password2 = "��й�ȣ2";

        //cryptogram : SHA256���� ��ȣȭ�� ��й�ȣ
        String cryptogram = sha256.encrypt(password);

        System.out.println("input         : "+password);
        System.out.println("After SHA256  : "+ cryptogram);
        //��й�ȣ ��ġ ����
        System.out.println(password+" : "+cryptogram.equals(sha256.encrypt(password)));
        System.out.println(password2+" : "+cryptogram.equals(sha256.encrypt(password2)));
    }
}
