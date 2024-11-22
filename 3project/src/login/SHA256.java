package login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {

    // �Է� ���ڿ��� SHA-256���� ��ȣȭ�Ͽ� �ؽ� ���� ��ȯ�ϴ� �޼���
    public String encrypt(String text) throws NoSuchAlgorithmException {
       // SHA-256 �˰����� �ν��Ͻ� ����
        MessageDigest md = MessageDigest.getInstance("SHA-256");         
        // �Է� ���ڿ��� ����Ʈ �迭�� ������Ʈ�Ͽ� �ؽ� ���� ���
        md.update(text.getBytes()); 
      // ���� �ؽ� ���� 16���� ���ڿ��� ��ȯ�Ͽ� ��ȯ
        return bytesToHex(md.digest()); 
    }

    // ����Ʈ �迭�� 16���� ���ڿ��� ��ȯ�ϴ� �޼���
    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
           // ����Ʈ ���� 16���� ���ڿ��� ��ȯ�Ͽ� StringBuilder�� �߰�
            builder.append(String.format("%02x", b)); 
        }
        // StringBuilder�� ������ ���ڿ��� ��ȯ
        return builder.toString(); 
    }

}