public class Main {

    public static void main(String[] args) {
        String bomb = "..B....";
        Integer force = 2;
        Bomb b = new Bomb(bomb, force);
        String[] result = b.explode();
        for (int i = 0; i < result.length; i++)
	        System.out.println(result[i]);
    }
}
