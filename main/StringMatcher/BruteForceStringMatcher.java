package main.StringMatcher;

import main.Matches.IMatchElement;
import main.Matches.MatchElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BruteForceStringMatcher implements IStringMatcher {

    @Override
    public List<IMatchElement> match(String toMatch, String key) {
        var n = toMatch.length();
        var m = key.length();

        //TODO: assert if the array is the proper data structure to store such things
        var matches = new ArrayList<IMatchElement>();
        for (int i = 0; i < n-m; i++){
            //end
            var candidate = toMatch.substring(i, i+m);
            if (candidate.equals(key)){
                var matchElement = new MatchElement(key, i);
                matches.add(matchElement);
            }
        }

        return matches;
    }

    public static void main(String[] args){
        var bf = new BruteForceStringMatcher();

        var matches = bf.match("blabla", "b");
    }
}
