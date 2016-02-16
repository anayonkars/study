package code.demoutils;

import java.io.*;

/**
 * Created by ANAYONKS on 16/02/2016.
 */
public class SerializeDemo {
    static class NormalParent {
        public NormalParent() {

        }
        public NormalParent(int data) {
            System.out.println("NormalParent " + data);
        }
    }
    static class Normal extends NormalParent implements Serializable {
        private static final long serialVersionUID = 1L;
        public int data;
        public Normal(int data) {
            super(data);
            System.out.println("Normal " + data);
            this.data = data;
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        Normal n = new Normal(5);
        oos.writeObject(n);
        oos.flush();
        byte[] b = baos.toByteArray();
        //System.out.println(b);
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        ObjectInputStream ois = new ObjectInputStream(bais);
        n = (Normal)ois.readObject();
        System.out.println(n.data);
    }
}
