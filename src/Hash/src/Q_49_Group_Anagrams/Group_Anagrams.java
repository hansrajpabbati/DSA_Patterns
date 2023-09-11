package Hash.src.Q_49_Group_Anagrams;
import java.util.*;

//Complexity
// Time : O(NKlogk)
// space : O(NK)

public class Group_Anagrams {

    public String sortString(String str){
        if(str == null || str.length() ==0){
            return null;
        }
        char[] strChar = str.toCharArray();
        Arrays.sort(strChar);
        return new String(strChar);
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)
        {
            return new ArrayList<>();
        }
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i=0; i< strs.length; i++){
            String temp = sortString(strs[i]);
            if(!map.containsKey(temp)){
                map.put(temp,new ArrayList<String>());
            }
            map.get(temp).add(strs[i]);
        }

        List<List<String>> anagrams = new ArrayList<>();
        for(Map.Entry<String,List<String>> m :  map.entrySet()){
            List<String> temp = m.getValue();
            Collections.sort(temp);
            anagrams.add(temp);
        }
        return anagrams;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Group_Anagrams obj = new Group_Anagrams();
        List<List<String>> ans = obj.groupAnagrams(strs);
        System.out.println(ans);
    }


}

