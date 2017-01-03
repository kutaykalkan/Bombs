import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kutay on 12/5/2016.
 */
public class Bomb {
    private String bomb;
    private Integer force;

    /**
     * @param bomb String containing B denoting the bomb and series of '.' denoting the chamber.
     * @param force Number of characters the bomb will impact on each run.
     */
    public Bomb(String bomb, Integer force){
        this.bomb = bomb;
        this.force = force;
    }

    /**
     * @return String array containing every run of explosions.
     */
    public String[] explode() {
        List<String> output = new ArrayList<String>();
        output.add(bomb);

        StringBuilder chamber = new StringBuilder(bomb);
        int upperBound = bomb.length() - 1;
        Character[] memo = new Character[upperBound + 1];
        while (true) {
            Arrays.fill(memo, null);
            int countEmpty = 0;
            for (int i = 0; i <= upperBound; i++) {
                Character c = chamber.charAt(i);
                if (c == '.')
                    countEmpty++;
                processWaves(chamber, force, i, upperBound, c, memo);
            }

            if (countEmpty == bomb.length()) {
                break;//break when everything is '.'
            }
            output.add(chamber.toString());
        }

        return output.toArray(new String[output.size()]);
    }

    private void processWaves(StringBuilder chamber, int force, int location, int upperBound, Character c, Character[] memo){
        memo[location] = c;

        if (location - force >= 0){
            if (memo[location - force] == '>' || memo[location - force] == 'X' || memo[location - force] == 'B')
                chamber.setCharAt(location, '>');
            else
                chamber.setCharAt(location, '.');
        }
        else{
            if (chamber.charAt(location) != '<')
            chamber.setCharAt(location, '.');
        }

        if (location + force <= upperBound){
            if (chamber.charAt(location + force) == '<' || chamber.charAt(location + force) == 'X' || chamber.charAt(location + force) == 'B')
                if (chamber.charAt(location)== '>')
                    chamber.setCharAt(location, 'X');
                else
                    chamber.setCharAt(location, '<');
            else {
                if (chamber.charAt(location) != '>')
                    chamber.setCharAt(location, '.');
            }
        }
        else{
            if (chamber.charAt(location) != '>')
                chamber.setCharAt(location, '.');
        }
    }
}
