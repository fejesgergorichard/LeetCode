/*
You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to
cityBi. Return the destination city, that is, the city without any path outgoing to another city.
It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one
destination city.

Example 1:
Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo"
Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city.
Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".

Example 2:
Input: paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"
Explanation: All possible trips are:
"D" -> "B" -> "C" -> "A".
"B" -> "C" -> "A".
"C" -> "A".
"A".
Clearly the destination city is "A".

Example 3:
Input: paths = [["A","Z"]]
Output: "Z"

Constraints:
1 <= paths.length <= 100
paths[i].length == 2
1 <= cityAi.length, cityBi.length <= 10
cityAi != cityBi
All strings consist of lowercase and uppercase English letters and the space character.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    /** HashMap solution. Each source is a key, each destination is a value. (100% speed - 100% memory on leetcode) */
    public String destCity(List<List<String>> paths) {
        String destinationCity = "";
        HashMap<String, String> map = new HashMap<>();

        // Fill up the map
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }

        // Check every destination(value) if it's also a source(key). If not, that is our final destination.
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!map.containsKey(entry.getValue())) {
                destinationCity = entry.getValue();
                break;
            }
        }

        return destinationCity;
    }


    /** Two lists: one for sources, one for destinations (80% speed, 100% memory on leetcode) */
    public String destCityLists(List<List<String>> paths) {
        String destinationCity = "";
        List<String> sources = new ArrayList<String>();
        List<String> dests = new ArrayList<String>();

        // Fill up the sources and destinations list
        for (List<String> path : paths) {
            sources.add(path.get(0));
            dests.add(path.get(1));
        }

        // Check for every destination if it's also a source. If not, it means we cant go anywhere from there.
        for (String dest : dests) {
            if (!sources.contains(dest)) {
                destinationCity = dest;
                break;
            }
        }

        return destinationCity;
    }
}