// import java.util.*;

// public class SuffixStructures {
//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);

//     String s = sc.nextLine();
//     String t = sc.nextLine();
//     sc.close();

//     Map<Character,Integer> hmS = new HashMap<>();
//     for (int i = 0; i<s.length(); i++) {
//       hmS.put(s.charAt(i), hmS.getOrDefault(s.charAt(i), 0) + 1);
//     }

//     Map<Character,Integer> hmT = new HashMap<>();
//     for (int i = 0; i<t.length(); i++) {
//       hmT.put(t.charAt(i), hmT.getOrDefault(t.charAt(i), 0) + 1);
//     }
//     boolean sHasMoreCharThanTNeedFlag = false;
//     for (Map.Entry<Character,Integer> el: hmT.entrySet()) {
//       Character key = el.getKey();
//       int val = el.getValue();
      
//       int countInSVal = hmS.getOrDefault(key, 0);
//       if (countInSVal > val) {
//         sHasMoreCharThanTNeedFlag = true;
//       } else if (countInSVal < val) {
//         System.out.println("need tree");
//         return;
//       }
//     }

//     if (!sHasMoreCharThanTNeedFlag) {
//       if (s.length()==t.length()) { // every char need exists, just swap position
//         System.out.println("array");
//         return;
//       } else { // every char need exists, but there are some char that is in s but in t
//         System.out.println("both");
//         return;
//       }
//     } 

//     // more char than need, need to remove AND MAYBE ALSO swap
//     boolean deletedFlag = false;

//     if (deletedFlag) {
//       System.out.println("both");
//     } else {
//       System.out.println("automaton");
//     }
    
//   }
// }


import java.util.*;

public class SuffixStructures {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.nextLine();
    String t = sc.nextLine();
    sc.close();

    int[] cnt_s = new int[26];
    int[] cnt_t = new int[26];
    boolean automaton = false, array = false;

    for (int i =0; i<26;i++) {
      cnt_s[i] = 0;
      cnt_t[i] = 0;
    }

    for (char c: s.toCharArray()) {
      cnt_s[c - 'a']++;
    }
    for (char c: t.toCharArray()) {
      cnt_t[c - 'a']++;
    }
    for (int i =0; i<26;i++) {
      if (cnt_t[i] > cnt_s[i]) {
        System.out.println("need tree");
        return;
      }
      if (cnt_t[i] < cnt_s[i]) {
        automaton = true;
      }
    }

    int match = -1;
    for (char c: t.toCharArray()) {
      int idx = s.indexOf(c, match);
      if (idx == -1) {
        array = true;
      } else {
        match = idx;
      }
    }

    if (automaton && array) {
      System.out.println("both");
    } else if (automaton) {
      System.out.println("automaton");
    } else {
      System.out.println("array");
    }
  }
}
