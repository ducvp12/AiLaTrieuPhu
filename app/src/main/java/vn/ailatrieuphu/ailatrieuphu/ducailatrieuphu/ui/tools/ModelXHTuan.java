package vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.ui.tools;

import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ModelXHTuan {
     String img;
     String stt;
     String name, diem;

     public String getStt() {
          return stt;
     }

     public void setStt(String stt) {
          this.stt = stt;
     }

     public ModelXHTuan(String stt) {
          this.stt = stt;
     }

     public String getImg() {
          return img;
     }

     public void setImg(String img) {
          this.img = img;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getDiem() {
          return diem;
     }

     public void setDiem(String diem) {
          this.diem = diem;
     }

     public ModelXHTuan(String img, String name, String diem, String stt) {
          this.img = img;
          this.name = name;
          this.diem = diem;
          this.stt=stt;
     }

}
