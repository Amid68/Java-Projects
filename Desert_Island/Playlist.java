import java.util.ArrayList;

class Playlist {
    public static void main(String[] args) {

        ArrayList<String> desertIslandPlaylist = new ArrayList<String>();
        
        desertIslandPlaylist.add("song1");
        desertIslandPlaylist.add("song2");
        desertIslandPlaylist.add("song3");
        desertIslandPlaylist.add("song4");
        desertIslandPlaylist.add("song5");
        desertIslandPlaylist.add("song6");
        desertIslandPlaylist.add("song7");

        System.out.println(desertIslandPlaylist);
        System.out.println(desertIslandPlaylist.size());

        desertIslandPlaylist.remove(3);
        desertIslandPlaylist.remove(4);

        System.out.println(desertIslandPlaylist);
        System.out.println(desertIslandPlaylist.size());

        String TempVar = desertIslandPlaylist[3];
        desertIslandPlaylist[3] = desertIslandPlaylist[4];
        desertIslandPlaylist[4] = TempVar; 

    }
}