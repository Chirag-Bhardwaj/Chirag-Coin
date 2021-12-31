////////////////////////////// FILE HEADER /////////////////////////////////////
//
// Title:    Blockchain – Blockchain.java
//
// Author:   Chirag Bhardwaj
// Email:    chiragbhardwaj2002@gmail.com
//
////////////////////////////// Description /////////////////////////////////////
//
// A simple and secure Blockchain software made using the SHA256 algorithm.
// Changing any data will result in breaking of the entire chain, thus
// making this Blockchain robust.
//
////////////////////////////////////////////////////////////////////////////////

import com.google.gson.*;
import java.util.ArrayList;

public class Blockchain {

    public static ArrayList<Block> Blocks = new ArrayList<>();

    public static void main(String[] args) {

        Block b1 = new Block("0", "Block 1");
        Block b2 = new Block(b1.getHash(), "Block 2");
        Block b3 = new Block(b2.getHash(), "Block 3");

        Blocks.add(b1);
        Blocks.add(b2);
        Blocks.add(b3);

        String chainJson = new GsonBuilder().setPrettyPrinting().create().toJson(Blocks);
        System.out.println(chainJson);
    }

    public static boolean isValidChain() {

        Block prevBlock;
        Block currBlock;

        for (int i = 1; i < Blocks.size(); ++i) {
            if (!Blocks.get(i).prevHash.equals(Blocks.get(i - 1).hash)) {
                return false;
            }
        }
        return true;
    }
}
