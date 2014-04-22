package tp7;

import java.io.*;

/**
 * Created by Fran on 15/04/14.
 */
public class IOTree {
    public BinTree loadArbin() {
        try {
            FileInputStream fs = new FileInputStream("Arbin.ser");
            ObjectInputStream os = new ObjectInputStream(fs);
            BinTree binTree = (BinTree) os.readObject();
            return binTree;
        } catch (IOException ignored) {

        } catch (ClassNotFoundException ignored) {

        }
        return null;
    }

    public void saveArbin(BinTree binTree) {
        try {
            FileOutputStream fs = new FileOutputStream("Arbin.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(binTree);
            os.close();
        } catch (FileNotFoundException ignored) {

        } catch (IOException ignored) {

        }
    }
}
