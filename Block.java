////////////////////////////// FILE HEADER /////////////////////////////////////
//
// Title:    Blockchain – Block.java
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

import java.util.Date;

public class Block {

    public String hash; // Hash of this block.
    private String data; // Data stored in this block.
    public String prevHash; // Hash of the previous block.
    public long timeStamp;

    public Block(String prevHash, String data) {

        this.data = data;
        this.prevHash = prevHash;
        this.timeStamp = new Date().getTime();
        this.hash = getHash();
    }

    public String getHash() {

        return GenerateHash.sha256(prevHash + this.timeStamp + data);
    }
}
