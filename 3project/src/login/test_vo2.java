package login;

import java.util.Date;

public class test_vo2 {
   private String id;
   private String cryptogram;
   private String tel;
   
   public test_vo2() {}
   public test_vo2(String id,String cryptogram,String tel) {
      super();
      this.id= id;
      this.cryptogram = cryptogram;
      this.tel = tel;
      
   }
   
   public test_vo2(String id,String tel) {
	      super();
	      this.id= id;
	      this.tel = tel;
	      
	   }

   public void setId(String id) {
      this.id = id;
   }
   public String getPw() {
      return cryptogram;
   }
   public void setPw(String cryptogram) {
      this.cryptogram = cryptogram;
   }
   public String getTel() {
      return tel;
   }
   public void setTel(String tel) {
      this.tel = tel;
   }
   
   public String getId() {
      return id;
   }
   

}
